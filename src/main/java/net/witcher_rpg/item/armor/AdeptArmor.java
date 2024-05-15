package net.witcher_rpg.item.armor;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import mod.azure.azurelibarmor.animatable.GeoItem;
import mod.azure.azurelibarmor.animatable.client.RenderProvider;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Util;
import net.witcher_rpg.client.armor.AdeptArmorRenderer;
import net.more_rpg_classes.entity.attribute.MRPGCEntityAttributes;
import net.spell_engine.api.item.armor.Armor;
import org.jetbrains.annotations.NotNull;

import java.util.EnumMap;
import java.util.UUID;
import java.util.function.Consumer;

public class AdeptArmor extends ModArmorItem implements GeoItem {
    public AdeptArmor(Armor.CustomMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }
    @Override
    public void createRenderer(Consumer<Object> consumer) {
        consumer.accept(new RenderProvider() {
            private AdeptArmorRenderer renderer;

            @Override
            public @NotNull BipedEntityModel<LivingEntity> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, BipedEntityModel<LivingEntity> original) {
                if (renderer == null)
                    renderer = new AdeptArmorRenderer();

                renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                return renderer;
            }
        });
    }

    private Multimap<EntityAttribute, EntityAttributeModifier> attributes;
    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        if (attributes == null) {
            return super.getAttributeModifiers(slot);
        }
        return slot == this.type.getEquipmentSlot() ? this.attributes : super.getAttributeModifiers(slot);
    }
    private static final EnumMap MODIFIERS = (EnumMap) Util.make(new EnumMap(Type.class), (uuidMap) -> {
        uuidMap.put(Type.BOOTS, UUID.fromString("43beccfa-76b7-409e-935b-9c8006816c7b"));
        uuidMap.put(Type.LEGGINGS, UUID.fromString("1c818bc1-11f1-4e17-8937-c1f5a69949df"));
        uuidMap.put(Type.CHESTPLATE, UUID.fromString("006084c8-f8e5-4ca6-8d92-dbfb2e37097f"));
        uuidMap.put(Type.HELMET, UUID.fromString("e3c917b4-2690-46aa-b32e-9f718263937a"));
    });

    @Override
    public void setAttributes(Multimap<EntityAttribute, EntityAttributeModifier> attributes) {
        ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.putAll(attributes);
        UUID uuid = (UUID)MODIFIERS.get(this.type);
        builder.put(MRPGCEntityAttributes.SIGN_INTENSITY,new EntityAttributeModifier(uuid,"sign_intensity",0.5, EntityAttributeModifier.Operation.ADDITION));
        builder.put(MRPGCEntityAttributes.ADRENALINE_MODIFIER,new EntityAttributeModifier(uuid,"adrenaline",0.01, EntityAttributeModifier.Operation.MULTIPLY_BASE));
        this.attributes = builder.build();
    }
}