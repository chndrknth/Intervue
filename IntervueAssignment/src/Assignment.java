import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Assignment {
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		 
			System.setProperty("webdriver.chrome.driver","./softwares/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.intervue.io/");
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.findElement(By.xpath("(//span[text()='Login'])[1]")).click();
			
			Set<String> wins = driver.getWindowHandles();
			for(String win:wins){
				driver.switchTo().window(win);
			}
			
			driver.findElement(By.xpath("(//div[text()='Login'])[1]")).click();
			driver.findElement(By.id("login_email")).sendKeys("chandrakanthsrinivasa@gmail.com");
			driver.findElement(By.id("login_password")).sendKeys("password");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(2000);  
			
		    TakesScreenshot ts=(TakesScreenshot)driver;
		    File temp = ts.getScreenshotAs(OutputType.FILE);
		    File perm= new File("./Screenshot/login.png");
		    FileHandler.copy(temp, perm);
			driver.close();
		 }
	}


