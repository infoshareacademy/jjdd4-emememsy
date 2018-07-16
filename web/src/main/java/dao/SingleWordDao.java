package dao;

import com.infoshareacademy.emememsy.SingleWord;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class SingleWordDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Long save(SingleWord c) {
        entityManager.persist(c);
        return c.getId();
    }

    public SingleWord update(SingleWord c) {
        return entityManager.merge(c);
    }

    public void delete(Long id) {
        final SingleWord c = entityManager.find(SingleWord.class, id);
        if (c != null) {
            entityManager.remove(c);
        }
    }

    public SingleWord findById(Long id) {
        return entityManager.find(SingleWord.class, id);
    }

    public List<SingleWord> findAll() {
        final Query query = entityManager.createQuery("SELECT s FROM SingleWord s");
        return query.getResultList();
    }

    public SingleWord findByCategory(String category) {
        final Query query = entityManager.createNativeQuery(
            "SELECT * FROM WORDS WHERE category = CZŁOWIEK ORDER BY RAND() LIMIT 1");
        return (SingleWord) query.getResultList();
    }


}
