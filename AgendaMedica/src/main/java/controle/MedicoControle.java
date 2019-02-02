package controle;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import modelo.Especialidade;
import modelo.Medico;
import repositorio.MedicoRepositorio;

/**
 * @author jeremias
 */
@Named
@RequestScoped
public class MedicoControle {

    @Inject
    private Medico medico;

    @Inject
    private MedicoRepositorio repositorio;
    
    public Medico getMedico() {
        return medico;
    }

    public List<Medico> buscarTodos() {
        return repositorio.buscarTodos();
    }

    public List<Medico> buscarPorEspecialidade(Especialidade especialidade) {
        return repositorio.buscarPorEspecialidade(especialidade);
    }
}
