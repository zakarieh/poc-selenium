package main.java.fr.mediker.pageEvents;

import main.java.fr.mediker.pageObjects.HomePageElements;
import main.java.fr.mediker.utils.ElementFetch;
import main.java.fr.mediker.utils.ElementsTypes;
import test.java.BaseTest;

public class HomePageEvents {

  ElementFetch elementFetch = new ElementFetch();

  public void signInButtonText() {
//    BaseTest.logger.info("Verifying Login Button ");
    elementFetch.getWebElement(ElementsTypes.xpath, HomePageElements.signInButtonText).click();
  }

}
