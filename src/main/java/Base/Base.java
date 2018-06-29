package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public abstract class Base {
    public static WebDriver driver;
    public String genericText = generateText();

    @BeforeSuite
    public static void OpenDriver() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        //Open browser
    }

    @AfterSuite
    public static void CloseDriver() {
        driver.quit();
        //Quit browser
    }

    public void openPage(String url) {
        driver.get(url);
    }

    public WebElement findElement(String css) {
        WebElement element = null;
        try {
            element = driver.findElement(By.cssSelector(css));
        } catch (Exception e) {
            System.out.println("Something gone wrong while finding element: " + css);
        }
        return element;
    }

    public String getText(String css) {
        return findElement(css).getText();
    }

    public void click(String css) {
        waitUntilElementLoad(css);
        Actions action = new Actions(driver);
        action.moveToElement(findElement(css)).click().perform();
        //driver.findElement(By.cssSelector(css)).click();   -- optional usage
    }

    public void fillTextBox(String css, String text) {
        findElement(css).click();
        findElement(css).clear();
        findElement(css).sendKeys(text);
    }

    public boolean isElementFound(String css) {
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        int exists = driver.findElements(By.cssSelector(css)).size();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        if (exists != 0) {
            return true;
        } else return false;
    }

    public void onHover(String css) {
        Actions action = new Actions(driver);
        action.moveToElement(findElement(css)).build().perform();
    }

    public void assertAreEquals(String actual, String expected) {
        waitUntilElementLoad(actual);
        Assert.assertEquals(getText(actual), expected);
    }

    public void assertIsInclude(String actual, String expected) {
        waitUntilElementLoad(actual);
        Assert.assertTrue(getText(actual).contains(expected));
    }

    public void waitUntilElementLoad(String css) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(css)));
    }

    protected String generateText() {
        String characters = "abcdefghijklmnoprstuvyz";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 7) {
            int index = (int) (rnd.nextFloat() * characters.length());
            salt.append(characters.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
}
