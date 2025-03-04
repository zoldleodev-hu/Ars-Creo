package com.hollingsworth.ars_creo;


import com.hollingsworth.ars_creo.common.display.TurretDisplaySource;
import com.hollingsworth.ars_creo.common.lib.LibBlock;
import com.hollingsworth.ars_creo.common.registry.ModBlockRegistry;
import com.hollingsworth.ars_creo.contraption.*;
import com.hollingsworth.arsnouveau.common.lib.LibBlockNames;
import com.hollingsworth.arsnouveau.setup.registry.BlockRegistry;
import com.simibubi.create.AllInteractionBehaviours;
import com.simibubi.create.AllMovementBehaviours;

import com.simibubi.create.api.behaviour.display.DisplaySource;
import com.simibubi.create.api.behaviour.interaction.MovingInteractionBehaviour;
import com.simibubi.create.api.behaviour.movement.MovementBehaviour;
import com.simibubi.create.api.stress.BlockStressValues;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.List;


public class CreateCompat {


    public static void setup(){
        MovingInteractionBehaviour.REGISTRY.register(BlockRegistry.BASIC_SPELL_TURRET.get(), new BasicTurretBehavior());
        MovementBehaviour.REGISTRY.register(BlockRegistry.BASIC_SPELL_TURRET.get(),  new AbstractTurretBehavior());
        MovementBehaviour.REGISTRY.register(BlockRegistry.TIMER_SPELL_TURRET.get(),  new TimerTurretBehavior());
        MovementBehaviour.REGISTRY.register(BlockRegistry.ENCHANTED_SPELL_TURRET.get(),  new EnhancedTurretBehavior());
        MovementBehaviour.REGISTRY.register(BlockRegistry.SOURCE_JAR.get(), new SourceJarBehavior());
        MovementBehaviour.REGISTRY.register(BlockRegistry.CREATIVE_SOURCE_JAR.get(), new SourceJarBehavior());
        BlockStressValues.CAPACITIES.register(ModBlockRegistry.STARBY_WHEEL.get(), () -> 16.0);
        List<DisplaySource> turretSource = new ArrayList<>();
        turretSource.add(new TurretDisplaySource());
        DisplaySource.BY_BLOCK_ENTITY.register(BlockRegistry.BASIC_SPELL_TURRET_TILE.get(), turretSource);
        DisplaySource.BY_BLOCK_ENTITY.register(BlockRegistry.TIMER_SPELL_TURRET_TILE.get(), turretSource);
        DisplaySource.BY_BLOCK_ENTITY.register(BlockRegistry.ROTATING_TURRET_TILE.get(), turretSource);

    }

}
