package pages;

import core.Element;
import enums.ByValue;

public class BuscaPetsPage {


    public Element  valitemfish =new Element ("//div[@id='SidebarContent']/a/img", ByValue.xpath);
    public Element  preencherbusca =new Element ("keyword", ByValue.name);
    public Element  clicbuscar =new Element ("searchProducts" , ByValue.name);
    public Element  clicretornarmenu =new Element ("//html/body/div[2]/div[1]/a", ByValue.xpath);

}

