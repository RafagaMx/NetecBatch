package com.bbva.mzic.batch;

import org.junit.Before;
import org.junit.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.scope.context.StepContext;
import org.springframework.batch.repeat.RepeatStatus;

import java.util.LinkedHashMap;

import static org.mockito.Mockito.when;

import com.bbva.mzic.batch.pojos.Message;
import com.bbva.mzic.batch.tasks.SaludoJob;
import com.bbva.mzic.batch.util.ConfigurationFactoryMock;

import junit.framework.Assert;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MZICJHM101MXExecuteTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(MZICJHM101MXExecuteTest.class);
	
	@InjectMocks
	private SaludoJob job;
	
	@Mock
	Message message;

	@Before
	public void setUp() {
		ConfigurationFactoryMock applicationConfigurationService = new ConfigurationFactoryMock();
	 
		String texto = applicationConfigurationService.getApplicationConfigurationService(null)
			.getDefaultProperty("message", "Por si no esta, toma esto");
		
		LOGGER.debug("texto message [{}]" , texto);
		
		MockitoAnnotations.initMocks(this);
		
		message.setText(texto);
		job.setMessage(message);
		LOGGER.debug("texto message [{}]" , texto);
		LOGGER.debug ("job message [{}] [{}]" , job.getMessage(), texto);
	}

	@Test
	public void testLaunchJob() throws Exception {
		
		JobParameters jobParameters = new JobParameters(new LinkedHashMap<String, JobParameter>() {
			{
				put("message", new JobParameter("Hola APX Inner"));
			}
		});

		JobExecution jobExecution = new JobExecution(1L, jobParameters);
		StepExecution stepExecution = new StepExecution("FirstStep", jobExecution);
		StepContribution stepContribution = new StepContribution(stepExecution);
		
		StepContext stepContext = new StepContext(stepExecution);
		ChunkContext chunkContext = new ChunkContext(stepContext);

		RepeatStatus repeatResult = job.execute(stepContribution, chunkContext);
		
		when (message.getText()).thenReturn("Hola Mundo APX");
		
		LOGGER.debug("--> job.getMessage() [{}] " , job.getMessage().getText());
		LOGGER.debug("--> message.getText() [{}]" , message.getText());
		Assert.assertEquals(job.getMessage().getText(), message.getText() );
	}
	
	@Test
	public void testLaunchJob2() throws Exception {
		
		JobParameters jobParameters = new JobParameters(new LinkedHashMap<String, JobParameter>() {
			{
				put("message", new JobParameter("Hola APX Inner"));
			}
		});

		JobExecution jobExecution = new JobExecution(1L, jobParameters);
		StepExecution stepExecution = new StepExecution("FirstStep", jobExecution);
		StepContribution stepContribution = new StepContribution(stepExecution);
		
		StepContext stepContext = new StepContext(stepExecution);
		ChunkContext chunkContext = new ChunkContext(stepContext);

		RepeatStatus repeatResult = job.execute(stepContribution, chunkContext);
		
		// ASSERT
		LOGGER.debug ("repeatResult " + repeatResult);
		Assert.assertEquals(repeatResult, RepeatStatus.FINISHED);
	}
	
	
	@Test
	public void testMessageNull() throws Exception {
		
		JobParameters jobParameters = new JobParameters(new LinkedHashMap<String, JobParameter>() {
			{
				put("message", new JobParameter("Hola APX Inner"));
			}
		});

		JobExecution jobExecution = new JobExecution(1L, jobParameters);
		StepExecution stepExecution = new StepExecution("FirstStep", jobExecution);
		StepContribution stepContribution = new StepContribution(stepExecution);
		
		StepContext stepContext = new StepContext(stepExecution);
		ChunkContext chunkContext = new ChunkContext(stepContext);

		RepeatStatus repeatResult = job.execute(stepContribution, chunkContext);
		
		LOGGER.debug("--> job.getMessage() [{}] " , job.getMessage().getText());
		LOGGER.debug("--> message.getText() [{}]" , message.getText());
		Assert.assertEquals(job.getMessage().getText(), message.getText() );

	}
}
