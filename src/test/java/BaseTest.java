package test.java;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import main.java.fr.mediker.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.lang.reflect.Method;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class BaseTest {
  public static WebDriver driver;
  private ExtentSparkReporter extentSparkReporter;
  private static ExtentReports extentReports;
  public static ExtentTest extentTest;


  @BeforeTest
  public void beforeTestMethod() {
    extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator + "reports" + File.separator + "automation-report.html");
    extentSparkReporter.config().setEncoding("utf-8");
    extentSparkReporter.config().setDocumentTitle("Automation Report" + Instant.now().toString());
    extentSparkReporter.config().setReportName("Test Compaign");
    extentSparkReporter.config().setTheme(Theme.DARK);
    extentSparkReporter.config().setTimeStampFormat("EEEE d MMMM yyyy hh:mm:ss");
    extentSparkReporter.config().setCss(".badge-primary(background-color: #00000}");
//    htmlReporter.config().setJs("document.getElementsByClassName('logo')[0].style.display='none';");


    extentReports = new ExtentReports();
    extentReports.attachReporter(extentSparkReporter);
    extentReports.setSystemInfo("Automation Tester", "Eng. Zakarieh F. Arreh");
  }

  @BeforeMethod
  @Parameters(value = {"browserName"})
  public void beforeMethodMethod(String browserName, Method testMethod) {
    extentTest = extentReports.createTest(
      testMethod.getName());

    setUpDriver(browserName);
    driver.get(Constants.url);
    System.out.println("Browser selected: " + browserName);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod(ITestResult result) {
    if (result.getStatus() == ITestResult.FAILURE) {
      extentTest.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
      extentTest.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
//      String methodName = result.getMethod().getMethodName();
//      String logText = "Test Case:" + methodName + " Skipped";
//      Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
//      logger.log(Status.FAIL, m);
//      logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
    } else if (result.getStatus() == ITestResult.FAILURE) {
//      logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
      String methodName = result.getMethod().getMethodName();
      String logText = "Test Case:" + methodName + " Skipped";
      Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
      extentTest.log(Status.SKIP, m);
    } else if (result.getStatus() == ITestResult.SUCCESS) {
//      logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " - Test Case PASS", ExtentColor.GREEN));
      String methodName = result.getMethod().getMethodName();
      String logText = "Test Case: " + methodName + " Passed ";
      Markup m = MarkupHelper.createLabel(logText, ExtentColor.CYAN);
      extentTest.log(Status.PASS, m);
    }
    driver.quit();
  }


  @AfterTest
  public void afterTestMethod() {
    extentReports.flush();
  }


  protected void setUpDriver(String browser) {

//    if (browser.equalsIgnoreCase("chrome")) {
//      System.getProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver");
////      System.getProperty("webdriver.chrome.driver", "~/Documents/Self-proj/poc-selenium/drivers/chromedriver");
//      driver = new ChromeDriver();
//    } else if (browser.equalsIgnoreCase("firefox")) {
//      System.getProperty("webdriver.gecko.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "geckodriver");
//      FirefoxOptions options = new FirefoxOptions();
//      options.addArguments("-headless");
//      options.setCapability("acceptInsecureCerts", true);
//      options.setCapability("browserName", "firefox");
//      driver = new FirefoxDriver(options);
//    } else if (browser.equalsIgnoreCase("edge")) {
//      System.getProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver");
//      driver = new ChromeDriver();
//    }

    if (browser.equalsIgnoreCase("chrome")) {
      WebDriverManager.chromedriver().clearDriverCache().setup();
      driver = new ChromeDriver();
    } else if (browser.equalsIgnoreCase("firefox")) {
      FirefoxOptions options = new FirefoxOptions();
//      options.addArguments("--window-size=1920,1080");
      options.addArguments("-headless");
//      options.addArguments("--disable-gpu");
//      options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36");
      WebDriverManager.firefoxdriver().setup();
      driver = new FirefoxDriver(options);
    } else if (browser.equalsIgnoreCase("edge")) {
      WebDriverManager.edgedriver().setup();
      driver = new EdgeDriver();
    }

  }
}
