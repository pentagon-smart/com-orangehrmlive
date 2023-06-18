package orangehrmlive_testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Scanner;

public class MultiBrowserTesting {
    static Scanner sc = new Scanner(System.in);

    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        System.out.print("Enter Browser Name: ");
        String browser = sc.nextLine();

        //1. Browser setup
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("EDGE")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong browser name");
        }

        //2.Open URL
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //3.Print the title of the page
        String title = driver.getTitle();
        System.out.println("Page title is : " +title);

        //4.Print the current url
        System.out.println("Current Url is: " + driver.getCurrentUrl() );

        //5.Print the page source
        System.out.println("Page source is: " +driver.getPageSource());

        //6.Enter the username to username field
        WebElement userNameField = driver.findElement(By.name("username"));
        userNameField.sendKeys("Admin");

        //7.Enter the password to password field
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        Thread.sleep(2000);

        //8.Close the browser
        driver.close();
    }
}
