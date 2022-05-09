/*Write a script to perform the following actions:

Open the SMS application
Click the "Create New Message" button to write a new SMS.
Locate the contact fields and enter your own phone number to send a message to your own phone number.
Locate the message input field and enter the message "Hello from Appium".
Locate the send button and click it.
Write an assertion to verify that the message has been sent successfully.  */


package activities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity5 {
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
}
