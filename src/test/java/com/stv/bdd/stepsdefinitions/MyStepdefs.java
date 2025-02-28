package com.stv.bdd.stepsdefinitions;

import com.stv.factory.factorypages.LoginFactoryPage;
import com.stv.factory.factorypages.MainFactoryPage;
import com.stv.factory.factorytests.BasicFactoryTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.stv.framework.core.lib.ImmotionPageURLs.FORGOT_PASSWORD_URL;
import static com.stv.framework.core.utils.Waiters.waitForElementVisible;

import java.time.Duration;

public class MyStepdefs extends BasicFactoryTest {



    private final MainFactoryPage mainFactoryPage = new MainFactoryPage();
    private final LoginFactoryPage loginFactoryPage = new LoginFactoryPage();


    @Given("Main page is loaded")
    public void mainPageIsLoaded() {
        setUp();
    }

    @When("Support Center panel is loaded")
    public void supportCenterPanelIsLoaded() {
        waitForElementVisible(getDriver(), Duration.ofSeconds(2), mainFactoryPage.getSupportCenter());
        Assert.assertTrue(mainFactoryPage.isSupportCenterDisplayed(), "Support Center panel isn't visible");
    }

    @And("Navigation Bar is loaded")
    public void navigationBarIsLoaded() {
        waitForElementVisible(getDriver(), Duration.ofSeconds(2), mainFactoryPage.getNavigationPanel());
        Assert.assertTrue(mainFactoryPage.isNavigationPanelDisplayed(), "Navigation panel isn't visible");
    }

    @When("Go to the login page")
    public void goToTheLoginPage() {
        waitForElementVisible(getDriver(), Duration.ofSeconds(2), mainFactoryPage.getLoginButton());
        mainFactoryPage.clickLogin();
    }

    @When("Click on the I don't remember my password in link")
    public void clickOnTheIDonTRememberMyPasswordInLink() {
        loginFactoryPage.clickForgotPasswordLink();
    }

    @Then("User should be redirected to the help page")
    public void userShouldBeRedirectedToTheHelpPage() throws Exception {
        String result = getDriver().getCurrentUrl();
        Assert.assertEquals(result, FORGOT_PASSWORD_URL, "Forgot password page isn't loaded");
        afterClass();
    }

}
