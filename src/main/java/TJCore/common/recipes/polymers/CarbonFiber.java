package TJCore.common.recipes.polymers;

import TJCore.common.metaitem.TJMetaItems;

import static TJCore.common.metaitem.TJMetaItems.*;
import static TJCore.common.recipes.recipemaps.TJRecipeMaps.*;
import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static TJCore.api.material.TJMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;

public class CarbonFiber {
    public static void register() {

        CARBON_MESH.setInvisible();
        CARBON_FIBERS.setInvisible();
        MIXER_RECIPES.recipeBuilder()
                .duration(20)
                .EUt(VA[EV])
                .input(dust, Bismuth, 9)
                .input(dust, Phosphorus)
                .input(dust, Molybdenum, 12)
                .fluidInputs(Oxygen.getFluid(52000))
                .output(dust, BismuthPhosphomolybdate, 74)
                .buildAndRegister();


        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .duration(300)
                .EUt(VA[HV])
                .notConsumable(dust, BismuthPhosphomolybdate)
                .fluidInputs(Propene.getFluid(2000))
                .fluidInputs(Ammonia.getFluid(2000))
                .fluidInputs(Oxygen.getFluid(3000))
                .fluidOutputs(Acrylonitrile.getFluid(2000))
                .fluidOutputs(Water.getFluid(6000))
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .duration(200)
                .EUt(VA[MV])
                .input(dust, SodiumCyanide, 3)
                .input(dust,Sulfur, 1)
                .output(dust, SodiumThiocyanate, 5)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .duration(15)
                .EUt(VA[LV])
                .input(dust, SodiumThiocyanate, 5)
                .fluidInputs(Water.getFluid(1000))
                .fluidOutputs(SodiumThiocyanatePolymerizationSolution.getFluid(1000))
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .duration(120)
                .EUt(VA[EV])
                .fluidInputs(SodiumThiocyanatePolymerizationSolution.getFluid(10))
                .fluidInputs(Acrylonitrile.getFluid(1000))
                .output(dust, Polyacrylonitrile)
                .buildAndRegister();

        SPINNING_RECIPES.recipeBuilder()
                .duration(500)
                .EUt(VA[MV])
                .input(dust, Polyacrylonitrile)
                .notConsumable(stickLong, Polytetrafluoroethylene)
                .output(SPUN_POLYACRYLONITRILE)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .duration(25)
                .EUt(VA[MV])
                .input(SPUN_POLYACRYLONITRILE)
                .fluidInputs(Water.getFluid(250))
                .output(WASHED_POLYACRLONITRILE, 2)
                .chancedOutput(WASHED_POLYACRLONITRILE, 1, 1000, 1500)
                .chancedOutput(WASHED_POLYACRLONITRILE, 1, 1000, 1500)
                .buildAndRegister();

        MIXER_RECIPES.recipeBuilder()
                .duration(25)
                .EUt(VA[MV])
                .fluidInputs(PolyvinylChloride.getFluid(144))
                .fluidInputs(Polyethylene.getFluid(144))
                .fluidOutputs(CFCoatingSolution.getFluid(1000))
                .buildAndRegister();

        FURNACE_RECIPES.recipeBuilder()
                .duration(25)
                .EUt(VA[MV])
                .input(WASHED_POLYACRLONITRILE)
                .output(BAKED_POLYACRLONITRILE)
                .buildAndRegister();

        AUTOCLAVE_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[MV])
                .input(BAKED_POLYACRLONITRILE)
                .fluidInputs(Oxygen.getFluid(10))
                .output(OXIDIZED_CARBON_THREAD, 8)
                .buildAndRegister();

        CHEMICAL_BATH_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[MV])
                .input(OXIDIZED_CARBON_THREAD)
                .fluidInputs(NitricAcid.getFluid(50))
                .output(ETCHED_CARBON_THREAD)
                .buildAndRegister();

        LAMINATOR_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[IV])
                .input(ETCHED_CARBON_THREAD, 4)
                .fluidInputs(CFCoatingSolution.getFluid(10))
                .output(COATED_CARBON_THREAD, 2)
                .chancedOutput(COATED_CARBON_THREAD, 2, 5000, 1000)
                .buildAndRegister();

        LOOM_RECIPES.recipeBuilder()
                .duration(600)
                .EUt(VA[ZPM])
                .input(COATED_CARBON_THREAD, 16)
                .circuitMeta(0)
                .output(WOVEN_CARBON_FIBER)
                .buildAndRegister();

        LOOM_RECIPES.recipeBuilder()
                .duration(150)
                .EUt(VA[ZPM])
                .input(COATED_CARBON_THREAD, 4)
                .circuitMeta(1)
                .output(THIN_WOVEN_CARBON_FIBER)
                .buildAndRegister();

        LAMINATOR_RECIPES.recipeBuilder()
                .duration(45)
                .EUt(VA[EV])
                .fluidInputs(Epoxy.getFluid(144))
                .input(WOVEN_CARBON_FIBER, 1)
                .output(TJMetaItems.CARBON_FIBER_PLATE)
                .buildAndRegister();

        LAMINATOR_RECIPES.recipeBuilder()
                .duration(45)
                .EUt(VA[EV])
                .fluidInputs(Epoxy.getFluid(36))
                .input(THIN_WOVEN_CARBON_FIBER)
                .output(CARBON_FIBER_FOIL)
                .buildAndRegister();
    }
}
