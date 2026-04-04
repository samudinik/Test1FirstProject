import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AeoTest {

    WebDriver driver;

    @BeforeEach
    void setup() {
        // Setup Chrome driver automatically
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // Implicit wait to handle element loading
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // 1. Navigate to Aeo
        driver.get("https://www.ae.com/");
    }

    @Test
    void testAeoSearch() {



        //2. Find by id
        WebElement appointmentLink = driver.findElement(By.id("ember50"));
        assertEquals("Book a Stylist Appointment", appointmentLink.getText(), "The 'Book a Stylist Appointment' link should be visible on the page.");
    }
    @Test
    void testAeoClick() {


        //2. Find by id
        WebElement appointmentLink = driver.findElement(By.id("ember50"));
        appointmentLink.click();
        WebElement link = driver.findElement(By.linkText("Find an Appointment"));
        assertTrue(link.isDisplayed(), "Find an Appointment' link should be visible on the page.");
    }


    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
