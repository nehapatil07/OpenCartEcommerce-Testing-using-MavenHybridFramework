package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Featurespage {
WebDriver driver;

public Featurespage(WebDriver driver){
	PageFactory.initElements(driver, this);
	this.driver=driver;
}

}
