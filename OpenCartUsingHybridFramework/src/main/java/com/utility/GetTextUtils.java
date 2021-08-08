package com.utility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


import com.testbase.Baseclass;

public class GetTextUtils extends Baseclass{
 WebDriver driver;

public String getText(String locname, String locvalue, WebDriver driver){
	String str=null;
	if(locname.equals("xpath")){
		str=driver.findElement(By.xpath(locvalue)).getText();
	} else if (locname.equals("id")){
		str=driver.findElement(By.id(locvalue)).getText();
	} else{
		System.out.println("invalid locator value");
	}
	return str;
}
public void ScrollDown(WebDriver driver){
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,300)");
}

public void sendText(String locname, String locval, String EnterText, WebDriver driver){
	
	if(locname.equals("xpath")){
		driver.findElement(By.xpath(locval)).sendKeys(EnterText);
	} else if (locname.equals("id")){
		driver.findElement(By.id(locval)).sendKeys(EnterText);
	} else{
		System.out.println("invalid locator value");
	}
}	
}

