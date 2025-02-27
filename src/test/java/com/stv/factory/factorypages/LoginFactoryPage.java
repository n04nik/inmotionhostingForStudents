package com.stv.factory.factorypages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.stv.framework.core.lib.ImmotionPageURLs.FORGOT_PASSWORD_URL;
import static com.stv.framework.core.lib.ImmotionPageURLs.NEED_HELP_URL;

public class LoginFactoryPage extends FactoryPage {

    @FindBy(css = "#username")
    private WebElement emailField;

    @FindBy(css = "#password")
    private WebElement passwordField;

    @FindBy(css = "#login-submit")
    private WebElement submitButton;

    @FindBy(css = ".forgot-password")
    private WebElement forgotPasswordLink;

    @FindBy(css = ".amp-icon-newtab")
    private WebElement needHelpLink;

    public boolean isEmailFieldDisplayed() {
        return emailField.isDisplayed();
    }

    public boolean isPasswordFieldDisplayed() {
        return passwordField.isDisplayed();
    }

    public boolean isSubmitButtonDisplayed() {
        return submitButton.isDisplayed();
    }

    public boolean isForgotPasswordLinkDisplayed() {
        return forgotPasswordLink.isDisplayed();
    }

    public boolean isClickNeedHelpLinkDisplayed() {
        return needHelpLink.isDisplayed();
    }

    public void clickNeedHelpLink() {

        needHelpLink.click();
        getDriver().get(NEED_HELP_URL);
    }

    public void clickForgotPasswordLink() {
        forgotPasswordLink.click();
        getDriver().get(FORGOT_PASSWORD_URL);
    }
}