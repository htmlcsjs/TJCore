package TJCore.common.tools;

import gregtech.common.tools.ToolBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class ToolLithographyMask extends ToolBase {

    public float getBaseDamage(ItemStack stack) {
        return super.getBaseDamage(stack) + 5;
    }

    @Override
    public float getAttackSpeed(ItemStack stack) {
        return 0.7f;
    }

    @Override
    public float getNormalDamageBonus(EntityLivingBase entity, ItemStack stack, EntityLivingBase attacker) {
        return 0.0f;
    }


}
