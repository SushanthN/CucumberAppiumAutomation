package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Base {

	protected Properties prop;

	protected FileInputStream base_file = new FileInputStream(
			System.getProperty("user.dir") + "/src/test/resources/data.properties");

	protected FileInputStream android_file = new FileInputStream(
			System.getProperty("user.dir") + "/src/test/resources/android_data.properties");

	protected FileInputStream ios_file = new FileInputStream(
			System.getProperty("user.dir") + "/src/test/resources/ios_data.properties");

	public 	Base() throws IOException {
		prop = new Properties();
		prop.load(base_file);
		prop.load(android_file);
		prop.load(ios_file);
	}



	public String getUsername() {
		return prop.getProperty("username");
	}

	public String getPassword() {
		return prop.getProperty("password");
	}
	
	public String getNativeView() {
		return prop.getProperty("native");
	}

	public String getWebView() {
		return prop.getProperty("web");
	}
	
	public String getappName() {
		return (String) prop.get("appname");
	}
	
	public String getdeviceName() {
		return prop.getProperty("deviceName");
	}
	
	public String getappPackage() {
		return prop.getProperty("appPackage");
	}

	public String getappActivity() {
		return prop.getProperty("appActivity");
	}


	public String getautomationName() {
		return prop.getProperty("automationName");
	}



	public String getandroid_deviceName() {
		return prop.getProperty("android_deviceName");
	}

	public String getiOS_deviceName() {
		return prop.getProperty("iOS_deviceName");
	}


	public String getandroid_automationName() {
		return prop.getProperty("android_automationName");
	}

	public String getiOS_automationName() {
		return prop.getProperty("iOS_automationName");
	}

	public String getRunningPlatformName() {
		return prop.getProperty("runningPlatform");
	}

	public String getAndroidAppId() {
		return prop.getProperty("android_appId");
	}

	public String getiOSAppId() {
		return prop.getProperty("ios_appId");
	}

	public String getDeviceLanguageFromProps() {
		return prop.getProperty("deviceLanguage");
	}

	public String getAndroidBuildName() {
		return prop.getProperty("android_buildName");
	}

	public String getiOSBuildName() {
		return prop.getProperty("ios_buildName");
	}

	public String getOSname() {
		return prop.getProperty("os");
	}



	public String getxcodeSigningId() {
		return prop.getProperty("xcodeSigningId");
	}

	public String getUdid() {
		return prop.getProperty("udid");
	}

	public String getbundleId() {
		return prop.getProperty("bundleId");
	}




}
