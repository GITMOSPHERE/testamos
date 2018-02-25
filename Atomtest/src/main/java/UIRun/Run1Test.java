package UIRun;

import org.junit.runner.RunWith;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;

	
	@RunWith(ExtendedCucumber.class)
	@ExtendedCucumberOptions(jsonReport = "target/cucumber.json",
			overviewReport = true,
	        detailedReport = true,
	        //detailedAggregatedReport = true,5
	        //toPDF=true,
	        outputFolder = "target")

	@CucumberOptions(
			features = {"src\\test\\resources\\Feature\\Jenkinslogin.feature"},
						glue = "MainPack",
			plugin = { "html:target/cucumber-html-report",
						"json:target/cucumber.json", 
						"pretty:target/cucumber-pretty.txt",
							"usage:target/cucumber-usage.json",
							"junit:target/cucumber-results.xml"
							}
			)
	/*"html:target/Masterthought",*/
		

public class Run1Test {

		public void runCukes() throws Throwable
{
	new TestNGCucumberRunner(getClass()).runCukes();
}

}


