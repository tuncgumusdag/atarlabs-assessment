package Page;

import Base.Base;
import org.openqa.selenium.WebDriver;

public class CreateLoginPage extends Base {

    protected String elementAccountAndLists = "#nav-link-accountList";
    protected String elementCreateYourAmazonAccount = "#createAccountSubmit";
    protected String textboxYourName = "#ap_customer_name";
    protected String dataYourName = "Tunc Gumusdag";
    protected String textboxEmail = "#ap_email";
    protected String dataEmail = genericText + "_1903@gmail.com";
    protected String textboxPassword = "#ap_password";
    protected String dataPassword = "12345678";
    protected String textboxReEnterPassword = "#ap_password_check";
    protected String dataReEnterPassword = "12345678";
    protected String elementCreate = "#continue";
    protected String elementCaptchaBox = "#auth-error-message-box";
    protected String elementCustomerName = "#nav-link-accountList>.nav-line-1";
    protected String dataCustomerName = "Hello, Tunc";

    public CreateLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void createLogin() {
        click(elementAccountAndLists);
        click(elementCreateYourAmazonAccount);
        fillTextBox(textboxYourName, dataYourName);
        fillTextBox(textboxEmail, dataEmail);
        fillTextBox(textboxPassword, dataPassword);
        fillTextBox(textboxReEnterPassword, dataReEnterPassword);
        click(elementCreate);
        //Create an account
        //Login with created account

        if (isElementFound(elementCaptchaBox) == true) //CAPTCHA
        {
            System.out.println("CAPTCHA CAUGHT US");
            System.out.println("GIVE SOME REST AND TRY LATER"); //You should wait for 15 min to whitelisted again
            CloseDriver();
        }
    }

    public void loginAssertion() {
        assertAreEquals(elementCustomerName, dataCustomerName);
        //Assert login successfully with created account
    }
}
