package BDD.stepdefinition;

import BDD.step.buscarProductoStep;
import BDD.webdriver.DOM;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;


public class buscarProductoStepDef {

    private final buscarProductoStep buscarProductoStep = new buscarProductoStep();
    private final DOM dom = new DOM();

    private Scenario scenario;


    @After
    public void afterScenario(Scenario scenario) {
        this.scenario = scenario;
        dom.takeScreenShot(scenario);
        dom.quitBrowser();
    }

    @Given("Que ingreso a la pagina web de mercadolibre - {string}")
    public void Que_ingreso_a_la_pagina_web_de_mercadoLibre(String URL) {
        buscarProductoStep.stepNavigateToURL(URL);
    }

    @When("Ingreso el texto {string}")
    public void Ingreso_el_texto(String txtProducto) {
        buscarProductoStep.stepClickSearch();
        buscarProductoStep.stepTypeProduct(txtProducto);
    }

    @And("Le doy click al boton buscar")
    public void Le_doy_click_al_boton_buscar() {
        buscarProductoStep.stepClickSearchEngine();
    }

    @Then("valido que me muestre el valor {string}")
    public void valido_que_me_muestre_el_valor(String txtResultadoEsperado) {
        Assertions.assertEquals(txtResultadoEsperado, buscarProductoStep.stepVerifyAssert());
    }
}
