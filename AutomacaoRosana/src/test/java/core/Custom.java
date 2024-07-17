package core;

import io.cucumber.java.BeforeStep;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Custom {

    @Before
    public void iniciarTeste(){
       Driver.setDriver("https://www.google.com");
    }

    @Test
    public void executarTeste(){
        System.out.println("TESTE")
        ;
    }

    @After
    public void finalizarTeste(){
        Driver.quitBrowser();
    }
}

