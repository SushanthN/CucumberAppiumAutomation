package config;


import com.google.common.collect.ImmutableMap;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import base.Base;
import org.testng.annotations.AfterSuite;
import utils.AppiumServer;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class Hooks extends Base {


	private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

	public Hooks() throws IOException {
		super();
	}


	@Before
	public void chooseRunningPlatform() throws IOException, InterruptedException {

		String runningPlatform = getRunningPlatformName();
		String os = getOSname();
		System.out.println("Running Platform is " + runningPlatform);
		System.out.println("Running OS is " + os);

		if (runningPlatform.equalsIgnoreCase("device")) {
			if (os.equalsIgnoreCase("Android")) {
				android_setupAppium();
			} else if (os.equalsIgnoreCase("iOS")) {
				iOS_setupAppium();
			}

		}
		System.out.println("Caps are set.............");
		driver.get().manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
	}



	public void android_setupAppium() throws InterruptedException {

		AppiumServer.start();
		File appDir = new File("src/App/");
		File app = new File(appDir, getappName());
		URL url;
		try {
			url = new URL("http://127.0.0.1:4723/wd/hub");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, getdeviceName());
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, getautomationName());
			capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
			capabilities.setCapability("autoGrantPermissions", true);
			driver.set(new AndroidDriver(url, capabilities));
			System.out.println("caps are set.............");

		} catch (Exception exp) {
			System.out.println("!Cause is :" + exp.getCause());
			System.out.println("Message is :.." + exp.getMessage());
			exp.printStackTrace();
		}
	}

	public void iOS_setupAppium() throws InterruptedException {

		AppiumServer.start();
		URL url;
		try {
			url = new URL("http://0.0.0.0:4723/wd/hub");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, getiOS_deviceName());
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, getiOS_automationName());
		//	capabilities.setCapability(IOSMobileCapabilityType.XCODE_ORG_ID, getxcodeOrgId());
		//	capabilities.setCapability(IOSMobileCapabilityType.XCODE_SIGNING_ID, getxcodeSigningId());
			capabilities.setCapability(MobileCapabilityType.UDID, getUdid());
			capabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, getbundleId());
			capabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
			capabilities.setCapability("autoAcceptAlerts", true);
			capabilities.setCapability("autoGrantPermissions", true);
			capabilities.setCapability("noReset", true);
			driver.set(new IOSDriver<>(url, capabilities))  ;

			//driver.installApp()
		} catch (Exception exp) {
			System.out.println("!Cause is :" + exp.getCause());
			System.out.println("Message is :.." + exp.getMessage());
			exp.printStackTrace();
		}
	}


	public static AppiumDriver<MobileElement> getDriver() {

		return driver.get();
	}


	@AfterSuite
	public void tearDown() {
//      android_driver.quit();
		AppiumServer.stop(getDriver());
		System.out.println("Appium server stopped");
	}

}
