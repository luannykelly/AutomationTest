package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InsurancePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public InsurancePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void fillOutEnterVehicleData() {
        waitForElement(By.id("make"));
        new Select(driver.findElement(By.id("make"))).selectByVisibleText("Ford");
        new Select(driver.findElement(By.id("model"))).selectByVisibleText("Scooter");
        driver.findElement(By.id("cylindercapacity")).sendKeys("49");
        driver.findElement(By.id("engineperformance")).sendKeys("90");
        driver.findElement(By.id("dateofmanufacture")).sendKeys("12/03/2020");
        new Select(driver.findElement(By.id("numberofseats"))).selectByVisibleText("5");
        driver.findElement(By.className("ideal-radiocheck-label")).click();
        new Select(driver.findElement(By.id("numberofseatsmotorcycle"))).selectByVisibleText("2");
        new Select(driver.findElement(By.id("fuel"))).selectByVisibleText("Diesel");
        driver.findElement(By.id("payload")).sendKeys("120");
        driver.findElement(By.id("totalweight")).sendKeys("240");
        driver.findElement(By.id("listprice")).sendKeys("5000");
        driver.findElement(By.id("licenseplatenumber")).sendKeys("KTY4678");
        driver.findElement(By.id("annualmileage")).sendKeys("5000");
        driver.findElement(By.id("nextenterinsurantdata")).click();
    }

    public void fillOutEnterInsurantData() {
        waitForElement(By.id("firstname"));
        driver.findElement(By.id("firstname")).sendKeys("John");
        driver.findElement(By.id("lastname")).sendKeys("Whitehorse");
        driver.findElement(By.id("birthdate")).sendKeys("09/12/1980");
        WebElement genderMale = driver.findElement(By.id("gendermale"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", genderMale);
        driver.findElement(By.id("streetaddress")).sendKeys("1600 Fake Street");
        new Select(driver.findElement(By.id("country"))).selectByVisibleText("United States");
        driver.findElement(By.id("zipcode")).sendKeys("94043");
        driver.findElement(By.id("city")).sendKeys("Mountain View");
        new Select(driver.findElement(By.id("occupation"))).selectByVisibleText("Selfemployed");
        WebElement element = driver.findElement(By.id("speeding"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        driver.findElement(By.id("website")).sendKeys("www.johnwhitehorseshoes.com");
        driver.findElement(By.id("nextenterproductdata")).click();
    }

    public void fillOutEnterProductData() {
        waitForElement(By.id("startdate"));
        driver.findElement(By.id("startdate")).sendKeys("01/02/2025");
        new Select(driver.findElement(By.id("insurancesum"))).selectByVisibleText("30.000.000,00");
        new Select(driver.findElement(By.id("meritrating"))).selectByVisibleText("Bonus 7");
        new Select(driver.findElement(By.id("damageinsurance"))).selectByVisibleText("Full Coverage");
        WebElement checkbox = driver.findElement(By.id("LegalDefenseInsurance"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.left = '0px';", checkbox);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
        new Select(driver.findElement(By.id("courtesycar"))).selectByVisibleText("Yes");
        driver.findElement(By.id("nextselectpriceoption")).click();
    }

    public void fillOutSelectPriceOption() {
        waitForElement(By.id("selectgold"));
        WebElement selectGold = driver.findElement(By.id("selectgold"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", selectGold);
        WebElement nextButton = driver.findElement(By.id("nextsendquote"));
        js.executeScript("arguments[0].click();", nextButton);
    }

    public void fillOutSendQuote() {
        waitForElement(By.id("email"));
        driver.findElement(By.id("email")).sendKeys("test@example.us");
        driver.findElement(By.id("phone")).sendKeys("6019521325");
        driver.findElement(By.id("username")).sendKeys("johnw");
        driver.findElement(By.id("password")).sendKeys("John123");
        driver.findElement(By.id("confirmpassword")).sendKeys("John123");
        driver.findElement(By.id("sendemail")).click();
    }

    public String verifySuccessMessage() {
        try {
            waitForElement(By.xpath("/html/body/div[4]/h2"));
            WebElement message = driver.findElement(By.xpath("/html/body/div[4]/h2"));
            return message.getText();
        } catch (NoSuchElementException e) {
            return "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private void waitForElement(By by) { //verifica o objeto antes das ações
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
