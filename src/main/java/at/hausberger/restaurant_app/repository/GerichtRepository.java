package at.hausberger.restaurant_app.repository;

import at.hausberger.restaurant_app.model.Gericht;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GerichtRepository extends JpaRepository<Gericht, Long> {
}