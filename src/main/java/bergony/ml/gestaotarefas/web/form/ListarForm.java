package bergony.ml.gestaotarefas.web.form;

import bergony.ml.gestaotarefas.model.TarefaModel;
import bergony.ml.gestaotarefas.model.UsuarioModel;
import bergony.ml.gestaotarefas.services.TarefaService;
import bergony.ml.gestaotarefas.services.UsuarioService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import java.util.List;

@NoArgsConstructor
@Data
@Component
@SessionScope
public class ListarForm implements ViewFormBean{

    private List<UsuarioModel> usuarios;
    private List<TarefaModel> tarefas;

    private UsuarioService usuarioService;
    private TarefaService tarefaService;

    @Autowired
    public ListarForm(UsuarioService usuarioService, TarefaService tarefaService) {
        this.usuarioService = usuarioService;
        this.tarefaService = tarefaService;
    }

    @PostConstruct
    public void init() {
        usuarios = usuarioService.listarUsuario();
        tarefas = tarefaService.listarTarefas();
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ListarForm)) return false;
        final ListarForm other = (ListarForm) o;
        if (!other.canEqual(this)) return false;
        final Object this$usuarios = this.getUsuarios();
        final Object other$usuarios = other.getUsuarios();
        if (this$usuarios == null ? other$usuarios != null : !this$usuarios.equals(other$usuarios)) return false;
        final Object this$service = this.getUsuarioService();
        final Object other$service = other.getUsuarioService();
        if (this$service == null ? other$service != null : !this$service.equals(other$service)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ListarForm;
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $usuarios = this.getUsuarios();
        result = result * PRIME + ($usuarios == null ? 43 : $usuarios.hashCode());
        final Object $service = this.getUsuarioService();
        result = result * PRIME + ($service == null ? 43 : $service.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ListaUsuariosForm(usuarios=" + this.getUsuarios() + ", service=" + this.getUsuarioService() + ")";
    }
}
