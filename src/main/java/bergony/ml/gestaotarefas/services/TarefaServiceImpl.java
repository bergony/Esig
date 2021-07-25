package bergony.ml.gestaotarefas.services;

import bergony.ml.gestaotarefas.model.TarefaModel;
import bergony.ml.gestaotarefas.repositories.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaServiceImpl implements TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaServiceImpl(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    @Override
    public TarefaModel criarTarefa(TarefaModel tarefaModel) {
        return tarefaRepository.save(tarefaModel);
    }

    @Override
    public TarefaModel atualizarTarefa(TarefaModel tarefaModel) {

        try {
            tarefaRepository.findById(tarefaModel.getIdTarefa());
        } catch (Exception e) {
            System.out.println("Tarefa nao encontrada :" + e.getMessage());
        }

        TarefaModel tarefaParaAtualzar = TarefaModel.builder().
                idTarefa(tarefaModel.getIdTarefa()).
                titulo(tarefaModel.getTitulo()).
                deadline(tarefaModel.getDeadline()).
                descricao(tarefaModel.getDescricao()).
                prioridadeStatus(tarefaModel.getPrioridadeStatus()).
                responsavel(tarefaModel.getResponsavel()).
                tarefaStatus(tarefaModel.getTarefaStatus()).
                build();

        return tarefaRepository.save(tarefaParaAtualzar);
    }

    @Override
    public TarefaModel findByTarefa(TarefaModel tarefaModel) {
        return tarefaRepository.getOne(tarefaModel.getIdTarefa());
             }

    @Override
    public void removerTarefa(Long id) {
        tarefaRepository.deleteById(id);

    }

    @Override
    public List<TarefaModel> listarTarefas() {
        return tarefaRepository.findAll();
    }
}
