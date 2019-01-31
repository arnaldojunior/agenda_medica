package modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author claudio.barbosa
 */

@Entity
@Table(name = "medicos")
@NamedQueries({
        @NamedQuery(name = "Medico.buscarTodos", 
                    query = "SELECT m FROM Medico m"),
        
                    
        @NamedQuery(name = "Especialidade.buscarPorEspecialidade", 
                    query = "SELECT a FROM Medico a WHERE a.especialide = :espec")})     
        
    
public class Medico implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, 
                    generator = "medico_seq")
    @SequenceGenerator(name = "medico_seq",
                       sequenceName = "medico_seq",
                       initialValue = 100,
                       allocationSize = 1)
    private Long id;
    
    @Column(name = "nome", nullable = false)
    private String nome;
    
    @Column(name = "crm", nullable = false)
    private String crm;
    
    @ManyToMany
    private Set<Especialidade> especialidades = new HashSet<>();

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }
    
    public Set<Especialidade> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(Set<Especialidade> especialidades) {
        this.especialidades = especialidades;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Medico other = (Medico) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
     @Override
    public String toString() {
        return "Medico{" + "nome=" + nome + ", crm=" + crm + '}';
    }
    
}
