package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    // public  void testCase01(){
    //     System.out.println("Start Test case: testCase01");
    //     driver.get("https://www.google.com");
    //     System.out.println("end Test case: testCase02");
    // }

    public void testCase01() throws InterruptedException {
        try{
            System.out.println("Start Test case: testCase01");

            driver.get(" https://leetcode.com/");

            Thread.sleep(3000);

            String CurrentUrl = driver.getCurrentUrl();

            if (CurrentUrl.contains("leetcode")) {

                System.out.println("URL contains leetcode");

            } else {

                System.out.println("URL does not contain leetcode");
            }

            System.out.println("end Test case: testCase01");

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

     public void testCase02() throws InterruptedException {
        try{
            System.out.println("Start Test case: testCase02");

            driver.get(" https://leetcode.com/");

            Thread.sleep(3000);

           // Click on the "Problems" link
            WebElement problemsLink = driver.findElement(By.xpath("(//p[@class='link'])[2]"));
            problemsLink.click();

            Thread.sleep(5000);

            // Verify that you are on the problem set page
            String url=driver.getCurrentUrl();
            if (url.contains("problemset")) {
                System.out.println("On the problem set page");
            } else {
                System.out.println("Not on the problem set page");
            }

            Thread.sleep(5000);

            // Retrieve details of the first 5 questions and print them
            List<WebElement> questionElements = driver.findElements(By.xpath("//a[@class='h-5 hover:text-blue-s dark:hover:text-dark-blue-s']"));
            Thread.sleep(5000);
        //   int numberOfQuestions = Math.min(5, questionElements.size());

            Thread.sleep(5000);

            for (int i = 1; i <=5; i++) {
                WebElement question = questionElements.get(i);
                String questionTitle = question.getText();
                System.out.println("Question " + (i + 1) + ": " + questionTitle);
            }

            System.out.println("end Test case: testCase02");

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void testCase03() throws InterruptedException {
        try{
            System.out.println("Start Test case: testCase03");

            driver.get(" https://leetcode.com/");

            Thread.sleep(3000);

           // Click on the "Problems" link
            WebElement problemsLink = driver.findElement(By.xpath("(//p[@class='link'])[2]"));
            problemsLink.click();


            Thread.sleep(5000);

            // Click on the first problem (Two Sum)
            WebElement twoSumLink = driver.findElement(By.xpath("//a[normalize-space()='1. Two Sum']"));
            twoSumLink.click();

            Thread.sleep(5000);

            // Verify that the URL contains "two-sum"
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.contains("two-sum")) {
                System.out.println("URL contains 'two-sum'");
            } else {
                System.out.println("URL does not contain 'two-sum'");
            }


            System.out.println("end Test case: testCase03");

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void testCase04() throws InterruptedException {
        try{
            System.out.println("Start Test case: testCase04");

            driver.get(" https://leetcode.com/");

            Thread.sleep(3000);

           // Click on the "Problems" link
            WebElement problemsLink = driver.findElement(By.xpath("(//p[@class='link'])[2]"));
            problemsLink.click();


            Thread.sleep(5000);

            // Click on the first problem (Two Sum)
            WebElement twoSumLink = driver.findElement(By.xpath("//a[normalize-space()='1. Two Sum']"));
            twoSumLink.click();

            Thread.sleep(5000);

            //Click on EnableButton

            WebElement EnableButton = driver.findElement(By.xpath("//button[normalize-space()='Enable Dynamic Layout']"));
            EnableButton.click();

            Thread.sleep(5000);
            
            //Click on skip button
            WebElement skip = driver.findElement(By.xpath("//button[normalize-space()='Skip tour']"));
            skip.click();

            Thread.sleep(5000);

             // Click on the submissions tab
             WebElement submissionsTab = driver.findElement(By.xpath("//div[@class='normal absolute left-0 top-0 whitespace-nowrap font-normal'][normalize-space()='Submissions']"));
             submissionsTab.click();

             Thread.sleep(5000);

             // Verify that it displays "Register or Sign In"
            // WebElement registerSignInMessage = driver.findElement(By.xpath("//a[text()='Register or Sign In']"));
            // if (registerSignInMessage.isDisplayed()) {
            //     System.out.println("The message 'Register or Sign In' is displayed on the submissions tab");
            // } else {
            //     System.out.println("The message 'Register or Sign In' is not displayed on the submissions tab");
            // }
            WebElement regiterOrSignin=driver.findElement(By.xpath("//a[@class='px-3 py-1.5 font-medium inline-flex items-center whitespace-nowrap transition-all focus:outline-none text-label-r hover:text-label-r rounded-lg bg-green-s dark:bg-dark-green-s hover:bg-green-3 dark:hover:bg-dark-green-3']"));
            System.out.println("Register or Sign-in :"  + regiterOrSignin.getText());


            System.out.println("end Test case: testCase04");

        } catch (Exception e) {
            // TODO: handle exception
        }
    }


}
