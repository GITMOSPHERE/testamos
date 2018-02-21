
package MainPack;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.gargoylesoftware.htmlunit.javascript.host.Element;
import UIAct.actioner;

import UIAct.actioner;
import MainPack.GetdatafromExcel;

import com.sun.javafx.print.Units;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.*;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class fblogin extends actioner {
		// TODO Auto-generated method stub
	Scenario scenario;

	@Before
	public void before(Scenario scenario) {
	    this.scenario = scenario;
	}

	GetdatafromExcel datatab = new GetdatafromExcel();
		@Given("^I want to launch fb url$")
		public void i_want_to_launch_fb_url() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			actioner.openBrowser("IE");
			actioner.navigateTo("www.facebook.com");
			System.out.println("Am launcing the browser");
		    		
		}
		@When("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
		public void User_enters_input_values(String arg1,String arg2) throws Throwable 
		{
		    // Write code here that turns the phrase above into concrete actions
			System.out.println("Into the facebook login form");
			actioner.input(arg1,arg2);
		//	throw new PendingException();
		}

		@And("^clicks login button$")
		public void clicks_login_button() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
			actioner.click("LOGIN");
		  //  throw new PendingException();
		}

		@And("^then user clicks logout button$")
		public void then_user_clicks_logout_button() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
			actioner.click("LOGOUT");
			System.out.println("Am OUT");
		    //throw new PendingException();
		}

	}


