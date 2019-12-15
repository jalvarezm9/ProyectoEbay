package belatrix.manager;

import org.openqa.selenium.WebDriver;


public class DriverManager {
	
    private static WebDriver driver;
    
    public static void setDriver(WebDriver driverx) {
        driver = driverx;
    }

    public static WebDriver getDriver() {
        return driver;
    }

}
