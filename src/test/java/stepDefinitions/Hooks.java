package stepDefinitions;

import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

    public static String strTestCase;
    protected Scenario scenario;

    @Before
    public void getTC(Scenario scene)  {
        this.scenario = scene;
        strTestCase = scenario.getSourceTagNames().toString().replace("@", "");
        Reporter.setTestRunnerOutput("<b>" + strTestCase + "</b>");
        Reporter.setTestRunnerOutput("<br>");
    }

    @After
    public void wrapTC()    {
        Reporter.setTestRunnerOutput("<br>");
    }
}
