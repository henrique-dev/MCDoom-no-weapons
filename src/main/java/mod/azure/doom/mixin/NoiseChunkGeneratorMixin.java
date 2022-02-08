package mod.azure.doom.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.collection.Pool;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.NoiseChunkGenerator;

@Mixin(NoiseChunkGenerator.class)
public class NoiseChunkGeneratorMixin {

	@Inject(method = "getEntitySpawnList(Lnet/minecraft/world/biome/Biome;Lnet/minecraft/world/gen/StructureAccessor;Lnet/minecraft/entity/SpawnGroup;Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/util/collection/Pool;", at = @At(value = "HEAD"), cancellable = true)
	private void structureMobs(Biome biome, StructureAccessor accessor, SpawnGroup group, BlockPos pos,
			CallbackInfoReturnable<Pool<SpawnSettings.SpawnEntry>> cir) {
		Pool<SpawnSettings.SpawnEntry> pool = getStructureSpawns(biome, accessor, group, pos);
		if (pool != null)
			cir.setReturnValue(pool);
	}

	private static Pool<SpawnSettings.SpawnEntry> getStructureSpawns(Biome biome, StructureAccessor accessor,
			SpawnGroup group, BlockPos pos) {

//		if (group == SpawnGroup.MONSTER) {
//			if (accessor.getStructureAt(pos, DoomStructures.HELL_CHURCH).hasChildren()) {
//				return HellChurchStructure.STRUCTURE_MONSTERS;
//			}
//		}

		return null;
	}
}
