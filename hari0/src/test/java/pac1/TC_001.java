package pac1;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.aventstack.extentreports.*;
import com.firstcry.ExtentManager;

import java.net.URL;

public class TC_001 {

    public static void main(String[] args) {
        AndroidDriver<MobileElement> driver = null;
        ExtentReports extent = ExtentManager.getinstance();
        ExtentTest test = extent.createTest("TC_001 - Add & Remove Product Flow");

        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15");
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Nothing Phone (2a)");
            caps.setCapability(MobileCapabilityType.UDID, "000453487000064");
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            caps.setCapability(MobileCapabilityType.NO_RESET, true);

            caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "fc.admin.fcexpressadmin");
            caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "fc.admin.fcexpressadmin.HomeActivity");

            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723"), caps);
            WebDriverWait wait = new WebDriverWait(driver, 20);

            test.log(Status.INFO, "App launched successfully.");

            // Step 1: Close popup
            try {
                MobileElement cross = driver.findElementByAndroidUIAutomator("new UiSelector().description(\"C\")");
                wait.until(ExpectedConditions.elementToBeClickable(cross));
                cross.click();
                test.pass("✅ Cross popup closed successfully!");
            } catch (Exception e) {
                test.info("No Cross popup detected. Continuing...");
            }

            // Step 2: Scroll and click
            MobileElement girlElement = driver.findElementByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))" +
                            ".scrollIntoView(new UiSelector().text(\"SBC_Default_Girl_6to24M_Fashion\"))"
            );
            wait.until(ExpectedConditions.elementToBeClickable(girlElement));
            girlElement.click();
            test.pass("✅ Clicked on SBC_Default_Girl_6to24M_Fashion successfully!");

            // Step 3: Click Baby Cloth
            MobileElement BabyClothElement = driver.findElementByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true))" +
                            ".scrollIntoView(new UiSelector().text(\"Baby Girl Clothesl\"))"
            );
            wait.until(ExpectedConditions.elementToBeClickable(BabyClothElement));
            BabyClothElement.click();
            test.pass("✅ Clicked on BabyCloth successfully!");

            // Step 4: Select 18-24 Months
            MobileElement CategoryElement = driver.findElementByAndroidUIAutomator(
                    "new UiSelector().text(\"18-24 Months\")"
            );
            wait.until(ExpectedConditions.elementToBeClickable(CategoryElement));
            CategoryElement.click();
            test.pass("✅ Clicked on 18-24 Months successfully!");
            Thread.sleep(5000);

            // Step 5: Choose Ethnic Wear
            MobileElement ChooseElement = driver.findElementByAndroidUIAutomator(
                    "new UiSelector().text(\"Ethnic Wear\")"
            );
            wait.until(ExpectedConditions.elementToBeClickable(ChooseElement));
            ChooseElement.click();
            test.pass("✅ Clicked on Ethnic Wear successfully!");
            Thread.sleep(5000);

            // Step 6: Click Product
            MobileElement ProductElement = driver.findElementByAndroidUIAutomator(
                    "new UiSelector().text(\"Titrit\").instance(1)"
            );
            wait.until(ExpectedConditions.elementToBeClickable(ProductElement));
            ProductElement.click();
            test.pass("✅ Clicked on Product successfully!");
            Thread.sleep(5000);

            // Step 7: Add To Cart
            MobileElement AddToCartElement = driver.findElementByAndroidUIAutomator(
                    "new UiSelector().text(\"ADD TO CART\")"
            );
            wait.until(ExpectedConditions.elementToBeClickable(AddToCartElement));
            AddToCartElement.click();
            test.pass("✅ Product added successfully!");
            Thread.sleep(500);

            // Step 8: Go To Cart
            MobileElement GoCartElement = driver.findElementByAndroidUIAutomator(
                    "new UiSelector().text(\"P\")"
            );
            wait.until(ExpectedConditions.elementToBeClickable(GoCartElement));
            GoCartElement.click();
            test.pass("✅ Cart opened successfully!");
            Thread.sleep(10000);

           

        } catch (Exception e) {
            test.fail("❌ Test failed due to: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
            extent.flush();
            System.out.println("📄 Extent Report generated successfully!");
        }
    }
}

