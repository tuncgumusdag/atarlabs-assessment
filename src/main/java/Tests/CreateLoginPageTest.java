package Tests;

import Base.Base;
import Page.CreateLoginPage;
import org.testng.annotations.Test;

public class CreateLoginPageTest extends Base {

    @Test
    public void createLoginTest() {
        CreateLoginPage createLoginPage = new CreateLoginPage(driver);
        createLoginPage.createLogin();
        createLoginPage.loginAssertion();
    }
}
