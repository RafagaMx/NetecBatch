package com.bbva.mzic.batch;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HolaItemReader implements ItemReader<String>{

	private static final Logger LOGGER = LoggerFactory.getLogger(HolaItemReader.class);
	
	private String[] input= {
			"hOLA mUNDO apx bATCH  ",
			"Adios Mundo APX Batch",
			"  Un mensaje mas.....",
			"Solo para demostracion",
			"Curso: APX Batch  ",
			null
	};
	
	@Override
	public String read() throws Exception, UnexpectedInputException, 
	                        ParseException, NonTransientResourceException {
		// Implementación de la carga de datos
		String men= this.input[(int)(Math.random() * input.length)];
		LOGGER.info("read(): [{}]", men);
		return men;
	}

}
