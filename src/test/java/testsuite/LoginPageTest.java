package testsuite;


import com.ultimateqa.courses.pages.LoginPage;
import junit.framework.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testbase.BaseTest;


public class LoginPageTest extends BaseTest {

    LoginPage loginPage = new LoginPage();

    public LoginPageTest() {
    }

    @BeforeMethod(
            alwaysRun = true
    )
    public void inIt() {
        this.loginPage = new LoginPage();
    }

    @Test(
            groups = {"sanity", "regression"}
    )
    public void UserShouldLoginSuccessfullyWithValidCredentials() {
        this.loginPage.enterUserName("tomsmith");
        this.loginPage.enterPassword("SuperSecretPassword!");
        this.loginPage.clickOnLoginButton();
        Assert.assertEquals(this.loginPage.getLoginTextMessage(), "Secure Area", "Text message not fount");
    }

    @Test(
            groups = {"smoke", "regression"}
    )
    public void verifyTheUsernameErrorMessage() {
        this.loginPage.enterUserName("tomsmith1");
        this.loginPage.enterPassword("SuperSecretPassword!");
        this.loginPage.clickOnLoginButton();
        Assert.assertEquals(this.loginPage.getUserNameErrorMessage(), "Your username is invalid!\n×", "Error message not fount");
    }

    @Test(
            groups = {"smoke", "regression"}
    )
    public void verifyThePasswordErrorMessage() {
        this.loginPage.enterUserName("tomsmith");
        this.loginPage.enterPassword("SuperSecretPassword");
        this.loginPage.clickOnLoginButton();
        Assert.assertEquals(this.loginPage.getPasswordErrorMessage(), "Your password is invalid!\n×", "Error message not fount");
    }
}

