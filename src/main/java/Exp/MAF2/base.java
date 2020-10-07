package Automation.MobileAutomation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

	public class base {
		public static AppiumDriverLocalService service;
		public static AndroidDriver<AndroidElement>  driver;
		
		public AppiumDriverLocalService startServer() {
		boolean flag=	checkIfServerIsRunnning(4723);
		if(!flag)
		{
			
			service=AppiumDriverLocalService.buildDefaultService();
			service.start();
		}
			return service;
		}
	
		
		
	public static boolean checkIfServerIsRunnning(int port) {
		
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			
			serverSocket.close();
		} catch (IOException e) {
			//If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}

	public static void startEmulator() throws IOException, InterruptedException {
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\Automation\\resources\\emulator.bat");
		Thread.sleep(10000);
	}

	
	
	public static  AndroidDriver<AndroidElement> capabilities(String AppName) throws IOException, InterruptedException
	{
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Automation\\MobileAutomation\\global.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		File appDir = new File("src");
	    File app = new File(appDir, (String) prop.get(AppName));
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    String DeviceName=(String) prop.get("device");
	    if(DeviceName.contains("emulator"))
	    {
	    	startEmulator();
	    }
	    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DeviceName);
	    capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
	    driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		return driver;
	}
	
	
	public static void getScreenshot(String s) throws IOException, InvalidFormatException
	{
		File scrfile=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrfile,new File(System.getProperty("user.dir")+"\\Screenshots\\"+s+".png"));
		XWPFDocument doc = new XWPFDocument();
		XWPFParagraph p = doc.createParagraph();
		XWPFRun r = p.createRun();
		r.setText(s);
		r.addBreak();
		r.addPicture(new FileInputStream(scrfile), Document.PICTURE_TYPE_PNG, s, Units.toEMU(400), Units.toEMU(400));
		FileOutputStream out = new FileOutputStream(System.getProperty("user.dir")+"\\Screenshots\\"+s+".docx");
		doc.write(out);
		out.close();
		doc.close();
	}

}
