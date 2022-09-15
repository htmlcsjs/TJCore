package TJCore.common.recipes;

import gregicality.multiblocks.GregicalityMultiblocks;
import gregicality.multiblocks.api.recipes.GCYMRecipeMaps;
import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.stack.UnificationEntry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import org.lwjgl.opencl.CL;


import static TJCore.common.metaitem.TJMetaItems.*;
import static TJCore.common.recipes.recipemaps.TJRecipeMaps.DEHYDRATOR_RECIPES;
import static TJCore.common.recipes.recipemaps.TJRecipeMaps.LAMINATOR_RECIPES;
import static TJCore.api.material.TJMaterials.*;
import static gregtech.api.GTValues.*;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;
import static gregtech.common.items.MetaItems.*;

public class SMD {
    public static void registerSMDRecipes() {

        // TRANSISTORS
        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[MV])
                .input(foil, PolyvinylChloride, 2)
                .input(wireFine, AnnealedCopper, 2)
                .fluidInputs(Polyethylene.getFluid(144))
                .output(SMD_TRANSISTOR_1, 32)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[IV])
                .input(foil, Ladder_Poly_P_Phenylene, 2)
                .input(plate, Ruthenium)
                .input(wireFine, ZBLAN)
                .fluidInputs(SeleniumMonobromide.getFluid(288))
                .output(SMD_TRANSISTOR_2, 32)
                .buildAndRegister();

        // RESISTORS
        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[MV])
                .input(foil, SilicaCeramic, 2)
                .input(dust, Mica, 2)
                .input(dust, SilverLeadOxide)
                .input(foil, PolyvinylChloride)
                .fluidInputs(Polyethylene.getFluid(144))
                .output(SMD_RESISTOR_1, 32)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[EV])
                .input(dust, Silicon, 2)
                .input(dustSmall, Gallium, 2)
                .input(wireFine, Nichrome)
                .fluidInputs(Polyethylene.getFluid(288))
                .output(SMD_RESISTOR_2, 32)
                .buildAndRegister();


        // CAPACITORS
        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[MV])
                .input(foil, SilicaCeramic, 4)
                .input(foil, NickelPlatedTin)
                .input(wireFine, Silver, 2)
                .fluidInputs(Polyethylene.getFluid(144))
                .output(SMD_CAPACITOR_1, 32)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[LuV])
                .input(foil, Ladder_Poly_P_Phenylene, 2)
                .input(dust, LuminescentSiliconNanocrystals, 2)
                .input(bolt, ZBLAN)
                .fluidInputs(SeleniumMonobromide.getFluid(144))
                .output(SMD_CAPACITOR_2, 32)
                .buildAndRegister();


        // DIODES
        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[MV])
                .input(dustSmall, Phosphorus)
                .input(dustSmall, Gallium)
                .input(foil, Silicon, 2)
                .fluidInputs(Polyethylene.getFluid(144))
                .output(SMD_DIODE_1, 32)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[IV])
                .input(foil, Ruthenium, 2)
                .input(dustSmall, Naquadah)
                .input(dustSmall, Indium)
                .fluidInputs(PolyphenyleneSulfide.getFluid(144))
                .output(SMD_DIODE_2, 32)
                .buildAndRegister();

        // INDUCTORS
        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[MV])
                .input(FERROUS_INDUCTOR_CORE)
                .input(wireFine, Copper, 2)
                .fluidInputs(Polyethylene.getFluid(144))
                .output(SMD_INDUCTOR_1, 32)
                .buildAndRegister();

        ASSEMBLER_RECIPES.recipeBuilder()
                .duration(50)
                .EUt(VA[EV])
                .input(TUNGSTEN_INDUCTOR_CORE)
                .input(foil, Naquadah)
                .input(wireFine, Platinum)
                .fluidInputs(PolyphenyleneSulfide.getFluid(144))
                .output(SMD_INDUCTOR_2, 32)
                .buildAndRegister();

        // MISC. INTERMEDIARIES
        LAMINATOR_RECIPES.recipeBuilder()
                .duration(40)
                .EUt(VA[LV])
                .input(bolt, Steel)
                .input(foil, Silicon)
                .fluidInputs(Polyethylene.getFluid(144))
                .output(FERROUS_INDUCTOR_CORE)
                .buildAndRegister();

        LAMINATOR_RECIPES.recipeBuilder()
                .duration(40)
                .EUt(VA[EV])
                .input(bolt, Tungsten)
                .input(foil, NiobiumNitride)
                .fluidInputs(Glass.getFluid(144))
                .output(TUNGSTEN_INDUCTOR_CORE)
                .buildAndRegister();

    }
}
