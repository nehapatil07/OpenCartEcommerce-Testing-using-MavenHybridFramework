package com.testbase;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Baseclass {
public static WebDriver driver;
public static Logger log=Logger.getLogger(Baseclass.class);

public static String ReadProperty(String key){
	Properties prop=new Properties();
	log.info("Data is being entered");
	try {
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/logindata.properties");
		prop.load(fis);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return prop.getProperty(key);
}

public static WebDriver Initialization(){
	log.info("initializing....");
if(ReadProperty("brname").equalsIgnoreCase("chrome")){
	log.info("user wants to automate with chrome browser");
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	driver=new ChromeDriver();
}	else if(ReadProperty("brname").equalsIgnoreCase("firefox")){
	log.info("user wants to automate with firefox browser");
	System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
	driver=new FirefoxDriver();
} else {
	log.info("invalid input");
}
	log.info("browser is initialized");
	driver.get("https://www.opencart.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	return driver;
}

public static void getScreenshot(String name){
	log.info("method failed...taking screenshot");
	TakesScreenshot tsc=(TakesScreenshot) driver;
	File src=tsc.getScreenshotAs(OutputType.FILE);
	File dest=new File(System.getProperty("user.dir")+"/MyScreenshot/"+name+".jpg");
	try {
		FileUtils.copyFile(src, dest);
	} catch (IOException e) {
		e.printStackTrace();
	}
	log.info("screenshot taken and saved in MySreenshot folder");
}
/*public static void main(String[] args) {
System.out.println(ReadProperty("username"));
Initialization();
getScreenshot("NSP");
}*/
}
