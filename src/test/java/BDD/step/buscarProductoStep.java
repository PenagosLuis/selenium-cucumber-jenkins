package BDD.step;

import BDD.page.buscarProductoPage;

public class buscarProductoStep {

    public buscarProductoPage buscarProductoPage(){
        return new buscarProductoPage();
    }
    public void stepNavigateToURL(String URL){
        buscarProductoPage().navigateToURL(URL);
    }
    public void stepClickSearch(){

        buscarProductoPage().clickSearch();

    }
    public void stepTypeProduct(String txtProduct){

        buscarProductoPage().typeProduct(txtProduct);
    }
    public void stepClickSearchEngine(){

        buscarProductoPage().clickSearchEngine();
    }
        public String stepVerifyAssert (){

        return buscarProductoPage().verifyAssert();
    }

}
