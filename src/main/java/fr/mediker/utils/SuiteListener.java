package main.java.fr.mediker.utils;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;
import test.java.BaseTest;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;


public class SuiteListener implements ITestListener, IAnnotationTransformer {

  @Override
  public void onTestStart(ITestResult result) {
    String testName = result.getName();
    System.out.println(testName + " started executing");
  }


  @Override
  public void onTestSuccess(ITestResult result) {
    String testName = result.getName();
    System.out.println(testName + " got succefully executed");
  }

  @Override
  public void onTestFailure(ITestResult iTestResult) {
    String filename = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + iTestResult.getMethod().getMethodName();
    File file = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);

    try {
      FileUtils.copyFile(file, new File(filename + ".png"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void onTestSkipped(ITestResult result) {
  }

  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
  }

//  @Override
//  public void onTestFailedWithTimeout(ITestResult result) {
//    this.onTestFailure(result);
//  }

  @Override
  public void onStart(ITestContext context) {
  }

  @Override
  public void onFinish(ITestContext context) {
  }


  //  @Override
  public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
    annotation.setRetryAnalyzer(RetryAnalyser.class);
  }
}
