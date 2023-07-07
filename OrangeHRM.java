package com.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM {

	static WebDriver driver = null;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		driver.manage().window().maximize();
		Thread.sleep(3000);

		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();

						
		Thread.sleep(5000);

		// checkByPara();
		checkByText();

		driver.quit();
	}

	static void checkByPara() {
		try {
			driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div/div[1]/div/p"));
			System.out.println("Login Succesfull");
		} catch (NoSuchElementException e) {
			System.out.println("Login Failed");
		}
	}

	static void checkByText() {

		try {
			driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]"));
			System.out.println("Login Failed");
		} catch (NoSuchElementException e) {
			System.out.println("Login Sucessfull");
		}
	}

}
