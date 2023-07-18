package actionPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JobCodePage {

	public WebDriver driver;

	public JobCodePage(WebDriver driver) {
		this.driver = driver;
	}

	By NAME = By.xpath("//input[@placeholder='Enter your name']");
	By EMAIL = By.cssSelector("input[type='email' ]");
	By PHONE = By.xpath("//input[@name='phone' and @type='number']");
	// By NOTICE_PERIOD = By.xpath("//input[@placeholder='Notice Period (Days)']");
	By EXPERIENCE = By.xpath("//input[@name='experience']");
	By DESCRIPTION = By.cssSelector("textarea[name='description']");
	By APPLY_NOW = By.xpath("//button[text()='APPLY NOW']");
	By UPLOAD_FILE = By.cssSelector("input#inputFile");
	// By successMessage=By.xpath("//h4[text()='Application Submitted
	// Successfully.']");
	By NotSuccessMessage = By.xpath("//p[text()='something went wrong! please try again later']");

	public void FillForm(String name, String Email, String Phone, String Description) {
		driver.findElement(NAME).sendKeys(name);
		driver.findElement(EMAIL).sendKeys(Email);
		driver.findElement(PHONE).sendKeys(Phone);
		// driver.findElement(NOTICE_PERIOD).sendKeys(Notice);
		// driver.findElement(EXPERIENCE).sendKeys(Experience);
		driver.findElement(DESCRIPTION).sendKeys(Description);
	}

	/*
	 * public void clearFormFields() { driver.findElement(NAME).clear();
	 * driver.findElement(EMAIL).clear(); driver.findElement(PHONE).clear(); //
	 * driver.findElement(NOTICE_PERIOD).sendKeys(Notice).clear(); //
	 * driver.findElement(EXPERIENCE).sendKeys(Experience).clear();
	 * driver.findElement(DESCRIPTION).clear(); }
	 */

	public void clearFormFields() {
		WebElement nameField = driver.findElement(NAME);
		nameField.sendKeys(Keys.CONTROL + "a");
		nameField.sendKeys(Keys.BACK_SPACE);

		WebElement emailField = driver.findElement(EMAIL);
		emailField.sendKeys(Keys.CONTROL + "a");
		emailField.sendKeys(Keys.BACK_SPACE);

		WebElement phoneField = driver.findElement(PHONE);
		phoneField.sendKeys(Keys.CONTROL + "a");
		phoneField.sendKeys(Keys.BACK_SPACE);

		WebElement descriptionField = driver.findElement(DESCRIPTION);
		descriptionField.sendKeys(Keys.CONTROL + "a");
		descriptionField.sendKeys(Keys.BACK_SPACE);
	}

	public void uploadResume() {
		driver.findElement(UPLOAD_FILE)
				.sendKeys(System.getProperty("user.dir") + "\\src\\test\\Upload File\\upload me");

	}

	public void applyNow() {
		driver.findElement(APPLY_NOW).click();
	}

	public void formSubmitSuccessValidation(String scenario_type) {
		// WebElement successMassage=driver.findElement(successMessage);
		// String Actual_msg= successMassage.getText();
		WebElement notSuccessMessage = driver.findElement(NotSuccessMessage);
		String Actual_msg = notSuccessMessage.getText();
		String Expected = "Application Submitted Successfully.";
		boolean result = Actual_msg.contains(Expected);
		if (result == true && scenario_type.contains("Possitive")) {
			System.out.println("test  pass :" + Actual_msg +" " + scenario_type);
		} else if(result == true && scenario_type.contains("Negative")){
			System.err.println("test  Fail :" + "From not submitted" +" "+ scenario_type);
        }else if(result == false && scenario_type.contains("Possitive")){
			System.err.println("test  Fail :" + "From not submitted" +" "+ scenario_type);
        }else if(result == false && scenario_type.contains("Negative")){
			System.out.println("test  pass :" + "From not submitted" +" "+ scenario_type);
        }
	}

}
