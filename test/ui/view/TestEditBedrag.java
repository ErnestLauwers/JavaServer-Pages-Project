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

public class TestEditBedrag {

    WebDriver driver;
    String url = "http://localhost:8080/lauwers_ernest_war_exploded/";

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url + "Controller?command=overzicht");
    }

    @After
    public void clean() {
        driver.quit();
    }

    @Test
    public void test_Form_is_shown_If_wijzig_button_is_clicked() {
        driver.findElement(By.className("knopWijzig")).click();
        assertEquals("Wijzig", driver.getTitle());
        ArrayList<WebElement> h2s = (ArrayList<WebElement>) driver.findElements(By.tagName("h2"));
        assertTrue(containsWebElementsWithText(h2s, "Wijzigen"));
    }

    @Test
    public void test_Form_is_shown_again_with_error_messages_If_all_fields_are_empty() {
        driver.findElement(By.className("knopWijzig")).click();
        assertEquals("Wijzig", driver.getTitle());
        WebElement naamInput = driver.findElement(By.id("naam"));
        naamInput.clear();
        naamInput.sendKeys("");

        WebElement activiteitInput = driver.findElement(By.id("activiteit"));
        activiteitInput.clear();
        activiteitInput.sendKeys("");

        WebElement aantalInput = driver.findElement(By.id("aantal"));
        aantalInput.clear();
        aantalInput.sendKeys("");

        WebElement datumInput = driver.findElement(By.id("datum"));
        datumInput.clear();
        datumInput.sendKeys("");

        driver.findElement(By.id("submit")).click();

        assertEquals("Wijzig", driver.getTitle());
        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebElementsWithText(lis, "De naam mag niet leeg zijn."));
        assertTrue(containsWebElementsWithText(lis, "Activiteit mag niet leeg zijn."));
        assertTrue(containsWebElementsWithText(lis, "Het aantal euro mag niet leeg zijn."));
        assertTrue(containsWebElementsWithText(lis, "Datum mag niet leeg zijn."));
    }

    @Test
    public void test_Overview_is_shown_If_all_fields_are_filled_out_correctly() {
        driver.findElement(By.className("knopWijzig")).click();
        assertEquals("Wijzig", driver.getTitle());
        WebElement naamInput = driver.findElement(By.id("naam"));
        naamInput.clear();
        naamInput.sendKeys("Ernest");

        WebElement activiteitInput = driver.findElement(By.id("activiteit"));
        activiteitInput.clear();
        activiteitInput.sendKeys("winkel");

        WebElement aantalInput = driver.findElement(By.id("aantal"));
        aantalInput.clear();
        aantalInput.sendKeys("5");

        WebElement datumInput = driver.findElement(By.id("datum"));
        datumInput.clear();
        datumInput.sendKeys("12/01/2022");

        driver.findElement(By.id("submit")).click();

        assertEquals("Overzicht", driver.getTitle());
        ArrayList<WebElement> tds = (ArrayList<WebElement>) driver.findElements(By.tagName("td"));
        assertTrue(containsWebElementsWithText(tds, "Ernest"));
        assertTrue(containsWebElementsWithText(tds, "winkel"));
        assertTrue(containsWebElementsWithText(tds, "5"));
        assertTrue(containsWebElementsWithText(tds, "12/01/2022"));
    }

    @Test
    public void test_Form_is_shown_again_with_error_messages_If_name_field_is_left_empty() {
        driver.findElement(By.className("knopWijzig")).click();
        assertEquals("Wijzig", driver.getTitle());
        WebElement naamInput = driver.findElement(By.id("naam"));
        naamInput.clear();
        naamInput.sendKeys("");

        WebElement activiteitInput = driver.findElement(By.id("activiteit"));
        activiteitInput.clear();
        activiteitInput.sendKeys("winkel");

        WebElement aantalInput = driver.findElement(By.id("aantal"));
        aantalInput.clear();
        aantalInput.sendKeys("5");

        WebElement datumInput = driver.findElement(By.id("datum"));
        datumInput.clear();
        datumInput.sendKeys("12/01/2022");

        driver.findElement(By.id("submit")).click();

        assertEquals("Wijzig", driver.getTitle());
        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebElementsWithText(lis, "De naam mag niet leeg zijn."));
    }

    @Test
    public void test_Form_is_shown_again_with_error_messages_If_activity_field_is_left_empty() {
        driver.findElement(By.className("knopWijzig")).click();
        assertEquals("Wijzig", driver.getTitle());
        WebElement naamInput = driver.findElement(By.id("naam"));
        naamInput.clear();
        naamInput.sendKeys("Ernest");

        WebElement activiteitInput = driver.findElement(By.id("activiteit"));
        activiteitInput.clear();
        activiteitInput.sendKeys("");

        WebElement aantalInput = driver.findElement(By.id("aantal"));
        aantalInput.clear();
        aantalInput.sendKeys("5");

        WebElement datumInput = driver.findElement(By.id("datum"));
        datumInput.clear();
        datumInput.sendKeys("12/01/2022");

        driver.findElement(By.id("submit")).click();

        assertEquals("Wijzig", driver.getTitle());
        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebElementsWithText(lis, "Activiteit mag niet leeg zijn."));
    }

    @Test
    public void test_Form_is_shown_again_with_error_messages_If_number_field_is_left_empty() {
        driver.findElement(By.className("knopWijzig")).click();
        assertEquals("Wijzig", driver.getTitle());
        WebElement naamInput = driver.findElement(By.id("naam"));
        naamInput.clear();
        naamInput.sendKeys("Ernest");

        WebElement activiteitInput = driver.findElement(By.id("activiteit"));
        activiteitInput.clear();
        activiteitInput.sendKeys("winkel");

        WebElement aantalInput = driver.findElement(By.id("aantal"));
        aantalInput.clear();
        aantalInput.sendKeys("");

        WebElement datumInput = driver.findElement(By.id("datum"));
        datumInput.clear();
        datumInput.sendKeys("12/01/2022");

        driver.findElement(By.id("submit")).click();

        assertEquals("Wijzig", driver.getTitle());
        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebElementsWithText(lis, "Het aantal euro mag niet leeg zijn."));
    }

    @Test
    public void test_Form_is_shown_again_with_error_messages_If_date_field_is_left_empty() {
        driver.findElement(By.className("knopWijzig")).click();
        assertEquals("Wijzig", driver.getTitle());
        WebElement naamInput = driver.findElement(By.id("naam"));
        naamInput.clear();
        naamInput.sendKeys("Ernest");

        WebElement activiteitInput = driver.findElement(By.id("activiteit"));
        activiteitInput.clear();
        activiteitInput.sendKeys("winkel");

        WebElement aantalInput = driver.findElement(By.id("aantal"));
        aantalInput.clear();
        aantalInput.sendKeys("5");

        WebElement datumInput = driver.findElement(By.id("datum"));
        datumInput.clear();
        datumInput.sendKeys("");

        driver.findElement(By.id("submit")).click();

        assertEquals("Wijzig", driver.getTitle());
        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebElementsWithText(lis, "Datum mag niet leeg zijn."));
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
