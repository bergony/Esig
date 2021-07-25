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
import java.util.List;

@Component
@ViewScoped
@ManagedBean
@RequiredArgsConstructor
public class TarefaAction implements RequestActionBean {

    private final TarefaForm tarefaForm;
    private final TarefaService tarefaService;

    public void criarTarefa() {
        tarefaService.criarTarefa(new TarefaModel(tarefaForm));
    }

    public PrioridadeStatus[] getPrioridadesStatusItems() {
        return PrioridadeStatus.values();
    }

    public TarefaStatus[] getTarefaStatusItems() {
        return TarefaStatus.values();
    }


}
