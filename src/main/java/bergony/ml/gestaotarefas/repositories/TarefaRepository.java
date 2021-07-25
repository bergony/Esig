package bergony.ml.gestaotarefas.repositories;

import bergony.ml.gestaotarefas.model.TarefaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<TarefaModel, Long> {
}
