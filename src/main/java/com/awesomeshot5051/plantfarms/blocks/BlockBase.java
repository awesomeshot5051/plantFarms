package com.awesomeshot5051.plantfarms.blocks;

import de.maxhenkel.corelib.block.VoxelUtils;
import de.maxhenkel.corelib.client.CustomRendererBlockItem;
import de.maxhenkel.corelib.client.ItemRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

public class BlockBase extends HorizontalRotatableBlock {

    private static final VoxelShape SHAPE = VoxelUtils.combine(
            Block.box(0D, 0D, 0D, 16D, 1D, 16D),
            Block.box(0D, 15D, 0D, 16D, 16D, 16D),
            Block.box(0D, 0D, 0D, 1D, 16D, 16D),
            Block.box(15D, 0D, 0D, 16D, 16D, 16D),
            Block.box(0D, 0D, 0D, 16D, 16D, 1D),
            Block.box(0D, 0D, 15D, 16D, 16D, 16D)
    );

    public BlockBase(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter reader, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return SHAPE;
    }

    public static Item createItemWithDynamicRenderer(Block block) {
        // Extract the class name dynamically
        String className = block.getClass().getSimpleName();
        String itemRendererName = className.replace("Block", "");

        try {
            // Capitalize the renderer name if it's in the 'trees' package
            String blockPackage = block.getClass().getPackageName();
//            if (blockPackage.contains(".trees") || blockPackage.contains(".Trees")) {
//                // Only for classes in the 'trees' package, capitalize the first letter
//                itemRendererName = Character.toUpperCase(itemRendererName.charAt(0)) + itemRendererName.substring(1);
//            }

            // Build the fully qualified name for the renderer
            String location = blockPackage.substring(blockPackage.lastIndexOf('.') + 1); // Extract the location from the package
            String rendererPackage = blockPackage.replace(".blocks.", ".items.render.");
//            rendererPackage += location;
            String fullyQualifiedRendererName = rendererPackage + "." + itemRendererName + "ItemRenderer";

            // Dynamically find the renderer class and create a new instance
            Class<?> rendererClass = Class.forName(fullyQualifiedRendererName);
            ItemRenderer itemRenderer = (ItemRenderer) rendererClass.getDeclaredConstructor().newInstance();

            // Return the custom block item with the dynamic renderer
            return new CustomRendererBlockItem(block, new Item.Properties()) {
                @OnlyIn(Dist.CLIENT)
                @Override
                public ItemRenderer createItemRenderer() {
                    return itemRenderer;
                }
            };
        } catch (Exception e) {
            throw new RuntimeException("Failed to create item renderer for: " + itemRendererName, e);
        }
    }


}
