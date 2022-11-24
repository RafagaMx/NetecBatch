package com.bbva.mzic.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.core.scope.context.ChunkContext;

public class SaludoJob implements Tasklet {

    private static final Logger LOGGER = LoggerFactory.getLogger(SaludoJob.class);
    private String message;

    public SaludoJob() {
        super();
        LOGGER.info ("constructor()");
        this.message = message;
    }

    public String getMessage () {
        return this.message;
    }

    public void setMessage (String message) {
        LOGGER.info ("setMessage() {} ", message);
        this.message= message;
    }

    @Override
    public RepeatStatus  execute (StepContribution arg0, ChunkContext arg1) {
        LOGGER.info ("execute() ");
        return RepeatStatus.FINISHED;
    }
}