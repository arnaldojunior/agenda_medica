package controle;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import modelo.Especialidade;
import modelo.Medico;
import repositorio.MedicoRepositorio;
import repositorio.EspecialidadeRepositorio;


/**
 * @author jeremias
 */
@Named
@RequestScoped
public class MedicoControle {

    @Inject
    private Medico medico;
    
    private List<Medico> medicos = new ArrayList<>();
   
    @Inject
    private Especialidade especialidade;
    
    @Inject
    private MedicoRepositorio repositorio;
    
    @Inject
    private EspecialidadeRepositorio especialidadeRepositorio;
    
        
    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public List<Medico> buscarTodos() {
        return repositorio.buscarTodos();
    }
    
    public List<Especialidade> buscarTodasEspecialidades() {
        return especialidadeRepositorio.buscarTodos();
    }
    
    public void buscarPorEspecialidade() {
        System.out.println("Buscar Por Especialidade");
        this.medicos = repositorio.buscarPorEspecialidade(especialidade);
        System.out.println("Médicos: "+ medicos);
    }
    
}
