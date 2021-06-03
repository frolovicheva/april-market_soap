package ru.geekbrains.april.market.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.geekbrains.april.market.models.WSProduct;

import java.util.Optional;

@Repository
public interface WSProductRepository extends JpaRepository<WSProduct, Long> {
    @Query("select p from WSProduct p where p.id = ?1")
    Optional<WSProduct> findById(Long id);
}
