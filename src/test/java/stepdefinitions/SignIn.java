package stepdefinitions;

import base.Base;
import config.Hooks;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import screens.Signin_Screen;
import utils.CommonMethods;
import utils.Utilities;

import java.io.IOException;

public class SignIn extends Base implements Signin_Screen{

    public static AppiumDriver<MobileElement> driver;
    public CommonMethods common;
    public SignIn() throws IOException {
        driver= Hooks.getDriver();
        common = new CommonMethods(driver);

    }


    @Given("^User open the Instagram application$")
    public void user_open_insta_page_and_login_to_app() throws Throwable {
        common.clickAndroidElement(login);
        System.out.println("User is in:" + driver.getContext());

    }

    @When("^Login with Facebook account$")
    public void proceed_with_login() throws Throwable {
        Utilities utilities = new Utilities(driver);
        common.clickAndroidElement(Signin_Screen.login_with_facebook);
        common.enterText(Signin_Screen.user_name_using_fb, getUsername());
        common.enterText(Signin_Screen.password_using_fb, getPassword());
        common.clickAndroidElement(Signin_Screen.login_using_fb);
        common.clickAndroidElement(Signin_Screen.fb_login_confirmation_button);
        utilities.switchcontext(getNativeView());
    }
}
