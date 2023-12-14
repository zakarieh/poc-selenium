package test.java;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import main.java.fr.mediker.pageEvents.HomePageEvents;
import main.java.fr.mediker.pageEvents.HomeProfileEvents;
import main.java.fr.mediker.pageEvents.LoginPageEvents;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SampleTest1 extends BaseTest {

  HomePageEvents homePageEvents = new HomePageEvents();
  LoginPageEvents loginPageEvents = new LoginPageEvents();
  HomeProfileEvents homeProfileElements = new HomeProfileEvents();


  @Test(priority = 1)
  public void sampleMethodForEnteringCredentials() {
    homePageEvents.signInButtonText();
    loginPageEvents.verifyIfLoginIsLoaded();
    loginPageEvents.enterCredentiels();
    homeProfileElements.contactCardInHome();
  }

}
