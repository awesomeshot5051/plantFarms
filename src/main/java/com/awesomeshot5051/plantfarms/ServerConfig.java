package com.awesomeshot5051.plantfarms;

import de.maxhenkel.corelib.config.ConfigBase;
import net.neoforged.neoforge.common.ModConfigSpec;

public class ServerConfig extends ConfigBase {
    /// The End
    public final ModConfigSpec.IntValue chorusSpawnTime;

    /// The Nether
    public final ModConfigSpec.IntValue crimsonSpawnTime;
    public final ModConfigSpec.IntValue warpedSpawnTime;
    public final ModConfigSpec.IntValue wartSpawnTime;


    /// Overworld


    //Overworld Trees
    public final ModConfigSpec.IntValue oakSpawnTime;
    public final ModConfigSpec.IntValue spruceSpawnTime;
    public final ModConfigSpec.IntValue birchSpawnTime;
    public final ModConfigSpec.IntValue jungleSpawnTime;
    public final ModConfigSpec.IntValue darkOakSpawnTime;
    public final ModConfigSpec.IntValue acaciaSpawnTime;
    public final ModConfigSpec.IntValue azaleaSpawnTime;
    public final ModConfigSpec.IntValue mangroveSpawnTime;
    public final ModConfigSpec.IntValue cherrySpawnTime;

    //Overworld Crops

    public final ModConfigSpec.IntValue wheatSpawnTime;
    public final ModConfigSpec.IntValue carrotSpawnTime;
    public final ModConfigSpec.IntValue potatoSpawnTime;
    public final ModConfigSpec.IntValue beetrootSpawnTime;
    public final ModConfigSpec.IntValue pumpkinSpawnTime;
    public final ModConfigSpec.IntValue melonSpawnTime;
    public final ModConfigSpec.IntValue sugarCaneSpawnTime;
    public final ModConfigSpec.IntValue cocoaBeanSpawnTime;
    public final ModConfigSpec.IntValue berrySpawnTime;
    public final ModConfigSpec.IntValue bambooSpawnTime;

    //Overworld Flowers
    public final ModConfigSpec.IntValue dandelionSpawnTime;
    public final ModConfigSpec.IntValue poppySpawnTime;
    public final ModConfigSpec.IntValue orchidSpawnTime;
    public final ModConfigSpec.IntValue alliumSpawnTime;
    public final ModConfigSpec.IntValue azureSpawnTime;
    public final ModConfigSpec.IntValue redSpawnTime;
    public final ModConfigSpec.IntValue orangeSpawnTime;
    public final ModConfigSpec.IntValue whiteSpawnTime;
    public final ModConfigSpec.IntValue pinkSpawnTime;
    public final ModConfigSpec.IntValue daisySpawnTime;
    public final ModConfigSpec.IntValue cornflowerSpawnTime;
    public final ModConfigSpec.IntValue lilySpawnTime;
    public final ModConfigSpec.IntValue sunflowerSpawnTime;
    public final ModConfigSpec.IntValue lilacSpawnTime;
    public final ModConfigSpec.IntValue roseSpawnTime;
    public final ModConfigSpec.IntValue peonySpawnTime;

    public final ModConfigSpec.BooleanValue universalReputation;


    public ServerConfig(ModConfigSpec.Builder builder) {
        super(builder);
        ///The End
        chorusSpawnTime = builder
                .comment("The time in ticks the chorus plant takes to drop stuff")
                .defineInRange("chorus_farm.spawn_time", 20 * 3, 20 * 3, 20 * 3);

        ///The Nether
        crimsonSpawnTime = builder
                .comment("The time in ticks the crimson farm takes to drop stuff")
                .defineInRange("crimson_farm.spawn_time", 20 * 3, 20 * 3, 20 * 3);
        warpedSpawnTime = builder
                .comment("The time in ticks the warped farm takes to drop stuff")
                .defineInRange("warped_farm.spawn_time", 20 * 3, 20 * 3, 20 * 3);
        wartSpawnTime = builder
                .comment("The time in ticks the nether wart farm takes to drop stuff")
                .defineInRange("wart_farm.spawn_time", 20 * 3, 20 * 3, 20 * 3);

        ///The Overworld

        //Overworld Trees
        oakSpawnTime = builder
                .comment("The time in ticks the spruce farm takes to spawn a oak")
                .defineInRange("oak_farm.spawn_time", 20 * 3, 20 * 3, 20 * 3);
        spruceSpawnTime = builder
                .comment("The time in ticks the spruce farm takes to spawn a spruce")
                .defineInRange("spruce_farm.spawn_time", 20 * 3, 20 * 3, 20 * 3);

        birchSpawnTime = builder
                .comment("The time in ticks the birch farm takes to spawn a birch")
                .defineInRange("birch_farm.spawn_time", 20 * 3, 20 * 3, 20 * 3);

        jungleSpawnTime = builder
                .comment("The time in ticks the elder azalea farm takes to spawn an elder azalea")
                .defineInRange("jungle_farm.spawn_time", 20 * 3, 20 * 3, 20 * 3);

        darkOakSpawnTime = builder
                .comment("The time in ticks the darkOak farm takes to spawn an darkOak")
                .defineInRange("dark_oak_farm.spawn_time", 20 * 3, 20 * 3, 20 * 3);

        acaciaSpawnTime = builder
                .comment("The time in ticks the acacia farm takes to spawn a acacia")
                .defineInRange("acacia_farm.spawn_time", 20 * 3, 20 * 3, 20 * 3);

        azaleaSpawnTime = builder
                .comment("The time in ticks the azalea farm takes to spawn a azalea")
                .defineInRange("azalea_farm.spawn_time", 20 * 3, 20 * 3, 20 * 3);

        mangroveSpawnTime = builder
                .comment("The time in ticks the mangrove farm takes to spawn a mangrove")
                .defineInRange("mangrove_farm.spawn_time", 20 * 3, 20 * 3, 20 * 3);

        cherrySpawnTime = builder
                .comment("The time in ticks the cherry farm takes to spawn an cherry")
                .defineInRange("cherry_farm.spawn_time", 20 * 3, 20 * 3, 20 * 3);

        //Overworld Crops
        wheatSpawnTime = builder
                .comment("The time in ticks the wheat farm takes to spawn wheat")
                .defineInRange("wheat_farm.spawn_time", 20 * 3, 20 * 3, 20 * 3);

        carrotSpawnTime = builder
                .comment("The time in ticks the carrot farm takes to spawn carrots")
                .defineInRange("carrot_farm.spawn_time", 20 * 3, 20 * 3, 20 * 3);

        potatoSpawnTime = builder
                .comment("The time in ticks the potato farm takes to spawn potatoes")
                .defineInRange("potato_farm.spawn_time", 20 * 3, 20 * 3, 20 * 3);

        beetrootSpawnTime = builder
                .comment("The time in ticks the beetroot farm takes to spawn beetroots")
                .defineInRange("beetroot_farm.spawn_time", 20 * 3, 20 * 3, 20 * 3);

        pumpkinSpawnTime = builder
                .comment("The time in ticks the pumpkin farm takes to spawn pumpkins")
                .defineInRange("pumpkin_farm.spawn_time", 20 * 3, 20 * 3, 20 * 3);

        melonSpawnTime = builder
                .comment("The time in ticks the melon farm takes to spawn melons")
                .defineInRange("melon_farm.spawn_time", 20 * 3, 20 * 3, 20 * 3);

        sugarCaneSpawnTime = builder
                .comment("The time in ticks the sugar cane farm takes to spawn sugar canes")
                .defineInRange("sugar_cane_farm.spawn_time", 20 * 3, 20 * 3, 20 * 3);

        cocoaBeanSpawnTime = builder
                .comment("The time in ticks the cocoa bean farm takes to spawn cocoa beans")
                .defineInRange("cocoa_bean_farm.spawn_time", 20 * 3, 20 * 3, 20 * 3);

        berrySpawnTime = builder
                .comment("The time in ticks the sweet berry farm takes to spawn sweet berries")
                .defineInRange("sweet_berry_farm.spawn_time", 20 * 3, 20 * 3, 20 * 3);

        bambooSpawnTime = builder
                .comment("The time in ticks the bamboo farm takes to spawn bamboo")
                .defineInRange("bamboo_farm.spawn_time", 20 * 3, 20 * 3, 20 * 3);


        //Overworld Flowers

        dandelionSpawnTime = builder
                .comment("The time in ticks the dandelion farm takes to spawn dandelions")
                .defineInRange("dandelion_farm.spawn_time", 20 * 3, 20 * 3, 20 * 3);

        poppySpawnTime = builder
                .comment("The time in ticks the poppy farm takes to spawn poppies")
                .defineInRange("poppy_farm.spawn_time", 20 * 3, 20 * 3, 20 * 3);

        orchidSpawnTime = builder
                .comment("The time in ticks the blue orchid farm takes to spawn blue orchids")
                .defineInRange("orchid_farm.spawn_time", 20 * 3, 20 * 3, 20 * 3);

        alliumSpawnTime = builder
                .comment("The time in ticks the allium farm takes to spawn alliums")
                .defineInRange("allium_farm.spawn_time", 20 * 3, 20 * 3, 20 * 3);

        azureSpawnTime = builder
                .comment("The time in ticks the azure bluet farm takes to spawn azure bluets")
                .defineInRange("azure_farm.spawn_time", 20 * 3, 20 * 3, 20 * 3);

        redSpawnTime = builder
                .comment("The time in ticks the red tulip farm takes to spawn red tulips")
                .defineInRange("red_farm.spawn_time", 20 * 3, 20 * 3, 20 * 3);

        orangeSpawnTime = builder
                .comment("The time in ticks the orange tulip farm takes to spawn orange tulips")
                .defineInRange("orange_farm.spawn_time", 20 * 3, 20 * 3, 20 * 3);

        whiteSpawnTime = builder
                .comment("The time in ticks the white tulip farm takes to spawn white tulips")
                .defineInRange("white_farm.spawn_time", 20 * 3, 20 * 3, 20 * 3);

        pinkSpawnTime = builder
                .comment("The time in ticks the pink tulip farm takes to spawn pink tulips")
                .defineInRange("pink_farm.spawn_time", 20 * 3, 20 * 3, 20 * 3);

        daisySpawnTime = builder
                .comment("The time in ticks the oxeye daisy farm takes to spawn oxeye daisies")
                .defineInRange("daisy_farm.spawn_time", 20 * 3, 20 * 3, 20 * 3);

        cornflowerSpawnTime = builder
                .comment("The time in ticks the cornflower farm takes to spawn cornflowers")
                .defineInRange("cornflower_farm.spawn_time", 20 * 3, 20 * 3, 20 * 3);

        lilySpawnTime = builder
                .comment("The time in ticks the lily of the valley farm takes to spawn lilies")
                .defineInRange("lilly_farm.spawn_time", 20 * 3, 20 * 3, 20 * 3);

        sunflowerSpawnTime = builder
                .comment("The time in ticks the sunflower farm takes to spawn sunflowers")
                .defineInRange("sunflower_farm.spawn_time", 20 * 3, 20 * 3, 20 * 3);

        lilacSpawnTime = builder
                .comment("The time in ticks the lilac farm takes to spawn lilacs")
                .defineInRange("lilac_farm.spawn_time", 20 * 3, 20 * 3, 20 * 3);

        roseSpawnTime = builder
                .comment("The time in ticks the rose bush farm takes to spawn rose bushes")
                .defineInRange("rose_farm.spawn_time", 20 * 3, 20 * 3, 20 * 3);

        peonySpawnTime = builder
                .comment("The time in ticks the peony farm takes to spawn peonies")
                .defineInRange("peony_farm.spawn_time", 20 * 3, 20 * 3, 20 * 3);


        universalReputation = builder
                .comment(
                        "If the villager reputation should be the same for every player",
                        "This affects the prices of cured/converted villagers and the prices of the auto trader"
                )
                .define("villager.universal_reputation", true);

    }
}
