import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class DiscountPowerBillPayment extends browser{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		driver = browser.UsingChrome("https://www.discountpowertx.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("My Account")).click();
		
		driver.findElement(By.id("username")).sendKeys("samjohar92");
		driver.findElement(By.id("password")).sendKeys("Samjohar92");
		driver.findElement(By.id("logonButton")).click();
		
		String amountDue = driver.findElement(By.id("amountDue")).getText();
		String customerDetails = driver.findElement(By.id("accountName")).getText();
		if(customerDetails.equalsIgnoreCase("Inderpreet Singh Johar ( 72960200-3 )"))
		{
			if(!amountDue.equals("$0.00"))
			{
				driver.findElement(By.linkText("Pay Bill Now")).click();
				driver.findElement(By.id("ccPayment")).click();
				
				Select s1 = new Select(driver.findElement(By.id("cardType")));
				s1.selectByValue("ZVIS");
				
				driver.findElement(By.id("cardNumber")).sendKeys("4266841591163421");
				driver.findElement(By.id("cardCVV")).sendKeys("097");
				
				Select s2 = new Select(driver.findElement(By.id("cardExpMonth")));
				s2.selectByValue("11");
				
				Select s3 = new Select(driver.findElement(By.id("cardExpYear")));
				s3.selectByValue("2023");
				
				driver.findElement(By.id("cardZip")).sendKeys("75080");
				
				driver.findElement(By.linkText("Continue")).click();
				driver.findElement(By.linkText("Submit Payment")).click();
			}
			else
			{
				driver.findElement(By.linkText("Log Out")).click();
			}
		}
		driver.quit();
		
		
	}

}
