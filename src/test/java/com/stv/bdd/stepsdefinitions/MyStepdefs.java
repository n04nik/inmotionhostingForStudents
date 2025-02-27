package com.stv.bdd.stepsdefinitions;

import com.stv.factory.factorypages.LoginFactoryPage;
import com.stv.factory.factorypages.MainFactoryPage;
import com.stv.factory.factorytests.BasicFactoryTest;
import com.stv.framework.core.drivers.MyDriver;
import com.stv.framework.core.lib.ImmotionPageURLs;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static com.stv.framework.core.lib.ImmotionPageURLs.FORGOT_PASSWORD_URL;
import static com.stv.framework.core.utils.Waiters.waitForElementVisible;

import java.time.Duration;

public class MyStepdefs extends BasicFactoryTest {

    private WebDriver driver;
    private MainFactoryPage mainFactoryPage;
    private LoginFactoryPage loginFactoryPage;

    @Before
    public void setUp() {
        driver = MyDriver.getDriver();
        mainFactoryPage = new MainFactoryPage();
        loginFactoryPage = new LoginFactoryPage();
        driver.manage().window().maximize();
    }

    @Given("Main page is loaded")
    public void mainPageIsLoaded() {
        driver.get(ImmotionPageURLs.START_URL);
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(mainFactoryPage.getLoginButton()));
        mainFactoryPage.clickLogin();
    }

    @When("Click on the I don't remember my password in link")
    public void clickOnTheIDonTRememberMyPasswordInLink() {
        loginFactoryPage.clickForgotPasswordLink();
    }

    @Then("User should be redirected to the help page")
    public void userShouldBeRedirectedToTheHelpPage() {
        String result = getDriver().getCurrentUrl();
        Assert.assertEquals(result, FORGOT_PASSWORD_URL, "Forgot password page isn't loaded");
    }

    @After
    public void closeDriver() {
        driver.quit();
    }


}
