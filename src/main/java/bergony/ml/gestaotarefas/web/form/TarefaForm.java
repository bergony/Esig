package bergony.ml.gestaotarefas.web.form;

import bergony.ml.gestaotarefas.enums.PrioridadeStatus;
import bergony.ml.gestaotarefas.enums.TarefaStatus;
import bergony.ml.gestaotarefas.model.TarefaModel;
import bergony.ml.gestaotarefas.model.UsuarioModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Date;

@NoArgsConstructor
@Data
@Component
@SessionScope
public class TarefaForm implements ViewFormBean {

    private Long idTarefa;

    private String titulo;

    private String descricao;

    private PrioridadeStatus prioridadeStatus;

    private Date deadline;

    private TarefaStatus tarefaStatus;

    private UsuarioModel responsavel;

    public TarefaForm(TarefaModel tarefaModel) {
        this.idTarefa = tarefaModel.getIdTarefa();
        this.titulo = tarefaModel.getTitulo();
        this.descricao = tarefaModel.getDescricao();
        this.prioridadeStatus = tarefaModel.getPrioridadeStatus();
        this.deadline = tarefaModel.getDeadline();
        this.tarefaStatus = tarefaModel.getTarefaStatus();
        this.responsavel = tarefaModel.getResponsavel();
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof TarefaForm)) return false;
        final TarefaForm other = (TarefaForm) o;
        if (!other.canEqual(this)) return false;
        final Object this$idTarefa = this.getIdTarefa();
        final Object other$idTarefa = other.getIdTarefa();
        if (this$idTarefa == null ? other$idTarefa != null : !this$idTarefa.equals(other$idTarefa)) return false;
        final Object this$titulo = this.getTitulo();
        final Object other$titulo = other.getTitulo();
        if (this$titulo == null ? other$titulo != null : !this$titulo.equals(other$titulo)) return false;
        final Object this$descricao = this.getDescricao();
        final Object other$descricao = other.getDescricao();
        if (this$descricao == null ? other$descricao != null : !this$descricao.equals(other$descricao)) return false;
        final Object this$prioridadeStatus = this.getPrioridadeStatus();
        final Object other$prioridadeStatus = other.getPrioridadeStatus();
        if (this$prioridadeStatus == null ? other$prioridadeStatus != null : !this$prioridadeStatus.equals(other$prioridadeStatus))
            return false;
        final Object this$deadline = this.getDeadline();
        final Object other$deadline = other.getDeadline();
        if (this$deadline == null ? other$deadline != null : !this$deadline.equals(other$deadline)) return false;
        final Object this$tarefaStatus = this.getTarefaStatus();
        final Object other$tarefaStatus = other.getTarefaStatus();
        if (this$tarefaStatus == null ? other$tarefaStatus != null : !this$tarefaStatus.equals(other$tarefaStatus))
            return false;
        final Object this$responsavel = this.getResponsavel();
        final Object other$responsavel = other.getResponsavel();
        return this$responsavel == null ? other$responsavel == null : this$responsavel.equals(other$responsavel);
    }

    protected boolean canEqual(final Object other) {
        return other instanceof TarefaForm;
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $idTarefa = this.getIdTarefa();
        result = result * PRIME + ($idTarefa == null ? 43 : $idTarefa.hashCode());
        final Object $titulo = this.getTitulo();
        result = result * PRIME + ($titulo == null ? 43 : $titulo.hashCode());
        final Object $descricao = this.getDescricao();
        result = result * PRIME + ($descricao == null ? 43 : $descricao.hashCode());
        final Object $prioridadeStatus = this.getPrioridadeStatus();
        result = result * PRIME + ($prioridadeStatus == null ? 43 : $prioridadeStatus.hashCode());
        final Object $deadline = this.getDeadline();
        result = result * PRIME + ($deadline == null ? 43 : $deadline.hashCode());
        final Object $tarefaStatus = this.getTarefaStatus();
        result = result * PRIME + ($tarefaStatus == null ? 43 : $tarefaStatus.hashCode());
        final Object $responsavel = this.getResponsavel();
        result = result * PRIME + ($responsavel == null ? 43 : $responsavel.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "TarefaForm(idTarefa=" + this.getIdTarefa() + ", titulo=" + this.getTitulo() + ", descricao=" + this.getDescricao() + ", prioridadeStatus=" + this.getPrioridadeStatus() + ", deadline=" + this.getDeadline() + ", tarefaStatus=" + this.getTarefaStatus() + ", responsavel=" + this.getResponsavel() + ")";
    }
}
