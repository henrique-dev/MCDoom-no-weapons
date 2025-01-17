package mod.azure.doom.client.render;

import mod.azure.azurelib.renderer.GeoEntityRenderer;
import mod.azure.doom.client.models.CacodemonModel;
import mod.azure.doom.entity.tierheavy.CacodemonEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class CacodemonRender extends GeoEntityRenderer<CacodemonEntity> {

	public CacodemonRender(EntityRendererProvider.Context renderManagerIn) {
		super(renderManagerIn, new CacodemonModel());
	}

	@Override
	protected float getDeathMaxRotation(CacodemonEntity entityLivingBaseIn) {
		return 0.0F;
	}

}