package com.witmerscreeners;

import org.openqa.selenium.chrome.ChromeDriver;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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

public class Personality {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		
		//WebDriverManager.firefoxdriver().setup();
		
		//WebDriverManager.edgedriver().setup();

		WebDriver driver = new ChromeDriver();

		//WebDriver driver = new FirefoxDriver();

		//WebDriver driver = new EdgeDriver();
		
		driver.get("https://dev0.witmer.ai/#/login");
		
		driver.manage().window().maximize();
		
		// Clear cookies
		
		driver.manage().deleteAllCookies();

		driver.navigate().refresh();
		
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("arunachalam@energetics.ai");
		
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Mail@123");
		
		driver.findElement(By.id("loginButton")).click();
		
		Duration timeout = Duration.ofSeconds(10);
        
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Personality')]")));
        
        WebElement personalityelement = driver.findElement(By.xpath("//a[contains(text(),'Personality')]"));
        
        Actions actions = new Actions(driver);
        
        actions.moveToElement(personalityelement).perform();
        
        personalityelement.click();
        
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
        	
        	//WebElement option = driver.findElement(By.xpath("//label[contains(text(),'Very Accurate')]"));
        	
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
        
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'OK')]")));
		
		driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
		
		Thread.sleep(11000);
        
        driver.findElement(By.xpath("//button[contains(text(),' ')]")).click();
		
		//driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();
		
		//driver.quit();
		
	}

}
