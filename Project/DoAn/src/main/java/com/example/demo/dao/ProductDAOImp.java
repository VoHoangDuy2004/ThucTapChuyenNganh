        package com.example.demo.dao;

        import com.example.demo.entity.Product;
        import jakarta.persistence.EntityManager;
        import jakarta.persistence.TypedQuery;
        import jakarta.transaction.Transactional;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.security.core.parameters.P;
        import org.springframework.stereotype.Repository;

        import java.util.List;

        @Repository
        public class ProductDAOImp implements ProductDAO {
            private EntityManager em;
            @Autowired
            public ProductDAOImp(EntityManager em){
                this.em=em;
            }
            @Override
            public List<Product> findAll() {
                TypedQuery<Product> query=em.createQuery("from Product",Product.class);
                return query.getResultList();
            }

            @Override
            public Product findById(int id) {
                return em.find(Product.class, id);
            }

            @Transactional
            @Override
            public Product save(Product product) {
                return em.merge(product);
            }

            @Transactional
            @Override
            public void deleteById(int id) {
                Product product = findById(id);
                em.remove(product);
            }

            @Override
            public List<Product> findAllByStatus(String status) {
                TypedQuery<Product> query = em.createQuery(
                        "from Product p join p.category c where p.status = :status and c.status = 'active' order by p.price",
                        Product.class
                );
                query.setParameter("status", status);
                return query.getResultList();
            }

            @Override
            public List<Product> findByCategoryId(int id_cate) {
                TypedQuery<Product> query = em.createQuery(
                        "select p from Product p join p.category c " +
                                "where p.status = 'active' " +
                                "and c.status = 'active' " +
                                "and c.id = :cid " +
                                "order by p.price",
                        Product.class
                );

                query.setParameter("cid", id_cate);

                return query.getResultList();
            }


        }
