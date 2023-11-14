package comsaucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

/**
 * BaseUrl = https://www.saucedemo.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Enter the email to email field.
 * 7. Enter the password to password field.
 * 8. Click on Login Button.
 * 9. Print the current url.
 * 10. Navigate to baseUrl
 * 11. Refresh the page.
 * 12. Close the browser.
 */

public class P4_ComSauceDemo {

    //BaseUrl = https://www.saucedemo.com/
    //  1. Setup chrome browser.
    static String browser = "Chrome";
    static String baseUrl = "https://www.saucedemo.com/";

    static WebDriver driver;

    //main method
    public static void main(String[] args) {

        //multi browser set up
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("Safari")) {
            driver = new SafariDriver();
        } else {
            System.out.println("Invalid Browser name");
        }

        //2. Open URL.
        driver.get(baseUrl);

        driver.manage().window().maximize();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //    3. Print the title of the page.
        System.out.println("Page Title : " + driver.getTitle());

        //   4. Print the current url.
        System.out.println("Current Url : " + driver.getCurrentUrl());

        //   5. Print the page source.
        System.out.println("Page Source : " + driver.getPageSource());

        //   6. Enter the email to email field.
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("visual_user");

        //   7. Enter the password to password field.
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        //    8. Click on Login Button.
        WebElement login = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));

        //  9. Print the current url.
        System.out.println("Current Url : " + driver.getCurrentUrl());

        //    10. Navigate to baseUrl
        driver.navigate().back();

        //11. Refresh the page.
        driver.navigate().refresh();

        //12. Close the browser.
        driver.quit();
    }
}
