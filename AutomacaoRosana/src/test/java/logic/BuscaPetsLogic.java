package logic;

import core.Driver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Keys;
import pages.BuscaPetsPage;

@Slf4j
public class BuscaPetsLogic {

    private String step;
    BuscaPetsPage buscaPetsPage = new BuscaPetsPage();

    public BuscaPetsLogic(){}

   public void validarPaginaAcessada(){
        buscaPetsPage.valitemfish.isDisplayed();
    }
    public void realizarBusca(){
        buscaPetsPage.preencherbusca.sendKeys("a");
        buscaPetsPage.clicbuscar.sendKeys(Keys.ENTER);
        buscaPetsPage.clicretornarmenu.isDisplayed();;
    }

    public void validarRetorno(){
        buscaPetsPage.clicretornarmenu.sendKeys(Keys.ENTER);
        buscaPetsPage.valitemfish.isDisplayed();
    }

    }

