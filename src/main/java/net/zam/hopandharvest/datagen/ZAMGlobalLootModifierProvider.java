package net.zam.hopandharvest.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;
import net.zam.hopandharvest.HopsHarvest;
import net.zam.hopandharvest.loot.DungeonChests;
import net.zam.hopandharvest.registry.ZAMItems;

public class ZAMGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ZAMGlobalLootModifierProvider(PackOutput output) {
        super(output, HopsHarvest.MOD_ID);
    }

    @Override
    protected void start() {
        add("hops_seeds_from_dungeon", new DungeonChests(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/simple_dungeon")).build(),
                LootItemRandomChanceCondition.randomChance(0.25f).build() }, // 25% chance
                ZAMItems.HOP_SEEDS.get(), 1, 5));

        add("hops_seeds_from_mineshaft", new DungeonChests(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/abandoned_mineshaft")).build(),
                LootItemRandomChanceCondition.randomChance(0.25f).build() }, // 25% chance
                ZAMItems.HOP_SEEDS.get(), 1, 5));

        add("hops_seeds_from_shipwreck", new DungeonChests(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/shipwreck_supply")).build(),
                LootItemRandomChanceCondition.randomChance(0.25f).build() }, // 25% chance
                ZAMItems.HOP_SEEDS.get(), 1, 5));
    }
}
