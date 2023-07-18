package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
public WebDriver driver;

	public WebDriver testBaseManager() throws IOException {
		
		File file =new File(System.getProperty("user.dir")+"\\src\\test\\propertyFile.properties");
		FileInputStream fis= new FileInputStream(file);
		Properties prop =new Properties();
		prop.load(fis);
		
		String brawser=prop.getProperty("bname");
		String Url=prop.getProperty("url");
		
		if(driver==null) 
		{
           if(brawser.equalsIgnoreCase("chrome")) 
           {
        	 WebDriverManager.chromedriver().setup();
        	   driver =new ChromeDriver();
           }else if(brawser.equalsIgnoreCase("edge")) 
           {
        	 WebDriverManager.edgedriver().setup();
          	   driver =new EdgeDriver();
           }else if(brawser.equalsIgnoreCase("Firefox")) 
           {
        	   WebDriverManager.firefoxdriver().setup();
          	   driver =new FirefoxDriver();
		   }else 
		   {
			   System.err.println("Driver not foud....please provide correct drive");
		   }
           
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get(Url);
		return driver;
	}	
}
