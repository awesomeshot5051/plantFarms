package com.awesomeshot5051.plantfarms.blocks;

import com.awesomeshot5051.plantfarms.blocks.tileentity.tfarmBlockTileentity;
import com.awesomeshot5051.plantfarms.datacomponents.VillagerBlockEntityData;
import com.awesomeshot5051.plantfarms.items.render.tfarmBlockItemRenderer;
import de.maxhenkel.corelib.block.IItemBlock;
import de.maxhenkel.corelib.blockentity.SimpleBlockEntityTicker;
import de.maxhenkel.corelib.client.CustomRendererBlockItem;
import de.maxhenkel.corelib.client.ItemRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

public class TFarmBlock extends BlockBase implements EntityBlock, IItemBlock {

    public TFarmBlock() {
        super(Properties.of().mapColor(MapColor.METAL).strength(2.5F).sound(SoundType.METAL).noOcclusion());
    }

    @Override
    public Item toItem() {
        return new CustomRendererBlockItem(this, new Item.Properties()) {
            @OnlyIn(Dist.CLIENT)
            @Override
            public ItemRenderer createItemRenderer() {
                return new tfarmBlockItemRenderer();
            }
        };
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> components, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, components, tooltipFlag);
        tfarmBlockTileentity trader = VillagerBlockEntityData.getAndStoreBlockEntity(stack, context.registries(), context.level(), () -> new tfarmBlockTileentity(BlockPos.ZERO, ModBlocks.TFARM_BLOCK.get().defaultBlockState()));
        // Removed villager-related tooltip information
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level1, BlockState state, BlockEntityType<T> type) {
        return new SimpleBlockEntityTicker<>(); // Keeps default behavior
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return new tfarmBlockTileentity(blockPos, blockState); // Spawn tfarmBlockTileentity
    }

    @Override
    public @NotNull RenderShape getRenderShape(@NotNull BlockState state) {
        return RenderShape.MODEL;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public float getShadeBrightness(@NotNull BlockState state, @NotNull BlockGetter worldIn, @NotNull BlockPos pos) {
        return 1F;
    }
}
