package org.fundacionjala.pivotal.cucumber.selenium.pages.common;

import org.fundacionjala.pivotal.cucumber.selenium.browser.DriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Administrator on 5/30/2017.
 */
public final class CommonActions {
  /**
   * construcotor.
   */
  private CommonActions() {
  }

  /**
   * setText.
   *
   * @param element webemet.
   * @param text    text to set
   */
  public static void setTextField(final WebElement element,
                                  final String text) {
    DriverManager.getInstance().getWait()
            .until(ExpectedConditions.visibilityOf(element));
    element.clear();
    element.sendKeys(text);
  }

  /**
   * Click.
   *
   * @param element element
   */
  public static void clickElement(final WebElement element) {
    DriverManager.getInstance().getWait()
            .until(ExpectedConditions.elementToBeClickable(element));
    element.click();
  }

  /**
   * Click.
   *
   * @param elementsList list of elemetns.
   * @param selectItem   imtm.
   * @return webElement
   */
  public static WebElement selectAnElement(final List<WebElement> elementsList,
                                           final String selectItem) {
    final int timeOut = 30;
    WebElement element = null;
    new WebDriverWait(DriverManager.getInstance()
            .getDriver(), timeOut);
    for (WebElement accountWebElement1 : elementsList) {
      if (accountWebElement1.getText().equals(selectItem)) {
        element = accountWebElement1;
        break;
      }
    }
    return element;
  }

  /**
   * Click.
   *
   * @param element to seelt
   */
  public static void clickOnaHiddenElement(final WebElement element) {
    DriverManager.getInstance().getWait()
            .until(ExpectedConditions.elementToBeClickable(element));
    JavascriptExecutor executor =
            (JavascriptExecutor) DriverManager.getInstance().getDriver();
    executor.executeScript("arguments[0].click()", element);
  }

  /**
   * Verify Messges.
   *
   * @param element is a WebElement
   * @param message is the message that shows the application.
   * @return true  if the element is present or false if not
   */
  public static boolean verifyMessages(final WebElement element,
                                       final String message) {
    return element.getText().contains(message);
  }

  /**
   * Verify if a element is enabled.
   *
   * @param element is a WebElement
   * @return true  if the element is present or false if not
   */
  public static boolean assertAndVerifyElement(final WebElement element) {
    return element.isEnabled();
  }
}



