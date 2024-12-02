package net.witcher_rpg.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.witcher_rpg.item.WitcherArmorDiagram;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }


    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(WitcherArmorDiagram.ENHANCED_FELINE_SCHOOL_DIAGRAM, Models.HANDHELD);
        itemModelGenerator.register(WitcherArmorDiagram.ENHANCED_GRIFFIN_SCHOOL_DIAGRAM, Models.HANDHELD);
        itemModelGenerator.register(WitcherArmorDiagram.ENHANCED_WOLVEN_SCHOOL_DIAGRAM, Models.HANDHELD);
        itemModelGenerator.register(WitcherArmorDiagram.ENHANCED_URSINE_SCHOOL_DIAGRAM, Models.HANDHELD);

        itemModelGenerator.register(WitcherArmorDiagram.SUPERIOR_FELINE_SCHOOL_DIAGRAM, Models.HANDHELD);
        itemModelGenerator.register(WitcherArmorDiagram.SUPERIOR_GRIFFIN_SCHOOL_DIAGRAM, Models.HANDHELD);
        itemModelGenerator.register(WitcherArmorDiagram.SUPERIOR_WOLVEN_SCHOOL_DIAGRAM, Models.HANDHELD);
        itemModelGenerator.register(WitcherArmorDiagram.SUPERIOR_URSINE_SCHOOL_DIAGRAM, Models.HANDHELD);
    }
}
