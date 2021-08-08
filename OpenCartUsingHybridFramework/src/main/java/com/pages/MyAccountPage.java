package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
WebDriver driver;

public MyAccountPage(WebDriver driver){
	PageFactory.initElements(driver, this);
	this.driver=driver;
}
@FindBy(xpath="//a[contains(text(),'Features')]")
private WebElement featureslink;

public Featurespage Featurelink(){
	featureslink.click();
	return new Featurespage(driver);
}
}
