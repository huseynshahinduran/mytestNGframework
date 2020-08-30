package com.techproed.pages;

import com.sun.org.apache.xpath.internal.res.XPATHErrorResources;
import com.techproed.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GlbSingUpPage {

    /*
    Global Trader Sign Up Test.
Kullanici https://www.glbtrader.com/register.html adresine gitsin.
Kullanici kimlik bilgileri ile kayit oldugunda “Success!” mesajini gormeli.
pages  paketinin altina bir page class olusturun : GlbSignUpPage
Page objelerini(webelement) bulun.
smoketest  paketinin altina bir test classi olusturun : GlbSignUpTest
=====Page Object Model kullanin======

     */


    public GlbSingUpPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="email")
    public WebElement email;

    @FindBy(id="name")
    public WebElement name;

    @FindBy(id="mobile")
    public WebElement mobile;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(id="re_password")
    public WebElement rePassword;

    @FindBy(xpath="//button[@value='Login']")
    public WebElement singUpButton;

    @FindBy(xpath = "div[@class='alert alert-success']")
    public WebElement successMessage;







}
