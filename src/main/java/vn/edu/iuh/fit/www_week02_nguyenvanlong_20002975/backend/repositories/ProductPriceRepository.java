package vn.edu.iuh.fit.www_week02_nguyenvanlong_20002975.backend.repositories;

import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.backend.models.ProductPrice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductPriceRepository extends CRUDRepository<ProductPrice> {

    public ProductPriceRepository() {
        super();
        logger = LoggerFactory.getLogger(this.getClass().getName());
    }

    public List<ProductPrice> getAll(int page) {
        try {
            return em.createNamedQuery("ProductPrice.getAll", ProductPrice.class)
                    .setFirstResult((page - 1) * 20)
                    .setMaxResults(20)
                    .getResultList();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return new ArrayList<>();
    }

    public Optional<ProductPrice> findById(LocalDateTime price_date_time, long productId) {
        try {
            ProductPrice productPrice = em.createNamedQuery("ProductPrice.findById", ProductPrice.class)
                    .setParameter("price_date_time", price_date_time)
                    .setParameter("productId", productId)
                    .getSingleResult();

            return Optional.of(productPrice);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return Optional.empty();
    }

    public Optional<ProductPrice> getProductNewPrice(long productId) {
        try {
            ProductPrice productPrice = em.createNamedQuery("ProductPrice.getProductNewPrice", ProductPrice.class)
                    .setParameter("productId", productId)
                    .setMaxResults(1)
                    .getSingleResult();

            return Optional.of(productPrice);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return Optional.empty();
    }

    public List<ProductPrice> getActiveProductsWithNewPrice(int page) {
        try {
            return em.createNamedQuery("ProductPrice.getActiveProductsWithNewPrice", ProductPrice.class)
                    .setFirstResult((page - 1) * 20)
                    .setMaxResults(20)
                    .getResultList();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return new ArrayList<>();
    }

    public long countActiveProductsWithNewPrice() {
        try {
            return em
                    .createNamedQuery("ProductPrice.countActiveProductsWithNewPrice", Long.class)
                    .setMaxResults(1)
                    .getSingleResult();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return 0;
    }
}
