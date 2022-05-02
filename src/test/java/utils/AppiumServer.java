package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;

public class AppiumServer {

    public static AppiumDriverLocalService service;

    public static void start() {

        // starting the Appium server code

        service=AppiumDriverLocalService.buildService(
                new AppiumServiceBuilder().usingDriverExecutable(new File(System.getProperty("user.dir") + "\\src\\test\\java\\Drivers\\node.exe"))
                        .withLogFile(new File(System.getProperty("user.dir") + "\\src\\test\\resources\\logs\\log.txt"))
                        .withArgument(GeneralServerFlag.SESSION_OVERRIDE));
        service.start();
        if (service == null || !service.isRunning()) {
            throw new AppiumServerHasNotBeenStartedLocallyException("An appium server node is not started!");
        }

    }


    public static void startServer_cmd() {
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("cmd.exe /c start cmd.exe /k \"appium -a 127.0.0.1 -p 4723 --session-override \"");
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void stop(AppiumDriver driver) {

        if (driver != null) {
            driver.quit();
        }
        if (service!= null) {
            service.stop();
        }

    }

}
