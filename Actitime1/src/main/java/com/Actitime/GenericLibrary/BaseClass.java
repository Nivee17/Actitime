package com.Actitime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	FileLibrary f = new FileLibrary();
	public WebDriver driver;
	
	@BeforeSuite
	public void dataBase() {
		Reporter.log("database connected", true);
	}
	@BeforeTest
	public void launchBrowser() throws IOException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String URL = f.getPropertydata("url");
		driver.get(URL);
		Reporter.log("Browser launched successfully", true);
	}
	
	@BeforeMethod
	public void login() throws IOException {
		String un = f.getPropertydata("username");
		driver.findElement(By.id("username")).sendKeys(un);
		String pwd = f.getPropertydata("password");
		driver.findElement(By.name("pwd")).sendKeys(pwd);
		driver.findElement(By.xpath("//div[.='Login ']")).click();
		Reporter.log("Logged in successfully");
	}
	
	@AfterTest
	public void logout() {
		driver.findElement(By.id("logoutLink")).click();
		Reporter.log("logged out succesfully");
	}
	
	@AfterMethod
	public void CloseBrowser() {
		driver.quit();
		Reporter.log("Browser closed successfully");
	}
	
	@AfterSuite
	public void closeDataBase() {
		Reporter.log("database disconnected", true);
	}
	
	


}
