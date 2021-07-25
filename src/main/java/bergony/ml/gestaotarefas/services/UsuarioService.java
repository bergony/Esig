package bergony.ml.gestaotarefas.services;

import bergony.ml.gestaotarefas.model.UsuarioModel;
import bergony.ml.gestaotarefas.web.form.UsuarioForm;

import java.util.List;

public interface UsuarioService {

    UsuarioModel criarUsuario(UsuarioModel usuarioModel);

    UsuarioModel atualizarUsuario(UsuarioModel usuarioModel);

    void removerUsuario(Long id);

    List<UsuarioModel> listarUsuario();

}
