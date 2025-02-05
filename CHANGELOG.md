# 2.4.0 - 1.21.1
- Spell Engine 1.5 Update
- fix Attribute Registry
- changed some cooldowns and casting times

# 2.3.1 - 1.21.1
- fixed crash -> forgot ServerWorld Check on Yrden particle effect spawner

# 2.3.0 - 1.21.1
**- Spell Engine 1.4 Update!**
- AzureLib Armor 3.0 Update!
- Rend & Whirl range now matching the melee weapon distance
- Buffed the Range for the Axii Puppet spell

### 2.2.4 - 1.21
- Fixed some errors regarding Witcher Ores

2.2.3 - 1.21
- Fix: Witcher Spell Books uncraftable since 2.2.2 #6

2.2.2 - 1.21
- ### **Spell Scroll Update**
- **Spell Allocation**
- The Alternate Signs can be found via the new loot-able Spell Scrolls
- The Alternate Signs can be added to the Master Witcher Spell Book
- This can be done on the Spell Binding Table
- The Master Witcher Spell Book can only contain 7 Spells
- **BALANCING**
- Whirl cast duration was reduced to 2.5 from 3.5
- Witcher Reflexes cast duration was increased to 0.5 from 0.25
- **GENERAL**
- added the missing sign intensity & adrenaline burst effect (Attribute Boosting Effect)
- renamed the spell book item ids

2.2.1 - 1.21
- fixed a issue with the wolven armor crafting recipe

2.2.0 - 1.21
- Spell Engine 1.2 Update
- added the Heavenly Witcher Sword (Aether Variant)

2.1.0 - 1.21
**WITCHER SCHOOLS ARMOR UPDATE**
**INTERNAL CHANGES**
- BREAKING FOR TEXTURE PACKS: Changed the paths for textures in the model files
- CONFIG RESET: Your custom item Configs got reset, the config file is now called: "items_v5"
- Added magic damage types for each sign school and silver
- Added entity type tags for targets that are vulnerable to a specific sign
- Added Entity Type for Axii Immunity (Mostly for Bosses)
- If a target is vulnerable to a specific sign, the damage gets increased
- Cleaned up the code of relic witcher swords
- Added a tweaks config file
- Added a Witcher Grave Structure for Witcher Related Loot
- Relic Witcher Swords can only be found in Witcher Related structure chests now and in the future (LNE Witcher Add On)

**BALANCING**
- Rend Spell damage now scales with adrenaline effect amplifier
- Casting damaging signs (aard & igni) increases your adrenaline now
- Added the Stagger Effect
- Made the passive for all relic swords configurable
- The ultimatum sword applies stagger instead of fire
- Added missing textures of status effects
- The Kaer Morhen Set now acts as an early- to mid-game armor choice
- Changed Armor Set Bonuses

**ADDITIONS**
- You now can level up your Witcher School Armor!
- Added "smithing template" diagrams for each witcher school armor (Enhanced & Superior Tier)
- New Armor: Wolven Witcher-School Armor
- Wolven Gear is a hybrid medium armor type
- Superior witcher gear is fireproof like Netherite gear

2.0.5 - 1.21
- forgot "has_meteorite" worldgen tag for the new meteorite "geode" feature

2.0.4 - 1.21
- **CONFIG** Your effects config got overwritten, use effects_v1 now
- forgot to add silver & steel swords to their tags
- added more configured_feature variants for the witcher ores
- tweaked some numbers for the ores
- made the dark iron ore brighter
- added a meteorite like geode
- added netherrack dark iron ore
- adrenaline effect amplifier now gets decreased on receiving damage (like in TW3 game)

2.0.3
- Ice And Fire Fabric Silver Ingot Compat

2.0.2
- Griffin School Armor used Ursine Armor texture, oops

2.0.1
- Spell Engine API Update (1.1.0 + 1.21.1)
- Updated SpellHelperMixin
- QuenActiveShield now stuns you for a short amount when removed, because it explodes in TW3 and knocks you back
- fixed tooltips for some witcher swords
- made the Master Witcher Book not stack able

2.0.0
-  1.21.x update
- alternate sign mode is disabled for 1.21 version, will be enabled later
- the alternate signs can still be found in the Master Witcher Spell Book
- Sign Intensity Enchant is for Weapons, added specific sign intensity enchants for all Sign-Forms for the armor
- new particles for the aard signs
- new Spell School Witcher_Melee, that the melee spells also benefit from adrenaline, to crit more & higher
- Rend now stuns blocking entities and adds grievous wounds effect
- nerfed Whirl & Rend cooldown