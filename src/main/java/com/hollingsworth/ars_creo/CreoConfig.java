package com.hollingsworth.ars_creo;


import net.neoforged.fml.config.IConfigSpec;
import net.neoforged.neoforge.common.ModConfigSpec;

public class CreoConfig {

    public static ModConfigSpec SERVER_CONFIG;

    public static ModConfigSpec.IntValue WHEEL_BASE_SPEED;
    public static ModConfigSpec.IntValue WHEEL_BONUS_SPEED;

    static {
        ModConfigSpec.Builder SERVER_BUILDER = new ModConfigSpec.Builder();
        WHEEL_BASE_SPEED = SERVER_BUILDER.comment("Base speed of the wheel").defineInRange("wheelBaseSpeed", 16, 0, Integer.MAX_VALUE);
        WHEEL_BONUS_SPEED = SERVER_BUILDER.comment("Speed of the wheel with a gold block in front").defineInRange("wheelMaxSpeed", 24, 0, Integer.MAX_VALUE);
        SERVER_CONFIG = SERVER_BUILDER.build();
    }
    
}
