package net.nospacehuman.cbc;

import net.fabricmc.api.ModInitializer;
import net.nospacehuman.cbc.block.ModBlocks;
import net.nospacehuman.cbc.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CouldBeCursedMod implements ModInitializer {

	public static final String MOD_ID = "cbc";
	public static final String MOD_NAME = "Could Be Cursed";

	public static final String MOD_REGISTRY_NAME = MOD_NAME + " / " + MOD_ID;

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		LOGGER.debug(MOD_REGISTRY_NAME);
	}
}
