
package control;

import boundary.Build;
import entity.Mood;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class BuildService {

    @PersistenceContext
    private EntityManager em;

    public void save(Build build) {
        em.persist(build);
    }

    public List<Build> findAll() {
        return em.createQuery("select b from Build b", Build.class).getResultList();
    }

}
