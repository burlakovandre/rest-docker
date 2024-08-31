package home.rest.repository;

import home.rest.model.Engine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EngineRepository extends JpaRepository<Engine, Long> {
}
