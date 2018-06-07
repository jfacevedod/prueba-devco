package todo;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import todo.steps.EliminarTareaSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class EliminarTareaDefinitions {

    @Steps
    EliminarTareaSteps eliminarTareaSteps;


    @Given("^que el usuario desea eliminar la  tarea (.*)$")
    public void que_el_usuario_desea_eliminar_la_tarea_estudiar(String nombreTarea) throws Exception {
        eliminarTareaSteps.openPage();
        eliminarTareaSteps.crearTarea(nombreTarea);
    }
    @When("^el usuario elimina la tarea (.*)$")
    public void el_usuario_seleciona_la_tarea_estudiar(String nombreTarea) throws Exception {
        eliminarTareaSteps.eliminarTarea(nombreTarea);
    }

    @Then("^la tarea (.*) se elimina de la lista$")
    public void la_tarea_estudiar_se_elimina_de_la_lista(String nombreTarea) throws Exception {
        boolean tarea =  eliminarTareaSteps.estaLaTarea(nombreTarea);
        assertThat(tarea, is(false));
    }

    @Then("^se reduce el contador de tareas pendientes$")
    public void se_reduce_el_contador_de_tareas_pendientes() throws Exception {
        int cantidadTareasPendientes = eliminarTareaSteps.getTareasPendientes();
        assertThat(cantidadTareasPendientes, is(1));
    }


}