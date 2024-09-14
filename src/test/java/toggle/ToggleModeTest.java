package toggle;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.Color;

import static org.testng.Assert.assertTrue;

public class ToggleModeTest extends BaseTest {
    private String darkModeClass = "dark-mode";
    private String darkModeColorBackgroundColor = "#141625";
    private String lightModeClass = "light-mode";
    private String lightModeColorBackgroundColor = "#f8f8fb";

    // app intially starts with light mode
    @Test
    public void testDarkMode() {
        this.toggleDarkMode();
        verifyMode(darkModeClass, darkModeColorBackgroundColor);
    }

    @Test
    public void testSwitchToLightMode() {
        darkModePage.clickLightMode();
        verifyMode(lightModeClass, lightModeColorBackgroundColor);
    }

    @Test
    public void testToggleModePersist() {
        this.toggleDarkMode();
        driver.navigate().refresh();
        verifyMode(darkModeClass, darkModeColorBackgroundColor);
    }

    private void verifyMode(String expectedClass, String expectedBackgroundColor) {
        String bodyClass = darkModePage.getModeClass();
        String backgroundColor = Color.fromString(darkModePage.getModeColour()).asHex();

        assertTrue(bodyClass.contains(expectedClass), "Body class should be " + expectedClass);
        Assert.assertEquals(expectedBackgroundColor, backgroundColor, "Background color should be " + expectedBackgroundColor);
    }

    public void toggleDarkMode() {
        darkModePage.clickDarkMode();
    }
}
