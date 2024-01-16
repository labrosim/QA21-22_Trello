package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    EventFiringWebDriver driver;

    HelperUser helperUser;

    HelperBoard helperBoard;

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    String url = "https://trello.com/home";

    public void init(){
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new WDListener());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(url);

        logger.info("opened  --> "+url);
        helperUser = new HelperUser(driver);
        helperBoard = new HelperBoard(driver);

        logger.info("URL --> "+url+"start testing --> "+ LocalDate.now());

    }

    public HelperUser getHelperUser() {
        return helperUser;
    }
    public HelperBoard getHelperBoard(){
        return helperBoard;
    }

    public void stop(){
        driver.quit();
        logger.info("stop testing --> "+LocalDate.now());
    }

}
