package base;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utilities.ScreenshotUtility;

public class BaseClass {
	public WebDriver driver;
	public Properties p;

	@BeforeMethod(groups= {"sanity","regression"})
	//@Parameters({"browser"})
	//public void setup(String br) throws IOException {
	public void setup() throws IOException {
		
		FileReader file=new FileReader("./src//test//resources//config.properties");
		//or  
		p=new Properties();
		p.load(file);
		/*
		 * switch(br.toLowerCase()) { case "chrome":driver = new ChromeDriver();break;
		 * case "edge":driver = new EdgeDriver();break;
		 * default:System.out.println("Invalid browser"); return; }
		 */
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	}

	@AfterMethod(groups= {"sanity","regression"})
	public void tearDown(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			ScreenshotUtility sc=new ScreenshotUtility();
			sc.captureScreenShotForFailedTestcase(driver,iTestResult.getName());
			
		}
		driver.close();
	}
  @Test
  public void f() {
  }
}
