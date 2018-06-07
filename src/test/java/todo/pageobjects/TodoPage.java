package todo.pageobjects;


import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.Keys;


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
        WebElementFacade botonEliminar = listTareas.selectByVisibleText(nombreTarea).findBy(".destroy");
        botonEliminar.click();
    }

    public boolean estaLaTareaEnListaTareas(String nombreTarea){
        boolean existeTarea = listTareas.selectByVisibleText(nombreTarea).isPresent();
        return existeTarea;
    }


    public int getContadorTareasPendientes() {
        String contador = spanContador.findElement(By.tagName("strong")).getText();
        int contadorInt = Integer.parseInt(contador);
        return contadorInt;
    }



}

