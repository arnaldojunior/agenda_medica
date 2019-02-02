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

    public void create(Object medico) throws Exception {

        EntityManager em = null;
        try {
            transaction.begin();
            em = getEntityManager();
            em.persist(medico);
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            try {
                transaction.rollback();
            } catch (Exception ex) {
                throw new Exception("Erro ao efetuar rollback: " + ex);
            }
        } finally {
            if (em != null) {
                em.close();
            }
        }
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
}
