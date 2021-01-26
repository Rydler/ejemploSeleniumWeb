package selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.junit.Before;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    
    private WebDriver driver;

    @Before
    public void setUp(){
        System.out.println("Iniciando configuración para la prueba...");
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        driver = new ChromeDriver();
        //driver.get("https://www.amazon.com");
        //driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(900, 700));
        driver.manage().window().setPosition(new Point(200, 200));
        //System.out.println("URL: " + driver.getCurrentUrl());
        //System.out.println("Title: " + driver.getTitle());
        driver.navigate().to("https://www.google.com");
    }

    @Test
    public void buscarProductoCorrecto()
    {
        System.out.println("Iniciando buscarProductoCorrecto");
        //driver.navigate().to("https://www.google.com");
        WebElement searchbox = driver.findElement(By.name("q"));
        searchbox.sendKeys("HandBook Devops");
        searchbox.submit();
        assertEquals("HandBook Devops - Buscar con Google", driver.getTitle().trim());
    }

    @Test
    public void obtenerDetalleProducto()
    {
        System.out.println("Iniciando obtenerDetalleProducto");
        //driver.navigate().to("https://www.google.com");
        WebElement searchbox = driver.findElement(By.name("q"));
        searchbox.sendKeys("HandBook Devops");
        searchbox.submit();
        
        WebElement botonImagenes = driver.findElement(By.className("hide-focus-ring"));
        botonImagenes.click();
        WebElement contenedorImagenes = driver.findElement(By.className("lv4kTe"));
        List<WebElement> imagenes = contenedorImagenes.findElements(By.tagName("a"));
        imagenes.get(0).click();
        assertNotNull(imagenes.get(0));
    }

}
