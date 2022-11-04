package TJCore.api.block;

import gregtech.api.recipes.recipeproperties.TemperatureProperty;
import gregtech.api.unification.material.Material;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public interface ITurbineBladeStats {

    /**
     * @return The unique name of the turbine blades
     */
    @Nonnull
    String getName();

    /**
     * This is used to get the tier of the turbine blades
     *
     * @return the tier of the turbine blades
     */
    int getTier();

    /**
     * This is used to get the maximum rotation speed of the turbine blades
     *
     * @return the maximum rotation speed of the turbine blades
     */

    int getRotationCap();

}
