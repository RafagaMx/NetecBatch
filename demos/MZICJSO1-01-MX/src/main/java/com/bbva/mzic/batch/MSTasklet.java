package com.bbva.mzic.batch;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bbva.elara.batch.utility.sort.merge.impl.SortAndMergeUtilityImpl;
import com.bbva.elara.batch.utility.sort.merge.enumeration.SortKeyCriteria;

public class MSTasklet implements Tasklet {

	private static final Logger LOGGER = LoggerFactory.getLogger(MSTasklet.class);

	private SortAndMergeUtilityImpl mySortOrMerge;

	public MSTasklet() {
		LOGGER.info("En el constructor");
	}

	@Override
	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {
		LOGGER.info(":::: Inicio execute()");
		mySortOrMerge.sortUnix();
		LOGGER.info(":::: Fin execute()");
		return RepeatStatus.FINISHED;
	}

	public void setMySortOrMerge(SortAndMergeUtilityImpl mySortOrMerge) {
		this.mySortOrMerge = mySortOrMerge;
		LOGGER.info("set(): {}" , this.mySortOrMerge);
	}

	@Override
	public String toString() {
		return "MSTasklet [mySortOrMerge=" + mySortOrMerge + "]";
	}

}
