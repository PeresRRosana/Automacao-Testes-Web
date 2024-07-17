package core;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Driver {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static ChromeOptions options;

    public void Driver(){

    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriverWait getWait() {
        return wait;
    }

    public static void setWait(WebDriverWait wait) {
        Driver.wait = wait;
    }

    public static void aguardar(long tempo) {
        Thread.currentThread();
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void fechar(){
        driver.quit();
    }
    public static void setDriver(String url) {

        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
        driver = new ChromeDriver(options);
        driver.get(url);
        driver.manage().window().maximize();

    }

    public static String printScreen(String arquivo) throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("printScreen\\" + arquivo + ".png"));
        return "printScreen\\" + arquivo + ".png";

    }

    public static void setDriverTab(String url) {
        //System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        // driver = new ChromeDriver();

        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_T);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_T);
        } catch (AWTException ex) {
            throw new WebDriverException("Erro ao digitar CTRL + T", ex);
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        //driver.switchTo().window(windowHandles.get(0));
        driver.switchTo().window(windowHandles.get(1));

        driver.get(url);
        Driver.aguardar(2000);

        driver.manage().window().maximize();

    }

    public static void switchTab(int tabNum, String url) {

        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(tabNum));
        driver.get(url);

    }

    public static void closeBrowserTab(int tabNum) {
        //ver
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(tabNum));
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_W);
        } catch (AWTException ex) {
            throw new WebDriverException("Erro ao digitar CTRL + W", ex);
        }
        //driver.switchTo().window(windowHandles.get(1));
    }

    public static void quitBrowser() {
        driver.quit();
    }

    public static void setOtherDriver(String teste) {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(teste);
        driver.manage().window().maximize();
    }

    //**********************************************************************************

    /*public void buscarTermo(){
        {
            List<WebElement> elements = driver.findElements(By.name("q"));
            assert(elements.size() > 0);
        }

        driver.findElement(By.name("q")).sendKeys("Teste");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }


    public void quitTest() {
        driver.quit();
    }*/

}

