package Tests;

import Base.Base;
import Page.HomePage;
import org.testng.annotations.Test;

public class HomePageTest extends Base {

    @Test
    public void homePageTest() {
        HomePage homePage = new HomePage(driver);
        homePage.openAmazon();
    }
}
