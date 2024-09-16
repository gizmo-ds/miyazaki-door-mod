package dev.aika.miyazaki_door.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoorBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MiyazakiDoorBlock extends DoorBlock {
    public MiyazakiDoorBlock(Settings settings, BlockSetType blockSetType) {
        super(settings, blockSetType);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient) {
            if (!isOpen(state)) {
                world.playSound(player, pos, getBlockSetType().doorOpen(), SoundCategory.BLOCKS, 1.0F, world.getRandom().nextFloat() * 0.1F + 0.9F);
            }
            return ActionResult.PASS;
        }
        if (isOpen(state)) return ActionResult.PASS;
        player.sendMessage(Text.translatable("miyazaki-door.message.cant_open"), true);
        return ActionResult.FAIL;
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean notify) {
        // Do nothing
    }
}
