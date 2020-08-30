package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class FaceLoginPage {

    WebDriver driver;
    public FaceLoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(id="email")
    public WebElement email;

    @FindBy(id="pass")
    public WebElement password;

    @FindBy(id="u_0_b")
    public WebElement loginButton;

    @FindBy(xpath ="//div[@role='alert']")
    public WebElement error_message;




}
