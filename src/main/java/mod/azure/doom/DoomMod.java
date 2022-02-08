package mod.azure.doom;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import mod.azure.doom.block.GunTableBlock;
import mod.azure.doom.client.gui.GunTableScreenHandler;
import mod.azure.doom.config.DoomConfig;
import mod.azure.doom.entity.tileentity.GunBlockEntity;
import mod.azure.doom.entity.tileentity.IconBlockEntity;
import mod.azure.doom.entity.tileentity.TotemEntity;
import mod.azure.doom.network.PacketHandler;
import mod.azure.doom.util.DoomVillagerTrades;
import mod.azure.doom.util.MobAttributes;
import mod.azure.doom.util.MobSpawn;
import mod.azure.doom.util.recipes.GunTableRecipe;
import mod.azure.doom.util.registry.DoomBlocks;
import mod.azure.doom.util.registry.DoomItems;
import mod.azure.doom.util.registry.DoomStructures;
import mod.azure.doom.util.registry.DoomStructuresConfigured;
import mod.azure.doom.util.registry.ModEntityTypes;
import mod.azure.doom.util.registry.ModSoundEvents;
import mod.azure.doom.util.registry.ProjectilesEntityRegister;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.fabricmc.fabric.impl.structure.FabricStructureImpl;
import net.fabricmc.fabric.mixin.structure.StructuresConfigAccessor;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.chunk.FlatChunkGenerator;
import net.minecraft.world.gen.chunk.StructureConfig;
import net.minecraft.world.gen.chunk.StructuresConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import software.bernie.geckolib3.GeckoLib;

public class DoomMod implements ModInitializer {

	public static DoomItems ITEMS;
	public static DoomConfig config;
	public static ModSoundEvents SOUNDS;
	public static ModEntityTypes MOBS;
	public static final String MODID = "doom";
	public static BlockEntityType<TotemEntity> TOTEM;
	public static BlockEntityType<IconBlockEntity> ICON;
	public static ProjectilesEntityRegister PROJECTILES;
	public static RecipeType<GunTableRecipe> GUN_TABLE_RECIPE;
	public static final Logger LOGGER = LogManager.getLogger();
	public static BlockEntityType<GunBlockEntity> GUN_TABLE_ENTITY;
	public static final Identifier BFG = new Identifier(MODID, "bfg");
	public static final Identifier PISTOL = new Identifier(MODID, "pistol");
	public static final Identifier PLASMA = new Identifier(MODID, "plamsa");
	public static final Identifier BFG9000 = new Identifier(MODID, "bfg9000");
	public static final Identifier SHOTGUN = new Identifier(MODID, "shotgun");
	public static final Identifier UNMAYKR = new Identifier(MODID, "unmaykr");
	public static final Identifier BALLISTA = new Identifier(MODID, "ballista");
	public static final Identifier CHAINGUN = new Identifier(MODID, "chaingun");
	public static final Identifier CHAINSAW = new Identifier(MODID, "chainsaw");
	public static final Identifier CRUCIBLE = new Identifier(MODID, "crucible");
	public static final Identifier GUNS = new Identifier(MODID, "crafting_guns");
	public static final Identifier RELOAD_GUN = new Identifier(MODID, "gun_reload");
	public static final Identifier HEAVYCANNON = new Identifier(MODID, "heavycannon");
	public static final Identifier MARAUDERAXE = new Identifier(MODID, "marauderaxe");
	public static final Identifier SUPERSHOTGUN = new Identifier(MODID, "supershotgun");
	public static final Identifier GUN_TABLE_GUI = new Identifier(MODID, "gun_table_gui");
	public static final Identifier ROCKETLAUNCHER = new Identifier(MODID, "rocketlauncher");
	public static final Identifier SENTINELHAMMER = new Identifier(MODID, "sentinelhammer");
	public static final Identifier CHAINSAW_ETERNAL = new Identifier(MODID, "chainsaweternal");
	public static final Identifier DARKLORDCRUCIBLE = new Identifier(MODID, "darklordcrucible");
	public static final Identifier DSG = new Identifier(MODID, "doomed_shotgun");
	public static final Identifier DGAUSS = new Identifier(MODID, "doomed_gauss");
	public static final Identifier DPLASMARIFLE = new Identifier(MODID, "doomed_plasma_rifle");
	public static final GunTableBlock GUN_TABLE = new GunTableBlock(
			FabricBlockSettings.of(Material.METAL).sounds(BlockSoundGroup.METAL).strength(4.0f).nonOpaque());
	public static final ItemGroup DoomEggItemGroup = FabricItemGroupBuilder.create(new Identifier(MODID, "eggs"))
			.icon(() -> new ItemStack(DoomItems.IMP_SPAWN_EGG)).build();
	public static final ItemGroup DoomArmorItemGroup = FabricItemGroupBuilder.create(new Identifier(MODID, "armor"))
			.icon(() -> new ItemStack(DoomItems.DOOM_HELMET)).build();
	public static final ItemGroup DoomBlockItemGroup = FabricItemGroupBuilder.create(new Identifier(MODID, "blocks"))
			.icon(() -> new ItemStack(DoomBlocks.BARREL_BLOCK)).build();
	public static final ItemGroup DoomWeaponItemGroup = FabricItemGroupBuilder.create(new Identifier(MODID, "weapons"))
			.icon(() -> new ItemStack(DoomItems.BFG_ETERNAL)).build();
	public static final ItemGroup DoomPowerUPItemGroup = FabricItemGroupBuilder.create(new Identifier(MODID, "powerup"))
			.icon(() -> new ItemStack(DoomItems.INMORTAL)).build();
	public static ScreenHandlerType<GunTableScreenHandler> SCREEN_HANDLER_TYPE = ScreenHandlerRegistry
			.registerSimple(GUN_TABLE_GUI, GunTableScreenHandler::new);
	public static final RecipeSerializer<GunTableRecipe> GUN_TABLE_RECIPE_SERIALIZER = Registry
			.register(Registry.RECIPE_SERIALIZER, new Identifier(MODID, "gun_table"), new GunTableRecipe.Serializer());

	@Override
	public void onInitialize() {
		AutoConfig.register(DoomConfig.class, GsonConfigSerializer::new);
		config = AutoConfig.getConfigHolder(DoomConfig.class).getConfig();
		DoomBlocks.init();
		ITEMS = new DoomItems();
		SOUNDS = new ModSoundEvents();
		MOBS = new ModEntityTypes();
		PROJECTILES = new ProjectilesEntityRegister();
		FuelRegistry.INSTANCE.add(DoomItems.ARGENT_ENERGY, 32767);
		Registry.register(Registry.BLOCK, new Identifier(MODID, "gun_table"), GUN_TABLE);
		ICON = Registry.register(Registry.BLOCK_ENTITY_TYPE, MODID + ":icon",
				FabricBlockEntityTypeBuilder.create(IconBlockEntity::new, DoomBlocks.ICON_WALL1).build(null));
		TOTEM = Registry.register(Registry.BLOCK_ENTITY_TYPE, MODID + ":totem",
				FabricBlockEntityTypeBuilder.create(TotemEntity::new, DoomBlocks.TOTEM).build(null));
		GUN_TABLE_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, MODID + ":guntable",
				FabricBlockEntityTypeBuilder.create(GunBlockEntity::new, GUN_TABLE).build(null));
		MobSpawn.addSpawnEntries();
		if (config.misc.enable_all_villager_trades) {
			ServerLifecycleEvents.SERVER_STARTED.register(minecraftServer -> DoomVillagerTrades.addTrades());
		}
		MobAttributes.init();
		GeckoLib.initialize();
		PacketHandler.registerMessages();
		DoomStructures.setupAndRegisterStructureFeatures();
		DoomStructuresConfigured.registerConfiguredStructures();
		addStructureSpawningToDimensionsAndBiomes();
	}

	public static void addStructureSpawningToDimensionsAndBiomes() {
		BiomeModifications.addStructure(
				BiomeSelectors.categories(Biome.Category.DESERT, Biome.Category.EXTREME_HILLS, Biome.Category.FOREST,
						Biome.Category.ICY, Biome.Category.JUNGLE, Biome.Category.PLAINS, Biome.Category.SAVANNA,
						Biome.Category.TAIGA),
				RegistryKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_KEY, BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE
						.getId(DoomStructuresConfigured.CONFIGURED_HELL_CHURCH)));
		Identifier runAfterFabricAPIPhase = new Identifier(DoomMod.MODID, "run_after_fabric_api");
		ServerWorldEvents.LOAD.addPhaseOrdering(Event.DEFAULT_PHASE, runAfterFabricAPIPhase);
		ServerWorldEvents.LOAD.register(runAfterFabricAPIPhase,
				(MinecraftServer minecraftServer, ServerWorld serverWorld) -> {
					if (serverWorld.getChunkManager().getChunkGenerator() instanceof FlatChunkGenerator
							&& serverWorld.getRegistryKey().equals(World.OVERWORLD)) {
						return;
					}
					StructuresConfig worldStructureConfig = serverWorld.getChunkManager().getChunkGenerator()
							.getStructuresConfig();
					Map<StructureFeature<?>, StructureConfig> tempMap = new HashMap<>(
							worldStructureConfig.getStructures());
					if (serverWorld.getRegistryKey().equals(World.OVERWORLD)) {
						tempMap.put(DoomStructures.HELL_CHURCH,
								FabricStructureImpl.STRUCTURE_TO_CONFIG_MAP.get(DoomStructures.HELL_CHURCH));
					} else {
						tempMap.remove(DoomStructures.HELL_CHURCH);
					}
					((StructuresConfigAccessor) worldStructureConfig).setStructures(tempMap);
				});
	}

}
