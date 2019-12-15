package belatrix.runner;

import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import belatrix.manager.DriverManager;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"belatrix/steps"},
        tags = {"@End2End"},
        monochrome = true,
        plugin  = {
                "pretty",
                "html:cucumber-reports/cucumber-pretty",
                "json:cucumber-reports/CucumberTestReport.json",
                "rerun:cucumber-reports/rerun.txt"
        })
@RunWith(Cucumber.class)
public class TestRunner {
	
	private static WebDriver driver;
	
	@BeforeClass
	public static void inicioEscenarios(){
		
		System.setProperty("webdriver.chrome.driver", "C:\\ProgramasWD\\chromedriver.exe");	
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		DriverManager.setDriver(driver);
	}
	
	@AfterClass
	public static void finEscenarios(){
		driver.close();
		
	}


}



