package com.awesomeshot5051.plantfarms.blocks.nether.warpedForest;

import com.awesomeshot5051.plantfarms.blocks.*;
import com.awesomeshot5051.plantfarms.blocks.tileentity.nether.warpedForest.*;
import com.awesomeshot5051.plantfarms.datacomponents.*;
import com.awesomeshot5051.plantfarms.gui.*;
import com.awesomeshot5051.plantfarms.items.render.nether.warpedForest.*;
import de.maxhenkel.corelib.block.*;
import de.maxhenkel.corelib.blockentity.*;
import de.maxhenkel.corelib.client.*;
import net.minecraft.*;
import net.minecraft.client.gui.screens.*;
import net.minecraft.core.*;
import net.minecraft.network.chat.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.*;
import net.minecraft.world.phys.*;
import net.neoforged.api.distmarker.*;

import javax.annotation.*;
import java.util.*;
import java.util.stream.*;

import static net.minecraft.world.item.BlockItem.*;


public class warpedFarmBlock extends BlockBase implements EntityBlock, IItemBlock {

    public warpedFarmBlock() {
        super(Properties.of().mapColor(MapColor.METAL).strength(2.5F).sound(SoundType.METAL).noOcclusion());
    }

    @Override
    public Item toItem() {
        return new CustomRendererBlockItem(this, new Item.Properties()) {
            @OnlyIn(Dist.CLIENT)
            @Override
            public ItemRenderer createItemRenderer() {
                return new warpedFarmItemRenderer(); // Custom creeper farm renderer
            }
        };
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> components, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, components, tooltipFlag);
        warpedFarmTileentity trader = VillagerBlockEntityData.getAndStoreBlockEntity(stack, context.registries(), context.level(), () -> new warpedFarmTileentity(BlockPos.ZERO, ModBlocks.WARPED_FARM.get().defaultBlockState()));
        if (Screen.hasShiftDown()) {
            components.add(Component.translatable("tooltip.plantfarms.warped_farm.shift")
                    .withStyle(ChatFormatting.GRAY));
            ItemContainerContents defaultType = ItemContainerContents.fromItems(Collections.singletonList(new ItemStack(Items.WOODEN_AXE)));
            ItemStack axeType = ItemContainerContents.fromItems(Collections.singletonList(Objects.requireNonNull(stack.getOrDefault(ModDataComponents.AXE_TYPE, defaultType)).copyOne())).copyOne();
            components.add(Component.literal("This farm has a " + convertToReadableName(axeType.getItem().getDefaultInstance().getDescriptionId()) + " on it.")
                    .withStyle(ChatFormatting.RED));
        } else {
            components.add(Component.literal("Hold §4Shift§r to see tool").withStyle(ChatFormatting.YELLOW));
            components.add(Component.translatable("tooltip.plantfarms.warped_farm.hint")
                    .withStyle(ChatFormatting.YELLOW));
        }
    }

    private String convertToReadableName(String block) {
        // Remove "item.minecraft." and replace underscores with spaces
        String readableName = block.replace("item.minecraft.", "").replace('_', ' ');
        // Capitalize the first letter of each word
        return Arrays.stream(readableName.split(" "))
                .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack heldItem, BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
        BlockEntity tileEntity = worldIn.getBlockEntity(pos);
        if (!(tileEntity instanceof warpedFarmTileentity farm)) { // Check for warpedFarmTileentity
            return super.useItemOn(heldItem, state, worldIn, pos, player, handIn, hit);
        }

        // Directly open the container without villager checks
        player.openMenu(new MenuProvider() {
            @Override
            public Component getDisplayName() {
                return Component.translatable(state.getBlock().getDescriptionId());
            }

            @Nullable
            @Override
            public AbstractContainerMenu createMenu(int id, Inventory playerInventory, Player player) {
                return new OutputContainer(id, playerInventory, farm.getOutputInventory(), ContainerLevelAccess.create(worldIn, pos), ModBlocks.WARPED_FARM::get); // Adjust for warped farm
            }
        });
        return ItemInteractionResult.SUCCESS;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level1, BlockState state, BlockEntityType<T> type) {
        return new SimpleBlockEntityTicker<>(); // Keeps default behavior
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        super.setPlacedBy(level, pos, state, placer, stack);
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof warpedFarmTileentity farmTileEntity) {
            ItemContainerContents hoeType = stack.get(ModDataComponents.HOE_TYPE);
            if (hoeType != null) {
                farmTileEntity.axeType = hoeType.getStackInSlot(0);
                farmTileEntity.setChanged();
                updateCustomBlockEntityTag(level, placer instanceof Player ? (Player) placer : null, pos, hoeType.getStackInSlot(0));
                level.sendBlockUpdated(pos, state, state, 3);
            }
        }
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new warpedFarmTileentity(blockPos, blockState); // Spawn warpedFarmTileentity
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public float getShadeBrightness(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 1F;
    }
}
