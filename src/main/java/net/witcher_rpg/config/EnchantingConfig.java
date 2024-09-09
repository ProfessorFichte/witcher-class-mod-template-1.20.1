package net.witcher_rpg.config;


import net.tinyconfig.versioning.VersionableConfig;
import net.witcher_rpg.custom.Enchantment_WitcherSpellSchool;

public class EnchantingConfig extends VersionableConfig {
    public boolean allow_stacking = true;
    public PowerEnchantingConfig sign_intensity = new PowerEnchantingConfig(true, 5, 10, 9, 0.03F);

    public EnchantingConfig() {
    }

    public void apply() {
        Enchantment_WitcherSpellSchool.SIGNS.config = this.sign_intensity ;
    }
}
