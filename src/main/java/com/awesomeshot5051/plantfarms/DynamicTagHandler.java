package com.awesomeshot5051.plantfarms;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import static net.minecraft.core.registries.Registries.BLOCK;

public class DynamicTagHandler {

    public static final TagKey<Block> MY_TAG = TagKey.create(
            // The registry key. The type of the registry must match the generic type of the tag.
            BLOCK,
            // The location of the tag. This example will put our tag at data/examplemod/tags/blocks/example_tag.json.
            ResourceLocation.fromNamespaceAndPath("examplemod", "example_tag")
    );

    DynamicTagHandler(Level level, Block block) {
        BlockState blockState = block.defaultBlockState();
        boolean isInBlockTag = blockState.is(MY_TAG);
    }
}
