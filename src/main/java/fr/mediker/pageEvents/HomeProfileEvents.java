package main.java.fr.mediker.pageEvents;

import main.java.fr.mediker.pageObjects.HomeProfileElements;
import main.java.fr.mediker.utils.ElementFetch;
import main.java.fr.mediker.utils.ElementsTypes;

public class HomeProfileEvents {

  ElementFetch elementFetch = new ElementFetch();

  public void contactCardInHome() {
    elementFetch.getWebElement(ElementsTypes.xpath, HomeProfileElements.contactCardInHome).click();
  }


}
