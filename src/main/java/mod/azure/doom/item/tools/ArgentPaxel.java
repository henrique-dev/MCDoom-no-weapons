package mod.azure.doom.item.tools;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Maps;

import mod.azure.doom.util.enums.DoomTier;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

public class ArgentPaxel extends DiggerItem {

	protected static final Map<Block, BlockState> SHOVEL_LOOKUP = Maps.newHashMap((new Builder<Block, BlockState>())
			.put(Blocks.GRASS_BLOCK, Blocks.DIRT_PATH.defaultBlockState())
			.put(Blocks.DIRT, Blocks.DIRT_PATH.defaultBlockState()).put(Blocks.PODZOL, Blocks.DIRT_PATH.defaultBlockState())
			.put(Blocks.COARSE_DIRT, Blocks.DIRT_PATH.defaultBlockState())
			.put(Blocks.MYCELIUM, Blocks.DIRT_PATH.defaultBlockState())
			.put(Blocks.ROOTED_DIRT, Blocks.DIRT_PATH.defaultBlockState()).build());

	protected static final Map<Block, Block> BLOCK_STRIPPING_MAP = (new Builder<Block, Block>())
			.put(Blocks.OAK_WOOD, Blocks.STRIPPED_OAK_WOOD).put(Blocks.OAK_LOG, Blocks.STRIPPED_OAK_LOG)
			.put(Blocks.DARK_OAK_WOOD, Blocks.STRIPPED_DARK_OAK_WOOD)
			.put(Blocks.DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_LOG).put(Blocks.ACACIA_WOOD, Blocks.STRIPPED_ACACIA_WOOD)
			.put(Blocks.ACACIA_LOG, Blocks.STRIPPED_ACACIA_LOG).put(Blocks.BIRCH_WOOD, Blocks.STRIPPED_BIRCH_WOOD)
			.put(Blocks.BIRCH_LOG, Blocks.STRIPPED_BIRCH_LOG).put(Blocks.JUNGLE_WOOD, Blocks.STRIPPED_JUNGLE_WOOD)
			.put(Blocks.JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_LOG).put(Blocks.SPRUCE_WOOD, Blocks.STRIPPED_SPRUCE_WOOD)
			.put(Blocks.SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_LOG).put(Blocks.WARPED_STEM, Blocks.STRIPPED_WARPED_STEM)
			.put(Blocks.WARPED_HYPHAE, Blocks.STRIPPED_WARPED_HYPHAE)
			.put(Blocks.CRIMSON_STEM, Blocks.STRIPPED_CRIMSON_STEM)
			.put(Blocks.CRIMSON_HYPHAE, Blocks.STRIPPED_CRIMSON_HYPHAE).build();

	@SuppressWarnings("unused")
	private static final List<TagKey<Block>> MINEABLE = ImmutableList.of(BlockTags.MINEABLE_WITH_AXE,
			BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.MINEABLE_WITH_SHOVEL);

	public ArgentPaxel() {
		super(9, -2.4F, DoomTier.DOOM, BlockTags.MINEABLE_WITH_AXE, new Item.Properties().stacksTo(1));
	}

	@Override
	public float getDestroySpeed(ItemStack stack, BlockState state) {
		return 30;
	}

	@Override
	public boolean isCorrectToolForDrops(BlockState state) {
		Block block = state.getBlock();
		if (block == Blocks.SNOW || block == Blocks.SNOW_BLOCK) {
			return true;
		}
		Material material = state.getMaterial();
		return material == Material.STONE || material == Material.METAL;
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		Level world = context.getLevel();
		BlockPos blockPos = context.getClickedPos();
		Player player = context.getPlayer();
		BlockState blockstate = world.getBlockState(blockPos);
		BlockState resultToSet = null;
		Block strippedResult = BLOCK_STRIPPING_MAP.get(blockstate.getBlock());
		if (strippedResult != null) {
			world.playSound(player, blockPos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
			resultToSet = strippedResult.defaultBlockState().setValue(RotatedPillarBlock.AXIS,
					blockstate.getValue(RotatedPillarBlock.AXIS));
		} else {
			if (context.getClickedFace() != Direction.DOWN) {
				BlockState foundResult = SHOVEL_LOOKUP.get(blockstate.getBlock());
				if (foundResult != null && world.getBlockState(blockPos.above()).isAir()) {
					world.playSound(player, blockPos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0F, 1.0F);
					resultToSet = foundResult;
				} else if (blockstate.getBlock() instanceof CampfireBlock && blockstate.getValue(CampfireBlock.LIT)) {
					resultToSet = blockstate.setValue(CampfireBlock.LIT, false);
				}
			}
		}
		if (resultToSet == null) {
			return InteractionResult.PASS;
		}
		if (!world.isClientSide()) {
			world.setBlock(blockPos, resultToSet, 11);
			if (player != null) {
				context.getItemInHand().hurtAndBreak(1, (LivingEntity) player, (Consumer<LivingEntity>) ((p) -> {
					((LivingEntity) p).broadcastBreakEvent(context.getHand());
				}));
			}
		}
		return InteractionResult.SUCCESS;
	}

	@Override
	public void appendHoverText(ItemStack itemStack, Level level, List<Component> list, TooltipFlag tooltipFlag) {
		list.add(Component.translatable("doom.argent_powered.text").withStyle(ChatFormatting.RED)
				.withStyle(ChatFormatting.ITALIC));
		super.appendHoverText(itemStack, level, list, tooltipFlag);
	}

}