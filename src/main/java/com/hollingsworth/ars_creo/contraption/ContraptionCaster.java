package com.hollingsworth.ars_creo.contraption;

import com.hollingsworth.arsnouveau.api.item.inv.FilterableItemHandler;
import com.hollingsworth.arsnouveau.api.spell.SpellContext;
import com.hollingsworth.arsnouveau.api.spell.wrapped_caster.IWrappedCaster;
import com.simibubi.create.content.contraptions.AbstractContraptionEntity;

import java.util.ArrayList;
import java.util.List;

public class ContraptionCaster implements IWrappedCaster {

    AbstractContraptionEntity contraption;
    List<FilterableItemHandler> itemHandlers;

    public ContraptionCaster(AbstractContraptionEntity contraption){
        this.contraption = contraption;
        itemHandlers = new ArrayList<>();
       // TODO: restore inventory
        // itemHandlers.add(new FilterableItemHandler(contraption.getContraption().getSharedInventory()));
    }

    @Override
    public SpellContext.CasterType getCasterType() {
        return SpellContext.CasterType.OTHER;
    }

    @Override
    public List<FilterableItemHandler> getInventory() {
        return itemHandlers;
    }

    @Override
    public void expendMana(int totalCost) {
        // todo: restore source expenditure
    }
}
