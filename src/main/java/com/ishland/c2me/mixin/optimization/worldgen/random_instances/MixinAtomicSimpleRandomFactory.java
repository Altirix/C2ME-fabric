package com.ishland.c2me.mixin.optimization.worldgen.random_instances;

import net.minecraft.util.math.MathHelper;
import net.minecraft.world.gen.random.AbstractRandom;
import net.minecraft.world.gen.random.AtomicSimpleRandom;
import net.minecraft.world.gen.random.RandomDeriver;
import net.minecraft.world.gen.random.SimpleRandom;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(AtomicSimpleRandom.RandomDeriver.class)
public abstract class MixinAtomicSimpleRandomFactory implements RandomDeriver {

    @Shadow @Final private long seed;

    /**
     * @author ishland
     * @reason non-atomic
     */
    @Overwrite
    @Override
    public AbstractRandom createRandom(int x, int y, int z) { // TODO [VanillaCopy]
        long l = MathHelper.hashCode(x, y, z);
        long m = l ^ this.seed;
        return new SimpleRandom(m);
    }

    /**
     * @author ishland
     * @reason non-atomic
     */
    @Overwrite
    @Override
    public AbstractRandom createRandom(String string) { // TODO [VanillaCopy]
        int i = string.hashCode();
        return new SimpleRandom((long)i ^ this.seed);
    }

}
