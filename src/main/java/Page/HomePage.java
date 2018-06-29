package Page;

import Base.Base;
import org.openqa.selenium.WebDriver;

public class HomePage extends Base {

    protected String url = "http://www.amazon.com/";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openAmazon() {
        openPage(url);
        //Enter https://www.amazon.com/
    }
}
