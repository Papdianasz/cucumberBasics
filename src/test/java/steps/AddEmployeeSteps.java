package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.AddEmployeePage;
import utils.ExcelReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import utils.CommonMethods;


public class AddEmployeeSteps extends CommonMethods {

    AddEmployeePage addEmployeePage = new AddEmployeePage();

    @When("user clicks on om PIM option")
    public void user_clicks_on_om_pim_option() {
        //WebElement pim = driver.findElement(By.id("menu_pim_viewPimModule"));
        //pim.click();
        addEmployeePage.menu_pim_viewPimModule.click();
    }

    @When("user clicks on Add employee option")
    public void user_clicks_on_add_employee_option() {
       // WebElement addEmp = driver.findElement(By.id("menu_pim_addEmployee"));
        //addEmp.click();
        addEmployeePage.menu_pim_addEmployee.click();
    }

    @When("user enters firstname and lastname")
    public void user_enters_firstname_and_lastname() {
        //WebElement firstName = driver.findElement(By.id("firstName"));
        //WebElement lastName = driver.findElement(By.id("lastName"));
        //firstName.sendKeys("Diana");
        //lastName.sendKeys("Priest");
        sendText("Diana", addEmployeePage.firstName);
        sendText("Priest", addEmployeePage.lastName);

    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        //WebElement saveBTN = driver.findElement(By.xpath("//input[@value='Save']"));
        //saveBTN.click();
        addEmployeePage.saveButton.click();
    }

    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("Employee added successfully");
    }

    @When("user enters firstname and middlename and lastname")
    public void user_enters_firstname_and_middlename_and_lastname() {
        //WebElement firstName = driver.findElement(By.id("firstName"));
        //WebElement middleName = driver.findElement(By.id("middleName"));
        //WebElement lastName = driver.findElement(By.id("lastName"));
        //firstName.sendKeys("Diana");
        //middleName.sendKeys("Szabina");
        //lastName.sendKeys("Papp");
        sendText("Diana",addEmployeePage.firstName);
        sendText("Szabina",addEmployeePage.middleName);
        sendText("Papp",addEmployeePage.lastName);
    }

    @When("user enters {string} and {string} and {string} in the application")
    public void user_enters_and_and_in_the_application(String firstName1, String middleName1, String lastName1) {
        /*WebElement firstName = driver.findElement(By.id("firstName"));
        WebElement middleName= driver.findElement(By.id("middleName"));
        WebElement lastName = driver.findElement(By.id("lastName"));
        firstName.sendKeys(firstName1);
        middleName.sendKeys(middleName1);
        lastName.sendKeys(lastName1);*/
        sendText(firstName1, addEmployeePage.firstName);
        sendText(middleName1, addEmployeePage.middleName);
        sendText(lastName1, addEmployeePage.lastName);

    }

    @When("user add {string} , {string} , {string}")
    public void user_add(String fn, String mn, String ln) {
        /*WebElement firstName = driver.findElement(By.id("firstName"));
        WebElement middleName= driver.findElement(By.id("middleName"));
        WebElement lastName = driver.findElement(By.id("lastName"));
        firstName.sendKeys(fn);
        middleName.sendKeys(mn);
        lastName.sendKeys(ln);
        */
        sendText(fn, addEmployeePage.firstName);
        sendText(mn, addEmployeePage.middleName);
        sendText(ln, addEmployeePage.lastName);
    }

    @When("users adds multiple employees using data table and save them")
    public void users_adds_multiple_employees_using_data_table_and_save_them(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> employeeNames=dataTable.asMaps();
        for (Map<String, String> employee : employeeNames) {
            /*WebElement firstName = driver.findElement(By.id("firstName"));
            WebElement middleName= driver.findElement(By.id("middleName"));
            WebElement lastName = driver.findElement(By.id("lastName"));*/

            addEmployeePage.firstName.sendKeys(employee.get("firstName"));
            addEmployeePage.middleName.sendKeys(employee.get("middleName"));
            addEmployeePage.lastName.sendKeys(employee.get("lastName"));


            WebElement saveBTN = driver.findElement(By.xpath("//input[@value='Save']"));
            //saveBTN.click();
            //click(saveBTN);
            addEmployeePage.saveButton.click();

            WebElement addEmp = driver.findElement(By.id("menu_pim_addEmployee"));
            //addEmp.click();
            //click(addEmp);
            addEmployeePage.menu_pim_addEmployee.click();

        }

    }

    @When("user adds multiple employees from excel file")
    public void user_adds_multiple_employees_from_excel_file() throws IOException, FileNotFoundException {
        List<Map<String,String>> newEmp = ExcelReader.read();
        for (Map<String, String> employee : newEmp) {
           /* WebElement firstName = driver.findElement(By.id("firstName"));
            WebElement middleName= driver.findElement(By.id("middleName"));
            WebElement lastName = driver.findElement(By.id("lastName"));*/

            addEmployeePage.firstName.sendKeys(employee.get("firstName"));
            addEmployeePage.middleName.sendKeys(employee.get("middleName"));
            addEmployeePage.lastName.sendKeys(employee.get("lastName"));


            WebElement saveBTN = driver.findElement(By.xpath("//input[@value='Save']"));
            //saveBTN.click();
            //click(saveBTN);
            addEmployeePage.saveButton.click();

            WebElement addEmp = driver.findElement(By.id("menu_pim_addEmployee"));
            //addEmp.click();
            //click(addEmp);
            addEmployeePage.menu_pim_addEmployee.click();

        }

    }

}
