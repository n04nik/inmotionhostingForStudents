package com.stv.factory.factorypages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainFactoryPage extends FactoryPage {

    @FindBy(css = "*[alt ='InMotion Hosting Logo']")
    private WebElement immotionLogo;

    @FindBy(id = "navbarNavDropdown")
    private WebElement navigationPanel;

    @FindBy(css = ".nav-link.btn-secondary-alt.btn-login")
    private WebElement loginButton;

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement acceptAllCookiesButton;

    @FindBy(id = "supportDropDown")
    private WebElement supportCenter;

    public MainFactoryPage acceptAllCookiesIfVisible() {
        if (acceptAllCookiesButton.isEnabled())
            acceptAllCookiesButton.click();
        return this;
    }

    public boolean isMainLogoDisplayed() {
        acceptAllCookiesIfVisible();
        return immotionLogo.isDisplayed();
    }

    public boolean isSupportCenterDisplayed() {
        return supportCenter.isDisplayed();
    }

    public boolean isNavigationPanelDisplayed() {
        return navigationPanel.isDisplayed();
    }

    public boolean isLoginButtonDisplayed() {
        return navigationPanel.isDisplayed();
    }

    public LoginFactoryPage clickLogin() {
        loginButton.click();
        return new LoginFactoryPage();
    }

    public WebElement getNavigationPanel() {
        return navigationPanel;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getSupportCenter() {
        return supportCenter;
    }
}

