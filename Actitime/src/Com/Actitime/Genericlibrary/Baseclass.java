package Com.Actitime.Genericlibrary;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import Com.Actitime.pom.LoginPage1;

public class Baseclass {
	public static WebDriver driver;
	FileLibrary f=new FileLibrary();
	@BeforeSuite
	public void databaseconnection() {
		Reporter.log("Database connected sucessfully",true);
	}
	@AfterSuite
	public void databasedisconnected() {
		Reporter.log("Database disconnected sucessfully",true);
	}
	@BeforeClass
	public void launchbrowser() throws IOException {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		 driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String URL = f.readDataFromProperty("url");
		driver.get(URL);
		Reporter.log("browser launched",true);
		
     }
	
	
	@AfterClass
	public void closebrowser() {
		driver.close();
		Reporter.log("browser closed",true);
	}
	
	@BeforeMethod
	public void login() throws IOException {
		String un = f.readDataFromProperty("username");
		String pw = f.readDataFromProperty("password");
		LoginPage1 lp=new LoginPage1(driver);
		lp.getUntbx().sendKeys(un);
		lp.getPwtbx().sendKeys(pw);
		lp.getLgbtn().click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Reporter.log("login successfully",true);
	}
	
	@AfterMethod
	public void logout() {
		driver.findElement(By.id("logoutLink")).click();
		Reporter.log("logout successfully",true);
		
	}
	
}