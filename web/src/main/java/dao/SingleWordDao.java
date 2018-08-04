package dao;

import com.infoshareacademy.emememsy.SingleWord;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Stateless
public class SingleWordDao {

    @PersistenceContext
    private EntityManager entityManager;

    @PostConstruct
    public void initialize() {
        entityManager.createNativeQuery("SET NAMES utf8").executeUpdate();
    }

    @Transactional
    public Long save(SingleWord c) {
        entityManager.persist(c);
        return c.getId();
    }

    @Transactional
    public SingleWord update(SingleWord c) {
        return entityManager.merge(c);
    }

    public void delete(Long id) {
        final SingleWord c = entityManager.find(SingleWord.class, id);
        if (c != null) {
            entityManager.remove(c);
        }
    }

    @Transactional
    public void deleteWord (SingleWord c) {
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

    public List<SingleWord> findAllByUser(String userName) {
        final Query query = entityManager.createQuery("SELECT s FROM SingleWord s WHERE s.userName = :userName");
        query.setParameter("userName", userName);
        return query.getResultList();
    }

    public SingleWord findByCategory2(String category) {
        final Query query = entityManager.createNativeQuery(
               // "SELECT s FROM SingleWord s WHERE s.category = :category"
            "SELECT * FROM WORDS WHERE category = CZŁOWIEK ORDER BY RAND() LIMIT 1");
        return (SingleWord) query.getResultList();
    }

    public List<String> findAllUsers () {
        final Query query = entityManager.createQuery(
                "SELECT s.userName FROM SingleWord s");
        return query.getResultList();
    }

    public List<SingleWord> findByAllCategoriesBrowseModeByUser(String userName){
        final Query query = entityManager.createQuery(
                "SELECT s FROM SingleWord s WHERE s.counter = 0 AND s.userName = :userName" );
        query.setParameter("userName", userName);
        return query.getResultList();
    }

    public List<SingleWord> findByCategoryBrowseModeByUser(String category, String userName){
        final Query query = entityManager.createQuery(
                "SELECT s FROM SingleWord s WHERE s.category = :category AND s.userName = :userName AND s.counter = 0");
        query.setParameter("category", category);
        query.setParameter("userName", userName);
        return query.getResultList();
    }

    public List<SingleWord> findByAllCategoriesLearnMode(){
        final Query query = entityManager.createQuery(
                "SELECT s FROM SingleWord s WHERE s.counter > 0 AND s.counter < 4" );
        return query.getResultList();
    }

    public List<SingleWord> findByCategoryLearnMode(String category){
        final Query query = entityManager.createQuery(
                "SELECT s FROM SingleWord s WHERE s.category = :category AND s.counter > 0 AND s.counter < 4");
        query.setParameter("category", category);
        return query.getResultList();
    }

    public List<SingleWord> findByAllCategoriesRepeatMode(){
        final Query query = entityManager.createQuery(
                "SELECT s FROM SingleWord s WHERE s.counter > 3 AND s.counter < 100" );
        return query.getResultList();
    }

    public List<SingleWord> findByCategoryRepeatMode(String category){
        final Query query = entityManager.createQuery(
                "SELECT s FROM SingleWord s WHERE s.category = :category AND s.counter > 3 AND s.counter < 100");
        query.setParameter("category", category);
        return query.getResultList();
    }

    public List<SingleWord> allDisplayed(){
        final Query query = entityManager.createQuery(
                "SELECT s FROM SingleWord s WHERE s.displayed > 0 ORDER BY s.displayed desc " );
        return query.getResultList();
    }

    public List<SingleWord> mostDifficult(){
        final Query query = entityManager.createQuery(
                "SELECT s FROM SingleWord s WHERE s.bad > 0 ORDER BY s.bad desc " );
        return query.getResultList();
    }

    public Long numberAllDisplayed(){
        final Query query = entityManager.createQuery(
                "SELECT COUNT(s.id) FROM SingleWord s WHERE s.displayed > 0" );
        return (Long)query.getSingleResult();
    }

    public Long totalNumberOfWordsBrowseMode(){
        final Query query = entityManager.createQuery(
                "SELECT COUNT(s.id) FROM SingleWord s WHERE s.counter = 0" );
        return (Long)query.getSingleResult();
    }

    public Long totalNumberOfWordsLearnMode(){
        final Query query = entityManager.createQuery(
                "SELECT COUNT(s.id) FROM SingleWord s WHERE s.counter > 0 and s.counter<4" );
        return (Long)query.getSingleResult();
    }

    public Long totalNumberOfWordsRepeatMode(){
        final Query query = entityManager.createQuery(
                "SELECT COUNT(s.id) FROM SingleWord s WHERE s.counter > 3" );
        return (Long)query.getSingleResult();
    }

    public Long totalNumberOfPassedWords(){
        final Query query = entityManager.createQuery(
                "SELECT COUNT(s.id) FROM SingleWord s WHERE s.counter > 100" );
        return (Long)query.getSingleResult();
    }



}
