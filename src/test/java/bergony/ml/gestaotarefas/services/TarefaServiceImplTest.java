package bergony.ml.gestaotarefas.services;

import bergony.ml.gestaotarefas.enums.PrioridadeStatus;
import bergony.ml.gestaotarefas.enums.TarefaStatus;
import bergony.ml.gestaotarefas.model.TarefaModel;
import bergony.ml.gestaotarefas.model.UsuarioModel;
import bergony.ml.gestaotarefas.repositories.TarefaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.ManyToOne;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@SpringBootTest
class TarefaServiceImplTest {


    @Autowired
    private TarefaService tarefaService;

    @MockBean
    private TarefaRepository tarefaRepository;

    private static final Long IDTAREFA = 1L;
    private static final String TITULO = "Programar";
    private static final PrioridadeStatus PRIORIDADESTATUS = PrioridadeStatus.ALTA;
    private static final TarefaStatus TAREFASTATUS = TarefaStatus.EM_ANDAMENTO;
    private static final String DESCRICAO = "Estagio na esig";


    private static final Long IDUSUARIO= 1L;
    private static final String NOME = "Bergony";

    private Date deadLine;
    private UsuarioModel responsavel;

    TarefaModel tarefa;


    @BeforeEach
    void setUp() throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        deadLine = formato.parse("20/01/2020");

        responsavel = UsuarioModel.builder()
                .idUsuario(IDUSUARIO)
                .name(NOME)
                .build();

        tarefa = TarefaModel.builder()
                .idTarefa(IDTAREFA)
                .titulo(TITULO)
                .prioridadeStatus(PRIORIDADESTATUS)
                .tarefaStatus(TAREFASTATUS)
                .descricao(DESCRICAO)
                .deadline(deadLine)
                .responsavel(responsavel)
                .build();
    }

    @Test
    @DisplayName("Test Criar Tarefa Success")
    void criarTarefa() {

        Mockito.when(tarefaRepository.save(any(TarefaModel.class))).thenReturn(tarefa);

        TarefaModel tarefaModel = tarefaService.criarTarefa(tarefa);

        Assertions.assertEquals(tarefaModel, tarefa);
        Assertions.assertEquals(tarefaModel.getIdTarefa(), IDTAREFA);
        Assertions.assertEquals(tarefaModel.getDeadline(), deadLine);
        Assertions.assertEquals(tarefaModel.getDescricao(), DESCRICAO);
        Assertions.assertEquals(tarefaModel.getPrioridadeStatus(), PRIORIDADESTATUS);
        Assertions.assertEquals(tarefaModel.getTitulo(), TITULO);
        Assertions.assertEquals(tarefaModel.getResponsavel(), responsavel);
        Assertions.assertEquals(tarefaModel.getTarefaStatus(), TAREFASTATUS);
    }

    @Test
    void atualizarTarefa() throws ParseException {

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        deadLine = formato.parse("01/10/2000");
        tarefa.setDeadline(deadLine);


        Mockito.when(tarefaRepository.findById(anyLong())).thenReturn(Optional.of(tarefa));

        Mockito.when(tarefaRepository.save(any(TarefaModel.class))).thenReturn(tarefa);

        TarefaModel tarefaModel = tarefaService.atualizarTarefa(tarefa);

        Assertions.assertEquals(tarefaModel, tarefa);

    }
}