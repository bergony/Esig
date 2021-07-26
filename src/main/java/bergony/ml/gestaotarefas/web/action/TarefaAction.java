package bergony.ml.gestaotarefas.web.action;

import bergony.ml.gestaotarefas.enums.PrioridadeStatus;
import bergony.ml.gestaotarefas.enums.TarefaStatus;
import bergony.ml.gestaotarefas.model.TarefaModel;
import bergony.ml.gestaotarefas.services.TarefaService;
import bergony.ml.gestaotarefas.web.form.TarefaForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
@ManagedBean
@RequiredArgsConstructor
public class TarefaAction implements RequestActionBean {


    private final TarefaForm tarefaForm;
    private final TarefaService tarefaService;

    public void criarTarefa() {
        TarefaModel tarefa = new TarefaModel(tarefaForm);

        tarefaForm.getTarefas().add(tarefa);
        tarefaService.criarTarefa(tarefa);
    }

    public void deletarTarefa(TarefaModel tarefa){
        tarefaForm.getTarefas().remove(tarefa);
        tarefaService.removerTarefa(tarefa.getIdTarefa());
    }

    public void concluirTarefa(TarefaModel tarefa){
        if(tarefa.getTarefaStatus() == TarefaStatus.EM_ANDAMENTO){
            tarefaForm.getTarefas().remove(tarefa);
            tarefa.setTarefaStatus(TarefaStatus.CONCLUIDA);
            tarefaService.atualizarTarefa(tarefa);
        }
    }

    public void editarTarefa(TarefaModel tarefa){
        tarefaForm.setTarefa(tarefa);

    }

    public void patchTarefa(){

        tarefaForm.getTarefas().remove(tarefaForm.getTarefa());

        tarefaForm.getTarefas().add(tarefaForm.getTarefa());
        tarefaService.atualizarTarefa(tarefaForm.getTarefa());

        tarefaForm.setTarefa(new TarefaModel());

    }

    public void filtraTarefa(){

        TarefaModel tarefa = tarefaForm.getTarefa();
        tarefaForm.setTarefas( new ArrayList<>());

        tarefaForm.getTarefas().addAll( tarefaService.filtroTarefas(tarefa));

        tarefaForm.setTarefa(new TarefaModel());
    }

    public PrioridadeStatus[] getPrioridadesStatusItems() {
        return PrioridadeStatus.values();
    }

    public TarefaStatus[] getTarefaStatusItems() {
        return TarefaStatus.values();
    }


}
