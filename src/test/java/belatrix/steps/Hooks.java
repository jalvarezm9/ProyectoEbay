package belatrix.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
	
	@Before
	public void setUp(Scenario scenario) {
		/*
		 * BD, DATA, etc
		 * */
		//scenario.write("Init scenario");
	}
	 
	@After
	public void tearDown(Scenario scenario) {
		
		//scenario.write("Finished scenario");
		
	//	testContext.getWebDriverManager().resetApp();
	}

}
