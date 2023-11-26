package main.java.fr.mediker.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import test.java.BaseTest;

import java.util.List;

public class ElementFetch {

  public WebElement getWebElement(String identifierType, String identifierValue) {

    switch (identifierType) {

      case ElementsTypes.xpath:
        return BaseTest.driver.findElement(By.xpath(identifierValue));

      case ElementsTypes.cssSelector:
        return BaseTest.driver.findElement(By.cssSelector(identifierValue));

      case ElementsTypes.id:
        return BaseTest.driver.findElement(By.id(identifierValue));

      case ElementsTypes.name:
        return BaseTest.driver.findElement(By.name(identifierValue));

      case ElementsTypes.tagname:
        return BaseTest.driver.findElement(By.tagName(identifierValue));

      case ElementsTypes.linkText:
        return BaseTest.driver.findElement(By.linkText(identifierValue));

      case ElementsTypes.partialLinkText:
        return BaseTest.driver.findElement(By.partialLinkText(identifierValue));

      case ElementsTypes.className:
        return BaseTest.driver.findElement(By.className(identifierValue));

      default:
        return null;
    }
  }

  public List<WebElement> getWebElements(String identifierType, String identifierValue) {

    switch (identifierType) {

      case ElementsTypes.xpath:
        return BaseTest.driver.findElements(By.xpath(identifierValue));

      case ElementsTypes.cssSelector:
        return BaseTest.driver.findElements(By.cssSelector(identifierValue));

      case ElementsTypes.id:
        return BaseTest.driver.findElements(By.id(identifierValue));

      case ElementsTypes.name:
        return BaseTest.driver.findElements(By.name(identifierValue));

      case ElementsTypes.tagname:
        return BaseTest.driver.findElements(By.tagName(identifierValue));

      case ElementsTypes.linkText:
        return BaseTest.driver.findElements(By.linkText(identifierValue));

      case ElementsTypes.partialLinkText:
        return BaseTest.driver.findElements(By.partialLinkText(identifierValue));

      case ElementsTypes.className:
        return BaseTest.driver.findElements(By.className(identifierValue));

      default:
        return null;
    }
  }


}
