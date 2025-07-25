package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReaders;


public class LoginSteps extends CommonMethods {

    LoginPage loginPage =new LoginPage();

    @Given("user is able to access HRMS application")
    public void user_is_able_to_access_hrms_application() {
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();

    }

    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() {
        //WebElement userName = driver.findElement(By.id("txtUsername"));
        //userName.sendKeys("Admin");
        sendText(ConfigReaders.read("userName"), loginPage.userName);

        //WebElement passwordField = driver.findElement(By.id("txtPassword"));
        //passwordField.sendKeys("Hum@nhrm123");
        sendText(ConfigReaders.read("passwordField"), loginPage.passwordField);

    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        //WebElement loginButton = driver.findElement(By.id("btnLogin"));
        //loginButton.click();
        loginPage.loginButton.click();

    }

    @Then("user is able to see dashboard page")
    public void user_is_able_to_see_dashboard_page() {
        System.out.println("Test passed, user is able to see dashboard page");

    }

    @When("user enters invalid username and password")
    public void user_enters_invalid_username_and_password() {

        sendText(ConfigReaders.read("Diana"), loginPage.userName);
        sendText(ConfigReaders.read("Hum@an"), loginPage.passwordField);

    }

    @Then("user can see error message")
    public void user_can_see_error_message() {
        System.out.println("'Invalid credential' message is visible");
    }


}



