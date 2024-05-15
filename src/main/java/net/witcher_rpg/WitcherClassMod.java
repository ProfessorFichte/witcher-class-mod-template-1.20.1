package net.witcher_rpg;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.witcher_rpg.client.particle.Particles;
import net.witcher_rpg.config.EffectsConfig;
import net.witcher_rpg.effect.Effects;
import net.witcher_rpg.entity.YrdenEntity;
import net.witcher_rpg.worldgen.OreGen;
import net.witcher_rpg.blocks.WitcherBlocks;
import net.witcher_rpg.item.armor.Armors;
import net.spell_engine.api.item.ItemConfig;
import net.spell_engine.api.loot.LootConfig;
import net.spell_engine.api.loot.LootHelper;
import net.tinyconfig.ConfigManager;
import net.witcher_rpg.config.Default;
import net.witcher_rpg.custom.custom_spells.CustomSpells;
import net.witcher_rpg.item.WitcherGroup;
import net.witcher_rpg.item.WitcherItems;
import net.witcher_rpg.item.weapon.WeaponsRegister;
import net.witcher_rpg.util.loot.WitcherLootTableChestModifiers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WitcherClassMod implements ModInitializer {
	public static final String MOD_ID = "witcher_rpg";
    public static final Logger LOGGER = LoggerFactory.getLogger("witcher_rpg");


	public static ConfigManager<ItemConfig> itemConfig = new ConfigManager<ItemConfig>
			("items_v2", Default.itemConfig)
			.builder()
			.setDirectory(MOD_ID)
			.sanitize(true)
			.build();

	public static ConfigManager<LootConfig> lootConfig = new ConfigManager<LootConfig>
			("loot_v2", Default.lootConfig)
			.builder()
			.setDirectory(MOD_ID)
			.sanitize(true)
			.constrain(LootConfig::constrainValues)
			.build();
	public static ConfigManager<EffectsConfig> effectsConfig = new ConfigManager<EffectsConfig>
			("effects", new EffectsConfig())
			.builder()
			.setDirectory(MOD_ID)
			.sanitize(true)
			.build();

	private void registerItemGroup() {
		WitcherGroup.WITCHER = FabricItemGroup.builder()
				.icon(() -> new ItemStack(Armors.witcherArmorSet.chest.asItem()))
				.displayName(Text.translatable("itemGroup." + MOD_ID + ".general"))
				.build();
		Registry.register(Registries.ITEM_GROUP, WitcherGroup.WITCHER_KEY, WitcherGroup.WITCHER);
	}

	private void subscribeEvents() {
		LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
			LootHelper.configure(id, tableBuilder, WitcherClassMod.lootConfig.value, WitcherItems.entries);
		});
	}

	@Override
	public void onInitialize() {
		lootConfig.refresh();
		itemConfig.refresh();
		WitcherLootTableChestModifiers.modifyChestLootTables();
		WitcherItems.registerModItems();
		Particles.register();
		Effects.register();
		WitcherGroup.registerItemGroups();
		OreGen.register();
		WitcherBlocks.register();
		CustomSpells.register();
		WeaponsRegister.register(itemConfig.value.weapons);
		Armors.register(itemConfig.value.armor_sets);
		itemConfig.save();
		registerItemGroup();
		subscribeEvents();
	}

	static{
		YrdenEntity.ENTITY_TYPE = Registry.register(
				Registries.ENTITY_TYPE,
				new Identifier(MOD_ID, "yrden"),
				FabricEntityTypeBuilder.<YrdenEntity>create(SpawnGroup.MISC, YrdenEntity::new)
						.dimensions(EntityDimensions.changing(6F, 0.5F))
						.fireImmune()
						.trackRangeBlocks(128)
						.trackedUpdateRate(20)
						.build()
		);
	}
}