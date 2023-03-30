package Com.Actitime.Testscripts;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import Com.Actitime.Genericlibrary.Baseclass;
import Com.Actitime.Genericlibrary.FileLibrary;
import Com.Actitime.pom.HomePage;
import Com.Actitime.pom.TaskPage;

public class TaskTest extends Baseclass {
	@Test
	public void createCustomer() throws EncryptedDocumentException, IOException {
		HomePage hp=new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		hp.getTasklnk().click();
		
		
		TaskPage tp=new TaskPage(driver);
		tp.getAddnew().click();
		tp.getNewcust().click();
		FileLibrary f=new FileLibrary();
		String name = f.readDataFromExcelFile("Sheet1", 4, 1);
		tp.getCustname().sendKeys(name);
		
		String description = f.readDataFromExcelFile("Sheet1", 4, 2);
		tp.getCustdesp().sendKeys(description);
		tp.getCreatecust().click();
	}

}
