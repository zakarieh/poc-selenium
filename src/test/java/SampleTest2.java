package test.java;

import main.java.fr.mediker.pageEvents.HomePageEvents;
import main.java.fr.mediker.pageEvents.LoginPageEvents;
import org.testng.annotations.Test;

public class SampleTest2 extends BaseTest {

  @Test(priority = 1)
  public void sampleMethodForEnteringCredentials2() {
    HomePageEvents homePageEvents = new HomePageEvents();
    LoginPageEvents loginPageEvents = new LoginPageEvents();
//    HomeProfileEvents homeProfileElements = new HomeProfileEvents();
    homePageEvents.signInButtonText();
    loginPageEvents.verifyIfLoginIsLoaded();

  }
}
