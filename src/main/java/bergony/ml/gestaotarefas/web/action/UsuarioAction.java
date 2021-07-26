package bergony.ml.gestaotarefas.web.action;

import bergony.ml.gestaotarefas.model.TarefaModel;
import bergony.ml.gestaotarefas.model.UsuarioModel;
import bergony.ml.gestaotarefas.services.UsuarioService;
import bergony.ml.gestaotarefas.web.form.UsuarioForm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequestScope
@RequiredArgsConstructor
public class UsuarioAction implements RequestActionBean {

    private final UsuarioForm usuarioForm;

    private final UsuarioService usuarioService;

    public void criarUsuario() {
        UsuarioModel usuario = new UsuarioModel(usuarioForm);
        usuarioForm.getUsuarios().add(usuario);
        usuarioService.criarUsuario(usuario);
    }



}
