package setup;

import config.TestConfig;
import org.testng.annotations.BeforeSuite;

public class GlobalSetupTestNG {

    @BeforeSuite
    public void globalSetup() {
        GlobalAuthSetup.loginAndSaveState(
                TestConfig.USERNAME,
                TestConfig.PASSWORD,
                TestConfig.USER_STATE);
    }
}