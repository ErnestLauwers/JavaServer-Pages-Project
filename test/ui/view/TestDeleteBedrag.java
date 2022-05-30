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

public class TestDeleteBedrag {

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
    public void test_Form_is_shown_If_delete_button_is_clicked() {
        driver.findElement(By.className("knopVerwijder")).click();
        assertEquals("Verwijder", driver.getTitle());
        ArrayList<WebElement> h2s = (ArrayList<WebElement>) driver.findElements(By.tagName("h2"));
        assertTrue(containsWebElementsWithText(h2s, "Ben je zeker dat je dit bedrag wilt verwijderen?"));
    }

    @Test
    public void test_Item_is_deleted_If_yes_is_clicked() {
        driver.findElement(By.className("knopVerwijder")).click();
        assertEquals("Verwijder", driver.getTitle());
        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("h2"));
        assertTrue(containsWebElementsWithText(lis, "Ben je zeker dat je dit bedrag wilt verwijderen?"));
        driver.findElement(By.id("submitJa")).click();
        assertEquals("Overzicht", driver.getTitle());
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