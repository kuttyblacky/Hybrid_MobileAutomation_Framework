package Exp.MAF2;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Exp.pageObjects.FormPage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ecommerce_tc_3 extends base {

	@Test
	public void errormsgValidation() throws IOException, InterruptedException {
		service=startServer();
		 AndroidDriver<AndroidElement> driver=capabilities("GeneralStoreApp");
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 FormPage formPage=new FormPage(driver);
		 
            //driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");

		    //driver.hideKeyboard();

		     //driver.findElement(By.xpath("//*[@text='Female']")).click();
			formPage.femaleOption.click();

		     driver.findElement(By.id("android:id/text1")).click();
		     
		     Utilities util=new Utilities(driver);
		     
		     util.scrollToText("Argentina");
		     
		     driver.findElement(By.xpath("//*[@text='Argentina']")).click();
		     //driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));

		    //   driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));     
		     
		     //driver.findElement(By.xpath("//*[@text='Argentina']")).click();

		     driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		     String toastMessage=driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");

		     System.out.println(toastMessage);

		     Assert.assertEquals("Please enter your name", toastMessage);//Actual validation
		     
		     driver.closeApp();
		
		     //name attribute for toast messages will have content
	}
}
