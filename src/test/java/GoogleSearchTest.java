import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GoogleSearchTest {

    WebDriver driver;

    @BeforeEach
    void setup() {
        // Setup Chrome driver automatically
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Implicit wait to handle element loading
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    void testGoogleSearch() {
        // 1. Navigate to Google
        driver.get("https://www.google.com");

        // 2. Find the search box (name="q")
        WebElement searchBox = driver.findElement(By.name("q"));

        // 3. Type "Selenium" and press Enter
        searchBox.sendKeys("Selenium automation");
        searchBox.submit();

        // 4. Assert that the title contains the search term
        assertTrue(driver.getTitle().contains("Selenium"), "Title should contain the search term");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
