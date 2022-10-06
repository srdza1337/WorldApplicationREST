package task.world_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task.world_test.model.Continents;

@Repository
public interface ContinentsRepository extends JpaRepository<Continents, Long>{

}
