package utils;

import java.io.IOException;

import pageObjectsFactory.AllPageObjects;
import pageStepDefinitions.Hooks;

public class TestContextSetup {

	public TestBase TestBase ;
	public AllPageObjects allPageObject;
	public Hooks hooks;

	
	public TestContextSetup() throws IOException {
 
		TestBase = new TestBase ();
		allPageObject=new AllPageObjects(TestBase.testBaseManager());
	
}
}