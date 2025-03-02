package com.hollingsworth.ars_creo.contraption.source;

import com.hollingsworth.arsnouveau.common.block.SourceJar;
import com.hollingsworth.arsnouveau.common.block.tile.SourceJarTile;
import com.hollingsworth.arsnouveau.setup.registry.BlockRegistry;
import com.simibubi.create.content.contraptions.AbstractContraptionEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

import static com.hollingsworth.ars_creo.contraption.ContraptionUtils.getFillState;

public class SourceInfo {

    public StructureTemplate.StructureBlockInfo blockInfo;
    public int amount;

    public SourceInfo(StructureTemplate.StructureBlockInfo blockInfo, int amount){
        this.blockInfo = blockInfo;
        this.amount = amount;
    }

    public int getAmount(){
        return amount;
    }

    public void removeAmount(int amount){
        this.amount -= amount;
        blockInfo.nbt().putInt(SourceJarTile.SOURCE_TAG, this.amount);
    }

    public void addAmount(int amount){
        this.amount += amount;
        blockInfo.nbt().putInt(SourceJarTile.SOURCE_TAG, this.amount);
    }

    public void removeWithUpdate(Level level, int amount, AbstractContraptionEntity entity){
        int currentFillState = getFillState(this.getAmount());
        this.removeAmount(amount);
        int nextFillState = getFillState(this.amount);
        if(currentFillState != nextFillState) {
            syncSource(entity, nextFillState);
        }
    }

    public void addWithUpdate(Level level, int amount, AbstractContraptionEntity entity){
        int currentFillState = getFillState(this.getAmount());
        this.addAmount(amount);
        int nextFillState = getFillState(this.amount);
        if(currentFillState != nextFillState) {
            syncSource(entity, nextFillState);
        }
    }

    public void syncSource(AbstractContraptionEntity contraption, int nextFillState){
        BlockPos structurePos = blockInfo.pos();
        CompoundTag structureTag = blockInfo.nbt();
        contraption.setBlock(structurePos,  new StructureTemplate.StructureBlockInfo(structurePos, BlockRegistry.SOURCE_JAR.defaultBlockState().setValue(SourceJar.fill, nextFillState), structureTag));
    }
}
