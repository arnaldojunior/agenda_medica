
package repositorio;

import javax.annotation.Resource;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.UserTransaction;
import modelo.Medico;
import modelo.Especialidade;



/**
 *
 * @author root
 */

public class MedicoRepositorio {
    
    @PersistenceUnit(unitName = "agendaMedicaPU")
    EntityManagerFactory emf;
    
    @Resource
    UserTransaction transaction;
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    public void create(Object medico) throws Exception {
        
        EntityManager em = null;
        try {
            transaction.begin();
            em = getEntityManager();
            em.persist(medico);
            transaction.commit();
        
        } catch(Exception e) {
            e.printStackTrace();
            try {
                transaction.rollback();
            } catch (Exception ex) {
                throw new Exception("Erro ao efetuar rollback: "+ ex);
            }
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
     
    public List<Medico> findAll() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            
            return em.createQuery("SELECT m FROM Medico m").getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    public List<Medico> findAllNamed() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            return em.createNamedQuery("Medico.buscarTodos").getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
      public List<Especialidade> buscarPorEspecialidade(Especialidade especialidade) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            return em.createQuery(
                    "SELECT a FROM Medico a WHERE a.especialide = :espec").setParameter("espec", especialidade)
                    .getResultList();
            
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
     public void deletar(Long id) throws Exception {
         EntityManager em = null;
        try {
            transaction.begin();
            em = getEntityManager();
            Object medico;
            try {
                medico = em.getReference(Object.class, id);
            } catch (EntityNotFoundException enfe) {
                throw new Exception("Medico com id " + id + " não existe.", enfe);
            }
            em.remove(medico);
            transaction.commit();
        
        } catch(Exception e) {
            e.printStackTrace();
            try {
                transaction.rollback();
            } catch (Exception ex) {
                throw new Exception("Erro ao efetuar rollback: "+ ex);
            }
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    
}
