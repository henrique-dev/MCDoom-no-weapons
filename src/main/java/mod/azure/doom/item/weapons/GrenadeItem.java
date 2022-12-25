package mod.azure.doom.item.weapons;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

import mod.azure.doom.client.render.item.GrenadeItemRender;
import mod.azure.doom.entity.projectiles.GrenadeEntity;
import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.animatable.client.RenderProvider;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class GrenadeItem extends Item implements GeoItem {

	private final Supplier<Object> renderProvider = GeoItem.makeRenderer(this);
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

	public GrenadeItem() {
		super(new Item.Properties().stacksTo(64));
		SingletonGeoAnimatable.registerSyncedAnimatable(this);
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
		controllers.add(new AnimationController<>(this, "popup_controller", 0, state -> PlayState.CONTINUE));
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.cache;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player user, InteractionHand hand) {
		ItemStack itemstack = user.getItemInHand(hand);
		if (!user.getCooldowns().isOnCooldown(this)) {
			user.getCooldowns().addCooldown(this, 25);
			if (!world.isClientSide) {
				GrenadeEntity snowball = new GrenadeEntity(world, user);
				snowball.shootFromRotation(user, user.getXRot(), user.getYRot(), 0.0F, 1.05F, 1.0F);
				snowball.setBaseDamage(0);
				world.addFreshEntity(snowball);
			}
			if (!user.getAbilities().instabuild) {
				itemstack.shrink(1);
			}
			return InteractionResultHolder.sidedSuccess(itemstack, world.isClientSide());
		} else {
			return InteractionResultHolder.fail(itemstack);
		}
	}

	@Override
	public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
		tooltip.add(Component.translatable("doom.doomed_credit.text").withStyle(ChatFormatting.RED)
				.withStyle(ChatFormatting.ITALIC));
		tooltip.add(Component.translatable("doom.doomed_credit1.text").withStyle(ChatFormatting.RED)
				.withStyle(ChatFormatting.ITALIC));
		super.appendHoverText(stack, worldIn, tooltip, flagIn);
	}

	@Override
	public void createRenderer(Consumer<Object> consumer) {
		consumer.accept(new RenderProvider() {
			private final GrenadeItemRender renderer = new GrenadeItemRender();

			@Override
			public BlockEntityWithoutLevelRenderer getCustomRenderer() {
				return this.renderer;
			}
		});
	}

	@Override
	public Supplier<Object> getRenderProvider() {
		return this.renderProvider;
	}

}
