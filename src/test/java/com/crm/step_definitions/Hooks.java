package com.crm.step_definitions;

import com.crm.utilities.ConfigurationReader;
import com.crm.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

/*@Before
public void setUp(){
    String url=ConfigurationReader.getProperty("web.url");

    Driver.getDriver().get(url);

}*/
    @After
    public void closeDriver(){
        Driver.closeDriver();
    }
}
