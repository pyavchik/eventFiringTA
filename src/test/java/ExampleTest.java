import io.trueautomation.client.driver.TrueAutomationDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static io.trueautomation.client.TrueAutomationHelper.ta;

public class ExampleTest {
    private TrueAutomationDriver driver;
    WebDriverListener eventListener;
    EventFiringWebDriver eventFiringWebDriver;
    DesiredCapabilities cap = new DesiredCapabilities(new ChromeOptions());
    private By loginBtn = By.cssSelector(ta("loginBtn", "a.login-btn"));
    private By signupBtn = By.cssSelector(ta("signupBt", "div.sign-up-container > a"));
    private By emailFl = By.name(ta("emailF", "email"));


    @BeforeTest
    public void beforeTest() throws MalformedURLException {
        driver = new TrueAutomationDriver(new URL("http://localhost:4444/wd/hub"), cap);
        eventFiringWebDriver = new EventFiringWebDriver(driver);
        eventListener = new WebDriverListener(driver);
        eventFiringWebDriver.register(eventListener);


    }


    @Test
    public void exampleTest() {
        eventFiringWebDriver.get("https://trueautomation.io");
        eventFiringWebDriver.findElement(loginBtn).click();
        eventFiringWebDriver.findElement(signupBtn).click();
        eventFiringWebDriver.findElement(emailFl).sendKeys("your@mail.com");
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}