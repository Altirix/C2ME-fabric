package com.ishland.c2me.client.mixin.uncapvd;

import com.ishland.c2me.common.config.C2MEConfig;
import net.minecraft.client.option.DoubleOption;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.Option;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

@Mixin(Option.class)
public class MixinOption {

    @Shadow @Final public static DoubleOption RENDER_DISTANCE;

    @Inject(method = "<clinit>", at = @At(value = "TAIL"))
    private static void modifyMaxViewDistance(CallbackInfo ci) {
        RENDER_DISTANCE.setMax(C2MEConfig.clientSideConfig.modifyMaxVDConfig.maxViewDistance);
    }

}
