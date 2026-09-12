package at.hausberger.restaurant_app.repository;

import at.hausberger.restaurant_app.model.Kunde;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KundeRepository extends JpaRepository<Kunde, Long> {
}