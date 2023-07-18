package pageObjectsFactory;

import org.openqa.selenium.WebDriver;

import actionPages.JobCodePage;

public class AllPageObjects {
	
	public WebDriver driver;
	public JobCodePage jobCodePage;
	
	public AllPageObjects(WebDriver driver) {
		this.driver=driver;
	}
	public JobCodePage getJobCodePage() {
		jobCodePage=new JobCodePage(driver);
		return jobCodePage;
	}
	
	
	
	
}
