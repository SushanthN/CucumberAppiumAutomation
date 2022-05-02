package utils;


import base.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;

public class CommonMethods extends Base {

    private static AppiumDriver<MobileElement> driver;
    
    public CommonMethods(AppiumDriver<MobileElement> driver) throws IOException {
        super();
        this.driver = driver;
    }

    public static void updateReadFlag(String input) {
        try {
            FileInputStream file=new FileInputStream(new File(input));
            XSSFWorkbook workbook=new XSSFWorkbook(file);
            XSSFSheet sheet=workbook.getSheetAt(0);
            Iterator<Row> rowIterator=sheet.rowIterator();
            while (rowIterator.hasNext()) {
                Cell cell=rowIterator.next().cellIterator().next();

                if (cell.getStringCellValue().equals("N")) {
                    cell.setCellValue("C");
                    break;
                }
            }
            file.close();
            FileOutputStream output_file=new FileOutputStream(new File(input));
            workbook.write(output_file);
            output_file.close();
        } catch (Exception e) {
        }
    }

    


    public void waitUntilPageLoads(WebDriver driver) {

        try {
            ExpectedCondition<Boolean> pageloadcondition=new ExpectedCondition<Boolean>() {


                public Boolean apply(WebDriver driver) {
                    // TODO Auto-generated method stub
                    return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                }
            };
            WebDriverWait wait=new WebDriverWait(driver, 50);
            wait.until(pageloadcondition);
        } catch (Exception E) {

            E.printStackTrace();
            Reporter.log("Unable to wait for the page to load", true);
        }


    }

    public String fetchCurrentDateAndTime() {
        String dateAndTime=null;
        try {
            DateFormat dateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
            Date date=new Date();
            dateAndTime=dateFormat.format(date);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            //	extentReportLogFAIL("Unable to find date element"+e.getMessage());
        } finally {
            return dateAndTime;
        }

    }



    //Scroll to a particular element

    public static AndroidElement scrollToElement(By by ) {
        AndroidElement element=null;
        int numberOfTimes=10;
        Dimension size=driver.manage().window().getSize();
        int anchor=(int) (size.width / 2);
        //Swipe up to scroll down
        int startPoint=(int) (size.height - 10);
        int endPoint=10;

        for (int i=0; i < numberOfTimes; i++) {
            try {
                new TouchAction(driver)
                        .longPress(PointOption.point(anchor, startPoint)) //.press(point(anchor, startPoint)) if used press need proper waiting time
                        //.waitAction(waitOptions(ofMillis(miliseconds)))
                        .moveTo(PointOption.point(anchor, endPoint)).release().perform();
                element=(AndroidElement) driver.findElement(by);
                i=numberOfTimes;
            } catch (NoSuchElementException ex) {
                System.out.println(String.format("Element not available. Scrolling (%s) times…", i + 1));
            }
        }
        return element;
    }


    public static void scrollDown() {
        //if pressX was zero it didn't work for me
        int pressX=driver.manage().window().getSize().width / 2;
        // 4/5 of the screen as the bottom finger-press point
        int bottomY=driver.manage().window().getSize().height * 4 / 5;
        // just non zero point, as it didn't scroll to zero normally
        int topY=driver.manage().window().getSize().height / 8;
        //scroll with TouchAction by itself
        scroll(pressX, bottomY, pressX, topY);
    }


    public static void scroll(int fromX, int fromY, int toX, int toY ) {
        TouchAction touchAction=new TouchAction(driver);
        touchAction.longPress(PointOption.point(fromX, fromY)).moveTo(PointOption.point(toX, toY)).release().perform();
    }


    public static void scrollUp(int howManySwipes, AppiumDriver<MobileElement> driver) {
        Dimension size=driver.manage().window().getSize();
        // calculate coordinates for vertical swipe
        int startVerticalY=(int) (size.height * 0.8);
        int endVerticalY=(int) (size.height * 0.21);
        int startVerticalX=(int) (size.width / 2.1);
        try {
            for (int i=1; i <= howManySwipes; i++) {
                new TouchAction(driver).press(PointOption.point(startVerticalX, startVerticalY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(startVerticalX, endVerticalY)).release()
                        .perform();
            }
        } catch (Exception e) {
            //print error or something
        }
    }


    public static void scrollDown(int howManySwipes, AppiumDriver<MobileElement> driver) {
        Dimension size=driver.manage().window().getSize();
        // calculate coordinates for vertical swipe
        int startVerticalY=(int) (size.height * 0.8);
        int endVerticalY=(int) (size.height * 0.21);
        int startVerticalX=(int) (size.width / 2.1);
        try {
            for (int i=1; i <= howManySwipes; i++) {
                new TouchAction(driver).press(PointOption.point(startVerticalX, endVerticalY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(startVerticalX, startVerticalY)).release()
                        .perform();
            }
        } catch (Exception e) {
            //print error or something
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public  boolean isDisplayed( By locator ){
        return driver.findElement(locator).isDisplayed();
    }

    public void waitForAndroidElement(By locator){
        ( new WebDriverWait(driver, 45))
                                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void clickAndroidElement( By locator ){
        waitForAndroidElement( locator);
        driver.findElement(locator).click();
    }

    public void click_using_actions( By locator ){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(locator)).build().perform();
    }

    public void enterTextUsingActions( By locator, String text ){
        driver.findElement(locator).clear();
        Actions actions = new Actions(driver);
        actions.sendKeys(text).build().perform();
    }

    public void enterText(By locator, String value ){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    public void waitForElement(WebDriver driver, By locator){
        ( new WebDriverWait(driver, 45))
                .until(ExpectedConditions.presenceOfElementLocated(locator));

    }

    public void clickElement(WebDriver driver, By locator){
        waitForElement(driver, locator);
        driver.findElement(locator).click();
    }

    public void waitForVisiblity(WebDriver driver, By locator){
        ( new WebDriverWait(driver, 45))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    public void clickUsingJS(WebDriver driver, By locator){

        WebElement element = driver.findElement(locator);
        ( (JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void clickUsingActions(WebDriver driver, By locator ){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(locator)).build().perform();
    }

    public void enterText(WebDriver driver, By locator, String...value ){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }
    public  boolean isDisplayed(WebDriver driver, By locator ){
        return driver.findElement(locator).isDisplayed();

    }


}
