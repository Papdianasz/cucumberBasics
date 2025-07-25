package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import io.cucumber.java.Scenario;
import utils.CommonMethods;

public class Hooks extends CommonMethods {

    @Before
    public void start(){
        openBrowserAndLaunchApplication();
    }

    @After
    public void end(Scenario scenario){
        byte[] pic; //it is a return type method take screenshot
        if (scenario.isFailed()){
            pic=takeScreenshot("failed/"+scenario.getName());
        }else {
            pic =takeScreenshot("passed/"+scenario.getName());
        }
        scenario.attach(pic,"image/png",scenario.getName());

        //in this code no matter the TC is passed or failed, screenshot will be taken anyway before closing the browser

        //driver.quit();
        closeBrowser();
    }

}

//@Before and @After are pre and post conditions
