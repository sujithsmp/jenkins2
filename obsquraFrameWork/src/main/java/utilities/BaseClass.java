package utilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaseClass {
	public static WebDriver driver;
	public Properties p;

	@BeforeMethod(groups = { "sanity", "regression" })
	@Parameters({ "browser","os" })
	public void setup(String br,String os) throws IOException {
		// public void setup() throws IOException {

		FileReader file = new FileReader("./src//test//resources//config.properties");
		p = new Properties();
		p.load(file);

		switch (br.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Invalid browser");
			return;
		}

		//driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	}

	@AfterMethod(groups = { "sanity", "regression" })
	
	
	public void tearDown(ITestResult iTestResult) throws IOException {
		driver.quit();
		}
	
	/*public void tearDown(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			ScreenshotUtility sc = new ScreenshotUtility();
			sc.captureScreenShotForFailedTestcase(driver, iTestResult.getName());

		}
		driver.quit();
	}*/

	
	public String captureScreenShot(String name) {
		
		TakesScreenshot scrShot = (TakesScreenshot) driver;
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE);// screenshot will store in temporary path

		File f1 = new File(System.getProperty("user.dir") + "\\OutputScreenshots");// Generating folder using Java
		if (!f1.exists()) {
		f1.mkdirs();// mkdir --> will create folder using java
		}
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());// date time capture using
		// java
		String targetFilePath=System.getProperty("user.dir") + "\\OutputScreenshots\\" + name + "_" + timeStamp + ".jpg";
		File finalDestination = new File(targetFilePath);
		//FileHandler.copy(screenShot, finalDestination);// copy screenshot from temp path to project folder
		screenShot.renameTo(finalDestination);
		return targetFilePath;
		}
	
}
