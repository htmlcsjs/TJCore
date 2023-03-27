package tjcore.common.pipelike.rotation;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelRotationAxle extends ModelBase {

    public ModelRenderer axle;

    public ModelRotationAxle(){
        this.axle = new ModelRenderer(this,0,0);
        this.axle.addBox(-2,0,-2, 4, 16, 4, 0);
        this.axle.rotationPointX = 8f;
        this.axle.rotationPointZ = 8f;
        this.axle.rotationPointY = 8f;
    }
}
