package nextGenTweaks;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import nextGenTweaks.proxy.CommonProxy;

@Mod(modid = "nextgentweaks" ,name="NextGen Tweaks", version = "@VERSION@", dependencies = "required-after:BuildCraft|Energy@{6.0.16}")
public class NextGenTweaks {

    @Instance
    public static NextGenTweaks instance;

    @SidedProxy(clientSide="nextGenTweaks.proxy.ClientProxy", serverSide="nextGenTweaks.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

}
