package task.world_test.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import task.world_test.model.States;

@Repository
public interface StatesRepository extends JpaRepository<States, Long>{
	
	
	// Vratiti pripadajuće state objekte po country kodu (ISO2), a takođe vraiti i kom kontinentu pripada.
	@Query(value = "SELECT s.id, s.country_code, s.state_code, s.state_name, c.name"
			+ " FROM  states s"
			+ " JOIN countries b ON b.iso2=s.country_code"
			+ " JOIN continents c ON b.continent_code=c.iso2"
			+ " ORDER BY s.country_code",nativeQuery = true)
	List<States> findAllByState();
	
	//3. Vratiti kojoj državi i kontinentu pripada state za prosleđen state kod.
	Optional<States> findByStateCode(String stateCode);
	
	@Query("Select s from States s ")
	public List<States> getAllStates();
	

}
