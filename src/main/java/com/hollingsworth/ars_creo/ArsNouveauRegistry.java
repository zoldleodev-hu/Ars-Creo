package com.hollingsworth.ars_creo;

import com.hollingsworth.ars_creo.common.registry.ModBlockRegistry;
import com.hollingsworth.arsnouveau.api.documentation.ReloadDocumentationEvent;
import com.hollingsworth.arsnouveau.api.documentation.builder.DocEntryBuilder;
import com.hollingsworth.arsnouveau.api.registry.DocumentationRegistry;

public class ArsNouveauRegistry {
    public static void registerDocumentation(ReloadDocumentationEvent event){
        DocumentationRegistry.registerEntry(DocumentationRegistry.CRAFTING, new DocEntryBuilder(ArsCreo.MODID, DocumentationRegistry.CRAFTING, ModBlockRegistry.STARBY_WHEEL.get().asItem())
                .withIntroPage()
                .withCraftingPages(ModBlockRegistry.STARBY_WHEEL.get()).build());
    }
}
