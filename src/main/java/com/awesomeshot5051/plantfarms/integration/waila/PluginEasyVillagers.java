package com.awesomeshot5051.plantfarms.integration.waila;

import com.awesomeshot5051.plantfarms.blocks.overworld.aboveGround.Trees.BirchFarmBlock;
import com.awesomeshot5051.plantfarms.blocks.overworld.aboveGround.Trees.SpruceFarmBlock;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;

@WailaPlugin
public class PluginEasyVillagers implements IWailaPlugin {

    @Override
    public void registerClient(IWailaClientRegistration registration) {
        registration.registerBlockComponent(HUDHandlerVillager.INSTANCE, BirchFarmBlock.class);
        registration.registerBlockComponent(HUDHandlerVillager.INSTANCE, SpruceFarmBlock.class);

        registration.registerBlockIcon(HUDHandlerVillager.INSTANCE, BirchFarmBlock.class);
        registration.registerBlockIcon(HUDHandlerVillager.INSTANCE, SpruceFarmBlock.class);
    }

}
