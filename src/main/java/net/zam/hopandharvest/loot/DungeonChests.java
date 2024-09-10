package net.zam.hopandharvest.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Random;
import java.util.function.Supplier;

public class DungeonChests extends LootModifier {
    public static final Supplier<Codec<DungeonChests>> CODEC = Suppliers.memoize(() ->
            RecordCodecBuilder.create(inst -> codecStart(inst)
                    .and(ForgeRegistries.ITEMS.getCodec().fieldOf("item").forGetter(m -> m.item))
                    .and(Codec.INT.fieldOf("min_count").forGetter(m -> m.minCount))
                    .and(Codec.INT.fieldOf("max_count").forGetter(m -> m.maxCount))
                    .apply(inst, DungeonChests::new)));

    private final Item item;
    private final int minCount;
    private final int maxCount;

    public DungeonChests(LootItemCondition[] conditionsIn, Item item, int minCount, int maxCount) {
        super(conditionsIn);
        this.item = item;
        this.minCount = minCount;
        this.maxCount = maxCount;
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext lootContext) {
        for (LootItemCondition condition : this.conditions) {
            if (!condition.test(lootContext)) {
                return generatedLoot;
            }
        }

        if (new Random().nextFloat() <= 0.75f) {
            Random random = new Random();
            int count = random.nextInt(maxCount - minCount + 1) + minCount;  // Random count between 1-4
            generatedLoot.add(new ItemStack(this.item, count));  // Add the item with random count
        }

        return generatedLoot;
    }




    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
