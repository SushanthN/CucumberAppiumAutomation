package screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface Signin_Screen {



	By login=By.id("com.instagram.android:id/log_in_button");
	By Create_new_account=By.id("com.instagram.android:id/sign_up_with_email_or_phone");
	By language_selector=By.id("com.instagram.android:id/language_selector_button");
	By login_with_facebook=By.id("com.instagram.android:id/login_facebook_container");
	By user_name_using_fb=By.id("m_login_email");
	By password_using_fb=By.id("m_login_password");
	By login_using_fb=By.id("u_0_4");
	By alert_accept=By.xpath("//*[@data-cookiebanner='accept_button']");
	//	By alert_accept=By.xpath("//*[@type='submit']");
	//By alert_accept=By.id("u_0_g");
	By fb_login_confirmation_button=By.xpath("//*[@type='submit']");

//	public Signin_Screen(AndroidDriver<AndroidElement> driver) {
//		this.driver= driver;
//	}
//
//
//	public WebElement getlogin_with_facebook()
//	{
//		return driver.findElement(login_with_facebook);
//	}
//
//	public WebElement getalert_accept()
//	{
//		return driver.findElement(alert_accept);
//	}
//
//	public WebElement getfb_login_confirmation_button()
//	{
//		return driver.findElement(fb_login_confirmation_button);
//	}
//
//	public WebElement getuser_name_using_fb()
//	{
//		return driver.findElement(user_name_using_fb);
//	}
//
//	public WebElement getpassword_using_fb()
//	{
//		return driver.findElement(password_using_fb);
//	}
//
//	public WebElement getlogin_using_fb()
//	{
//		return driver.findElement(login_using_fb);
//	}
//
//	public WebElement getLogin()
//	{
//		return driver.findElement(login);
//	}
//
//	public WebElement getlanguage_selector()
//	{
//		return driver.findElement(language_selector);
//	}
//
//	public WebElement getCreate_new_account()
//	{
//		return driver.findElement(Create_new_account);
//	}

}
