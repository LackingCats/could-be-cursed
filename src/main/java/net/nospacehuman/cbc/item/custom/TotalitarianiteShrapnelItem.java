package net.nospacehuman.cbc.item.custom;

import net.minecraft.block.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class TotalitarianiteShrapnelItem extends Item {
    public TotalitarianiteShrapnelItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(@NotNull ItemUsageContext context) {
        BlockState blockState = Blocks.LAVA.getDefaultState();
        float f = Math.min(16, 7);
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        BlockPos blockPos = context.getBlockPos();
        for (BlockPos blockPos2 : BlockPos.iterate(blockPos.add(-f, 0.0, -f), blockPos.add(f, 0.0, f))) {
            mutable.set(blockPos2.getX(), blockPos2.getY() + 1, blockPos2.getZ());
            context.getWorld().setBlockState(blockPos2, blockState);
        }

        context.getStack().damage(1, Objects.requireNonNull(context.getPlayer()), (player) -> player.sendToolBreakStatus(player.getActiveHand()));


        return ActionResult.SUCCESS;
    }
}
