package com.nhs.pages;

import com.nhs.utilities.BrowserUtils;
import com.nhs.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class NHSHealthCheck {
    WebDriver driver = Driver.get();

    public NHSHealthCheck() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "nhsuk-cookie-banner__link_accept_analytics")
    public WebElement cooky;

    @FindBy(id = "next-button")
    public WebElement startButton;

    @FindBy(xpath = "//label[@id='label-wales']")
    public WebElement selectedCountry;

    @FindBy(xpath = "//input[@id='next-button']")
    public WebElement nextButton;

    @FindBy(xpath = "//input[@id='dob-day']")
    public WebElement dayInput;

    @FindBy(xpath = "//input[@id='dob-month']")
    public WebElement monthInput;

    @FindBy(xpath = "//input[@id='dob-year']")
    public WebElement yearInput;

    @FindBy(xpath = "//label[@id='label-yes']")
    public WebElement yesLabel;

    @FindBy(xpath = "//label[@id='label-no']")
    public WebElement noLabel;

    @FindBy(xpath = "//input[@id='not-yet']")
    public WebElement notYetLabel;

    @FindBy(xpath = "//h1[@id='result-heading']")
    public WebElement resultText;


    @FindBy(xpath = "//h1[@class='heading-xlarge done-panel']")
    public WebElement done;


    public void countries() {
        cooky.click();
        String[] countries = {"England", "Wales", "Scotland"};
        String country = countries[new Random().nextInt(countries.length - 1)].toLowerCase();
        startButton.click();
        //Which country do you live in?
        WebElement setCountry = driver.findElement(By.xpath("//label[@id='label-" + country + "']"));

        setCountry.click();
        nextButton.click();
        if (!country.equals("wales")) {
            noLabel.click();
            nextButton.click();
        }
    }


    public void country(String country) {
        cooky.click();
        startButton.click();
        //Which country do you live in?
        WebElement setCountry = driver.findElement(By.xpath("//label[@id='label-" + country.toLowerCase() + "']"));
        setCountry.click();
        nextButton.click();

    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public String yesorNo() {
        String[] option = {"yes", "no"};
        String opt = option[new Random().nextInt(option.length)];
        return opt;
    }


    public void circumstances() {
// 16 yaş 18 yaş arası education
        //What is your date of birth?

        int day = getRandomNumber(1, 28);
        String dayy = String.valueOf(day);
        dayInput.sendKeys(dayy);
        int month = getRandomNumber(1, 12);
        String months = String.valueOf(month);
        monthInput.sendKeys(months);
        int year = getRandomNumber(1962, 2002);
        String years = String.valueOf(year);
        yearInput.sendKeys(years);
        BrowserUtils.waitFor(3);

        nextButton.click();

        //Do you live with a partner?
        if (yesorNo().equals("yes")) {
            yesLabel.click();
        } else {
            noLabel.click();
        }
        ;
        BrowserUtils.waitFor(3);
        nextButton.click();
        //Do you claim any benefits or tax credits?

        yesLabel.click();
        nextButton.click();
        //Do you get paid Universal Credit?
        WebElement yesButton = driver.findElement(By.xpath("//*[@id='paidUniversalCredit_fieldset']/label"));
        BrowserUtils.waitForClickablility(yesButton, 5);
        yesButton.click();
        nextButton.click();
        //As part of your Universal Credit, do you have any of these?
        yesLabel.click();
        nextButton.click();
        //Was your take-home pay for your last Universal Credit period £935 or less?
        noLabel.click();
        nextButton.click();
        //Are you pregnant or have you given birth in the last 12 months?
        noLabel.click();
        nextButton.click();
        //Do you have an injury or illness caused by serving in the armed forces?
        noLabel.click();
        nextButton.click();
        //Do you have diabetes?
        noLabel.click();
        nextButton.click();
        //Do you have glaucoma?
        noLabel.click();
        nextButton.click();
        //Do you live permanently in a care home?
        noLabel.click();
        nextButton.click();
        //Do you have more than £16,000 in savings, investments or property?
        noLabel.click();
        nextButton.click();


    }

    public void result() {

        Assert.assertTrue(resultText.getText().contains("Based on what you've told us"));

        System.out.println("resultText.getText() = " + resultText.getText().split("us")[1]);

    }


}
