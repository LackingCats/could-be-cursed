package net.nospacehuman.cbc;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CouldBeCursedMod implements ModInitializer {

	public static final String MOD_ID = "cbc";
	public static final String MOD_NAME = "Could Be Cursed";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		LOGGER.info(MOD_NAME + " / " + MOD_ID);
	}
}
