package bergony.ml.gestaotarefas.web.action;

import bergony.ml.gestaotarefas.model.TarefaModel;
import bergony.ml.gestaotarefas.services.TarefaService;
import bergony.ml.gestaotarefas.services.UsuarioService;
import bergony.ml.gestaotarefas.web.form.ListarForm;
import bergony.ml.gestaotarefas.web.form.TarefaForm;
import bergony.ml.gestaotarefas.web.form.UsuarioForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import java.util.List;

@Component
@ViewScoped
@ManagedBean
@RequiredArgsConstructor
public class ListarAction implements RequestActionBean {


    private ListarForm listarForm;
    private final TarefaService tarefaService;
    private final UsuarioService usuarioService;


    public void atulizarTarefa() {
        listarForm.setUsuarios(usuarioService.listarUsuario());
        listarForm.setTarefas(tarefaService.listarTarefas());
    }

}
