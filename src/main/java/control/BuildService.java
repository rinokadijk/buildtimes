
package control;

import boundary.Build;
import entity.BuildResult;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BuildService {

    @PersistenceContext
    private EntityManager em;

    public void save(BuildResult build) {
        em.persist(build);
    }

    public List<BuildResult> findAll() {
        return em.createQuery("select b from BuildResult b", BuildResult.class).getResultList();
    }

}
