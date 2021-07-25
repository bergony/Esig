package bergony.ml.gestaotarefas.model;

import bergony.ml.gestaotarefas.web.form.UsuarioForm;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUsuario;

    private String name;

    public UsuarioModel(UsuarioForm usuarioForm) {
        this.idUsuario = usuarioForm.getIdUsuario();
        this.name = usuarioForm.getName();
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof UsuarioModel)) return false;
        final UsuarioModel other = (UsuarioModel) o;
        if (!other.canEqual(this)) return false;
        final Object this$idUsuario = this.getIdUsuario();
        final Object other$idUsuario = other.getIdUsuario();
        if (this$idUsuario == null ? other$idUsuario != null : !this$idUsuario.equals(other$idUsuario)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        return this$name == null ? other$name == null : this$name.equals(other$name);
    }

    protected boolean canEqual(final Object other) {
        return other instanceof UsuarioModel;
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
        return "UsuarioModel(idUsuario=" + this.getIdUsuario() + ", name=" + this.getName() + ")";
    }
}
