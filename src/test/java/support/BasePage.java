package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BasePage {
    protected WebDriver driver;
    private String chromeDriverPath = "C:\\Users\\Pessoal\\IdeaProjects\\TestAutomation\\src\\main\\resources\\chromedriver.exe";

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    public void openUrl(String url) {
        driver.get(url);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        String expectedUrl = url.startsWith("http://") ? url.replace("http://", "https://") : url;
        String currentUrl = driver.getCurrentUrl();

        if (!currentUrl.equals(expectedUrl)) {
            throw new RuntimeException("Failed to navigate to the correct URL: " + expectedUrl + ". Current URL: " + currentUrl);
        }
    }


    public WebDriver getDriver() {
        return driver;
    }

    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
