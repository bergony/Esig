package bergony.ml.gestaotarefas.web.action;

import bergony.ml.gestaotarefas.enums.PrioridadeStatus;
import bergony.ml.gestaotarefas.services.TarefaService;
import bergony.ml.gestaotarefas.web.form.TarefaForm;
import bergony.ml.gestaotarefas.web.form.UsuarioForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;
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

        System.out.println(tarefaForm.toString());
        //tarefaService.criarTarefa(new TarefaModel(tarefaForm));
    }

    public PrioridadeStatus[] getPrioridadesStatusItems() {
        return PrioridadeStatus.values();
    }






}
