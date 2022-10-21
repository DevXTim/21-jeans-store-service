package kg.jeansstoreservice.jeansstoreservice.repository;

import kg.jeansstoreservice.jeansstoreservice.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Item, Long> {
}
