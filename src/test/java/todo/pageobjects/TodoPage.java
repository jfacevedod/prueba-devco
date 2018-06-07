package todo.pageobjects;


import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.Keys;

import java.util.List;


@DefaultUrl("http://todomvc.com/examples/angularjs/#/")
public class TodoPage extends PageObject {

    @FindBy(css = "#todo-count")
    WebElementFacade spanContador;

    @FindBy(css = "#new-todo")
    WebElementFacade inputTareas;

    @FindBy(id = "todo-list")
    WebElementFacade listTareas;

    public void insertarTarea (String nombreTarea) {
        inputTareas.sendKeys(nombreTarea);
        inputTareas.sendKeys(Keys.ENTER);
    }

    public void eliminarTarea(String nombreTarea) {
        WebElementFacade div = listTareas.findBy(By.xpath("//*[@id='todo-list']/li/div[contains(./label/text(),'"+nombreTarea+"')]"));
        WebElementFacade botonEliminar = listTareas.findBy(By.xpath("//*[@id='todo-list']/li/div[contains(./label/text(),'"+nombreTarea+"')]/button"));
        withAction().moveToElement(div).click(botonEliminar).perform();
    }

    public boolean estaLaTareaEnListaTareas(String nombreTarea){
        boolean labelTarea = listTareas.containsElements(By.xpath("//*[@id='todo-list']/li/div/label[contains(text(),'"+nombreTarea+"')]"));
        return labelTarea;
    }


    public int getContadorTareasPendientes() {
        String contador = spanContador.findElement(By.tagName("strong")).getText();
        int contadorInt = Integer.parseInt(contador);
        return contadorInt;
    }



}