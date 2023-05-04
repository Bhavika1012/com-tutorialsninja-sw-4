package com.tutorialninja.pages;

import com.tutorialninja.utilities.Utility;
import org.openqa.selenium.By;

public class HomePage extends Utility {

    By navigateToDesktop = By.xpath("//a[@class='dropdown-toggle'][normalize-space()='Desktops']");
    By allLaptopAndNoteBooks = By.xpath("//a[normalize-space()='Laptops & Notebooks']");
    By hoverAndClickOnComponent = By.xpath("//a[normalize-space()='Components']");
    By accountLogout = By.xpath("//h1[normalize-space()='Account Logout']");
    By myAccount = By.xpath("//h2[normalize-space()='My Account']");

    //This method is used to select menu
    public void selectMenu(String menu) {
        clickOnElement(By.xpath("//nav[@id='menu']//a[normalize-space()='" + menu + "']"));
    }

    //mouse Hover And Click On Desktop

    public void mouseHoverAndClickOnDesktop() throws InterruptedException {
        Thread.sleep(1000);
        mouseHoverToElementAndClick(navigateToDesktop);

    }

    //mouse Hover Click On Laptop And NoteBooks
    public void mouseHoverAndClickOnLaptopAndNoteBooks() throws InterruptedException {
        Thread.sleep(1000);
        mouseHoverToElementAndClick(allLaptopAndNoteBooks);
    }

    // mouseHover And Click On Component
    public void mouseHoverAndClickOnComponent() {
        mouseHoverToElementAndClick(hoverAndClickOnComponent);
    }

    //get Account Logout Text
    public String getAccountLogoutText() {
        return getTextFromElement(accountLogout);
    }

    //getting My Account Text
    public String getMyAccountText() {
        return getTextFromElement(myAccount);
    }
}
