package mod.azure.doom.util.registry;

import java.util.HashMap;
import java.util.Map;

import mod.azure.azurelib.items.AzureSpawnEgg;
import mod.azure.doom.DoomMod;
import mod.azure.doom.item.ArgentEnergyItem;
import mod.azure.doom.item.ArgentPlateItem;
import mod.azure.doom.item.UnopenedItem;
import mod.azure.doom.item.ammo.ArgentBolt; // FIRE WEAPON
import mod.azure.doom.item.ammo.BFGCell; // FIRE WEAPON
import mod.azure.doom.item.ammo.ChaingunAmmo; // FIRE WEAPON
import mod.azure.doom.item.ammo.ClipAmmo; // FIRE WEAPON
import mod.azure.doom.item.ammo.EnergyCell; // FIRE WEAPON
import mod.azure.doom.item.ammo.Rocket; // FIRE WEAPON
import mod.azure.doom.item.ammo.ShellAmmo; // FIRE WEAPON
import mod.azure.doom.item.ammo.UnmaykrBolt; // FIRE WEAPON
import mod.azure.doom.item.armor.AstroDoomArmor;
import mod.azure.doom.item.armor.BronzeDoomArmor;
import mod.azure.doom.item.armor.ClassicBronzeDoomArmor;
import mod.azure.doom.item.armor.ClassicDoomArmor;
import mod.azure.doom.item.armor.ClassicIndigoDoomArmor;
import mod.azure.doom.item.armor.ClassicRedDoomArmor;
import mod.azure.doom.item.armor.CrimsonDoomArmor;
import mod.azure.doom.item.armor.CultistDoomArmor;
import mod.azure.doom.item.armor.DarkLordArmor;
import mod.azure.doom.item.armor.DemoncideDoomArmor;
import mod.azure.doom.item.armor.DemonicDoomArmor;
import mod.azure.doom.item.armor.DoomArmor;
import mod.azure.doom.item.armor.DoomicornDoomArmor;
import mod.azure.doom.item.armor.EmberDoomArmor;
import mod.azure.doom.item.armor.GoldDoomArmor;
import mod.azure.doom.item.armor.HotrodDoomArmor;
import mod.azure.doom.item.armor.MaykrDoomArmor;
import mod.azure.doom.item.armor.MidnightDoomArmor;
import mod.azure.doom.item.armor.Mullet2DoomArmor;
import mod.azure.doom.item.armor.Mullet3DoomArmor;
import mod.azure.doom.item.armor.MulletDoomArmor;
import mod.azure.doom.item.armor.NightmareDoomArmor;
import mod.azure.doom.item.armor.PainterDoomArmor;
import mod.azure.doom.item.armor.PhobosDoomArmor;
import mod.azure.doom.item.armor.PraetorDoomArmor;
import mod.azure.doom.item.armor.PurplePonyDoomArmor;
import mod.azure.doom.item.armor.SantaDoomArmor;
import mod.azure.doom.item.armor.SentinelDoomArmor;
import mod.azure.doom.item.armor.TwentyFiveDoomArmor;
import mod.azure.doom.item.armor.ZombieDoomArmor;
import mod.azure.doom.item.powerup.DaisyItem;
import mod.azure.doom.item.powerup.InmortalSphereItem;
import mod.azure.doom.item.powerup.InvisibleSphereItem;
import mod.azure.doom.item.powerup.MegaSphereItem;
import mod.azure.doom.item.powerup.PowerSphereItem;
import mod.azure.doom.item.powerup.SoulCubeItem;
import mod.azure.doom.item.tools.ArgentAxe;
import mod.azure.doom.item.tools.ArgentHoe;
import mod.azure.doom.item.tools.ArgentPaxel;
import mod.azure.doom.item.tools.ArgentPickaxe;
import mod.azure.doom.item.tools.ArgentShovel;
import mod.azure.doom.item.weapons.ArgentSword;
import mod.azure.doom.item.weapons.AxeMarauderItem; // FIRE WEAPON
import mod.azure.doom.item.weapons.BFG; // FIRE WEAPON
import mod.azure.doom.item.weapons.BFG9000; // FIRE WEAPON
import mod.azure.doom.item.weapons.Ballista; // FIRE WEAPON
import mod.azure.doom.item.weapons.Chaingun; // FIRE WEAPON
import mod.azure.doom.item.weapons.Chainsaw; // FIRE WEAPON
import mod.azure.doom.item.weapons.ChainsawAnimated; // FIRE WEAPON
import mod.azure.doom.item.weapons.DGauss; // FIRE WEAPON
import mod.azure.doom.item.weapons.DPlasmaRifle; // FIRE WEAPON
import mod.azure.doom.item.weapons.DShotgun; // FIRE WEAPON
import mod.azure.doom.item.weapons.DarkLordCrucibleItem; // FIRE WEAPON
import mod.azure.doom.item.weapons.GrenadeItem; // FIRE WEAPON
import mod.azure.doom.item.weapons.HeavyCannon; // FIRE WEAPON
import mod.azure.doom.item.weapons.PistolItem; // FIRE WEAPON
import mod.azure.doom.item.weapons.PlasmaGun; // FIRE WEAPON
import mod.azure.doom.item.weapons.RocketLauncher; // FIRE WEAPON
import mod.azure.doom.item.weapons.SentinelHammerItem; // FIRE WEAPON
import mod.azure.doom.item.weapons.Shotgun; // FIRE WEAPON
import mod.azure.doom.item.weapons.SuperShotgun; // FIRE WEAPON
import mod.azure.doom.item.weapons.SwordCrucibleItem; // FIRE WEAPON
import mod.azure.doom.item.weapons.Unmaker; // FIRE WEAPON
import mod.azure.doom.item.weapons.Unmaykr; // FIRE WEAPON
import mod.azure.doom.util.enums.DAMat;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;

public class DoomItems {

	public static Shotgun SG;
	public static BFG9000 BFG;
	public static BFG BFG_ETERNAL;
	public static DaisyItem DAISY;
	public static Rocket ROCKET;
	public static DGauss DGAUSS;
	public static Ballista BALLISTA;
	public static Chaingun CHAINGUN;
	public static Chainsaw CHAINSAW;
	public static PistolItem PISTOL;
	public static DShotgun DSG;
	public static ClipAmmo BULLETS;
	public static BFGCell BFG_CELL;
	public static Unmaykr UNMAYKR;
	public static Unmaker UNMAKER;
	public static Chainsaw CHAINSAW64;
	public static PlasmaGun PLASMAGUN;
	public static ArgentAxe ARGENT_AXE;
	public static ArgentHoe ARGENT_HOE;
	public static SuperShotgun SSG;
	public static SoulCubeItem SOULCUBE;
	public static MegaSphereItem MEGA;
	public static GrenadeItem GRENADE;
	public static HeavyCannon HEAVYCANNON;
	public static Item ICON_ICON;
	public static ArgentBolt ARGENT_BOLT;
	public static ArgentPaxel ARGENT_PAXEL;
	public static ArgentSword ARGENT_SWORD;
	public static PowerSphereItem POWER;
	public static Item GAS_BARREL;
	public static EnergyCell ENERGY_CELLS;
	public static ArgentShovel ARGENT_SHOVEL;
	public static ShellAmmo SHOTGUN_SHELLS;
	public static UnmaykrBolt UNMAKRY_BOLT;
	public static UnopenedItem AXE_CLOSED;
	public static ArgentPickaxe ARGENT_PICKAXE;
	public static ArgentPlateItem ARGENT_PLATE;
	public static AxeMarauderItem AXE_OPEN;
	public static DPlasmaRifle DPLASMARIFLE;
	public static UnopenedItem SWORD_CLOSED;
	public static RocketLauncher ROCKETLAUNCHER;
	public static ArgentEnergyItem ARGENT_ENERGY;
	public static InmortalSphereItem INMORTAL;
	public static ChaingunAmmo CHAINGUN_BULLETS;
	public static SwordCrucibleItem CRUCIBLESWORD;
	public static InvisibleSphereItem INVISIBLE;
	public static ChainsawAnimated CHAINSAW_ETERNAL;
	public static SentinelHammerItem SENTINELHAMMER;
	public static DarkLordCrucibleItem DARKLORDCRUCIBLE;
	public static RecordItem E1M1_MUSIC_DISC;
	public static RecordItem GEOF_MUSIC_DISC;

	// Spawn Eggs
	public static AzureSpawnEgg ARACHNOTRON_SPAWN_EGG;
	public static AzureSpawnEgg IMP_SPAWN_EGG;
	public static AzureSpawnEgg PINKY_SPAWN_EGG;
	public static AzureSpawnEgg ARCHVILE_SPAWN_EGG;
	public static AzureSpawnEgg BARON_SPAWN_EGG;
	public static AzureSpawnEgg CACODEMON_SPAWN_EGG;
	public static AzureSpawnEgg MANCUBUS_SPAWN_EGG;
	public static AzureSpawnEgg LOST_SOUL_SPAWN_EGG;
	public static AzureSpawnEgg LOST_SOUL_ETERNAL_SPAWN_EGG;
	public static AzureSpawnEgg SPIDERMASTERMIND_SPAWN_EGG;
	public static AzureSpawnEgg ZOMBIEMAN_SPAWN_EGG;
	public static AzureSpawnEgg CHAINGUNNER_SPAWN_EGG;
	public static AzureSpawnEgg HELLKNIGHT_SPAWN_EGG;
	public static AzureSpawnEgg MARAUDER_SPAWN_EGG;
	public static AzureSpawnEgg PAIN_SPAWN_EGG;
	public static AzureSpawnEgg REVENANT_SPAWN_EGG;
	public static AzureSpawnEgg SHOTGUNGUY_SPAWN_EGG;
	public static AzureSpawnEgg CYBERDEMON_SPAWN_EGG;
	public static AzureSpawnEgg ICON_SPAWN_EGG;
	public static AzureSpawnEgg UNWILLING_SPAWN_EGG;
	public static AzureSpawnEgg POSSESSED_SCIENTIST_SPAWN_EGG;
	public static AzureSpawnEgg POSSESSED_SOLDIER_SPAWN_EGG;
	public static AzureSpawnEgg GORE_NEST_SPAWN_EGG;
	public static AzureSpawnEgg MECH_ZOMBIE_SPAWN_EGG;
	public static AzureSpawnEgg HELLKNIGHT2016_SPAWN_EGG;
	public static AzureSpawnEgg GARGOYLE_SPAWN_EGG;
	public static AzureSpawnEgg SPECTRE_SPAWN_EGG;
	public static AzureSpawnEgg CUEBALL_SPAWN_EGG;
	public static AzureSpawnEgg PROWLER_SPAWN_EGG;
	public static AzureSpawnEgg DREADKNIGHT_SPAWN_EGG;
	public static AzureSpawnEgg STONEIMP_SPAWN_EGG;
	public static AzureSpawnEgg POSSESSED_WORKER_SPAWN_EGG;
	public static AzureSpawnEgg DOOMHUNTER_SPAWN_EGG;
	public static AzureSpawnEgg WHIPLASH_SPAWN_EGG;
	public static AzureSpawnEgg BARON2016_SPAWN_EGG;
	public static AzureSpawnEgg FIREBORNE_BARON_SPAWN_EGG;
	public static AzureSpawnEgg ARMORED_BARON_SPAWN_EGG;
	public static AzureSpawnEgg MAYKR_DRONE_SPAWN_EGG;
	public static AzureSpawnEgg BLOOD_MAYKR_SPAWN_EGG;
	public static AzureSpawnEgg ARCH_MAKYR_SPAWN_EGG;
	public static AzureSpawnEgg ARACHNOTRONETERNAL_SPAWN_EGG;
	public static AzureSpawnEgg SPIDERMASTERMIND2016_SPAWN_EGG;
	public static AzureSpawnEgg TENTACLE_SPAWN_EGG;
	public static AzureSpawnEgg MOTHERDEMON_SPAWN_EGG;
	public static AzureSpawnEgg TURRET_SPAWN_EGG;
	public static AzureSpawnEgg SUMMONER_SPAWN_EGG;
	public static AzureSpawnEgg REVENANT2016_SPAWN_EGG;
	public static AzureSpawnEgg GLADIATOR_SPAWN_EGG;

	// Armor
	public static DoomArmor DOOM_HELMET;
	public static DoomArmor DOOM_CHESTPLATE;
	public static DoomArmor DOOM_LEGGINGS;
	public static DoomArmor DOOM_BOOTS;
	public static PraetorDoomArmor PRAETOR_DOOM_HELMET;
	public static PraetorDoomArmor PRAETOR_DOOM_CHESTPLATE;
	public static PraetorDoomArmor PRAETOR_DOOM_LEGGINGS;
	public static PraetorDoomArmor PRAETOR_DOOM_BOOTS;
	public static AstroDoomArmor ASTRO_DOOM_HELMET;
	public static AstroDoomArmor ASTRO_DOOM_CHESTPLATE;
	public static AstroDoomArmor ASTRO_DOOM_LEGGINGS;
	public static AstroDoomArmor ASTRO_DOOM_BOOTS;
	public static CrimsonDoomArmor CRIMSON_DOOM_HELMET;
	public static CrimsonDoomArmor CRIMSON_DOOM_CHESTPLATE;
	public static CrimsonDoomArmor CRIMSON_DOOM_LEGGINGS;
	public static CrimsonDoomArmor CRIMSON_DOOM_BOOTS;
	public static MidnightDoomArmor MIDNIGHT_DOOM_HELMET;
	public static MidnightDoomArmor MIDNIGHT_DOOM_CHESTPLATE;
	public static MidnightDoomArmor MIDNIGHT_DOOM_LEGGINGS;
	public static MidnightDoomArmor MIDNIGHT_DOOM_BOOTS;
	public static DemonicDoomArmor DEMONIC_DOOM_HELMET;
	public static DemonicDoomArmor DEMONIC_DOOM_CHESTPLATE;
	public static DemonicDoomArmor DEMONIC_DOOM_LEGGINGS;
	public static DemonicDoomArmor DEMONIC_DOOM_BOOTS;
	public static DemoncideDoomArmor DEMONCIDE_DOOM_HELMET;
	public static DemoncideDoomArmor DEMONCIDE_DOOM_CHESTPLATE;
	public static DemoncideDoomArmor DEMONCIDE_DOOM_LEGGINGS;
	public static DemoncideDoomArmor DEMONCIDE_DOOM_BOOTS;
	public static SentinelDoomArmor SENTINEL_DOOM_HELMET;
	public static SentinelDoomArmor SENTINEL_DOOM_CHESTPLATE;
	public static SentinelDoomArmor SENTINEL_DOOM_LEGGINGS;
	public static SentinelDoomArmor SENTINEL_DOOM_BOOTS;
	public static EmberDoomArmor EMBER_DOOM_HELMET;
	public static EmberDoomArmor EMBER_DOOM_CHESTPLATE;
	public static EmberDoomArmor EMBER_DOOM_LEGGINGS;
	public static EmberDoomArmor EMBER_DOOM_BOOTS;
	public static ZombieDoomArmor ZOMBIE_DOOM_HELMET;
	public static ZombieDoomArmor ZOMBIE_DOOM_CHESTPLATE;
	public static ZombieDoomArmor ZOMBIE_DOOM_LEGGINGS;
	public static ZombieDoomArmor ZOMBIE_DOOM_BOOTS;
	public static PhobosDoomArmor PHOBOS_DOOM_HELMET;
	public static PhobosDoomArmor PHOBOS_DOOM_CHESTPLATE;
	public static PhobosDoomArmor PHOBOS_DOOM_LEGGINGS;
	public static PhobosDoomArmor PHOBOS_DOOM_BOOTS;
	public static NightmareDoomArmor NIGHTMARE_DOOM_HELMET;
	public static NightmareDoomArmor NIGHTMARE_DOOM_CHESTPLATE;
	public static NightmareDoomArmor NIGHTMARE_DOOM_LEGGINGS;
	public static NightmareDoomArmor NIGHTMARE_DOOM_BOOTS;
	public static PurplePonyDoomArmor PURPLEPONY_DOOM_HELMET;
	public static PurplePonyDoomArmor PURPLEPONY_DOOM_CHESTPLATE;
	public static PurplePonyDoomArmor PURPLEPONY_DOOM_LEGGINGS;
	public static PurplePonyDoomArmor PURPLEPONY_DOOM_BOOTS;
	public static DoomicornDoomArmor DOOMICORN_DOOM_HELMET;
	public static DoomicornDoomArmor DOOMICORN_DOOM_CHESTPLATE;
	public static DoomicornDoomArmor DOOMICORN_DOOM_LEGGINGS;
	public static DoomicornDoomArmor DOOMICORN_DOOM_BOOTS;
	public static GoldDoomArmor GOLD_DOOM_HELMET;
	public static GoldDoomArmor GOLD_DOOM_CHESTPLATE;
	public static GoldDoomArmor GOLD_DOOM_LEGGINGS;
	public static GoldDoomArmor GOLD_DOOM_BOOTS;
	public static TwentyFiveDoomArmor TWENTY_FIVE_DOOM_HELMET;
	public static TwentyFiveDoomArmor TWENTY_FIVE_DOOM_CHESTPLATE;
	public static TwentyFiveDoomArmor TWENTY_FIVE_DOOM_LEGGINGS;
	public static TwentyFiveDoomArmor TWENTY_FIVE_DOOM_BOOTS;
	public static BronzeDoomArmor BRONZE_DOOM_HELMET;
	public static BronzeDoomArmor BRONZE_DOOM_CHESTPLATE;
	public static BronzeDoomArmor BRONZE_DOOM_LEGGINGS;
	public static BronzeDoomArmor BRONZE_DOOM_BOOTS;
	public static CultistDoomArmor CULTIST_DOOM_HELMET;
	public static CultistDoomArmor CULTIST_DOOM_CHESTPLATE;
	public static CultistDoomArmor CULTIST_DOOM_LEGGINGS;
	public static CultistDoomArmor CULTIST_DOOM_BOOTS;
	public static MaykrDoomArmor MAYKR_DOOM_HELMET;
	public static MaykrDoomArmor MAYKR_DOOM_CHESTPLATE;
	public static MaykrDoomArmor MAYKR_DOOM_LEGGINGS;
	public static MaykrDoomArmor MAYKR_DOOM_BOOTS;
	public static PainterDoomArmor PAINTER_DOOM_HELMET;
	public static PainterDoomArmor PAINTER_DOOM_CHESTPLATE;
	public static ClassicDoomArmor CLASSIC_DOOM_HELMET;
	public static ClassicDoomArmor CLASSIC_DOOM_CHESTPLATE;
	public static ClassicDoomArmor CLASSIC_DOOM_LEGGINGS;
	public static ClassicRedDoomArmor CLASSIC_RED_DOOM_CHESTPLATE;
	public static ClassicRedDoomArmor CLASSIC_RED_DOOM_LEGGINGS;
	public static ClassicIndigoDoomArmor CLASSIC_INDIGO_DOOM_CHESTPLATE;
	public static ClassicIndigoDoomArmor CLASSIC_INDIGO_DOOM_LEGGINGS;
	public static ClassicBronzeDoomArmor CLASSIC_BRONZE_DOOM_CHESTPLATE;
	public static ClassicBronzeDoomArmor CLASSIC_BRONZE_DOOM_LEGGINGS;
	public static ClassicDoomArmor CLASSIC_DOOM_BOOTS;
	public static MulletDoomArmor MULLET_DOOM_HELMET1;
	public static MulletDoomArmor MULLET_DOOM_CHESTPLATE1;
	public static Mullet2DoomArmor MULLET_DOOM_CHESTPLATE2;
	public static Mullet3DoomArmor MULLET_DOOM_CHESTPLATE3;
	public static MulletDoomArmor MULLET_DOOM_LEGGINGS1;
	public static MulletDoomArmor MULLET_DOOM_BOOTS1;
	public static HotrodDoomArmor HOTROD_HELMET;
	public static HotrodDoomArmor HOTROD_CHESTPLATE;
	public static HotrodDoomArmor HOTROD_LEGGINGS;
	public static HotrodDoomArmor HOTROD_BOOTS;
	public static SantaDoomArmor SANTA_HELMET;
	public static DarkLordArmor DARKLORD_HELMET;
	public static DarkLordArmor DARKLORD_CHESTPLATE;
	public static DarkLordArmor DARKLORD_LEGGINGS;
	public static DarkLordArmor DARKLORD_BOOTS;

	static <T extends Item> T item(String id, T c) {		
		Registry.register(BuiltInRegistries.ITEM, DoomMod.modResource(id), c);
		return c;
	}

	public static Item[] ITEMS = { CHAINSAW_ETERNAL, CRUCIBLESWORD, ROCKETLAUNCHER, AXE_OPEN, HEAVYCANNON, SSG, PLASMAGUN, CHAINSAW64, CHAINSAW, CHAINGUN, BALLISTA, UNMAYKR, BFG_ETERNAL, BFG, SG, PISTOL };

	public static Map<Item, Item> getItemMap() {
		final Map<Item, Item> vanillaItemMap = new HashMap<>();
		for (final Item i : DoomItems.ITEMS) {
			vanillaItemMap.put(BuiltInRegistries.ITEM.get(DoomMod.modResource(BuiltInRegistries.ITEM.getKey(i).getPath())), i);
		}
		return vanillaItemMap;
	}

	public static void initItems() {
		SG = item("shotgun", new Shotgun());
		BFG = item("bfg9000", new BFG9000());
		BFG_ETERNAL = item("bfg_eternal", new BFG());
		DAISY = item("daisy", new DaisyItem());
		ROCKET = item("rocket", new Rocket());
		DGAUSS = item("doomed_gauss", new DGauss());
		BALLISTA = item("ballista", new Ballista());
		CHAINGUN = item("chaingun", new Chaingun());
		CHAINSAW = item("chainsaw", new Chainsaw());
		PISTOL = item("pistol", new PistolItem());
		DSG = item("doomed_shotgun", new DShotgun());
		BULLETS = item("bullets", new ClipAmmo());
		BFG_CELL = item("bfg_cell", new BFGCell());
		UNMAYKR = item("unmaykr", new Unmaykr("white"));
		UNMAKER = item("unmaker", new Unmaker("demon"));
		CHAINSAW64 = item("chainsaw64", new Chainsaw());
		PLASMAGUN = item("plasmagun", new PlasmaGun());
		SSG = item("supershotgun", new SuperShotgun());
		GRENADE = item("doomed_grenade", new GrenadeItem());
		HEAVYCANNON = item("heavycannon", new HeavyCannon());
		ARGENT_BOLT = item("argent_bolt", new ArgentBolt());
		ENERGY_CELLS = item("energy_cells", new EnergyCell());
		SHOTGUN_SHELLS = item("shotgun_shells", new ShellAmmo());
		UNMAKRY_BOLT = item("unmaykr_bolt", new UnmaykrBolt());
		AXE_OPEN = item("axe_marauder_open", new AxeMarauderItem());
		DPLASMARIFLE = item("doomed_plasma_rifle", new DPlasmaRifle());
		ROCKETLAUNCHER = item("rocketlauncher", new RocketLauncher());
		CHAINGUN_BULLETS = item("chaingunbullets", new ChaingunAmmo());
		CRUCIBLESWORD = item("cruciblesword", new SwordCrucibleItem());
		CHAINSAW_ETERNAL = item("chainsaweternal", new ChainsawAnimated());
		SENTINELHAMMER = item("sentinelhammer", new SentinelHammerItem());
		DARKLORDCRUCIBLE = item("darklordcrucible", new DarkLordCrucibleItem());

		ARGENT_AXE = item("argent_axe", new ArgentAxe());
		ARGENT_HOE = item("argent_hoe", new ArgentHoe());		
		SOULCUBE = item("soulcube", new SoulCubeItem());
		MEGA = item("megasphere", new MegaSphereItem());		
		ICON_ICON = item("icon_icon", new Item(new Item.Properties()));		
		ARGENT_PAXEL = item("argent_paxel", new ArgentPaxel());
		ARGENT_SWORD = item("argent_sword", new ArgentSword());
		POWER = item("powersphere", new PowerSphereItem());
		GAS_BARREL = item("gas_barrel", new Item(new Item.Properties()));		
		ARGENT_SHOVEL = item("argent_shovel", new ArgentShovel());		
		AXE_CLOSED = item("axe_marauder_closed", new UnopenedItem());
		ARGENT_PICKAXE = item("argent_pickaxe", new ArgentPickaxe());
		ARGENT_PLATE = item("argent_plate", new ArgentPlateItem());		
		SWORD_CLOSED = item("cruciblesword_closed", new UnopenedItem());		
		ARGENT_ENERGY = item("argent_energy", new ArgentEnergyItem());
		INMORTAL = item("inmortalsphere", new InmortalSphereItem());		
		INVISIBLE = item("invisiblesphere", new InvisibleSphereItem());		
		E1M1_MUSIC_DISC = item("e1m1_music_disc", new RecordItem(166, DoomSounds.E1M1, new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 60));
		GEOF_MUSIC_DISC = item("netherambient_geoffplaysguitar_music_disc", new RecordItem(167, DoomSounds.NETHERAMBIENT_GEOFFPLAYSGUITAR, new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 60));
	}

	public static void initEggs() {
		ARACHNOTRON_SPAWN_EGG = item("arachnotron_spawn_egg", new AzureSpawnEgg(DoomEntities.ARACHNOTRON, 11022961, 11035249));
		IMP_SPAWN_EGG = item("imp_spawn_egg", new AzureSpawnEgg(DoomEntities.IMP, 11022961, 11035249));
		PINKY_SPAWN_EGG = item("pinky_spawn_egg", new AzureSpawnEgg(DoomEntities.PINKY, 11022961, 11035249));
		ARCHVILE_SPAWN_EGG = item("archvile_spawn_egg", new AzureSpawnEgg(DoomEntities.ARCHVILE, 11022961, 11035249));
		BARON_SPAWN_EGG = item("baron_spawn_egg", new AzureSpawnEgg(DoomEntities.BARON, 11022961, 11035249));
		CACODEMON_SPAWN_EGG = item("cacodemon_spawn_egg", new AzureSpawnEgg(DoomEntities.CACODEMON, 11022961, 11035249));
		MANCUBUS_SPAWN_EGG = item("mancubus_spawn_egg", new AzureSpawnEgg(DoomEntities.MANCUBUS, 11022961, 11035249));
		LOST_SOUL_SPAWN_EGG = item("lost_soul_spawn_egg", new AzureSpawnEgg(DoomEntities.LOST_SOUL, 11022961, 11035249));
		LOST_SOUL_ETERNAL_SPAWN_EGG = item("lost_soul_eternal_spawn_egg", new AzureSpawnEgg(DoomEntities.LOST_SOUL_ETERNAL, 11022961, 11035249));
		SPIDERMASTERMIND_SPAWN_EGG = item("spidermastermind_spawn_egg", new AzureSpawnEgg(DoomEntities.SPIDERMASTERMIND, 11022961, 11035249));
		ZOMBIEMAN_SPAWN_EGG = item("zombieman_spawn_egg", new AzureSpawnEgg(DoomEntities.ZOMBIEMAN, 11022961, 11035249));
		CHAINGUNNER_SPAWN_EGG = item("chaingunner_spawn_egg", new AzureSpawnEgg(DoomEntities.CHAINGUNNER, 11022961, 11035249));
		HELLKNIGHT_SPAWN_EGG = item("hellknight_spawn_egg", new AzureSpawnEgg(DoomEntities.HELLKNIGHT, 11022961, 11035249));
		MARAUDER_SPAWN_EGG = item("marauder_spawn_egg", new AzureSpawnEgg(DoomEntities.MARAUDER, 11022961, 11035249));
		PAIN_SPAWN_EGG = item("pain_spawn_egg", new AzureSpawnEgg(DoomEntities.PAIN, 11022961, 11035249));
		REVENANT_SPAWN_EGG = item("revenant_spawn_egg", new AzureSpawnEgg(DoomEntities.REVENANT, 11022961, 11035249));
		SHOTGUNGUY_SPAWN_EGG = item("shotgunguy_spawn_egg", new AzureSpawnEgg(DoomEntities.SHOTGUNGUY, 11022961, 11035249));
		CYBERDEMON_SPAWN_EGG = item("cyberdemon_spawn_egg", new AzureSpawnEgg(DoomEntities.CYBERDEMON, 11022961, 11035249));
		ICON_SPAWN_EGG = item("icon_of_sin_spawn_egg", new AzureSpawnEgg(DoomEntities.ICONOFSIN, 11022961, 11035249));
		UNWILLING_SPAWN_EGG = item("unwilling_spawn_egg", new AzureSpawnEgg(DoomEntities.UNWILLING, 11022961, 11035249));
		POSSESSED_SCIENTIST_SPAWN_EGG = item("possessed_scientist_spawn_egg", new AzureSpawnEgg(DoomEntities.POSSESSEDSCIENTIST, 11022961, 11035249));
		POSSESSED_SOLDIER_SPAWN_EGG = item("possessed_soldier_spawn_egg", new AzureSpawnEgg(DoomEntities.POSSESSEDSOLDIER, 11022961, 11035249));
		GORE_NEST_SPAWN_EGG = item("gorenest_spawn_egg", new AzureSpawnEgg(DoomEntities.GORE_NEST, 11022961, 11035249));
		MECH_ZOMBIE_SPAWN_EGG = item("mechazombie_spawn_egg", new AzureSpawnEgg(DoomEntities.MECHAZOMBIE, 11022961, 11035249));
		HELLKNIGHT2016_SPAWN_EGG = item("hellknight2016_spawn_egg", new AzureSpawnEgg(DoomEntities.HELLKNIGHT2016, 11022961, 11035249));
		GARGOYLE_SPAWN_EGG = item("gargoyle_spawn_egg", new AzureSpawnEgg(DoomEntities.GARGOYLE, 11022961, 11035249));
		SPECTRE_SPAWN_EGG = item("spectre_spawn_egg", new AzureSpawnEgg(DoomEntities.SPECTRE, 11022961, 11035249));
		CUEBALL_SPAWN_EGG = item("cueball_spawn_egg", new AzureSpawnEgg(DoomEntities.CUEBALL, 11022961, 11035249));
		PROWLER_SPAWN_EGG = item("prowler_spawn_egg", new AzureSpawnEgg(DoomEntities.PROWLER, 11022961, 11035249));
		DREADKNIGHT_SPAWN_EGG = item("dreadknight_spawn_egg", new AzureSpawnEgg(DoomEntities.DREADKNIGHT, 11022961, 11035249));
		STONEIMP_SPAWN_EGG = item("stoneimp_spawn_egg", new AzureSpawnEgg(DoomEntities.IMP_STONE, 11022961, 11035249));
		POSSESSED_WORKER_SPAWN_EGG = item("possessed_worker_spawn_egg", new AzureSpawnEgg(DoomEntities.POSSESSEDWORKER, 11022961, 11035249));
		DOOMHUNTER_SPAWN_EGG = item("doom_hunter_spawn_egg", new AzureSpawnEgg(DoomEntities.DOOMHUNTER, 11022961, 11035249));
		WHIPLASH_SPAWN_EGG = item("whiplash_spawn_egg", new AzureSpawnEgg(DoomEntities.WHIPLASH, 11022961, 11035249));
		BARON2016_SPAWN_EGG = item("baron2016_spawn_egg", new AzureSpawnEgg(DoomEntities.BARON2016, 11022961, 11035249));
		FIREBORNE_BARON_SPAWN_EGG = item("firebronebaron_spawn_egg", new AzureSpawnEgg(DoomEntities.FIREBARON, 11022961, 11035249));
		ARMORED_BARON_SPAWN_EGG = item("armoredbaron_spawn_egg", new AzureSpawnEgg(DoomEntities.ARMORBARON, 11022961, 11035249));
		MAYKR_DRONE_SPAWN_EGG = item("maykr_drone_spawn_egg", new AzureSpawnEgg(DoomEntities.MAYKRDRONE, 11022961, 11035249));
		BLOOD_MAYKR_SPAWN_EGG = item("blood_maykr_spawn_egg", new AzureSpawnEgg(DoomEntities.BLOODMAYKR, 11022961, 11035249));
		ARCH_MAKYR_SPAWN_EGG = item("arch_maykr_spawn_egg", new AzureSpawnEgg(DoomEntities.ARCHMAKER, 11022961, 11035249));
		ARACHNOTRONETERNAL_SPAWN_EGG = item("arachnotroneternal_spawn_egg", new AzureSpawnEgg(DoomEntities.ARACHNOTRONETERNAL, 11022961, 11035249));
		SPIDERMASTERMIND2016_SPAWN_EGG = item("spidermastermind2016_spawn_egg", new AzureSpawnEgg(DoomEntities.SPIDERMASTERMIND2016, 11022961, 11035249));
		TENTACLE_SPAWN_EGG = item("tentacle_spawn_egg", new AzureSpawnEgg(DoomEntities.TENTACLE, 11022961, 11035249));
		MOTHERDEMON_SPAWN_EGG = item("motherdemon_spawn_egg", new AzureSpawnEgg(DoomEntities.MOTHERDEMON, 11022961, 11035249));
		TURRET_SPAWN_EGG = item("turret_spawn_egg", new AzureSpawnEgg(DoomEntities.TURRET, 11022961, 11035249));
		SUMMONER_SPAWN_EGG = item("summoner_spawn_egg", new AzureSpawnEgg(DoomEntities.SUMMONER, 11022961, 11035249));
		REVENANT2016_SPAWN_EGG = item("revenant2016_spawn_egg", new AzureSpawnEgg(DoomEntities.REVENANT2016, 11022961, 11035249));
		GLADIATOR_SPAWN_EGG = item("gladiator_spawn_egg", new AzureSpawnEgg(DoomEntities.GLADIATOR, 11022961, 11035249));
	}

	public static void initArmor() {
		// Armor
		DOOM_HELMET = item("doom_helmet", new DoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.HELMET));
		DOOM_CHESTPLATE = item("doom_chestplate", new DoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.CHESTPLATE));
		DOOM_LEGGINGS = item("doom_leggings", new DoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.LEGGINGS));
		DOOM_BOOTS = item("doom_boots", new DoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.BOOTS));
		PRAETOR_DOOM_HELMET = item("praetor_doom_helmet", new PraetorDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.HELMET));
		PRAETOR_DOOM_CHESTPLATE = item("praetor_doom_chestplate", new PraetorDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.CHESTPLATE));
		PRAETOR_DOOM_LEGGINGS = item("praetor_doom_leggings", new PraetorDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.LEGGINGS));
		PRAETOR_DOOM_BOOTS = item("praetor_doom_boots", new PraetorDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.BOOTS));
		ASTRO_DOOM_HELMET = item("astro_doom_helmet", new AstroDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.HELMET));
		ASTRO_DOOM_CHESTPLATE = item("astro_doom_chestplate", new AstroDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.CHESTPLATE));
		ASTRO_DOOM_LEGGINGS = item("astro_doom_leggings", new AstroDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.LEGGINGS));
		ASTRO_DOOM_BOOTS = item("astro_doom_boots", new AstroDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.BOOTS));
		CRIMSON_DOOM_HELMET = item("crimson_doom_helmet", new CrimsonDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.HELMET));
		CRIMSON_DOOM_CHESTPLATE = item("crimson_doom_chestplate", new CrimsonDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.CHESTPLATE));
		CRIMSON_DOOM_LEGGINGS = item("crimson_doom_leggings", new CrimsonDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.LEGGINGS));
		CRIMSON_DOOM_BOOTS = item("crimson_doom_boots", new CrimsonDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.BOOTS));
		MIDNIGHT_DOOM_HELMET = item("midnight_doom_helmet", new MidnightDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.HELMET));
		MIDNIGHT_DOOM_CHESTPLATE = item("midnight_doom_chestplate", new MidnightDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.CHESTPLATE));
		MIDNIGHT_DOOM_LEGGINGS = item("midnight_doom_leggings", new MidnightDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.LEGGINGS));
		MIDNIGHT_DOOM_BOOTS = item("midnight_doom_boots", new MidnightDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.BOOTS));
		DEMONIC_DOOM_HELMET = item("demonic_doom_helmet", new DemonicDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.HELMET));
		DEMONIC_DOOM_CHESTPLATE = item("demonic_doom_chestplate", new DemonicDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.CHESTPLATE));
		DEMONIC_DOOM_LEGGINGS = item("demonic_doom_leggings", new DemonicDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.LEGGINGS));
		DEMONIC_DOOM_BOOTS = item("demonic_doom_boots", new DemonicDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.BOOTS));
		DEMONCIDE_DOOM_HELMET = item("demoncide_doom_helmet", new DemoncideDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.HELMET));
		DEMONCIDE_DOOM_CHESTPLATE = item("demoncide_doom_chestplate", new DemoncideDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.CHESTPLATE));
		DEMONCIDE_DOOM_LEGGINGS = item("demoncide_doom_leggings", new DemoncideDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.LEGGINGS));
		DEMONCIDE_DOOM_BOOTS = item("demoncide_doom_boots", new DemoncideDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.BOOTS));
		SENTINEL_DOOM_HELMET = item("sentinel_doom_helmet", new SentinelDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.HELMET));
		SENTINEL_DOOM_CHESTPLATE = item("sentinel_doom_chestplate", new SentinelDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.CHESTPLATE));
		SENTINEL_DOOM_LEGGINGS = item("sentinel_doom_leggings", new SentinelDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.LEGGINGS));
		SENTINEL_DOOM_BOOTS = item("sentinel_doom_boots", new SentinelDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.BOOTS));
		EMBER_DOOM_HELMET = item("ember_doom_helmet", new EmberDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.HELMET));
		EMBER_DOOM_CHESTPLATE = item("ember_doom_chestplate", new EmberDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.CHESTPLATE));
		EMBER_DOOM_LEGGINGS = item("ember_doom_leggings", new EmberDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.LEGGINGS));
		EMBER_DOOM_BOOTS = item("ember_doom_boots", new EmberDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.BOOTS));
		ZOMBIE_DOOM_HELMET = item("zombie_doom_helmet", new ZombieDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.HELMET));
		ZOMBIE_DOOM_CHESTPLATE = item("zombie_doom_chestplate", new ZombieDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.CHESTPLATE));
		ZOMBIE_DOOM_LEGGINGS = item("zombie_doom_leggings", new ZombieDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.LEGGINGS));
		ZOMBIE_DOOM_BOOTS = item("zombie_doom_boots", new ZombieDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.BOOTS));
		PHOBOS_DOOM_HELMET = item("phobos_doom_helmet", new PhobosDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.HELMET));
		PHOBOS_DOOM_CHESTPLATE = item("phobos_doom_chestplate", new PhobosDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.CHESTPLATE));
		PHOBOS_DOOM_LEGGINGS = item("phobos_doom_leggings", new PhobosDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.LEGGINGS));
		PHOBOS_DOOM_BOOTS = item("phobos_doom_boots", new PhobosDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.BOOTS));
		NIGHTMARE_DOOM_HELMET = item("nightmare_doom_helmet", new NightmareDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.HELMET));
		NIGHTMARE_DOOM_CHESTPLATE = item("nightmare_doom_chestplate", new NightmareDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.CHESTPLATE));
		NIGHTMARE_DOOM_LEGGINGS = item("nightmare_doom_leggings", new NightmareDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.LEGGINGS));
		NIGHTMARE_DOOM_BOOTS = item("nightmare_doom_boots", new NightmareDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.BOOTS));
		PURPLEPONY_DOOM_HELMET = item("purplepony_doom_helmet", new PurplePonyDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.HELMET));
		PURPLEPONY_DOOM_CHESTPLATE = item("purplepony_doom_chestplate", new PurplePonyDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.CHESTPLATE));
		PURPLEPONY_DOOM_LEGGINGS = item("purplepony_doom_leggings", new PurplePonyDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.LEGGINGS));
		PURPLEPONY_DOOM_BOOTS = item("purplepony_doom_boots", new PurplePonyDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.BOOTS));
		DOOMICORN_DOOM_HELMET = item("doomicorn_doom_helmet", new DoomicornDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.HELMET));
		DOOMICORN_DOOM_CHESTPLATE = item("doomicorn_doom_chestplate", new DoomicornDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.CHESTPLATE));
		DOOMICORN_DOOM_LEGGINGS = item("doomicorn_doom_leggings", new DoomicornDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.LEGGINGS));
		DOOMICORN_DOOM_BOOTS = item("doomicorn_doom_boots", new DoomicornDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.BOOTS));
		GOLD_DOOM_HELMET = item("gold_doom_helmet", new GoldDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.HELMET));
		GOLD_DOOM_CHESTPLATE = item("gold_doom_chestplate", new GoldDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.CHESTPLATE));
		GOLD_DOOM_LEGGINGS = item("gold_doom_leggings", new GoldDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.LEGGINGS));
		GOLD_DOOM_BOOTS = item("gold_doom_boots", new GoldDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.BOOTS));
		TWENTY_FIVE_DOOM_HELMET = item("twenty_five_helmet", new TwentyFiveDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.HELMET));
		TWENTY_FIVE_DOOM_CHESTPLATE = item("twenty_five_chestplate", new TwentyFiveDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.CHESTPLATE));
		TWENTY_FIVE_DOOM_LEGGINGS = item("twenty_five_leggings", new TwentyFiveDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.LEGGINGS));
		TWENTY_FIVE_DOOM_BOOTS = item("twenty_five_boots", new TwentyFiveDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.BOOTS));
		BRONZE_DOOM_HELMET = item("bronze_doom_helmet", new BronzeDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.HELMET));
		BRONZE_DOOM_CHESTPLATE = item("bronze_doom_chestplate", new BronzeDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.CHESTPLATE));
		BRONZE_DOOM_LEGGINGS = item("bronze_doom_leggings", new BronzeDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.LEGGINGS));
		BRONZE_DOOM_BOOTS = item("bronze_doom_boots", new BronzeDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.BOOTS));
		CULTIST_DOOM_HELMET = item("cultist_doom_helmet", new CultistDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.HELMET));
		CULTIST_DOOM_CHESTPLATE = item("cultist_doom_chestplate", new CultistDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.CHESTPLATE));
		CULTIST_DOOM_LEGGINGS = item("cultist_doom_leggings", new CultistDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.LEGGINGS));
		CULTIST_DOOM_BOOTS = item("cultist_doom_boots", new CultistDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.BOOTS));
		MAYKR_DOOM_HELMET = item("maykr_doom_helmet", new MaykrDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.HELMET));
		MAYKR_DOOM_CHESTPLATE = item("maykr_doom_chestplate", new MaykrDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.CHESTPLATE));
		MAYKR_DOOM_LEGGINGS = item("maykr_doom_leggings", new MaykrDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.LEGGINGS));
		MAYKR_DOOM_BOOTS = item("maykr_doom_boots", new MaykrDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.BOOTS));
		PAINTER_DOOM_HELMET = item("painter_doom_helmet", new PainterDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.HELMET));
		PAINTER_DOOM_CHESTPLATE = item("painter_doom_chestplate", new PainterDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.CHESTPLATE));
		CLASSIC_DOOM_HELMET = item("classic_doom_helmet", new ClassicDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.HELMET));
		CLASSIC_DOOM_CHESTPLATE = item("classic_doom_chestplate", new ClassicDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.CHESTPLATE));
		CLASSIC_DOOM_LEGGINGS = item("classic_doom_leggings", new ClassicDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.LEGGINGS));
		CLASSIC_RED_DOOM_CHESTPLATE = item("classic_red_chestplate", new ClassicRedDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.CHESTPLATE));
		CLASSIC_RED_DOOM_LEGGINGS = item("classic_red_leggings", new ClassicRedDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.LEGGINGS));
		CLASSIC_INDIGO_DOOM_CHESTPLATE = item("classic_black_chestplate", new ClassicIndigoDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.CHESTPLATE));
		CLASSIC_INDIGO_DOOM_LEGGINGS = item("classic_black_leggings", new ClassicIndigoDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.LEGGINGS));
		CLASSIC_BRONZE_DOOM_CHESTPLATE = item("classic_bronze_chestplate", new ClassicBronzeDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.CHESTPLATE));
		CLASSIC_BRONZE_DOOM_LEGGINGS = item("classic_bronze_leggings", new ClassicBronzeDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.LEGGINGS));
		CLASSIC_DOOM_BOOTS = item("classic_doom_boots", new ClassicDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.BOOTS));
		MULLET_DOOM_HELMET1 = item("redneck_doom1_helmet", new MulletDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.HELMET));
		MULLET_DOOM_CHESTPLATE1 = item("redneck_doom1_chestplate", new MulletDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.CHESTPLATE));
		MULLET_DOOM_CHESTPLATE2 = item("redneck_doom2_chestplate", new Mullet2DoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.CHESTPLATE));
		MULLET_DOOM_CHESTPLATE3 = item("redneck_doom3_chestplate", new Mullet3DoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.CHESTPLATE));
		MULLET_DOOM_LEGGINGS1 = item("redneck_doom1_leggings", new MulletDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.LEGGINGS));
		MULLET_DOOM_BOOTS1 = item("redneck_doom1_boots", new MulletDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.BOOTS));
		HOTROD_HELMET = item("hotrod_helmet", new HotrodDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.HELMET));
		HOTROD_CHESTPLATE = item("hotrod_chestplate", new HotrodDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.CHESTPLATE));
		HOTROD_LEGGINGS = item("hotrod_leggings", new HotrodDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.LEGGINGS));
		HOTROD_BOOTS = item("hotrod_boots", new HotrodDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.BOOTS));
		SANTA_HELMET = item("santa_helmet", new SantaDoomArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.HELMET));
		DARKLORD_HELMET = item("darklord_helmet", new DarkLordArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.HELMET));
		DARKLORD_CHESTPLATE = item("darklord_chestplate", new DarkLordArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.CHESTPLATE));
		DARKLORD_LEGGINGS = item("darklord_leggings", new DarkLordArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.LEGGINGS));
		DARKLORD_BOOTS = item("darklord_boots", new DarkLordArmor(DAMat.DOOM_ARMOR, ArmorItem.Type.BOOTS));
	}
}