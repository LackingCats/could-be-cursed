package net.nospacehuman.cbc.mixin;

import net.minecraft.client.gui.screen.TitleScreen;
import net.nospacehuman.cbc.CouldBeCursedMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class CouldBeCursedMixin {
	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		CouldBeCursedMod.LOGGER.info("mixin_mixin");
	}
}
