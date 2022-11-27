package com.bbva.mzic.batch.tasks;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import com.bbva.mzic.batch.pojos.Message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SaludoJob implements Tasklet {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SaludoJob.class);
	private Message message;

	
	public SaludoJob() {
		super();
		LOGGER.info("Estando en el constructor");
	}


	@Override
	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {

        // Toda la logica del task
		LOGGER.info("*** Hola mundo APX !!!****");
		LOGGER.info("arg0: [{}]" , arg0);
		LOGGER.info("arg1: [{}]" , arg1);
		LOGGER.info("message: [{}]", message.getText());
		return RepeatStatus.FINISHED;
	}


	public Message getMessage() {
		return message;
	}


	public void setMessage(Message message) {
		this.message = message;
		LOGGER.info("Property setting: [{}]", this.message);
	}
	
}
