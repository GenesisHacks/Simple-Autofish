package net.genesis.autofish.mixin;

import static net.genesis.autofish.Autofish.mc;
import static net.genesis.autofish.Autofish.on;
import static net.genesis.autofish.Autofish.ClientPlayer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FishingBobberEntity.class)
public abstract class AutofishMixin {
	@Shadow
	private boolean caughtFish;


	@Shadow
	public abstract PlayerEntity getPlayerOwner();



	@Inject(at = {@At("TAIL")}, method = {"onTrackedDataSet"})
	public void onTrackedDataSet(TrackedData<?> data, CallbackInfo ci) throws InterruptedException {
		ClientPlayer = MinecraftClient.getInstance().player;
		ItemStack AMainHand = ClientPlayer.getMainHandStack();
		ItemStack AOffHand = ClientPlayer.getOffHandStack();

		if (caughtFish && getPlayerOwner() instanceof ClientPlayerEntity) {
			if (!on) {
				if (AMainHand.isOf(Items.FISHING_ROD)) {
					mc.interactionManager.interactItem(mc.player, Hand.MAIN_HAND);
					Thread.sleep(5L);
					mc.interactionManager.interactItem(mc.player, Hand.MAIN_HAND);
				}
				if (AOffHand.isOf(Items.FISHING_ROD)) {
					mc.interactionManager.interactItem(mc.player, Hand.OFF_HAND);
					Thread.sleep(5L);
					mc.interactionManager.interactItem(mc.player, Hand.OFF_HAND);
				}
			}
		}
	}
}
