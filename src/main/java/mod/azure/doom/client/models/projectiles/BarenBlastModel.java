package mod.azure.doom.client.models.projectiles;

import mod.azure.azurelib.model.GeoModel;
import mod.azure.doom.DoomMod;
import mod.azure.doom.entity.projectiles.entity.BarenBlastEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class BarenBlastModel extends GeoModel<BarenBlastEntity> {
	@Override
	public ResourceLocation getModelResource(BarenBlastEntity object) {
		return DoomMod.modResource("geo/smallprojectile.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BarenBlastEntity object) {
		return DoomMod.modResource("textures/entity/projectiles/plasma_ball_red.png");
	}

	@Override
	public ResourceLocation getAnimationResource(BarenBlastEntity animatable) {
		return DoomMod.modResource("animations/smallprojectile.animation.json");
	}
	
	@Override
	public RenderType getRenderType(BarenBlastEntity animatable, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureResource(animatable));
	}
}
