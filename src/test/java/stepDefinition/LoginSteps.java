package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.InventoryPage;
import pages.LoginPage;

public class LoginSteps {
    private LoginPage loginPage;
    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        loginPage = new LoginPage();
        loginPage.open();
    }
    @When("user logs in with username {string} and password {string}")
    public void user_logs_in_with_username_and_password(String user, String pass) {
        loginPage.login(user, pass);
    }
    @Then("user should land on the products page")
    public void user_should_land_on_the_products_page() {
        Assert.assertTrue(new InventoryPage().isLoaded(), "Products page not displayed");
    }


    @Then("error message should contain {string}")
    public void error_Should_Contain(String expected) {
        String actual = loginPage.getErrorMessage();
        Assert.assertTrue(actual.contains(expected),
                "Expected to contain: " + expected + " but was: " + actual);
    }
}
