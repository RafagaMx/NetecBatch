package com.bbva.mzic.batch;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SaludoJob implements Tasklet {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SaludoJob.class);
	private String message;
	
	public SaludoJob() {
		super();
		LOGGER.info("Estando en el constructor");
	}


	@Override
	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {

        // Toda la logica del task
		// LOGGER.info("*** Hola mundo APX !!!****");
		LOGGER.info("arg0: {}", arg0);
		LOGGER.info("arg1: {}", arg1);
		LOGGER.info("message: {}", this.message);
		
//		boolean flag = Math.random() > 0.5 ? true: false;
//		if (flag) {
//			throw new IllegalArgumentException("Esto solo es prueba");
//		}
		// Only Trainning
		if (this.message.contains("a")) {
			throw new IllegalArgumentException("Esto solo es prueba");
		}
		
		return RepeatStatus.FINISHED;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		LOGGER.info("Property setting");
		this.message = message;
	}
	

}
