package mod.azure.doom.client.models.items;

import mod.azure.doom.DoomMod;
import mod.azure.doom.item.GuntableBlockItem;
import net.minecraft.resources.ResourceLocation;
import mod.azure.azurelib.model.GeoModel;

public class GunCraftingItemModel extends GeoModel<GuntableBlockItem> {
	@Override
	public ResourceLocation getAnimationResource(GuntableBlockItem entity) {
		return DoomMod.modResource("animations/gun_table.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GuntableBlockItem animatable) {
		return DoomMod.modResource("geo/gun_table.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GuntableBlockItem entity) {
		return DoomMod.modResource("textures/block/gun_table.png");
	}
}
