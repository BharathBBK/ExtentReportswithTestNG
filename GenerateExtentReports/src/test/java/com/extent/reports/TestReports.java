package com.extent.reports;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestReports {
	
	public  ExtentReports extent;
	public ExtentSparkReporter spark;
	public ExtentTest test;
  @Test
  public void Test1() {
	  test = extent.createTest("Verify Launch Browser")
			  .assignAuthor("Bharath")
			  .assignCategory("smoke")
			  .assignDevice("chrome");
	  test.log(Status.PASS, "Browser lunched");
	  test.pass("Browser launched successfully");
  }
  @Test
  public void Test2() {
	  test = extent.createTest("Verify user able to login with valid cred.")
			  .assignAuthor("Kumar")
			  .assignCategory("sanity")
			  .assignDevice("chrome");
	  test.info("Enter valid credentials");
	  test.pass("user logged in successfully");
	  test.warning("Reset password after first login");
  }
  @Test
  public void Test3() {
	  test = extent.createTest("Verify user able to reach home screen")
			  .assignAuthor("Kumar")
			  .assignCategory("regression")
			  .assignDevice("chrome");
	  test.skip("Unable to load home screen");
  }
  @Test
  public void Test4() {
	  test = extent.createTest("Verify user navigate all screens")
			  .assignAuthor("BBK")
			  .assignCategory("regression")
			  .assignDevice("chrome");
	  test.fail("User unable to navigate all screens");
  }
  @Test
  public void Test5() {
	  test = extent.createTest("Verify user able to click on logout button")
			  .assignAuthor("BBK")
			  .assignCategory("regression")
			  .assignDevice("chrome");
	  test.pass("User able to click on logout button and it's loading");
  }
  @Test
  public void Test6() {
	  test = extent.createTest("Verify user able to logged out successfully")
			  .assignAuthor("BBK1")
			  .assignCategory("regression")
			  .assignDevice("chrome");
	  test.fail("User unable to logout application is not responding");
	  test.info("User routed back to login screen instead of logout screen");
  }
  @BeforeTest
  public void beforeTest() {
	  extent = new ExtentReports();
	  spark = new ExtentSparkReporter("ExtentReport.html");
	  extent.attachReporter(spark);
  }

  @AfterTest
  public void afterTest() {
	  extent.flush();
  }

}
