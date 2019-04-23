import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class DiscountPowerBillPayment extends browser{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Calling UsingChrome method from browser.java
		driver = browser.UsingChrome("https://www.discountpowertx.com/");
		
		//maximizes screen
		driver.manage().window().maximize();
		
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.linkText("My Account")).click();
		
		driver.findElement(By.id("username")).sendKeys("Enter username");
		driver.findElement(By.id("password")).sendKeys("Enter password");
		driver.findElement(By.id("logonButton")).click();
		
		String amountDue = driver.findElement(By.id("amountDue")).getText();
		String customerDetails = driver.findElement(By.id("accountName")).getText();
		if(customerDetails.equalsIgnoreCase("Full Name ( Account Number)"))
		{
			if(!amountDue.equals("$0.00"))
			{
				driver.findElement(By.linkText("Pay Bill Now")).click();
				driver.findElement(By.id("ccPayment")).click();
				
				Select s1 = new Select(driver.findElement(By.id("cardType")));
				s1.selectByValue("ZVIS");
				
				driver.findElement(By.id("cardNumber")).sendKeys("Enter 16 digit card number");
 				driver.findElement(By.id("cardCVV")).sendKeys("Enter 3 digit CVV number");
				
				Select s2 = new Select(driver.findElement(By.id("cardExpMonth")));
				s2.selectByValue("Select expiry month by value ranging from 1-12 ");
				
				Select s3 = new Select(driver.findElement(By.id("cardExpYear")));
				s3.selectByValue("Select expiry year");
				
				driver.findElement(By.id("cardZip")).sendKeys("Enter 5 digit zip code");
				
				driver.findElement(By.linkText("Continue")).click();
				driver.findElement(By.linkText("Submit Payment")).click();
			}
			else
			{
				driver.findElement(By.linkText("Log Out")).click();
			}
		}
		
		//close all the browser instances
		driver.quit();
		
		
	}

}
