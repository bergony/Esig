package bergony.ml.gestaotarefas.conversor;

import bergony.ml.gestaotarefas.model.UsuarioModel;
import bergony.ml.gestaotarefas.repositories.UsuarioRepository;
import bergony.ml.gestaotarefas.web.form.UsuarioForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.util.Optional;

@Component
public class UsuarioConversor implements Converter {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return usuarioRepository.findById(Long.valueOf(value)).orElse(null);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if (object instanceof UsuarioModel) {
            UsuarioModel usuarioModel = (UsuarioModel) object;
            return usuarioModel.getIdUsuario().toString();
        }else {
            return null;
        }
    }


}
