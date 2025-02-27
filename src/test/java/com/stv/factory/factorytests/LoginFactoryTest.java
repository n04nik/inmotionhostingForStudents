package com.stv.factory.factorytests;

import com.stv.factory.factorypages.LoginFactoryPage;
import com.stv.factory.factorypages.MainFactoryPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.stv.framework.core.lib.ImmotionPageURLs.FORGOT_PASSWORD_URL;
import static com.stv.framework.core.lib.ImmotionPageURLs.NEED_HELP_URL;

public class LoginFactoryTest extends BasicFactoryTest {

    LoginFactoryPage loginFactoryPage = new LoginFactoryPage();
    MainFactoryPage mainFactoryPage = new MainFactoryPage();

    @Test(description = "Assert all elements on the login page displayed")

    public void assertLoginPageElementsAreDisplayed() {
        mainFactoryPage.clickLogin();
        Assert.assertTrue(loginFactoryPage.isEmailFieldDisplayed(), "The email field isn't displayed");
        Assert.assertTrue(loginFactoryPage.isPasswordFieldDisplayed(), "The password field isn't displayed");
        Assert.assertTrue(loginFactoryPage.isForgotPasswordLinkDisplayed(), "The Forgot Password link isn't displayed");
        Assert.assertTrue(loginFactoryPage.isSubmitButtonDisplayed(), "The login button isn't displayed");
        Assert.assertTrue(loginFactoryPage.isClickNeedHelpLinkDisplayed(), "The Need Help link isn't displayed");
    }

    @Test(description = "Verify that clicking the 'Need Help' link redirects to the correct help page URL")

    public void testClickNeedHelpLink() {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        setUp();
        mainFactoryPage.clickLogin();
        loginFactoryPage.clickNeedHelpLink();
        String currentUrl = getDriver().getCurrentUrl();
        Assert.assertEquals(NEED_HELP_URL, currentUrl);
    }

    @Test(description = "Verify that clicking the 'Forgot password' link redirects to the correct help page URL")

    public void testClickForgotPassword() {

        loginFactoryPage.clickForgotPasswordLink();
        String currentUrlPassword = getDriver().getCurrentUrl();
        Assert.assertEquals(FORGOT_PASSWORD_URL, currentUrlPassword);
    }

}
