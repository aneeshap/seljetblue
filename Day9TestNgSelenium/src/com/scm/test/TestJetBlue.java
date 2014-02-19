package com.scm.test;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestJetBlue {

		
		public static WebDriver driver;
		public String baseurl = "http://www.jetblue.com/";
		
	  @Test(dataProvider = "dp")
	  public void f(Integer n, String s) {
	  }
	  @BeforeClass
	  public void setBaseURL() {
		  
		   driver = new FirefoxDriver();
		   driver.get(baseurl);
	  }

	  @Test
	  public static void TestManageFlights() {
			// TODO Auto-generated method stub
		  
		  final String LOGIN_EMAIL = "aneeshadp@yahoo.com";
			final String PASSWORD ="testjetblue";
			
			 
			 //ChromeDriver driver = new ChromeDriver();
			// driver.get("http://google.com");
			
			
			driver.manage().window().maximize();
			//WebElement element = driver.findElement(By.xpath(".//*[@id='jb-header']/div/div[1]/ul/li[1]/a/span"));
			
			//WebElement firstname = driver.findElement(By.cssSelector("#my-info-first-name"));
		
			//firstname.sendKeys("aneesha");
			
			WebElement manageflightselement = driver.findElement(By.xpath(".//*[@id='jb-primary-links']/li[2]/a"));
			manageflightselement.click();
			//If user has not already signed in  sign in with email/pwd
			if(driver.findElement(By.tagName("body")).getText().contains("Sign in to quickly retrieve your flight information and manage your flights")){
			 
				driver.findElement(By.xpath(".//*[@id='signInForm']/input[1]")).sendKeys(LOGIN_EMAIL);
				//driver.findElement(By.xpath(".//*[@id='signInForm']/input[2]")).sendKeys(PASSWORD);
				
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("document.getElementsByName('password').value='aathira_123';");
				//driver.findElement(By.xpath(".//*[@id='signInForm']/input[3]")).sendKeys(PASSWORD);
				driver.findElement(By.xpath(".//*[@id='signInForm']/div[1]/div/a")).click();
			}
			
			 if (driver.findElement(By.tagName("body")).getText().contains("We can't find any upcoming flights in your TrueBlue account")){
				  //driver.findElement(By.xpath("html/body/div[1]/section/div/h4/a")).click();
				  driver.findElement(By.linkText("Book new travel")).click();
			  }
			 
			 
			 
			 List<WebElement> trip_type = driver.findElements(By.name("journeySpan"));
			 for (WebElement element : trip_type)
			 {
				 if (element.getAttribute("value").equalsIgnoreCase("RT") && element.isSelected()){
					
					 System.out.println("here in RT");
				 }
				 if (element.getAttribute("value").equalsIgnoreCase("OW") && element.isSelected()){
					 System.out.println("here in OW");
				 }
				 if (element.getAttribute("value").equalsIgnoreCase("MC") && element.isSelected()){
					 System.out.println("here in MC");
				 }
			 }
			 //Book a flight
			 /**
			 
			 List<WebElement> trip_type = driver.findElements(By.name("journeySpan"));
				 
			 
			 WebElement trips = driver.findElement(By.xpath(".//*[@id='searchContainer']/ul/li[1]"));
			
			 if(trips.isSelected()){
				 driver.findElement(By.xpath(".//*[@id='originAirportsInput']")).sendKeys("San Francisco");
				 
			 }
			 
			 
			 
			 for (WebElement element : trip_type)
			 {
				 if (element.getAttribute("value").equalsIgnoreCase("RT") && element.isSelected()){
					
					 System.out.println("here in RT");
				 }
				 if (element.getAttribute("value").equalsIgnoreCase("OW") && element.isSelected()){
					 System.out.println("here in OW");
				 }
				 if (element.getAttribute("value").equalsIgnoreCase("MC") && element.isSelected()){
					 System.out.println("here in MC");
				 }
			 }
			**/ 
		}
		
	  
	  @Test
	  public void testFlightStatustab(){
		  
		  // Select the manage flights tab to go to that Flightsstatustab
		  
		  WebElement manageflightselement = driver.findElement(By.xpath(".//*[@id='jb-primary-links']/li[2]/a"));
			manageflightselement.click();
			//select the flight status tab on the manage flights tab
		  driver.findElement(By.xpath(".//*[@id='page-nav']/li[3]/a")).click();
		  //Inside flight status tab
		  
		  
		  
		  WebElement by_city = driver.findElement(By.xpath(".//*[@id='ffstatus']/div[1]/div[1]/span/a/span"));
		  by_city.click();
		 WebElement from_city= driver.findElement(By.xpath(".//*[@id='fs_from_field']"));
		 from_city.sendKeys("San Francisco");
		 from_city.click();
		 WebElement to_city= driver.findElement(By.xpath(".//*[@id='fs_to_field']"));
		 to_city.sendKeys("San Diego");
		 to_city.click();
		 
		 //Select selectBox = new Select(driver.findElement(By.xpath(".//*[@id='ffstatus']/div[3]/ul/li")));
		 Select selectBox = new Select(driver.findElement(By.id("departure-select")));
		 System.out.println("selectbox"+selectBox.toString());
		 selectBox.selectByIndex(1); 
		 driver.findElement(By.xpath(".//*[@id='check-status-btn']")).click();
	  }
	  @Test
	  
	  public void testCheckInOnlinetab(){
		  WebElement manageflightselement = driver.findElement(By.xpath(".//*[@id='jb-primary-links']/li[2]/a"));
			manageflightselement.click();
			// Select the checkin online tab on the manageflights page
			  driver.findElement(By.xpath(".//*[@id='page-nav']/li[2]/a")).click();
		  
		 
	  }
	  

	  @AfterMethod
	  public void afterMethod() {
		 
	  }


	  @DataProvider
	  public Object[][] dp() {
	    return new Object[][] {
	      new Object[] { 1, "a" },
	      new Object[] { 2, "b" },
	    };
	  }
	  @BeforeClass
	  public void beforeClass() {
	  }

	  @AfterClass
	  public void afterClass() {
		  driver.quit();
	  }

	  @BeforeTest
	  public void beforeTest() {
	  }

	  @AfterTest
	  public void afterTest() {
	  }

	  @BeforeSuite
	  public void beforeSuite() {
	  }

	  @AfterSuite
	  public void afterSuite() {
	  }

	}


