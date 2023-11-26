package test.java;

import main.java.fr.mediker.pageEvents.HomePageEvents;
import main.java.fr.mediker.pageEvents.HomeProfileEvents;
import main.java.fr.mediker.pageEvents.LoginPageEvents;
import main.java.fr.mediker.pageObjects.HomeProfileElements;
import org.testng.annotations.Test;

public class SampleTest extends BaseTest {

  @Test
  public void sampleMethodForEnteringCredentials() {
    HomePageEvents homePageEvents = new HomePageEvents();
    LoginPageEvents loginPageEvents = new LoginPageEvents();
    HomeProfileEvents homeProfileElements = new HomeProfileEvents();
    homePageEvents.signInButtonText();
    loginPageEvents.verifyIfLoginIsLoaded();
    loginPageEvents.enterCredentiels();
    homeProfileElements.contactCardInHome();

  }
}
