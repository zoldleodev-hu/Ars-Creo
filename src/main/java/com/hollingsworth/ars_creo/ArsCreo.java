package com.hollingsworth.ars_creo;


import com.hollingsworth.ars_creo.client.render.ClientHandler;
import com.hollingsworth.ars_creo.common.registry.CreativeTabRegistry;
import com.hollingsworth.ars_creo.common.registry.ModBlockRegistry;
import com.hollingsworth.ars_creo.network.ACNetworking;
import com.simibubi.create.api.registry.CreateRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.registries.RegisterEvent;

import java.util.Objects;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ArsCreo.MODID)
public class ArsCreo
{

    public static final String MODID = "ars_creo";

    public ArsCreo(IEventBus modBus, ModContainer modContainer) {
        NeoForge.EVENT_BUS.addListener(ArsNouveauRegistry::registerDocumentation);
        modContainer.registerConfig(ModConfig.Type.COMMON, CreoConfig.SERVER_CONFIG);
        modBus.addListener(ACNetworking::register);
        modBus.addListener(this::clientSetup);
        modBus.addListener(ArsCreo::registerEvents);
        registers(modBus);
    }

    public static void registers(IEventBus event) {
        ModBlockRegistry.ITEMS.register(event);
        ModBlockRegistry.BLOCK_REG.register(event);
        ModBlockRegistry.BLOCK_ENTITY_REG.register(event);
        CreativeTabRegistry.TABS.register(event);
        CreateCompat.DISPLAY_SOURCES.register(event);
    }

    public static void registerEvents(RegisterEvent event) {
        event.register(Registries.ITEM, helper ->{
            ModBlockRegistry.onBlockItemsRegistry();
        });

        if(event.getRegistryKey().equals(CreateRegistries.DISPLAY_SOURCE)){
            CreateCompat.setupDisplayBehaviors();
        }
    }

    public static ResourceLocation prefix(String path){
        return ResourceLocation.fromNamespaceAndPath(MODID, path);
    }
    public void clientSetup(final FMLClientSetupEvent event) {
        ModLoadingContext.get().getActiveContainer().getEventBus().addListener(ClientHandler::init);
    }
}
