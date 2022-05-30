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

public class TestValidHtml {
    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After
    public void clean() {
        driver.quit();
    }

    @Test
    public void Test_Home_heeft_valide_html() {
        this.isValidateHtml("http://localhost:8080/lauwers_ernest_war_exploded/Controller?command=home");
    }

    @Test
    public void Test_Overzicht_heeft_valide_html() {
        this.isValidateHtml("http://localhost:8080/lauwers_ernest_war_exploded/Controller?command=overzicht");
    }

    @Test
    public void Test_VoegToe_heeft_valide_html() {
        this.isValidateHtml("http://localhost:8080/lauwers_ernest_war_exploded/Controller?command=voegToeMain");
    }

    @Test
    public void Test_Zoek_heeft_valide_html() {
        this.isValidateHtml("http://localhost:8080/lauwers_ernest_war_exploded/Controller?command=zoek");
    }

    @Test
    public void Test_Verwijder_heeft_valide_html() {
        this.isValidateHtml("http://localhost:8080/lauwers_ernest_war_exploded/Controller?command=verwijder");
    }

    @Test
    public void Test_Wijzig_heeft_valide_html() {
        this.isValidateHtml("http://localhost:8080/lauwers_ernest_war_exploded/Controller?command=wijzig");
    }

    @Test
    public void Test_ZoekResultaten_heeft_valide_html() {
        this.isValidateHtml("http://localhost:8080/lauwers_ernest_war_exploded/Controller?command=zoekOpNaam");
    }

    private void isValidateHtml(String url) {
        driver.get(url);
        String html = "<!DOCTYPE html>\n" + driver.getPageSource();
        driver.get("https://validator.w3.org/#validate_by_input");
        WebElement textarea = driver.findElement(By.id("fragment"));
        textarea.sendKeys(html);
        driver.findElement(By.cssSelector("#validate-by-input > form > p.submit_button > a")).click();
        String i = driver.findElement(By.cssSelector("html body div#results p.success")).getText();
        assertEquals("Document checking completed. No errors or warnings to show.", i);
    }
}