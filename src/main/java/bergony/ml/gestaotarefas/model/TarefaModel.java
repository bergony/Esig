package bergony.ml.gestaotarefas.model;


import bergony.ml.gestaotarefas.enums.PrioridadeStatus;
import bergony.ml.gestaotarefas.enums.TarefaStatus;
import bergony.ml.gestaotarefas.web.form.TarefaForm;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TarefaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTarefa;

    private String titulo;

    private String descricao;

    private PrioridadeStatus prioridadeStatus;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date deadline;

    private TarefaStatus tarefaStatus;

    @ManyToOne(optional = false)
    private UsuarioModel responsavel;

    public TarefaModel(TarefaForm tarefaForm) {
        this.idTarefa = tarefaForm.getIdTarefa();
        this.titulo = tarefaForm.getTitulo();
        this.descricao = tarefaForm.getDescricao();
        this.prioridadeStatus = tarefaForm.getPrioridadeStatus();
        this.deadline = tarefaForm.getDeadline();
        this.tarefaStatus = tarefaForm.getTarefaStatus();
        this.responsavel = tarefaForm.getResponsavel();
    }


    @Override
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof TarefaModel)) return false;
        final TarefaModel other = (TarefaModel) o;
        if (!other.canEqual((Object) this)) return false;
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
        if (this$responsavel == null ? other$responsavel != null : !this$responsavel.equals(other$responsavel))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof TarefaModel;
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
        return "TarefaModel(idTarefa=" + this.getIdTarefa() + ", titulo=" + this.getTitulo() + ", descricao=" + this.getDescricao() + ", prioridadeStatus=" + this.getPrioridadeStatus() + ", deadline=" + this.getDeadline() + ", tarefaStatus=" + this.getTarefaStatus() + ", responsavel=" + this.getResponsavel() + ")";
    }
}
