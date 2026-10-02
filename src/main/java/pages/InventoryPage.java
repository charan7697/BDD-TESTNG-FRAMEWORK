package pages;

import baseClass.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.configReader;

import java.time.Duration;

public class InventoryPage {
    private final WebDriver driver = DriverFactory.getDriver();
    private final WebDriverWait wait = new WebDriverWait(driver,
            Duration.ofSeconds(Long.parseLong(configReader.get("timeout"))));

    private final By title     = By.className("title");
    private final By cartBadge = By.className("shopping_cart_badge");

    public boolean isLoaded() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(title))
                .getText().equalsIgnoreCase("Products");
    }

    public void addToCart(String productName) {
        By btn = By.xpath("//div[text()='" + productName + "']"
                + "/ancestor::div[@class='inventory_item']//button");
        wait.until(ExpectedConditions.elementToBeClickable(btn)).click();
    }

    public String getCartCount() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge)).getText();
    }
}
