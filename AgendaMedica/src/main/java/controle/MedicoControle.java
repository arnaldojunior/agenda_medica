package controle;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
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
@ApplicationScoped
public class MedicoControle {

    @Inject
    private Medico medico;
    
    private List<Medico> medicos = new ArrayList<>();
   
    @Inject
    private Especialidade especialidade;
    
    @Inject
    private MedicoRepositorio medicoRepositorio;
    
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

    /*
    *Busca todos os médicos
    */
    
    public void buscarTodosOsMedicos() {
        this.medicos = medicoRepositorio.buscarTodos();
    }
    
    public List<Especialidade> buscarTodasEspecialidades() {
        return especialidadeRepositorio.buscarTodos();
    }
    
    /*
    * Busca todos os médicos por especialidade
    */
    public void buscarPorEspecialidade() {
        System.out.println(especialidade+"SYSTEM");
        this.medicos = medicoRepositorio.buscarPorEspecialidade(especialidade);
    }
    
    public void buscarPorMedicoPedro() {
        this.medicos = medicoRepositorio.buscarPorMedicoPedro();
    }
    
    
}
