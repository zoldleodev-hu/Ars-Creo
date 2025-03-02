package com.hollingsworth.ars_creo.client.render;

import com.hollingsworth.ars_creo.ArsCreo;
import com.hollingsworth.ars_creo.common.registry.ModBlockRegistry;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(value = Dist.CLIENT, modid = ArsCreo.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ClientHandler {
    @SubscribeEvent
    public static void init(final FMLClientSetupEvent evt) {
        ItemBlockRenderTypes.setRenderLayer(ModBlockRegistry.STARBY_WHEEL.get(), RenderType.cutout());
    }
    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event){
        event.registerBlockEntityRenderer(ModBlockRegistry.STARBY_TILE.get(), StarbuncleWheelRenderer::new);
    }
}
