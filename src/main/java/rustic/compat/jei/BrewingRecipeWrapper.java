package rustic.compat.jei;

import java.util.ArrayList;
import java.util.List;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.BlankRecipeWrapper;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import rustic.common.crafting.BrewingBarrelRecipe;

public class BrewingRecipeWrapper extends BlankRecipeWrapper {

	public BrewingBarrelRecipe recipe = null;

	public BrewingRecipeWrapper(BrewingBarrelRecipe recipe) {
		this.recipe = recipe;
	}

	@Override
	public void getIngredients(IIngredients ingredients) {
		FluidStack in = FluidRegistry.getFluidStack(recipe.getInput().getFluid().getName(), 1);
		in.amount = 8000;
		ingredients.setInput(FluidStack.class, in);
		FluidStack out = new FluidStack(recipe.getResult(in).getFluid(), 8000);
		ingredients.setOutput(FluidStack.class, out);
	}

}
