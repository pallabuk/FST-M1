/*Using the Appium inspector and Eclipse, write a TestNG program to perform a multiplication operation between two numbers.
Start by initializing the DesiredCapabilities, as shown below:
deviceName: "<Your device name>"
platformName: "android"
automationName: "UiAutomator2"
appPackage: "com.android.calculator2"
appActivity: ".Calculator"
Initialize the driver object for AndroidDriver() with the Appium server URL/IP address and the desired capabilities.

Next, in the @Test method,

Use the findElement() method to locate a number on the calculator numpad and click it.
Locate the multiplication(*) symbol and click it.
Locate another number on the calculator numpad and click it.
Locate the equal to button and click it.
Finally, locate the view where the final result is shown and get the text in it.
At the end of the method, write an assertion statement to verify your result.*/


package activities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity1 {
    //Driver declaration
    AndroidDriver<MobileElement> driver;

    //Setup Method
    @BeforeClass
    public void setUp() throws MalformedURLException {

        //Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceid", "emulator-5554");
        caps.setCapability("platformName","android");
        caps.setCapability("automationName","UiAutomator2");
        caps.setCapability("appPackage","com.android.calculator2");
        caps.setCapability("appActivity",".Calculator");
        caps.setCapability("noReset",true);

        //Appium Server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        //Driver Initiallization
        driver = new AndroidDriver<>(serverURL, caps);
    }
    @Test
    public void add() {
        // Using resource-id
        driver.findElementById("digit_5").click();
        // Using Accessibility ID
        driver.findElementByAccessibilityId("multiply").click();
        // Using XPath
        driver.findElementByXPath("//android.widget.Button[@text='9']").click();

        // Perform Calculation
        driver.findElementById("eq").click();

        // Display Result
        String result = driver.findElement(MobileBy.id("result")).getText();
        System.out.println(result);

        // Assertion
        Assert.assertEquals(result, "45");
    }

    @AfterClass
    public void tearDown() {
        // Close app
        driver.quit();
    }

}
