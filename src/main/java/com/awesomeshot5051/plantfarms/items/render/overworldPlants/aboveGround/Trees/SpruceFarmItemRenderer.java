package com.awesomeshot5051.plantfarms.items.render.overworldPlants.aboveGround.Trees;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import com.awesomeshot5051.plantfarms.blocks.tileentity.overworld.aboveGround.trees.SpruceFarmTileentity;
import com.awesomeshot5051.plantfarms.blocks.tileentity.render.overworld.aboveGround.Trees.SpruceFarmRenderer;
import com.awesomeshot5051.plantfarms.items.render.BlockItemRendererBase;
import net.minecraft.core.BlockPos;

public class SpruceFarmItemRenderer extends BlockItemRendererBase<SpruceFarmRenderer, SpruceFarmTileentity> {

    public SpruceFarmItemRenderer() {
        super(SpruceFarmRenderer::new, () -> new SpruceFarmTileentity(BlockPos.ZERO, ModBlocks.SPRUCE_FARM.get().defaultBlockState()));
    }

}
