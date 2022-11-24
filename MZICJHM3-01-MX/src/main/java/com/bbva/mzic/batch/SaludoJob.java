package com.bbva.mzic.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class SaludoJob implements Tasklet {

	private static final Logger LOGGER = LoggerFactory.getLogger(SaludoJob.class);

	private String message;

	public SaludoJob() {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		LOGGER.info("setMessage() {} ", message);
		this.message = message;
	}
	
	@Override
    public RepeatStatus  execute (StepContribution arg0, ChunkContext arg1) {
        LOGGER.info ("execute(): {} ", this.message);
        
        if(this.message.contains("a")) {
        	throw new IllegalArgumentException("Esto nunca sale a produccion");
        }
        return RepeatStatus.FINISHED;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SaludoJob other = (SaludoJob) obj;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		return true;
	}

}
