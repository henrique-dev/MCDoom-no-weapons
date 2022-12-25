package mod.azure.doom.item.powerup;

import java.util.List;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class InvisibleSphereItem extends Item {

	public InvisibleSphereItem() {
		super(new Item.Properties().stacksTo(64));
	}

	@Override
	public void onUseTick(Level worldIn, LivingEntity livingEntityIn, ItemStack stack, int count) {
		if (livingEntityIn instanceof Player) {
			Player playerentity = (Player) livingEntityIn;
			if (!worldIn.isClientSide()) {
				livingEntityIn.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 1200, 1));
				if (!playerentity.getAbilities().instabuild) {
					stack.shrink(1);
					if (stack.isEmpty()) {
						playerentity.getInventory().removeItem(stack);
					}
				}
			}
		}
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player user, InteractionHand hand) {
		ItemStack itemStack = user.getItemInHand(hand);
		user.startUsingItem(hand);
		return InteractionResultHolder.consume(itemStack);
	}

	@Override
	public UseAnim getUseAnimation(ItemStack stack) {
		return UseAnim.NONE;
	}

	@Override
	public int getUseDuration(ItemStack stack) {
		return 7000;
	}

	@Override
	public InteractionResult interactLivingEntity(ItemStack stack, Player user, LivingEntity entity,
			InteractionHand hand) {
		user.getItemInHand(hand);
		return InteractionResult.CONSUME;
	}

	@Override
	public void appendHoverText(ItemStack itemStack, Level level, List<Component> list, TooltipFlag tooltipFlag) {
		list.add(Component.translatable("doom.invisible.text").withStyle(ChatFormatting.ITALIC));
		super.appendHoverText(itemStack, level, list, tooltipFlag);
	}

}