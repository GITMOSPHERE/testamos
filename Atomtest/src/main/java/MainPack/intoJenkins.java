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
import MainPack.GetdatafromExcel;

import UIAct.actioner;
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

public class intoJenkins extends GetdatafromExcel {	

	Scenario scenario;
	@Before
	public void before(Scenario scenario) {
	    this.scenario = scenario;
	}

	GetdatafromExcel datatab = new GetdatafromExcel();
	
	@Given("^I want to launch localhost URL$")
	public void i_want_to_launch_localhost_URL() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
	actioner.openBrowser("IE");
	actioner.navigateTo("http://localhost:8080");
	System.out.println("Am launcing the browser");
}

@When("^entered the \"([^\"]*)\" and \"([^\"]*)\" in the login page$")
public void entered_the_and_in_the_login_page(String arg1, String arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
	
	System.out.println("Into the Jenkis login form");
	
	System.out.println(scenario.getName());
	String test1= datatab.get(scenario.getName(), arg1);
	System.out.println(test1);
	
	actioner.input(datatab.get(scenario.getName(), arg1),datatab.get(scenario.getName(), arg2));
}

@And("^click login button$")
public void click_login_button() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
	actioner.click("Jenkins LIaccess");
//	
}

@Then("^click logout button$")
public void click_logout_button() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
	actioner.click("Jenkins LOaccess");
	
}

}
