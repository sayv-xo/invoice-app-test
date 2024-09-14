package base;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.DarkModePage;
import pages.HomePage;

import java.util.*;

public class BaseTest {

    protected WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    protected HomePage homePage;
    protected DarkModePage darkModePage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        driver.get("https://invoice-app-psi-indol.vercel.app/");
        homePage = new HomePage(driver);
        darkModePage = homePage.darkMode();
    }

//    @AfterClass
//    public void tearDown() {
//        driver.quit();
//    }
}
