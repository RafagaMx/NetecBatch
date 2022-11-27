package com.bbva.mzic.batch;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Test for batch process MZICJHM5-02-MX
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:/META-INF/spring/batch/beans/MZICJHM5-02-MX-beans.xml","classpath:/META-INF/spring/batch/jobs/jobs-MZICJHM5-02-MX-context.xml","classpath:/META-INF/spring/jobs-MZICJHM5-02-MX-runner-context.xml"})
public class MZICJHM502MXFunctionalTest{

	@Autowired
	private JobLauncherTestUtils jobLauncherTestUtils;


	@Test
	public void testLaunchJob() throws Exception {
		//TODO implements job launch test
		//Without parameters (use this implementation if job not need parameters)
		// final JobExecution jobExecution = jobLauncherTestUtils.launchJob();
		
		//With parameters (use this implementation if job needs parameters comment first implementation) 
		/*********************** Parameters Definition ***********************/
		//First parameter
		final JobParameter jobParameter1 = new JobParameter("Octubre");
		final JobParameter jobParameter2 = new JobParameter("Noviembre");
		final JobParameter jobParameter3 = new JobParameter("Diciembre");
		
		//Add parameters to job
		final HashMap<String, JobParameter> parameters = new HashMap<String, JobParameter>();
		parameters.put("message1", jobParameter1);
		parameters.put("message2", jobParameter2);
		parameters.put("message3", jobParameter3);
		
		final JobParameters jobParameters = new JobParameters(parameters);
		final JobExecution jobExecution = jobLauncherTestUtils.launchJob(jobParameters);
		
		//TODO implements job launch test Assert's
		Assert.assertTrue(jobExecution.getExitStatus().equals(ExitStatus.COMPLETED));
	}
	

	@Test
	public void testLaunchJob2() throws Exception {
		//TODO implements job launch test
		//Without parameters (use this implementation if job not need parameters)
		// final JobExecution jobExecution = jobLauncherTestUtils.launchJob();
		
		//With parameters (use this implementation if job needs parameters comment first implementation) 
		/*********************** Parameters Definition ***********************/
		//First parameter
		final JobParameter jobParameter1 = new JobParameter("mayo");
		final JobParameter jobParameter2 = new JobParameter("Noviembre");
		final JobParameter jobParameter3 = new JobParameter("Diciembre");
		
		//Add parameters to job
		final HashMap<String, JobParameter> parameters = new HashMap<String, JobParameter>();
		parameters.put("message1", jobParameter1);
		parameters.put("message2", jobParameter2);
		parameters.put("message3", jobParameter3);
		
		final JobParameters jobParameters = new JobParameters(parameters);
		final JobExecution jobExecution = jobLauncherTestUtils.launchJob(jobParameters);
		
		//TODO implements job launch test Assert's
		Assert.assertTrue(jobExecution.getExitStatus().equals(ExitStatus.COMPLETED));
	}
	

	@Test
	public void testLaunchJob3() throws Exception {
		//TODO implements job launch test
		//Without parameters (use this implementation if job not need parameters)
		// final JobExecution jobExecution = jobLauncherTestUtils.launchJob();
		
		//With parameters (use this implementation if job needs parameters comment first implementation) 
		/*********************** Parameters Definition ***********************/
		//First parameter
		final JobParameter jobParameter1 = new JobParameter("mayo");
		final JobParameter jobParameter2 = new JobParameter("Noviembre");
		final JobParameter jobParameter3 = new JobParameter("abril");
		
		//Add parameters to job
		final HashMap<String, JobParameter> parameters = new HashMap<String, JobParameter>();
		parameters.put("message1", jobParameter1);
		parameters.put("message2", jobParameter2);
		parameters.put("message3", jobParameter3);
		
		final JobParameters jobParameters = new JobParameters(parameters);
		final JobExecution jobExecution = jobLauncherTestUtils.launchJob(jobParameters);
		
		//TODO implements job launch test Assert's
		Assert.assertTrue(jobExecution.getExitStatus().equals(ExitStatus.FAILED));
	}
}
