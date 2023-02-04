package tjcore.api.block;

import javax.annotation.Nonnull;

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
