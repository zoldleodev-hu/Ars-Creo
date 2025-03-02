package com.hollingsworth.ars_creo;


import com.hollingsworth.ars_creo.common.registry.ModBlockRegistry;
import com.hollingsworth.ars_creo.contraption.*;
import com.hollingsworth.arsnouveau.setup.registry.BlockRegistry;
import com.simibubi.create.api.behaviour.interaction.MovingInteractionBehaviour;
import com.simibubi.create.api.behaviour.movement.MovementBehaviour;
import com.simibubi.create.api.stress.BlockStressValues;


public class CreateCompat {


    public static void setup(){
        MovingInteractionBehaviour.REGISTRY.register(BlockRegistry.BASIC_SPELL_TURRET.get(), new BasicTurretBehavior());
        MovementBehaviour.REGISTRY.register(BlockRegistry.BASIC_SPELL_TURRET.get(),  new AbstractTurretBehavior());
        MovementBehaviour.REGISTRY.register(BlockRegistry.TIMER_SPELL_TURRET.get(),  new TimerTurretBehavior());
        MovementBehaviour.REGISTRY.register(BlockRegistry.ENCHANTED_SPELL_TURRET.get(),  new EnhancedTurretBehavior());
        MovementBehaviour.REGISTRY.register(BlockRegistry.SOURCE_JAR.get(), new SourceJarBehavior());
        MovementBehaviour.REGISTRY.register(BlockRegistry.CREATIVE_SOURCE_JAR.get(), new SourceJarBehavior());
        BlockStressValues.CAPACITIES.register(ModBlockRegistry.STARBY_WHEEL.get(), () -> 16.0);

    }

}
