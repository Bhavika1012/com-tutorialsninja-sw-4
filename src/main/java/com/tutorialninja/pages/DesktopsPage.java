package com.tutorialninja.pages;

import com.tutorialninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopsPage extends Utility {

    By sortPosition = By.xpath("//select[@id='input-sort']");
    By productText = By.xpath("//h1[normalize-space()='HP LP3065']");
    By desktopText = By.xpath("//h2[normalize-space()='Desktops']");
    By deliveryDateCalender = By.xpath("//i[@class='fa fa-calendar']");
    By monthYearElement = By.xpath("(//th[@class='picker-switch'])[1]");
    By allDatesElement = By.xpath("//*[@class='datepicker-days']//tbody//tr//td");
    By addToCart = By.xpath("//button[@id='button-cart']");
    By shoppingCartLink = By.xpath("//a[normalize-space()='shopping cart']");
    By successfulText = By.xpath("//div[@class='alert alert-success alert-dismissible']");
    By next = By.xpath("//div[@class='datepicker-days']//th[@class='next'][contains(text(),'›')]");

    public List<String> beforeSortDesktopByPositionZtoA() throws InterruptedException {
        Thread.sleep(1000);
// Get all the products name and stored into array list
        List<WebElement> beforeSortValue = driver.findElements(By.xpath("//div[@class='caption']//h4"));
        List<String> beforeSortDesktopValue = new ArrayList<>();
        for (WebElement value : beforeSortValue) {
            beforeSortDesktopValue.add(value.getText());
        }
        // Ascending order
        Collections.sort(beforeSortDesktopValue, String.CASE_INSENSITIVE_ORDER);
        // sorting by reverse order
        Collections.reverse(beforeSortDesktopValue);
        return beforeSortDesktopValue;
    }

    public List<String> afterSortDesktopByPositionZtoA() throws InterruptedException {
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (Z - A)");
        Thread.sleep(1000);
        // After sorting value
        List<WebElement> afterSortValue = driver.findElements(By.xpath("//div[@class='caption']//h4"));
        List<String> afterSortDesktopValue = new ArrayList<>();
        Thread.sleep(1000);
        for (WebElement value1 : afterSortValue) {
            afterSortDesktopValue.add(value1.getText());
        }
        return afterSortDesktopValue;
    }

    //Selecting from sort by dropdown list
    public void selectSortByPositionFromDropdownValue(String value) throws InterruptedException {
        Thread.sleep(1000);
        selectByVisibleTextFromDropDown(sortPosition, value);
    }

    //select product
    public void selectProductFromList(String product) throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[normalize-space()='" + product + "']"));
    }

    //get product text
    public String getTextOfProduct() {
        return getTextFromElement(productText);
    }

    //verify successful text
    public String verifySuccessfulText() {
        return getTextFromElement(successfulText);
    }

    //select delivery date
    public void selectDate(String date, String month, String year) throws InterruptedException {

        clickOnElement(deliveryDateCalender);
        while (true) {
            String monthYear = driver.findElement(monthYearElement).getText();
            String[] a = monthYear.split(" ");
            String mon = a[0];
            String yer = a[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(next);
            }
        }
        Thread.sleep(1000);
        // Select the date
        List<WebElement> allDates = driver.findElements(allDatesElement);
        for (WebElement dt : allDates) {
            if (dt.getText().equalsIgnoreCase(date)) {
                dt.click();
                break;
            }
        }
    }

    //Click on add to cart
    public void clickOnAddToCart() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(addToCart);
    }

    //Click on shopping cart link
    public void clickOnShoppingCartLink() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(shoppingCartLink);
    }

    //get desktop text
    public String getDesktopText() {
        return getTextFromElement(desktopText);
    }
}
