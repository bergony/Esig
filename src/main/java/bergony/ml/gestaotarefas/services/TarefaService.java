package bergony.ml.gestaotarefas.services;

import bergony.ml.gestaotarefas.model.TarefaModel;
import bergony.ml.gestaotarefas.web.form.TarefaForm;

import java.util.List;

public interface TarefaService {

    TarefaModel criarTarefa(TarefaModel tarefaModel);

    TarefaModel atualizarTarefa(TarefaModel tarefaModel);

    TarefaModel findByTarefa(TarefaModel tarefaModel);

    void removerTarefa(Long id);

    List<TarefaModel> listarTarefas();

    List<TarefaModel> filtroTarefas(TarefaModel tarefaModel);





}
