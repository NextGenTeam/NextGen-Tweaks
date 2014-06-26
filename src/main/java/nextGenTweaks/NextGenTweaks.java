package nextGenTweaks;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;

import java.util.ArrayList;

@Mod(modid = "nextgentweaks" ,name="NextGen Tweaks", version = "@VERSION@", dependencies = "required-after:BuildCraft|Energy@{6.0.16};required-after:ExtraUtilities@{1.1.0b}")
public class NextGenTweaks {

    @Instance
    public static NextGenTweaks instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {


    }

    @Mod.EventHandler
    public void load(FMLInitializationEvent event) {
        if (Loader.isModLoaded("ExtraUtilities")) {
            Block enderQuarry = GameRegistry.findBlock("ExtraUtilities", "enderQuarry");
            removeRecipe(new ItemStack(enderQuarry));        
        }
    }


    public void removeRecipe(ItemStack stack){
        ArrayList recipeList = (ArrayList) CraftingManager.getInstance().getRecipeList();
        for (int t = 0; t < recepieList.size(); t++) {
            IRecipe recipe = (IRecipe) recepieList.get(t);
            ItemStack recipeResult = recipe.getRecipeOutput();
            if (ItemStack.areItemStacksEqual(stack, recipeResult)){
                recepieList.remove(t);
                return;
            }
        }
    }

}
