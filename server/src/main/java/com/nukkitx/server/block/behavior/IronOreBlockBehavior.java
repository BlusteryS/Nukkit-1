package com.nukkitx.server.block.behavior;

import com.google.common.collect.ImmutableList;
import com.nukkitx.api.Player;
import com.nukkitx.api.block.Block;
import com.nukkitx.api.block.BlockTypes;
import com.nukkitx.api.item.ItemStack;
import com.nukkitx.api.item.TierTypes;
import com.nukkitx.api.item.ToolTypes;
import com.nukkitx.server.item.NukkitItemStackBuilder;

import javax.annotation.Nullable;
import java.util.Collection;

public class IronOreBlockBehavior extends SimpleBlockBehavior {
    public static final IronOreBlockBehavior INSTANCE = new IronOreBlockBehavior();
    private static final ItemStack IRON_ORE = new NukkitItemStackBuilder().itemType(BlockTypes.IRON_ORE).amount(1).build();

    @Override
    public Collection<ItemStack> getDrops(Player player, Block block, @Nullable ItemStack item) {
        return ImmutableList.of(IRON_ORE);
    }

    @Override
    public boolean isCorrectTool(@Nullable ItemStack item) {
        return item != null && item.getItemType().getToolType().isPresent() &&
                item.getItemType().getToolType().get() == ToolTypes.PICKAXE &&
                item.getItemType().getTierType().isPresent() &&
                item.getItemType().getTierType().get().getLevel() >= TierTypes.STONE.getLevel();
    }
}
