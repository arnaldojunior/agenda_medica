/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorio;

import java.util.List;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;
import modelo.Especialidade;

/**
 *
 * @author root
 */
public class EspecialidadeRepositorio {
    
    @PersistenceUnit(unitName = "agendaMedicaPU")
    EntityManagerFactory emf;

    @Resource
    UserTransaction transaction;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public List<Especialidade> buscarTodos() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            return em.createQuery("SELECT e FROM Especialidade e").getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
