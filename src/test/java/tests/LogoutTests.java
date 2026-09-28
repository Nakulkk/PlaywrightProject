package tests;

import base.BaseTest;
import config.TestConfig;
import org.testng.annotations.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LogoutTests extends BaseTest {

    @Test
    public void logout() {
        page.navigate(TestConfig.BASE_URL + "/inventory.html");

        page.locator("#react-burger-menu-btn").click();
        page.locator("#logout_sidebar_link").waitFor();
        page.locator("#logout_sidebar_link").click();

        page.waitForURL("https://www.saucedemo.com/");
        assertThat(page.locator("#login-button")).isVisible();
    }
}