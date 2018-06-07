package todo.steps;

import net.thucydides.core.annotations.Step;
import todo.pageobjects.TodoPage;


public class EliminarTareaSteps {
    TodoPage page ;

    @Step
    public void openPage(){
        page.open();
        page.insertarTarea("tarea1");
    }

    @Step
    public void crearTarea (String nombreTarea) {
        page.insertarTarea(nombreTarea);
    }


    @Step
    public void eliminarTarea (String nombreTarea) {
        page.eliminarTarea(nombreTarea);
    }

    @Step
    public boolean estaLaTarea (String nombreTarea) {
        boolean resultado = page.estaLaTareaEnListaTareas(nombreTarea);
        return resultado;
    }

    @Step
    public int getTareasPendientes() {
        int resultado =  page.getContadorTareasPendientes();
        return resultado;
    }


}
