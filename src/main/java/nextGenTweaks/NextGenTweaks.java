package nextGenTweaks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = "nextgentweaks", name = "NextGen Tweaks", version = "@VERSION@", dependencies = "required-after:ExtraUtilities")
public class NextGenTweaks {

	@EventHandler
	public void load(FMLInitializationEvent event) {
		if (Loader.isModLoaded("ExtraUtilities")) {
			Block enderQuarry = GameRegistry.findBlock("ExtraUtilities", "enderQuarry");
			removeRecipe(new ItemStack(enderQuarry));
		}
	}

	public void removeRecipe(ItemStack stack) {
		List<IRecipe> recipeList = CraftingManager.getInstance().getRecipeList();
		for (int i = 0; i < recipeList.size(); i++) {
			IRecipe recipe = recipeList.get(i);
			ItemStack recipeResult = recipe.getRecipeOutput();
			if (ItemStack.areItemStacksEqual(stack, recipeResult)) {
				recipeList.remove(i);
				return;
			}
		}
	}

}
