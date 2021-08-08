package com.tests;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.pages.Loginpage;
import com.pages.MyAccountPage;
import com.testbase.Baseclass;
import com.utility.GetTextUtils;

public class LoginpageTest extends Baseclass {
WebDriver driver=null;
Loginpage ln=null;
static MyAccountPage act=null;
static GetTextUtils utility=null;

@BeforeSuite
public void setup(){
	driver=Baseclass.Initialization();
	ln=new Loginpage(driver);
	utility=new GetTextUtils();
	
}
@AfterSuite
public void teardown(){
	driver.close();
}
@Test(priority=0)
public void verifyLoginbtn(){
	Baseclass.log.info("user is verifying login link");
	ln.verifyLoginLink();
	String str=utility.getText("xpath", "//h1", driver);
	System.out.println(str);
	Assert.assertEquals(driver.getTitle(), "OpenCart - Account Login");
}
@Test(priority=1)
public void VerifyValidLogin(){
	Baseclass.log.info("user is verifying valid login");
	act=new MyAccountPage(driver);
	act=ln.VerifyLogin();
	String actTitle=utility.getText("xpath","//p[contains(text(),'Welcome to OpenCart!')]", driver);
	Assert.assertEquals(actTitle,"Welcome to OpenCart!");	
}
/*@Test(priority=2)
public void verifyInvalidCredentials(){
	Baseclass.log.info("user is verifying invalid credentials..");
	ln.VerifyInvaliduname();
	String str=utility.getText(locname, locvalue, driver)
}*/
}
