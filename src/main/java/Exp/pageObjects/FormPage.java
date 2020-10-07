package Exp.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage {
	public FormPage(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	

	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
	
	@AndroidFindBy(xpath="//*[@text='Female']")
	public WebElement femaleOption;
	// driver.findElement(By.id("android:id/text1")).click();
	
	@AndroidFindBy(id="android:id/text1")
	private WebElement countrySelection;
	
	public WebElement getNameField()
	{
		System.out.println("trying to find the Name field");
		return nameField;
	}
	public WebElement getcountrySelection()
	{
		System.out.println("Selecting the option from dropdown");
		return countrySelection;
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='General Store']")
	private WebElement appname;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Your Name']")
	private WebElement namefield;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Gender']")
	private WebElement gen;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Enter name here']")
	private WebElement placeholder;
	
	@AndroidFindBy(xpath="//*[@text='Let's  Shop']")
	private WebElement submit;

	public WebElement getAppname() {
		return appname;
	}
	
	public WebElement getNamefieldtext() {
		return namefield;
	}
	
	public WebElement getPlaceholder() {
		return placeholder;
	}
	
	public WebElement getGen() {
		return gen;
	}
	public WebElement getSubmit() {
		return submit;
	}
	public void setNameField(WebElement nameField) {
		this.nameField = nameField;
	}
	
}
