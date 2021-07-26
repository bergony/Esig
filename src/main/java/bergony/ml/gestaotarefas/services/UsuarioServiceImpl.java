package bergony.ml.gestaotarefas.services;

import bergony.ml.gestaotarefas.model.UsuarioModel;
import bergony.ml.gestaotarefas.repositories.UsuarioRepository;
import bergony.ml.gestaotarefas.web.form.UsuarioForm;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UsuarioModel criarUsuario(UsuarioModel usuarioModel) {
        return usuarioRepository.save(usuarioModel);
    }

    @Override
    public UsuarioModel atualizarUsuario(UsuarioModel usuarioModel) {
        try {
            usuarioRepository.findById(usuarioModel.getIdUsuario());
        } catch (Exception e) {
            System.out.println("Usuario nao encontrada :");
        }

        UsuarioModel usuarioParaAtualzar = UsuarioModel.builder().
                idUsuario(usuarioModel.getIdUsuario()).
                name(usuarioModel.getName()).
                build();

        return usuarioRepository.save(usuarioParaAtualzar);

    }

    @Override
    public void removerUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public List<UsuarioModel> listarUsuario() {
        return usuarioRepository.findAll();
    }
}
