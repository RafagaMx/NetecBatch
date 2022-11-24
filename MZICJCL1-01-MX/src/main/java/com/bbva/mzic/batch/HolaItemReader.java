package com.bbva.mzic.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class HolaItemReader implements ItemReader<String>{
	private static final Logger LOGGER = LoggerFactory.getLogger(HolaItemReader.class);
	private static final String[] input = {"Primero", "Segundo", "Tercero", "Cuarto", null};
	
	@Override
	public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		// TODO Auto-generated method stub
		String message = input[(int)(Math.random()*input.length)];
		LOGGER.info ("HolaItemReader(): {} ", message);
		return message;
	}

	
}
