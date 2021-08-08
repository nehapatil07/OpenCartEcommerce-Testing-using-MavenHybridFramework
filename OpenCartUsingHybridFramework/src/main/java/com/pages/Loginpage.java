package com.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.testbase.Baseclass;
public class Loginpage {
WebDriver driver;


public Loginpage(WebDriver driver){
	PageFactory.initElements(driver, this);
	this.driver=driver;
}

@FindBy(xpath="//*[@class='btn btn-link navbar-btn']")
private WebElement Loginbtn;

@FindBy(id="input-email")
private WebElement uname;

@FindBy(id="input-password")
private WebElement pw;

@FindBy(xpath="//button[@type='submit']")
private WebElement btn;

@FindBy(name="pin")
private WebElement secCode;

@FindBy(xpath="//button[contains(text(), 'Continue')]")
private WebElement continuebtn;

public void verifyLoginLink(){
	Loginbtn.click();
}
public MyAccountPage VerifyLogin(){
	uname.sendKeys(Baseclass.ReadProperty("username"));
	pw.sendKeys(Baseclass.ReadProperty("password"));
	btn.click();
	secCode.sendKeys("2589");
	continuebtn.click();
	return new MyAccountPage(driver);
}
public void VerifyInvaliduname(){
	uname.sendKeys(" ");
	pw.sendKeys(Baseclass.ReadProperty("password"));
	btn.click();
}
}
