package setup;

import com.microsoft.playwright.*;
import config.TestConfig;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GlobalAuthSetup {
    public static void loginAndSaveState(String Username, String Password, String Outputpath) {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            page.navigate(TestConfig.LOGIN_URL);

            page.fill("#user-name", Username);
            page.fill("#password", Password);
            page.click("#login-button");

            page.waitForURL("**/inventory.html");

            Path path = Paths.get(Outputpath);
            Files.createDirectories(path.getParent());

            context.storageState(new BrowserContext.StorageStateOptions().setPath(path));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
