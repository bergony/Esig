package bergony.ml.gestaotarefas.web.form;

import bergony.ml.gestaotarefas.model.UsuarioModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@NoArgsConstructor
@Data
@Component
@SessionScope
public class UsuarioForm implements ViewFormBean  {

    private Long idUsuario;

    private String name;

    public UsuarioForm(UsuarioModel usuarioModel) {
        this.idUsuario = usuarioModel.getIdUsuario();
        this.name = usuarioModel.getName();
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof UsuarioForm)) return false;
        final UsuarioForm other = (UsuarioForm) o;
        if (!other.canEqual(this)) return false;
        final Object this$idUsuario = this.getIdUsuario();
        final Object other$idUsuario = other.getIdUsuario();
        if (this$idUsuario == null ? other$idUsuario != null : !this$idUsuario.equals(other$idUsuario)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        return this$name == null ? other$name == null : this$name.equals(other$name);
    }

    protected boolean canEqual(final Object other) {
        return other instanceof UsuarioForm;
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $idUsuario = this.getIdUsuario();
        result = result * PRIME + ($idUsuario == null ? 43 : $idUsuario.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "UsuarioForm(idUsuario=" + this.getIdUsuario() + ", name=" + this.getName() + ")";
    }
}
