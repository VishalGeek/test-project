import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Calculator {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        // TODO Auto-generated method stub


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "6.0");
        capabilities.setCapability("appPackage", "com.boondoggle.mortcalc");
        capabilities.setCapability("appActivity", "com.boondoggle.mortcalc.MortCalc");


        AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
        Thread.sleep(3000);

        String Expected = "$355.95";

        driver.findElementById("com.boondoggle.mortcalc:id/var_amount").clear();
        driver.findElementById("com.boondoggle.mortcalc:id/var_amount").sendKeys("20000");
        driver.findElementById("com.boondoggle.mortcalc:id/var_years").sendKeys("5");
        driver.findElementById("com.boondoggle.mortcalc:id/var_interest").sendKeys("2.5");
        driver.findElementById("com.boondoggle.mortcalc:id/buttoncalc").click();
        String output = driver.findElementById("com.boondoggle.mortcalc:id/var_mortgage").getText();

        System.out.println(output);

        if (Expected.equals(output))
        {

            System.out.println("Testcase PASSED");
        }else
        {
            System.out.println("Testcase FAILED");
        }

        //driver.quit();

    }

}

