import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FirstTests {
    WebDriver driver;
    @Test
    public void TestMethod(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);

        driver.get("https://www.selenium.dev/selenium/web/web-form.html");


        String title = driver.getTitle();
        String expected = "Form submitted";

        WebElement textBox = driver.findElement(By.name("my-text"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));
        WebElement checkbox = driver.findElement(By.id("my-check-2"));
        WebElement color = driver.findElement(By.xpath("/html/body/main/div/form/div/div[3]/label[1]/input"));
        WebElement dropdown = driver.findElement(By.name("my-datalist"));



        textBox.sendKeys("Selenium");
        submitButton.click();

        driver.navigate().back();
        checkbox.click();
        color.click();
        dropdown.sendKeys("New York");
        submitButton.click();

        WebElement massage = driver.findElement(By.cssSelector("h1"));
        Assert.assertEquals(massage.getText(),"Form submitted");
        System.out.println("Zara xpartaci");

        driver.quit();
    }
}
