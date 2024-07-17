package steps;

import core.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logic.BuscaPetsLogic;

public class BuscaPetsSteps {

    public BuscaPetsLogic buscaPetsLogic;

    public BuscaPetsSteps(){
        buscaPetsLogic = new BuscaPetsLogic();
    }

    @Given("que acesso a aplicacao desejada")
    public void que_acesso_a_aplicacao_desejada() {
        Driver.setDriver("https://petstore.octoperf.com/actions/Catalog.action");
        buscaPetsLogic.validarPaginaAcessada();
    }

    @When("realizo uma busca")
    public void realizo_uma_busca() {
        buscaPetsLogic.realizarBusca();
    }

    @Then("obtenho um resultado")
   public void obtenho_um_resultado() {
       buscaPetsLogic.validarRetorno();

    }
   @And("fecho a aplicacao")
   public void fecho_a_aplicacao(){
       Driver.fechar();
   }
}

