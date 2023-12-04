package start_xPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SelectorXpath {
    WebDriver driver;

    @BeforeClass
    public void preCondition(){
        driver = new ChromeDriver();
        driver.get("https://trello.com/home");
        System.out.println("before class");
    }


    @Test
    public void start(){
        System.out.println("Hi test1=============");
        WebElement elementLogin = driver.findElement(By.xpath("//a[@data-uuid='MJFtCCgVhXrVl7v9HA7EH_login']"));
        System.out.println(elementLogin.getText());
        WebElement btnGetTrelloForFree = driver.findElement(By.xpath("//*[text()='Get Trello for free' and @data-uuid='MJFtCCgVhXrVl7v9HA7EH_signup']"));
        System.out.println(btnGetTrelloForFree.getAttribute("class"));
        WebElement textTrello = driver.findElement(
                By.xpath("//main[@id='skip-target']/section[@class='UiSectionstyles__Section-sc-4xxafg-0 cDvxpF ui-section']//h1"));
        System.out.println(textTrello.getText());
        WebElement section = driver.findElement(By.xpath("//main[@id='skip-target']/*[5]"));
        System.out.println(section.getAttribute("data-testid"));
        WebElement parent = driver.findElement(By.xpath("//div[@class='FullWidthCarouselstyles__Controls-sc-16jty68-0 itOKSq']/../../.."));
        System.out.println("id=========" + parent.getAttribute("id"));
    }
    @Test
    public void start1(){
        System.out.println("Hi test2=============");

    }

    @AfterClass
    public void tearDown(){
        System.out.println("after class");
        driver.quit();
    }
}
