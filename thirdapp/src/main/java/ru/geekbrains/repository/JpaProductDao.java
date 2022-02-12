package ru.geekbrains.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.domain.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
@Transactional
public class JpaProductDao implements ProductDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Iterable<Product> findAll() {
        return entityManager.createQuery("select p from Product p").getResultList();
    }

    @Override
    public Product findById(Long id) {
        TypedQuery<Product> query = entityManager.createNamedQuery("Product.findById", Product.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public String findNameById(Long id) {
        TypedQuery<String> query = entityManager.createNamedQuery("Product.findNameById", String.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void insert(Product product) {
        entityManager.persist(product);
    }

    @Override
    public void deleteById(Long id) {
        Product savedProduct = findById(id);
        entityManager.remove(savedProduct);
    }
}
