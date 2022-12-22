package net.nospacehuman.cbc.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.nospacehuman.cbc.util.MyVarHolder;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class FederalisedOreFinderItem extends Item {
    public FederalisedOreFinderItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(@NotNull ItemUsageContext context) {
        if(context.getWorld().isClient()) {
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;

            for(int i = 0; i <= positionClicked.getY() + 64; i++) {
                Block bloccBelow = context.getWorld().getBlockState(positionClicked.down(i)).getBlock();
                if(isValuableBlocc(bloccBelow)) {
                    assert player != null;
                    outputValuableCoordinates(positionClicked.down(i), player, bloccBelow);
                    foundBlock = true;
                    break;
                }
            }

            if(!foundBlock) {
                assert player != null;
                player.sendMessage(new TranslatableText("item.cbc.federalised_ore_finder.no_valuables"), true);
            }

        }
        context.getStack().damage(2, Objects.requireNonNull(context.getPlayer()), (player) -> player.sendToolBreakStatus(player.getActiveHand()));


        return super.useOnBlock(context);
    }

    private void outputValuableCoordinates(@NotNull BlockPos bloccPos, @NotNull PlayerEntity player, @NotNull Block bloccBelow) {
        player.sendMessage(new LiteralText("Found " + bloccBelow.getName().getString() +
                " at [" + bloccPos.getX() + ", " + bloccPos.getY() + ", " + bloccPos.getZ() +
                        "]. " + MyVarHolder.MSG1 + "OreFinder™ " + MyVarHolder.MSG2), false);
    }

    private boolean isValuableBlocc(Block blocc) {
        return blocc == Blocks.DEEPSLATE_COAL_ORE;
    }

}
