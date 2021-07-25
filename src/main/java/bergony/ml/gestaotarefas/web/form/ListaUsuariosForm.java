package bergony.ml.gestaotarefas.web.form;

import bergony.ml.gestaotarefas.model.TarefaModel;
import bergony.ml.gestaotarefas.model.UsuarioModel;
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
public class ListaUsuariosForm implements ViewFormBean{

    private List<UsuarioModel> usuarios; // +getter (no setter necessary)

    private UsuarioService service;

    @Autowired
    public ListaUsuariosForm(UsuarioService service) {
        this.service = service;
    }

    @PostConstruct
    public void init() {
        usuarios = service.listarUsuario();
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ListaUsuariosForm)) return false;
        final ListaUsuariosForm other = (ListaUsuariosForm) o;
        if (!other.canEqual(this)) return false;
        final Object this$usuarios = this.getUsuarios();
        final Object other$usuarios = other.getUsuarios();
        if (this$usuarios == null ? other$usuarios != null : !this$usuarios.equals(other$usuarios)) return false;
        final Object this$service = this.getService();
        final Object other$service = other.getService();
        return this$service == null ? other$service == null : this$service.equals(other$service);
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ListaUsuariosForm;
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $usuarios = this.getUsuarios();
        result = result * PRIME + ($usuarios == null ? 43 : $usuarios.hashCode());
        final Object $service = this.getService();
        result = result * PRIME + ($service == null ? 43 : $service.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ListaUsuariosForm(usuarios=" + this.getUsuarios() + ", service=" + this.getService() + ")";
    }
}
