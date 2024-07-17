package core;

import enums.ByValue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class Element {

    private String map;
    private ByValue by;
    private Integer posicao;

    public Element(String map, ByValue sBy) {

        this.map = map;
        by = sBy;
    }

    public Element(String map, ByValue sBy, Integer _posicao) {

        this.map = map;
        by = sBy;
        posicao = _posicao;
    }

    public WebElement getElement(By by) {
        if (posicao == null) {
            return Driver.getDriver().findElement(by);
        }else {
            return Driver.getDriver().findElements(by).get(posicao);
        }
    }

    public WebElement criarElemento() {
        WebElement element = null;
        switch (by) {
            case id:
                element = getElement(By.id(map));
                break;
            case xpath:
                element = getElement(By.xpath(map));
                break;
            case css:
                element = getElement(By.cssSelector(map));
                break;
            case linkText:
                element = getElement(By.linkText(map));
                break;
            case name:
                element = getElement(By.name(map));
                break;
            default:
                //new Exception("Tipo de elemento não presente!");
                break;
        }

        return element;

    }

    public String getText() {
        return criarElemento().getText();
    }

    public void sendKeys(CharSequence key) {
        criarElemento().sendKeys(key);
    }

    public String getValue() {
        return criarElemento().getAttribute("value");
    }

    public String getAttribute(String atributo) {
        return criarElemento().getAttribute(atributo);
    }

    public void selectTextList(String value) {
        Select select = new Select(criarElemento());
        select.selectByVisibleText(value);
    }

    public List<WebElement> criarElementos() {
        List<WebElement> elements = new ArrayList<WebElement>();

        switch (by) {
            case id:
                elements = Driver.getDriver().findElements(By.id(map));
                break;
            case css:
                elements = Driver.getDriver().findElements(By.cssSelector(map));
                break;
            case linkText:
                elements = Driver.getDriver().findElements(By.linkText(map));
                break;
            case name:
                elements = Driver.getDriver().findElements(By.name(map));
                break;
            case xpath:
                elements = Driver.getDriver().findElements(By.xpath(map));
                break;

            default:
                break;
        }

        return elements;
    }

    public void clickElementValue(String valor) {
        for (WebElement webElement : criarElementos()) {
            if (webElement.getAttribute("value").equals(valor)) {
                webElement.click();
                break;
            }
        }
    }

    public void clickElementText(String valor) {
        for (WebElement webElement : criarElementos()) {
            if (webElement.getText().equals(valor)) {
                webElement.click();
                break;
            }
        }
    }

    public void click() {
        criarElemento().click();
    }

    public boolean isDisplayed() {
        return this.criarElemento().isDisplayed();
    }

    public void aguardaElemento() {

        switch (this.by) {
            case id:
                Driver.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.id(this.map)));
                break;
            case css:
                Driver.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(this.map)));
                break;
            case xpath:
                Driver.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(this.map)));
                break;
            case name:
                Driver.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.name(this.map)));
                break;

            default:
                break;
        }
    }

}

