package mod.azure.doom.client.models.armor;

import mod.azure.azurelib.model.GeoModel;
import mod.azure.doom.DoomMod;
import mod.azure.doom.item.armor.ClassicDoomArmor;
import net.minecraft.resources.ResourceLocation;

public class ClassicModel extends GeoModel<ClassicDoomArmor> {
	@Override
	public ResourceLocation getModelResource(ClassicDoomArmor object) {
		return DoomMod.modResource("geo/classicarmor.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ClassicDoomArmor object) {
		return DoomMod.modResource("textures/models/armor/classic_armor_layer_1.png");
	}

	@Override
	public ResourceLocation getAnimationResource(ClassicDoomArmor animatable) {
		return DoomMod.modResource("animations/armor_animation.json");
	}
}