package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	@Parameters({"browser"})
	@BeforeClass(groups={"sanity","regression","master"})
	public void setup(String br) throws Exception {
		
		//Loding config
		
		FileReader file = new FileReader("C:\\Users\\Pramod\\eclipse-workspace\\OpenCart07\\src\\test\\resources\\config.properties");
	                  p = new Properties();
		              p.load(file);
		
		logger = LogManager.getLogger(this.getClass());
		switch(br.toLowerCase()) {
		
		case "chrome":driver = new ChromeDriver();
		               break;
		case "edge":driver = new EdgeDriver();
                     break;
		case "firefox":driver = new FirefoxDriver();
             break;
         default : System.out.println("invalid browser");
         return;
		}
		
		//driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(p.getProperty("appURL")); //read url from properties file
		
	}
	@AfterClass(groups={"sanity","gression","master"})
	public void tearDown() {
		driver.quit();
	}
	
	public String randomeString()
	{
		
		String generateedstring = RandomStringUtils.randomAlphabetic(5);
		return generateedstring;
	}
	public String randomeNumber()
	{
		
		String generateednumber = RandomStringUtils.randomNumeric(5);
		return generateednumber;
	}
	public String randomeAlphaNumeric()
	{
		String generateedstring = RandomStringUtils.randomAlphabetic(3);
		String generateednumber = RandomStringUtils.randomNumeric(3);
		return (generateedstring+"@"+generateednumber);
	}
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	
	

}
