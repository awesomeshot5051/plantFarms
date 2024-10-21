
package com.awesomeshot5051.plantfarms.fluids;

import com.awesomeshot5051.plantfarms.blocks.ModBlocks;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import com.awesomeshot5051.plantfarms.items.ModItems;


public abstract class waterFluid extends BaseFlowingFluid {
    public static final BaseFlowingFluid.Properties PROPERTIES = new BaseFlowingFluid.Properties(() -> modFluidTypes.WATER_TYPE.get(), () -> modFluids.WATER.get(), () -> modFluids.FLOWING_WATER.get())
            .explosionResistance(100f).bucket(() -> ModItems.WATER_BUCKET.get()).block(() -> (LiquidBlock) ModBlocks.WATER.get());


    private waterFluid() {
        super(PROPERTIES);
    }

    public static class Source extends waterFluid {
        public int getAmount(FluidState state) {
            return 8;
        }

        public boolean isSource(FluidState state) {
            return true;
        }
    }

    public static class Flowing extends waterFluid {
        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
            super.createFluidStateDefinition(builder);
            builder.add(LEVEL);
        }

        public int getAmount(FluidState state) {
            return state.getValue(LEVEL);
        }

        public boolean isSource(FluidState state) {
            return false;
        }
    }
}
