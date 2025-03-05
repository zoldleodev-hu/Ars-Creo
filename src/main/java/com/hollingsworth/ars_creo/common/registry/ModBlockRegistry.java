package com.hollingsworth.ars_creo.common.registry;

import com.hollingsworth.ars_creo.ArsCreo;
import com.hollingsworth.ars_creo.CreateCompat;
import com.hollingsworth.ars_creo.client.render.StarbuncleWheelRenderer;
import com.hollingsworth.ars_creo.common.block.StarbuncleWheelBlock;
import com.hollingsworth.ars_creo.common.block.StarbuncleWheelTile;
import com.hollingsworth.ars_creo.common.lib.LibBlock;
import com.hollingsworth.arsnouveau.common.items.RendererBlockItem;
import com.hollingsworth.arsnouveau.setup.registry.ItemsRegistry;
import com.simibubi.create.foundation.item.ItemDescription;
import com.simibubi.create.foundation.item.KineticStats;
import com.simibubi.create.foundation.item.TooltipModifier;
import net.createmod.catnip.lang.FontHelper;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;



public class ModBlockRegistry {
    public static final DeferredRegister<Block> BLOCK_REG = DeferredRegister.create(BuiltInRegistries.BLOCK, ArsCreo.MODID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_REG = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, ArsCreo.MODID);

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(BuiltInRegistries.ITEM, ArsCreo.MODID);
    public static DeferredHolder<Block, StarbuncleWheelBlock> STARBY_WHEEL = BLOCK_REG.register(LibBlock.STARBUNCLE_WHEEL, () -> new StarbuncleWheelBlock(defaultProperties().noOcclusion().lightLevel((state) -> 10)));
    public static DeferredHolder<BlockEntityType<?>, BlockEntityType<StarbuncleWheelTile>> STARBY_TILE = BLOCK_ENTITY_REG.register(LibBlock.STARBUNCLE_WHEEL, () -> BlockEntityType.Builder.of(StarbuncleWheelTile::new, STARBY_WHEEL.get()).build(null));


    public static void onBlockItemsRegistry() {
        var starbyWheel = ITEMS.register(LibBlock.STARBUNCLE_WHEEL, () -> new RendererBlockItem(ModBlockRegistry.STARBY_WHEEL.get(), ItemsRegistry.defaultItemProperties()) {
            @Override
            public Supplier<BlockEntityWithoutLevelRenderer> getRenderer() {
                return StarbuncleWheelRenderer::getISTER;
            }
        });
        CreateCompat.setup();

        TooltipModifier.REGISTRY.register(starbyWheel.get(), KineticStats.create(starbyWheel.get()));

    }

    public static Block.Properties defaultProperties(){
        return Block.Properties.of().sound(SoundType.STONE).strength(2.0f, 6.0f);
    }
}
