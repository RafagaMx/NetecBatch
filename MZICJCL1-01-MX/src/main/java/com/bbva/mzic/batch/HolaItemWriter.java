package com.bbva.mzic.batch;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

public class HolaItemWriter implements ItemWriter<String>{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HolaItemWriter.class);
	
	@Override
	public void write(List<? extends String> arg0) throws Exception {
		LOGGER.info ("HolaItemWriter(): {} ", arg0);
		
	}

}
