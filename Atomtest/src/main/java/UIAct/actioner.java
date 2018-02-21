

package UIAct;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.omg.CORBA.UserException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
//import com.org.frameworkFiles.utility.Log;
//import com.org.frameworkFiles.utility.UserDefinedException;

import MainPack.fblogin;
import MainPack.intoJenkins;

//import com.org.frameworkFiles.stepDefinitions.SD_Capped_rates;
import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

public class actioner {

	protected static WebDriver driver;
	
	public static void openBrowser(String data) throws Exception{		
		System.out.println("Opening Browser");
		try{

			if(data.equals("Mozilla")){
				FirefoxProfile fp = new FirefoxProfile();
				fp.setAcceptUntrustedCertificates(true);
				driver = new FirefoxDriver(fp);
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				//Log.info("Mozilla browser started");				
			}
			else if(data.equals("IE")){
				//Dummy Code, Implement you own code
				File file = new File("C:\\Users\\c24088773\\Desktop\\Selenium tests\\IEDriverServer.exe");
				System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
				DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
		        ieCapabilities.setCapability(CapabilityType.BROWSER_NAME, "IE");
		        ieCapabilities.setCapability(InternetExplorerDriver.
		        		INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
				/*File file = new File("C:/Users/c24088773/Desktop/Selenium tests/IEDriverServer.exe");
				System.setProperty("webdriver.ie.driver", file.getAbsolutePath());-*/
				driver = new InternetExplorerDriver(ieCapabilities);
				driver.manage().window().maximize();
				//Log.info("IE browser started");
			}
			else if(data.equals("Chrome")){
				//Dummy Code, Implement you own code
				File file = new File("C:\\Users\\c24088773\\Desktop\\Selenium tests\\chromedriver.exe");
				System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		        driver = new ChromeDriver();              
		        driver.manage().window().maximize();
				//Log.info("Chrome browser started");
		        }

			int implicitWaitTime=(10);
			driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
			//actions = new Actions(driver);
			}
		catch (Exception e){
			//Log.info("Not able to open the Browser --- " + e.getMessage());
			throw new Exception("<<< Not able to open the Browser " + data + " >>> " + e.getMessage());			
			//DriverScript.bTestStepResult = false;
		}
	}
	public static void navigateTo(String data) throws Exception
	{
		try{
			//Log.info("Navigating to URL");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(data);
		}
		catch(Exception e)
		{   //Log.info("Not able to navigate --- " + e.getMessage());
			throw new Exception("<<< Unable to Navigate to " + data + " >>> " + e.getMessage());			
			//DriverScript.bTestStepResult = false;
		}
	}
	
	public static void input(String data1,String data2)
	{	
		//WebElement eml = driver.findElement(By.xpath("//*[@id='email']"));
		WebElement inp = driver.findElement(By.xpath("//*[@id='j_username']"));
		inp.clear();
		inp.sendKeys(data1);
		//WebElement pas = driver.findElement(By.xpath("//*[@id='pass']"));
		WebElement inp2 = driver.findElement(By.xpath("//*[@id='main-panel']/div/form/table/tbody/tr[2]/td[2]/input"));
		inp2.clear();
		inp2.sendKeys(data2);
	}
	
	public static void click(String udata) throws Exception{
		//WebElement elementToClick = driver.findElement(ObjectMap.getLocator(objTechName));
	    Thread.sleep(5000);
		if(udata == "LOGIN"){
		driver.findElement(By.xpath("//*[@id='u_0_3']")).click();
		}
		if(udata == "LOGOUT"){
		driver.findElement(By.xpath("//*[@id='userNavigationLabel']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='js_6t']/div/div/ul/li[12]/a/span/span")).click();
		driver.quit();
		}
		if(udata == "Jenkins LIaccess"){
			driver.findElement(By.xpath("//*[@id='yui-gen1-button']")).click();

		}
		if(udata == "Jenkins LOaccess"){
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id='header']/div[2]/span/a[2]/b")).click();
			driver.quit();		
		}
	}
}

