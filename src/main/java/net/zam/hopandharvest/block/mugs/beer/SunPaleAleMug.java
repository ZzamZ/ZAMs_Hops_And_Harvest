package net.zam.hopandharvest.block.mugs.beer;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.zam.hopandharvest.block.mugs.MugBlock;
import net.zam.hopandharvest.registry.ZAMParticles;

public class SunPaleAleMug extends MugBlock {

    public SunPaleAleMug(Properties properties) {
        super(properties);
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRand) {
        if (pRand.nextFloat() < 0.4f) {
            double d0 = (double)pPos.getX() + 0.4D + pRand.nextDouble() * 0.2D;
            double d1 = (double)pPos.getY() + 0.2D + pRand.nextDouble() * (0.2D - 0.02D);
            double d2 = (double)pPos.getZ() + 0.4D + pRand.nextDouble() * 0.2D;
            pLevel.addParticle(ZAMParticles.YELLOW_BUBBLES.get(), d0, d1, d2, 0.0D, pRand.nextDouble() * 0.1D, 0.0D);
        }
    }
}