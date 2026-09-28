package tests;

import base.BaseTest;
import config.TestConfig;
import org.testng.annotations.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DashbordTests extends BaseTest {

    @Test
    public void userIsloggedInWithoutLogin() {
        page.navigate(TestConfig.BASE_URL + "/inventory.html");
        assertThat(page).hasURL("https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void verifyDashboardElementsAreVisible() {
        page.navigate(TestConfig.BASE_URL + "/inventory.html");
        assertThat(page.locator(".title")).hasText("Products");
    }
}