package Academy.Options;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="C:\\Users\\joko2909\\SeleniumTraining\\APIFramework27012023\\src\\test\\java\\Academy\\Features", //All feature files in this package are to be run, src/test/java/features/Login.feature for a single file
					glue="Academy\\StepDefinitions", //The package where stepdefinition files are located)
				//	monochrome=true, //This is for results to be in a readable format
					//tags= "@DeletePlaceTag", //For tags, this is a tag from the feature file
					plugin = "json:target/jsonReports/cucumber-report.json" ) //This json file will be generated on order to have all the results from out TestRunner.java
					//This plugin is for generating a report in the json format, usually in the "target" folder and the subfolder "jsonReports"
					//In this target folder we have created another sub-folder "jsonReports" and there will be this file cucumber-report.json

public class TestRunner extends AbstractTestNGCucumberTests { //Extend with this AbstractTestNGCucumberTests class in order to run the TestNG

}




/* To relax this rule, go to

Manage Jenkins->

Manage Nodes->

Click settings(gear icon)->

click Script console on left and type in the following command:

System.setProperty("hudson.model.DirectoryBrowserSupport.CSP", "")

and Press Run. If you see the output as 'Result:' below "Result" header then the protection disabled. Re-Run your build and you can see that the new HTML files archived will have the CSS enabled.
*/