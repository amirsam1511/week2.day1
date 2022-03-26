package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("XXX");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("YYY");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("ZZZ");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("IT");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("TestLeaf started up in 2009, and we’ve been on an epic ride ever since. From our beginnings as an training company, we’ve tried to stay true to our core beliefs and to deliver an exceptional learning experience and job support for our customers and learners.");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("sdet@testleaf.com");
		WebElement option = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select selectOption = new Select(option);
		selectOption.selectByVisibleText("New York");
		driver.findElement(By.className("smallSubmit")).click();
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.linkText("Duplicate Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).clear();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Test");
		driver.findElement(By.id("createLeadForm_firstName")).clear();
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Testleaf");
		driver.findElement(By.className("smallSubmit")).click();
		String updatedTitle = driver.getTitle();
		System.out.println(updatedTitle);
		driver.close();

	}

}
