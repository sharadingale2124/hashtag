package pageStepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import actionPages.JobCodePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestContextSetup;

public class JobCodePageStep {

	public TestContextSetup testContextSetup;
	public JobCodePage jobCodePage;
	public String scenario_type;
    public WebDriver driver;
    
	public JobCodePageStep(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;

		jobCodePage = testContextSetup.allPageObject.getJobCodePage();
	}

	@Given("the user is on the join us page")
	public void the_user_is_on_the_join_us_page() throws IOException {
		driver=testContextSetup.TestBase.testBaseManager();
	}

	@When("the user enters the following details in the form:")
	public void the_user_enters_the_following_details_in_the_form(DataTable dataTable) throws InterruptedException {

		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

		System.out.println(data);

		for (Map<String, String> row : data) {
			String name = row.get("NAME");
			String Email = row.get("EMAIL");
			String Phone = row.get("PHONE");
			// String NOTICE = row.get("NOTICE PERIOD");
			// String Experience = row.get("EXPERIENCE");
			String Description = row.get("DESCRIPTION");
			scenario_type = row.get("Scenario");

			jobCodePage.clearFormFields();
			jobCodePage.FillForm(name, Email, Phone, Description);
			
			jobCodePage.uploadResume();
			the_user_submits_the_form_by_clicking_on_the_Apply_Now_button();
			the_form_should_be_submitted_successfully_with_possitive_scenario(scenario_type) ;
			driver.navigate().refresh();
		}

	}

	@And("the user submits the form by clicking on the Apply Now button")
	public void the_user_submits_the_form_by_clicking_on_the_Apply_Now_button() {
		jobCodePage.applyNow();
	}

	@Then("the form should be submitted successfully with possitive scenario {string}")
	public void the_form_should_be_submitted_successfully_with_possitive_scenario(String scenario_type) {
		jobCodePage.formSubmitSuccessValidation(scenario_type);

	}
}
