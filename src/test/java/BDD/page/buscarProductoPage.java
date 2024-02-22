package BDD.page;

import BDD.webdriver.DOM;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class buscarProductoPage extends DOM {

    @FindBy(id= "cb1-edit")
    protected WebElement txtBuscar;

    @FindBy(xpath = "//*[@type='submit']")
    WebElement btnBuscar;

    @FindBy(xpath = "//h1[@class='ui-search-breadcrumb__title']")
    WebElement rsltdoObtenido;

    public void clickSearch(){
        onClick(txtBuscar);
    }

    public void navigateToURL(String URL){
        initiateBrowser(URL);
    }
    public void typeProduct(String txtProduct){
        type(txtBuscar, txtProduct);
    }

    public void clickSearchEngine(){
        onClick(btnBuscar);
    }

    public String verifyAssert(){
        return getText(rsltdoObtenido);
    }
}



