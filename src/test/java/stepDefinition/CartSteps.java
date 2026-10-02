package stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.InventoryPage;

public class CartSteps {
    private InventoryPage inventoryPage;

    @When("user adds {string} to the cart")
    public void addToCart(String product) {
        inventoryPage = new InventoryPage();
        inventoryPage.addToCart(product);
    }

    @Then("cart badge should show {string}")
    public void cartBadgeShows(String count) {
        Assert.assertEquals(inventoryPage.getCartCount(), count);
    }
}
