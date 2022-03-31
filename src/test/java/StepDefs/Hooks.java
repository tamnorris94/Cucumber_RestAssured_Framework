package StepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    @Before()
    public void setUpAPI(Scenario scenario){
        System.out.println("Scenario starting: " + scenario);
    }

    @After()
    public void tearDown(Scenario scenario){
        System.out.println("Scenario ending: " + scenario);
    }
}
