
Feature: Buscar producto
  @PRUEBA1
  Scenario: Buscar producto y comprobar que el producto elegido sea el correcto.
    Given Que ingreso a la pagina web de mercadolibre - "https://www.mercadolibre.com.co"
    When  Ingreso el texto "Libro de Jenkins"
    And Le doy click al boton buscar
    Then  valido que me muestre el valor "Libro de jenkins"

