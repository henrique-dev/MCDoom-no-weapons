package mod.azure.doom.item.weapons;

import java.util.function.Consumer;
import java.util.function.Supplier;

import io.netty.buffer.Unpooled;
import mod.azure.doom.DoomMod;
import mod.azure.doom.client.ClientInit;
import mod.azure.doom.client.render.weapons.PlasmagunRender;
import mod.azure.doom.config.DoomConfig;
import mod.azure.doom.entity.projectiles.EnergyCellEntity;
import mod.azure.doom.util.enums.DoomTier;
import mod.azure.doom.util.registry.DoomItems;
import mod.azure.doom.util.registry.DoomSounds;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.animatable.client.RenderProvider;

public class PlasmaGun extends DoomBaseItem {

	private final Supplier<Object> renderProvider = GeoItem.makeRenderer(this);

	public PlasmaGun() {
		super(new Item.Properties().stacksTo(1).durability(401));
		SingletonGeoAnimatable.registerSyncedAnimatable(this);
	}

	@Override
	public boolean isValidRepairItem(ItemStack toRepair, ItemStack repair) {
		return DoomTier.PLASMA.getRepairIngredient().test(repair) || super.isValidRepairItem(toRepair, repair);
	}

	@Override
	public void onUseTick(Level worldIn, LivingEntity entityLiving, ItemStack stack, int count) {
		if (entityLiving instanceof Player) {
			Player playerentity = (Player) entityLiving;
			if (stack.getDamageValue() < (stack.getMaxDamage() - 1)) {
				if (!playerentity.getCooldowns().isOnCooldown(this)) {
					playerentity.getCooldowns().addCooldown(this, 3);
					if (!worldIn.isClientSide) {
						EnergyCellEntity abstractarrowentity = createArrow(worldIn, stack, playerentity);
						abstractarrowentity.shootFromRotation(playerentity, playerentity.getXRot(),
								playerentity.getYRot(), 0.0F, 0.15F * 3.0F, 1.0F);
						abstractarrowentity.isNoGravity();

						stack.hurtAndBreak(1, entityLiving, p -> p.broadcastBreakEvent(entityLiving.getUsedItemHand()));
						worldIn.addFreshEntity(abstractarrowentity);
						worldIn.playSound((Player) null, playerentity.getX(), playerentity.getY(), playerentity.getZ(),
								DoomSounds.PLASMA_FIRING, SoundSource.PLAYERS, 1.0F,
								1.0F / (worldIn.random.nextFloat() * 0.4F + 1.2F) + 0.25F * 0.5F);
						triggerAnim(playerentity, GeoItem.getOrAssignId(stack, (ServerLevel) worldIn),
								"shoot_controller", "firing");
					}
					boolean isInsideWaterBlock = playerentity.level.isWaterAt(playerentity.blockPosition());
					spawnLightSource(entityLiving, isInsideWaterBlock);
				}
			} else {
				worldIn.playSound((Player) null, playerentity.getX(), playerentity.getY(), playerentity.getZ(),
						DoomSounds.EMPTY, SoundSource.PLAYERS, 1.0F, 1.5F);
			}
		}
	}

	public static void reload(Player user, InteractionHand hand) {
		if (user.getItemInHand(hand).getItem() instanceof PlasmaGun) {
			while (!user.isCreative() && user.getItemInHand(hand).getDamageValue() != 0
					&& user.getInventory().countItem(DoomItems.ENERGY_CELLS) > 0) {
				removeAmmo(DoomItems.ENERGY_CELLS, user);
				user.getItemInHand(hand).hurtAndBreak(-20, user, s -> user.broadcastBreakEvent(hand));
				user.getItemInHand(hand).setPopTime(3);
				user.getCommandSenderWorld().playSound((Player) null, user.getX(), user.getY(), user.getZ(),
						DoomSounds.CLIPRELOAD, SoundSource.PLAYERS, 1.00F, 1.0F);
			}
		}
	}

	@Override
	public void inventoryTick(ItemStack stack, Level world, Entity entity, int slot, boolean selected) {
		if (world.isClientSide) {
			if (((Player) entity).getMainHandItem().getItem() instanceof PlasmaGun
					&& ClientInit.reload.consumeClick() && selected) {
				FriendlyByteBuf passedData = new FriendlyByteBuf(Unpooled.buffer());
				passedData.writeBoolean(true);
				ClientPlayNetworking.send(DoomMod.PLASMA, passedData);
			}
		}
	}

	public EnergyCellEntity createArrow(Level worldIn, ItemStack stack, LivingEntity shooter) {
		float j = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, stack);
		EnergyCellEntity arrowentity = new EnergyCellEntity(worldIn, shooter,
				(DoomConfig.energycell_damage + (j * 2.0F)));
		return arrowentity;
	}

	@Override
	public void createRenderer(Consumer<Object> consumer) {
		consumer.accept(new RenderProvider() {
			private final PlasmagunRender renderer = new PlasmagunRender();

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