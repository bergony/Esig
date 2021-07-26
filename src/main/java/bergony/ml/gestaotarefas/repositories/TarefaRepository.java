package bergony.ml.gestaotarefas.repositories;

import bergony.ml.gestaotarefas.enums.TarefaStatus;
import bergony.ml.gestaotarefas.model.TarefaModel;
import bergony.ml.gestaotarefas.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<TarefaModel, Long> {

    List<TarefaModel> findAllByTituloContains(String titulo);
    List<TarefaModel> findAllByDescricaoContains(String titulo);

    List<TarefaModel> findByResponsavel(UsuarioModel usuarioModel);

    List<TarefaModel> findAllByTarefaStatus(TarefaStatus tarefaStatus);
}
