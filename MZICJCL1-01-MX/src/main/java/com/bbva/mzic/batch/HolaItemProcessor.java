package com.bbva.mzic.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class HolaItemProcessor implements ItemProcessor<String, String>{

	private static final Logger LOGGER = LoggerFactory.getLogger(HolaItemProcessor.class);
	
	@Override
	public String process(String arg0) throws Exception {
		LOGGER.info ("HolaItemProcessor(): {} ", arg0);
		return arg0.trim().toUpperCase();
	}

}
