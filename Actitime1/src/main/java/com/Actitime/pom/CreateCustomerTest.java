package com.Actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CreateCustomerTest {

	@Test
	public void CreateCust() throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facbook.com");
		Thread.sleep(5000);
		driver.close();
	}

}
