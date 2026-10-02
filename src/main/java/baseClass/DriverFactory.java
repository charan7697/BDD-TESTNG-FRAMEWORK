package baseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utilities.configReader;

import java.time.Duration;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver() {
        String browser = configReader.get("browser").toLowerCase();
        boolean headless = Boolean.parseBoolean(configReader.get("headless"));

        switch (browser) {
            case "firefox" -> {
                FirefoxOptions fo = new FirefoxOptions();
                if (headless) fo.addArguments("-headless");
                driver.set(new FirefoxDriver(fo));
            }
            case "edge" -> driver.set(new EdgeDriver());
            default -> {
                ChromeOptions co = new ChromeOptions();
                co.addArguments("--start-maximized", "--disable-notifications");
                if (headless) co.addArguments("--headless=new", "--window-size=1920,1080",
                        "--no-sandbox", "--disable-dev-shm-usage");
                driver.set(new ChromeDriver(co));
            }
        }
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
