package com.awesomeshot5051.plantfarms;

import net.minecraft.resources.*;
import net.minecraft.tags.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;

import static net.minecraft.core.registries.Registries.*;

public class DynamicTagHandler {
    public static final TagKey<Block> MY_TAG = TagKey.create(BLOCK, ResourceLocation.fromNamespaceAndPath("examplemod", "example_tag"));

    DynamicTagHandler(Level level, Block block) {
        BlockState blockState = block.defaultBlockState();
        boolean isInBlockTag = blockState.is(MY_TAG);
    }
}