package ui.view;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class TestSearchBedrag {

    WebDriver driver;
    String url = "http://localhost:8080/lauwers_ernest_war_exploded/";

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url + "Controller?command=home");
    }

    @After
    public void clean() {
        driver.quit();
    }

    @Test
    public void test_Form_is_shown_If_zoek_button_is_clicked() {
        driver.findElement(By.xpath("/html/body/nav/ul/li[4]/a")).click();
        assertEquals("Zoek", driver.getTitle());
    }

    @Test
    public void test_Form_is_shown_again_with_error_message_If_search_field_is_empty() {
        driver.findElement(By.xpath("/html/body/nav/ul/li[4]/a")).click();
        assertEquals("Zoek", driver.getTitle());
        WebElement naamInput = driver.findElement(By.id("naamZ"));
        naamInput.clear();
        naamInput.sendKeys("");

        driver.findElement(By.id("submit")).click();

        assertEquals("Zoek", driver.getTitle());
        ArrayList<WebElement> ps = (ArrayList<WebElement>) driver.findElements(By.tagName("p"));
        assertTrue(containsWebElementsWithText(ps, "De naam mag niet leeg zijn."));
    }

    @Test
    public void test_Search_results_is_shown_If_search_field_is_filled_out_correctly_with_existing_name() {
        driver.findElement(By.xpath("/html/body/nav/ul/li[4]/a")).click();
        assertEquals("Zoek", driver.getTitle());
        WebElement naamInput = driver.findElement(By.id("naamZ"));
        naamInput.clear();
        naamInput.sendKeys("Ernest");

        driver.findElement(By.id("submit")).click();

        assertEquals("Zoek", driver.getTitle());
        ArrayList<WebElement> tds = (ArrayList<WebElement>) driver.findElements(By.tagName("td"));
        assertTrue(containsWebElementsWithText(tds, "Ernest"));
    }

    @Test
    public void test_Search_results_is_shown_If_search_field_is_filled_out_correctly_with_non_existing_name() {
        driver.findElement(By.xpath("/html/body/nav/ul/li[4]/a")).click();
        assertEquals("Zoek", driver.getTitle());
        WebElement naamInput = driver.findElement(By.id("naamZ"));
        naamInput.clear();
        naamInput.sendKeys("Steven");

        driver.findElement(By.id("submit")).click();

        assertEquals("Zoek", driver.getTitle());
        ArrayList<WebElement> ps = (ArrayList<WebElement>) driver.findElements(By.tagName("p"));
        assertTrue(containsWebElementsWithText(ps, "Er zijn geen bedragen op deze naam gevonden."));
    }

    private boolean containsWebElementsWithText(ArrayList<WebElement> elements, String text) {
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getText().equals(text)) {
                return true;
            }
        }
        return false;
    }
}