package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //it has the path of feature directory/file
        features = "src/test/resources/features/",
        //the name of the package where steps definitions are available
        glue ="steps",
        //it stops actual execution when set to true and scans all the steps
        //also, it provides missing step definition
        //to start the execution, set the value of dryRun to false
        dryRun = false,  //if u want to generate new definition (not existing ones) only that time is need to be changes to True
        tags="@valid",
        //it also can use the tag name like:
        // tags="@sprint1 or @sprint2", in this case both will run
        // tags="@sprint1 and @sprint2" in this case none of the scenarios won't run
        plugin ={"pretty", "html:target/cucumber.html", "json:target/cucumber.json"}
        //1.'pretty' will be able to see on my console which i executed aka local report/or reference
        //2."html:target/cucumber.html will generate a html report in target folder and the name of this generated html report will be cucumber.html
        //2a.no need to create a folder because this  will autogenerate
        //2b.to open this report, right click on the generated file/Open In/Browser/Chrome
        //2c. reports at every run overwrite each other
        //3.json:target/cucumber.json this is also autogenerate its folder's of report


)

public class TestRunner {
}
