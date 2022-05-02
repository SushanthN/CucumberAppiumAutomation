package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Home_Screen {

	AppiumDriver<MobileElement> driver;
	By tab_bar = By.id("com.instagram.android:id/tab_bar");
	By home_button = MobileBy.AccessibilityId("Home");
	By search_and_explore_button = MobileBy.AccessibilityId("Search and Explore");
	By camera_on_tab_bar = By.xpath("//android.widget.Button[@content-desc=\"Camera\"]");
	By user_profile = MobileBy.AccessibilityId("Profile");
	By activity_button = MobileBy.AccessibilityId("Activity");
	By news_feed = MobileBy.AccessibilityId("Image");
	By like_button = MobileBy.AccessibilityId("Like");
	By comment_button = MobileBy.AccessibilityId("Comment");
	By send_post = MobileBy.AccessibilityId("Send Post");
	By add_to_saved = MobileBy.AccessibilityId("Add to saved");
	By more_action_on_the_post = MobileBy.AccessibilityId("More actions for this post");
	By news_feeder_name = By.id("com.instagram.android:id/row_feed_photo_profile_name");
	By hamburger_button = MobileBy.AccessibilityId("Options");
	By profile_title_container=By.id("com.instagram.android:id/action_bar_textview_custom_title_container");
	By profile_setting_button=By.id("com.instagram.android:id/menu_settings_row");
	By edit_profile_button=By.id("com.instagram.android:id/profile_header_actions_top_row");
	By profile_full_name=By.id("com.instagram.android:id/profile_header_full_name");



	public Home_Screen(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}

	public WebElement gettab_bar() {
		return driver.findElement(tab_bar);
	}
	
	public WebElement getnews_feeder_name() {
		return driver.findElement(news_feeder_name);
	}
	
	public WebElement getnews_feed() {
		return driver.findElement(news_feed);
	}
	
	public WebElement getmore_action_on_the_post() {
		return driver.findElement(more_action_on_the_post);
	}
	
	public WebElement getadd_to_saved() {
		return driver.findElement(add_to_saved);
	}
	
	public WebElement getsend_post() {
		return driver.findElement(send_post);
	}
	
	public WebElement getcomment_button() {
		return driver.findElement(comment_button);
	}
	
	public WebElement getlike_button() {
		return driver.findElement(like_button);
	}

	public WebElement gethome_button() {
		return driver.findElement(home_button);
	}

	public WebElement getsearch_and_explore_button() {
		return driver.findElement(search_and_explore_button);
	}

	public WebElement getcamera_on_tab_bar() {
		return driver.findElement(camera_on_tab_bar);
	}

	public WebElement getuser_profile() {
		return driver.findElement(user_profile);
	}

	public WebElement getactivity_button() {
		return driver.findElement(activity_button);
	}

	public WebElement gethamburger_button()
	{
		return driver.findElement(hamburger_button);
	}

}
