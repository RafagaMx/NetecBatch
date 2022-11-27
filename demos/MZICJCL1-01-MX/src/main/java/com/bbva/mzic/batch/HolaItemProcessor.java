package com.bbva.mzic.batch;

import org.springframework.batch.item.ItemProcessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HolaItemProcessor implements ItemProcessor<String,String>{

	private static final Logger LOGGER = LoggerFactory.getLogger(HolaItemProcessor.class);
	
	@Override
	public String process(String arg0) throws Exception {
		// Logica de negocio para transformar la informacion
		String res = arg0.trim().toUpperCase();
		LOGGER.info("processor(): [{}]", res);
		return res;
	}

}
