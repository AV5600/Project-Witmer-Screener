package com.witmerscreeners;

import org.openqa.selenium.chrome.ChromeDriver;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;
import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Burnout {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		
		//WebDriverManager.firefoxdriver().setup();
		
		//WebDriverManager.edgedriver().setup();

		WebDriver driver = new ChromeDriver();

		//WebDriver driver = new FirefoxDriver();

		//WebDriver driver = new EdgeDriver();
		
		driver.get("https://app.mindn.ai/#/login");
		
		driver.manage().window().maximize();
		
		// Clear cookies
		
		driver.manage().deleteAllCookies();

		driver.navigate().refresh();
		
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("arunachalam@energetics.ai");
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Mail@123");
		
		driver.findElement(By.id("loginButton")).click();
		
		Duration timeout = Duration.ofSeconds(10);
        
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Wellness')]")));
        
        driver.findElement(By.xpath("//div[contains(text(),'Wellness')]")).click();
        
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Burnout')]")));
		
        driver.findElement(By.xpath("//span[contains(text(),'Burnout')]")).click();
        
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='  drop-down-angle  dropdown-toggle dropdown-toggle-split']")));
        
        WebElement dropdownelement = driver.findElement(By.xpath("//button[@class='  drop-down-angle  dropdown-toggle dropdown-toggle-split']"));
        
        Actions actions = new Actions(driver);
        
        actions.moveToElement(dropdownelement).perform();
        
		if (dropdownelement.isDisplayed()) {

			dropdownelement.click();
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Work-Related Burnout')]")));
			
			driver.findElement(By.xpath("//a[contains(text(),'Work-Related Burnout')]")).click();
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'Start Assessment')]")));

			driver.findElement(By.xpath("//button[contains(text(),'Start Assessment')]")).click();
			
		} else {
			
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'Start Assessment')]")));
			
			driver.findElement(By.xpath("//button[contains(text(),'Start Assessment')]")).click();
		
		}

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'Start')]")));
		
		driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();
        
        List<WebElement> element = driver.findElements(By.xpath("(//button[contains(text(),'CONTINUE')])[2]"));

        if (!element.isEmpty()) {

			driver.findElement(By.xpath("(//button[contains(text(),'CONTINUE')])[2]")).click();

		}
                
        for (int i = 0;  ; i++) {
           
        	int randomOption = new Random().nextInt(5);

            String xpath = "(//div[@class='svg-circle-card']//label[@class='ass-options '])[" + (randomOption + 1) + "]";

            WebElement option = driver.findElement(By.xpath(xpath));
        	
            List<WebElement> submitButtons = driver.findElements(By.xpath("//button[contains(text(),'Submit')]"));
            
            if (!submitButtons.isEmpty()) {
                
            	//System.out.println("Submit button found. Breaking the loop.");
            	
            	option.click();
                
                break;
                
            }else {
            	
            	option.click(); Thread.sleep(500);
            	
            }
            
        }
        
        driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
        
        driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
		
		//driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
		
		//driver.quit();
		
	}

}
