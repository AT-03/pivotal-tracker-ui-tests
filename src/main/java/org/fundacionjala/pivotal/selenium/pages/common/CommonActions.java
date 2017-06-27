package org.fundacionjala.pivotal.selenium.pages.common;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.fundacionjala.pivotal.selenium.browser.DriverManager;
import org.fundacionjala.pivotal.selenium.pages.accounts.Accounts;
import org.fundacionjala.pivotal.selenium.pages.menu.ToolBars;

/**
 * Created by Administrator on 5/30/2017.
 */
public final class CommonActions {

    private static final int MILLI_SECONDS = 4000;

    private static final Logger LOGGER = Logger.getLogger(CommonActions.class.getName());

    /**
     * constructor.
     */
    private CommonActions() {
    }

    /**
     * This method waits and clear the element.
     *
     * @param webElement Element to wait and clear.
     */
    public static void clearTextField(final WebElement webElement) {
        DriverManager.getInstance().getWait().until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
    }

    /**
     * setText.
     *
     * @param element web element.
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
     * @param elementsList list of elements.
     * @param selectItem   item.
     * @return webElement
     */
    public static WebElement selectAnElement(final List<WebElement> elementsList,
                                             final String selectItem) {
        WebElement webElement = elementsList.stream()
                .filter(element -> selectItem.equals(element.getText()))
                .findAny()
                .orElse(null);
        if (webElement == null) {
            throw new WebDriverException("Not fount: The element looking for does not exits!");
        }
        return webElement;

    }

    /**
     * Click.
     *
     * @param element to see.
     */
    public static void clickOnaHiddenElement(final WebElement element) {
        DriverManager.getInstance().getWait()
                .until(ExpectedConditions.elementToBeClickable(element));
        JavascriptExecutor executor =
                (JavascriptExecutor) DriverManager.getInstance().getDriver();
        executor.executeScript("arguments[0].click()", element);
    }

    /**
     * Verify Messages.
     *
     * @param element is a WebElement
     * @param message is the message that shows the application.
     * @return true  if the element is present or false if not
     */
    @Deprecated
    public static boolean verifyMessages(final WebElement element,
                                         final String message) {
        return element.getText().contains(message);
    }

    /**
     * This method waits and clickElement the element.
     *
     * @param webElement Element to wait and clickElement.
     * @return text to element.
     */
    public static String getText(final WebElement webElement) {
        DriverManager.getInstance().getWait().until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getText();
    }

    /**
     * This method return an account.
     *
     * @return Account return an account
     */
    public static Accounts getAccount() {
        ToolBars topMenu = new ToolBars();
        topMenu.clickUserMenu();
        return topMenu.clickAccountDropDownItem();
    }

    /**
     * Wait an seconds.
     */
    public static void sleep() {
        try {
            Thread.sleep(MILLI_SECONDS);
        } catch (InterruptedException e) {
            LOGGER.error("Waiting time is over", e);
            Thread.currentThread().interrupt();
        }
    }
}
