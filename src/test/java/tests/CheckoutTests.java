package tests;

import base.BaseTest;
import config.TestConfig;
import org.testng.annotations.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CheckoutTests extends BaseTest {

    @Test
    public void userCanNavigateToCheckout() {
        page.navigate(TestConfig.BASE_URL + "/inventory.html");


        page.locator("#add-to-cart-sauce-labs-backpack").click();
        page.locator(".shopping_cart_link").click();
        assertThat(page).hasURL(TestConfig.BASE_URL + "/cart.html");

        page.locator("#checkout").click();
        assertThat(page).hasURL(TestConfig.BASE_URL + "/checkout-step-one.html");
    }

    @Test
    public void completeCheckoutProcess() {
        page.navigate(TestConfig.BASE_URL + "/inventory.html");

        page.locator("#add-to-cart-sauce-labs-backpack").click();
        page.locator(".shopping_cart_link").click();
        page.locator("#checkout").click();

        page.getByPlaceholder("First Name").fill("Nakul");
        page.getByPlaceholder("Last Name").fill("Kapre");
        page.getByPlaceholder("Zip/Postal Code").fill("767676");
        page.locator("#continue").click();

        assertThat(page).hasURL(TestConfig.BASE_URL + "/checkout-step-two.html");

        page.getByText("Finish").click();
        assertThat(page).hasURL(TestConfig.BASE_URL + "/checkout-complete.html");
        assertThat(page.locator(".complete-header")).hasText("Thank you for your order!");
    }
}