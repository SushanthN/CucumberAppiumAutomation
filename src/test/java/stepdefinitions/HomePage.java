package stepdefinitions;

import config.Hooks;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.Home_Screen;

public class HomePage {

    public static AppiumDriver<MobileElement> driver;
    Home_Screen home;

    
    public HomePage()  {
        driver = Hooks.getDriver();
        home = new Home_Screen(driver);
    }


    @Then("^User successfully logs into the app$")
    public void user_successfully_logged_into_app() throws Throwable {
        Assert.assertTrue(home.gethome_button().isDisplayed());
    }


    @Test
    @Given("^User navigates to a profile page$")
    public void user_navigate_to_profile_page() throws Throwable {       
        home.getuser_profile().click();
        Assert.assertTrue(home.gethamburger_button().isDisplayed());
    }

    @Test
    @Given("^User landed to homepage$")
    public void user_landed_to_homepage() throws Throwable {
        Assert.assertTrue(home.gethome_button().isDisplayed());
    }

    @Test
    @When("^A user checks the options available on the home page$")
    public void user_checks_the_options_available_in_home_page() throws Throwable {
        Assert.assertTrue(home.getnews_feed().isDisplayed());
        Assert.assertTrue(home.getnews_feeder_name().isDisplayed());
        Assert.assertTrue(home.getmore_action_on_the_post().isDisplayed());
        Assert.assertTrue(home.getlike_button().isDisplayed());
        Assert.assertTrue(home.getcomment_button().isDisplayed());
        Assert.assertTrue(home.getsend_post().isDisplayed());
        Assert.assertTrue(home.getadd_to_saved().isDisplayed());

    }
}
