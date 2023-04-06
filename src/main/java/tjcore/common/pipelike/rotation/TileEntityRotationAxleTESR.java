package tjcore.common.pipelike.rotation;

import tjcore.TJValues;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.animation.FastTESR;

import javax.annotation.Nonnull;

import static net.minecraft.block.BlockRotatedPillar.AXIS;
import static org.lwjgl.opengl.GL11.*;

public class TileEntityRotationAxleTESR extends FastTESR<TileEntityRotationAxle> {

    private final ModelRotationAxle model = new ModelRotationAxle();
    private static final ResourceLocation texture = new ResourceLocation(TJValues.MODID, "textures/entity/axle.png");

    @Override
    public void renderTileEntityFast(@Nonnull TileEntityRotationAxle te, double x, double y, double z, float partialTicks, int destroyStage, float partial, BufferBuilder buffer) {

        TileEntityRotationAxle axleRef = (TileEntityRotationAxle) te.getWorld().getTileEntity(te.getPos());
        IBlockState state = te.getWorld().getBlockState(te.getPos());
        GlStateManager.enableDepth();

        GlStateManager.depthFunc(515);
        GlStateManager.depthMask(true);
        this.bindTexture(texture);
        if (destroyStage >= 0)
        {
            this.bindTexture(DESTROY_STAGES[destroyStage]);
            GlStateManager.matrixMode(5890);
            GlStateManager.pushMatrix();
            GlStateManager.scale(8.0F, 4.0F, 1.0F);
            GlStateManager.translate(0.0625F, 0.0625F, 0.0625F);
            GlStateManager.matrixMode(5888);
        }
        GlStateManager.pushMatrix();
        GlStateManager.enableRescaleNormal();
        GlStateManager.translate((float)x, (float)y, (float)z);
        GlStateManager.scale(1.0F, 1.0F, 1.0F);
        model.axle.rotateAngleX = 0;
        model.axle.rotateAngleY = 0;
        model.axle.rotateAngleZ = 0;
        model.axle.offsetX = 0.0f;
        model.axle.offsetY = 0.0f;
        model.axle.offsetZ = 0.0f;
        switch(state.getValue(AXIS)){
            case X:
                model.axle.rotateAngleZ = (float) Math.PI /2;
                //model.axle.rotateAngleY = (float) Math.PI /2;
                model.axle.offsetX = 0.5f;
                model.axle.rotateAngleY = axleRef.startAngle + axleRef.anglePerTick * partialTicks;
                break;
            case Y:
                //model.axle.rotateAngleZ = (float) Math.PI /2;
                model.axle.offsetY = -0.5f;
                model.axle.rotateAngleY = axleRef.startAngle + axleRef.anglePerTick * partialTicks;
                break;
            case Z:
                model.axle.rotateAngleX = (float) Math.PI /2;
                model.axle.offsetZ = -0.5f;
                model.axle.rotateAngleZ = axleRef.startAngle + axleRef.anglePerTick * partialTicks;
                break;
        }
        model.axle.render(0.0625f);
        GlStateManager.disableRescaleNormal();
        GlStateManager.popMatrix();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        if (destroyStage >= 0) {
            GlStateManager.matrixMode(5890);
            GlStateManager.popMatrix();
            GlStateManager.matrixMode(5888);
        }
    }
}
