package repositorio;

import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;
import modelo.Especialidade;
import modelo.Medico;

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

    public List<Medico> buscarTodos() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            return em.createQuery("SELECT z FROM Medico z").getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Medico> buscarPorEspecialidade(Especialidade especialidade) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            return em.createNamedQuery("Medico.buscarPorEspecialidade", Medico.class)
                    .setParameter("especialidade", especialidade)
                    .getResultList();

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public List<Medico> buscarPorMedicoPedro() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            return em.createNamedQuery("Medico.buscarPorMedicoPedro", Medico.class)
                    .getResultList();

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
