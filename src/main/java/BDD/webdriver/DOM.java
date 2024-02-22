package BDD.webdriver;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;


public class DOM {
    static String screenshotDir = "C:\\Users\\luism\\IdeaProjects\\_240213MiPrimerScriptWEB\\src\\test\\resources\\Evidencias\\";

    private static WebDriver driver;

    public static WebDriver webDriver(){
        if(driver==null){
            String chromeDriverPath = "C:\\Users\\luism\\IdeaProjects\\_240213MiPrimerScriptWEB\\src\\test\\resources\\webdriver\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver",chromeDriverPath);
            driver = new ChromeDriver();
        }
        return driver;
    }

    public DOM(){
        PageFactory.initElements(webDriver(),this);
    }

    public static void initiateBrowser(String URL){
        webDriver().get(URL);
        webDriver().manage().window().maximize();
    }
    public void takeScreenShot(Scenario scenario){

        try{
            final byte []  screenshot = ((TakesScreenshot) webDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Captura de pantalla");
        }catch (Exception e){
            e.printStackTrace();
        }
//        File screenshotFile = ((TakesScreenshot )webDriver()).getScreenshotAs(OutputType.FILE);
//        String destinationPath = screenshotDir + fileName + ".png";
//        try{
//            FileUtils.copyFile(screenshotFile, new File (destinationPath));
//            System.out.println("Captura de pantalla guardada");
//        }catch(IOException e){
//            System.out.println("Error al capturar la pantalla");
//            throw new RuntimeException(e);
//        }
    }
    public void onClick(WebElement element){
        element.click();
    }
    public void type(WebElement element, String text ){
        element.sendKeys(text);
    }
    public String getText (WebElement element){
        return element.getText();
    }

    public void quitBrowser(){
        webDriver().quit();
    }
}
