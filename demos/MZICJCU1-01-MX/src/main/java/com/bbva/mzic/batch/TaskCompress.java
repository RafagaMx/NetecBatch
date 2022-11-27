package com.bbva.mzic.batch;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bbva.elara.batch.utility.compress.manager.CompressManager;
import com.bbva.elara.batch.utility.compress.manager.utils.CompressionType;

public class TaskCompress implements Tasklet, StepExecutionListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(TaskCompress.class);

	private CompressManager compressManager;

	public TaskCompress(CompressManager compressManager) {
		this.compressManager = compressManager;
		LOGGER.info("---> TaskCompress()");
	}

	@Override
	public ExitStatus afterStep(StepExecution arg0) {

		LOGGER.info("---> afterStep()");
		return ExitStatus.COMPLETED;
	}

	@Override
	public void beforeStep(StepExecution arg0) {
		LOGGER.info("---> beforeStep()");
	}

	@Override
	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {
		
//		compressManager.decompressFile(
//				"/ENTORNO_LOCAL_APX/fichtemcomp/datent/archivo.zip", 
//				"/ENTORNO_LOCAL_APX/fichtemcomp/datsal/demo", 
//				CompressionType.ZIP);
		
		compressManager.compressFile(
				"/ENTORNO_LOCAL_APX/fichtemcomp/datent/pf", 
				"/ENTORNO_LOCAL_APX/fichtemcomp/datsal/salidaPF.zip", 
				CompressionType.ZIP);
		
		LOGGER.info("---> execute() decompress");
		return RepeatStatus.FINISHED;
	}

	public CompressManager getCompressManager() {
		return compressManager;
	}

	public void setCompressManager(CompressManager compressManager) {
		this.compressManager = compressManager;
	}
	
	
}