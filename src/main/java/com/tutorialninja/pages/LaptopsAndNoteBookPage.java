package com.tutorialninja.pages;

import com.tutorialninja.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNoteBookPage extends Utility {
    By sortByFilter = By.xpath("//select[@id='input-sort']");
    By productText =By.xpath("//h1[normalize-space()='MacBook']");
    By addToCart =By.xpath("//button[@id='button-cart']");
    By successText =By.xpath("//div[@class='alert alert-success alert-dismissible']");
    By shoppingCartLink = By.xpath("//a[normalize-space()='shopping cart']");
    By allLaptopsAndNotebooks=By.xpath("//h2[normalize-space()='Laptops & Notebooks']");


    public List<Double> beforeSortPriceHighToLow() throws InterruptedException {
        List<WebElement> products = driver.findElements(By.xpath("//p[@class ='price']"));
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(originalProductsPrice);
        // Sort By Reverse order
        Collections.sort(originalProductsPrice, Collections.reverseOrder());
        return originalProductsPrice;
    }

    public List<Double> afterSortPriceHighToLow() throws InterruptedException {
        List<WebElement> products = driver.findElements(By.xpath("//p[@class ='price']"));
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Price (High > Low)");
        // After filter Price (High > Low) Get all the products price and stored into array list
        products = driver.findElements(By.xpath("//p[@class ='price']"));
        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(afterSortByPrice);
        return afterSortByPrice;
    }

   //sort by filter for price
    public void sortByFilter(String value) {
        selectByVisibleTextFromDropDown(sortByFilter, value);
    }

    //selecting product
    public void selectProduct(String product) {
        clickOnElement(By.xpath("//a[normalize-space()='" + product + "']"));
    }

  //verify macbook text
    public String verifyMacBookText() throws InterruptedException {
        Thread.sleep(1000);
        return getTextFromElement(productText);
    }

  //add to cart
    public void clickOnAddToCart() {
        clickOnElement(addToCart);
    }

   //get success text
    public String getSuccessText() throws InterruptedException {
        Thread.sleep(1000);
        return getTextFromElement(successText);
    }

   //click on shopping cart link
    public void clickOnShoppingCartLink() throws InterruptedException {
        Thread.sleep(1000);
        clickOnElement(shoppingCartLink);
    }

  //Laptop and notebook text
    public String getLaptopsAndNotebooksText() throws InterruptedException {
        Thread.sleep(1000);
        return getTextFromElement(allLaptopsAndNotebooks);
    }
}
