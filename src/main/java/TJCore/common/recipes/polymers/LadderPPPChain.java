package TJCore.common.recipes.polymers;

import static gregicality.science.api.unification.materials.GCYSMaterials.*;

import static TJCore.api.material.TJMaterials.*;
import static gregicality.science.api.unification.materials.GCYSMaterials.Acetylene;
import static gregicality.science.api.unification.materials.GCYSMaterials.PhosphorusTrichloride;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;




public class LadderPPPChain {
    public static void register() {

        CHEMICAL_RECIPES.recipeBuilder()
                .duration(120)
                .EUt(VA[MV])
                .fluidInputs(Benzene.getFluid(1000), Bromine.getFluid(2000))
                .fluidOutputs(Bromobenzene.getFluid(1000), HydrobromicAcid.getFluid(1000))
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .duration(60)
                .EUt(VA[HV])
                .input(dust, Magnesium)
                .fluidInputs(Bromobenzene.getFluid(1000))
                .fluidOutputs(PhenylmagnesiumBromide.getFluid(1000))
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .duration(30)
                .EUt(VA[HV])
                .fluidInputs(PhosphorusTrichloride.getFluid(1000), PhenylmagnesiumBromide.getFluid(1000))
                .output(dust, Magnesium)
                .output(dust, TriphenylPhosphine)
                .fluidOutputs(Bromine.getFluid(1000), Chlorine.getFluid(1000))
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .duration(160)
                .EUt(VA[HV])
                .input(dust,TriphenylPhosphine, 4)
                .input(dust, PalladiumChloride)
                .fluidInputs(Hydrazine.getFluid(2500))
                .fluidOutputs(HydraziniumChloride.getFluid(2000), Hydrogen.getFluid(500))
                .output(dust, TetrakisPDCatalyst)
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .duration(40)
                .EUt(VA[HV])
                .fluidInputs(PhthalicAcid.getFluid(3000))
                .fluidInputs(Bromine.getFluid(500))
                .notConsumable(SulfurDioxide.getFluid(1))
                .fluidOutputs(DibromoisophthalicAcid.getFluid(3000))
                .buildAndRegister();

        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .duration(130)
                .EUt(VA[EV])
                .fluidInputs(ThionylChloride.getFluid(1000), DibromoisophthalicAcid.getFluid(4000), Chlorine.getFluid(2000))
                .fluidOutputs(Dibromoterephthaloyldichloride.getFluid(2000), Acetylene.getFluid(7000), CarbonDioxide.getFluid(2000), Oxygen.getFluid(5000))
                .output(dust, SulfurTrioxide)
                .buildAndRegister();

        LARGE_CHEMICAL_RECIPES.recipeBuilder()
                .duration(80)
                .EUt(VA[EV])
                .fluidInputs(Toluene.getFluid(1000))
                .fluidInputs(Dibromoterephthaloyldichloride.getFluid(1000))
                .notConsumable(dust, TetrakisPDCatalyst)
                .fluidOutputs(P1Solution.getFluid(2000))
                .buildAndRegister();

        CHEMICAL_RECIPES.recipeBuilder()
                .duration(180)
                .EUt(VA[HV])
                .fluidInputs(P1Solution.getFluid(1000))
                .fluidInputs(Dichloroethane.getFluid(250))
                .fluidOutputs(Ladder_Poly_P_Phenylene.getFluid(2016))
                .buildAndRegister();
    }
}
