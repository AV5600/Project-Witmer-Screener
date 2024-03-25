package com.witmerscreeners;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MMWA {
	
	public static CharSequence formattedDateTime;

	public static void main(String[] args) throws InterruptedException, AWTException, IOException {

		WebDriverManager.chromedriver().setup();
		
		//WebDriverManager.firefoxdriver().setup();
		
		//WebDriverManager.edgedriver().setup();

		WebDriver driver = new ChromeDriver();

		//WebDriver driver = new FirefoxDriver();

		//WebDriver driver = new EdgeDriver();
		
		driver.get("https://app.mindn.ai/#/login");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		// Clear cookies
		
		driver.manage().deleteAllCookies();

		driver.navigate().refresh();
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("arunachalam@energetics.ai");
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Mail@123");
		
		driver.findElement(By.id("loginButton")).click();
        
        WebElement mdselement = driver.findElement(By.xpath("//a[contains(text(),'MMWA')]"));
        
        Actions actions = new Actions(driver);
        
        actions.moveToElement(mdselement).perform();
        
        mdselement.click();
		
        driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();
        
        List<WebElement> elements = driver.findElements(By.xpath("(//button[contains(text(),'CONTINUE')])[2]"));

		if (!elements.isEmpty()) {

			driver.findElement(By.xpath("(//button[contains(text(),'CONTINUE')])[2]")).click();

		}
		
		
        for (int i = 1; i <= 12; i++) {
           
        	int randomOption = new Random().nextInt(5);

            String xpath = "(//div[@class='svg-circle-card']//label[@class='ass-options '])[" + (randomOption + 1) + "]";

            WebElement option = driver.findElement(By.xpath(xpath));
            
            option.click(); Thread.sleep(500);
        }
		
        WebElement element = driver.findElement(By.xpath("//label[contains(text(),'Rarely')]"));
        
        element.click(); Thread.sleep(500);
        
        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
        
        for (int i = 1; i <= 9; i++) {
            
        	int randomOption = new Random().nextInt(5);

            String xpath = "(//div[@class='svg-circle-card']//label[@class='ass-options '])[" + (randomOption + 1) + "]";

            WebElement option = driver.findElement(By.xpath(xpath));
            
            option.click(); Thread.sleep(500);
        }
        
        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
        
        for (int i = 1; i <= 32; i++) {
           
        	int randomOption = new Random().nextInt(5);

            String xpath = "(//div[@class='svg-circle-card']//label[@class='ass-options '])[" + (randomOption + 1) + "]";

            WebElement option = driver.findElement(By.xpath(xpath));
            
            option.click(); Thread.sleep(500);
        }
		
        driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
        
        driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
        
        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
        
        Thread.sleep(11000);
        
        driver.findElement(By.xpath("//button[contains(text(),' ')]")).click();
        
        driver.findElement(By.xpath("//button[contains(text(),'Home')]")).click();
        
        //driver.quit();
		
		
	}
	

}
