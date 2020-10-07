package Exp.MAF2;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import Exp.pageObjects.FormPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Zerosanity extends base{
	
	@Test
	public void sanitytest() throws IOException, InterruptedException {
		
		service=startServer();
		 AndroidDriver<AndroidElement> driver=capabilities("GeneralStoreApp");
		
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     FormPage formPage=new FormPage(driver);
	     
	    boolean namefield=formPage.getNameField().isDisplayed();
	    boolean countryfield=formPage.getcountrySelection().isDisplayed();
		boolean genderfield=formPage.femaleOption.isDisplayed();
		
		if(namefield==true)
		{
			System.out.println("Name field is Displayed");
		}
		else
		{
			System.out.println("Name field not Displayed");
		}
		
		if(countryfield==true)
		{
			System.out.println("Country field is Displayed");
		}
		else
		{
			System.out.println("Country field not Displayed");
		}
		
		if(genderfield==true)
		{
			System.out.println("Gender field is Displayed");
		}
		else
		{
			System.out.println("Gender field not Displayed");
		}
		
		driver.closeApp();
		
	}

}
