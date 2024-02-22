import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class SimpleSeleniumSample {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\luism\\IdeaProjects\\_240213MiPrimerScriptWEB\\src\\test\\resources\\webdriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();




        String screenshotDir = "C:\\Users\\luism\\IdeaProjects\\_240213MiPrimerScriptWEB\\src\\test\\resources\\Evidencias\\";
        driver.get("https://www.mercadolibre.com.co");
        driver.manage().window().maximize();

        takeScreenShot(driver,screenshotDir,"screenshot1.png");
        try{
            Thread.sleep(2500);
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        WebElement txtBuscar = driver.findElement(By.id("cb1-edit"));
        WebElement btnBuscar = driver.findElement((By.xpath("//*[@type='submit']")));

        txtBuscar.click();
        txtBuscar.sendKeys("Libro de Jenkins");
        takeScreenShot(driver,screenshotDir,"screenshot2.png");
        btnBuscar.click();
        WebElement lblRsltObtenido = driver.findElement(By.xpath("//h1[@class='ui-search-breadcrumb__title']"));
        String rsltObtenido = lblRsltObtenido.getText();
        String rsltEsperado = "Libro de jenkins";
        takeScreenShot(driver,screenshotDir,"screenshot3.png");

        Assertions.assertEquals(rsltEsperado,rsltObtenido);
        Thread.sleep(2500);
        driver.quit();
    }

    public static void takeScreenShot(WebDriver driver, String screenshotDir, String fileName){

        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        String destinationPath = screenshotDir + fileName;

       try{
           FileUtils.copyFile(screenshotFile, new File (destinationPath));
           System.out.println("Captura de pantalla guardada");
       }catch(IOException e){
           System.out.println("Error al capturar la pantalla");
           throw new RuntimeException(e);
       }
    }



}
