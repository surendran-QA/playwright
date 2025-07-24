import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LaunchBrowser {
    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser launch = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setChannel("chrome")
        );
        Page page = launch.newPage();
        page.navigate("https://www.google.com/");
        String title = page.title();
        System.out.println("page title:" + title);


        page.close();
        launch.close();
        playwright.close();
    }
}
