package main.java.fr.mediker.pageEvents;

import main.java.fr.mediker.pageObjects.LoginPageElements;
import main.java.fr.mediker.utils.ElementFetch;
import main.java.fr.mediker.utils.ElementsTypes;
import org.testng.Assert;

public class LoginPageEvents {

  ElementFetch elementFetch = new ElementFetch();

  public void verifyIfLoginIsLoaded() {
//    BaseTest.logger.info("Verifying Login Button below email and Password ");
    Assert.assertTrue(elementFetch.getWebElements(ElementsTypes.xpath, LoginPageElements.loginButtonText).size() > 0, LoginPageElements.loginButtonText+ "Element not found");
  }

  public void enterCredentiels() {
    elementFetch.getWebElement(ElementsTypes.xpath, LoginPageElements.emailAddressField).sendKeys("fouadzak@yopmail.com");
    elementFetch.getWebElement(ElementsTypes.xpath, LoginPageElements.passwordField).sendKeys("Test@12@34");
    elementFetch.getWebElement(ElementsTypes.xpath, LoginPageElements.loginButtonText).click();
  }

}
