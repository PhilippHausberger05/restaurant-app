package at.hausberger.restaurant_app.repository;

import at.hausberger.restaurant_app.model.Bestellung;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BestellungRepository extends JpaRepository<Bestellung, Long> {
}
