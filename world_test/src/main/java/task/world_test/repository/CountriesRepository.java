package task.world_test.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import task.world_test.model.Countries;

@Repository
public interface CountriesRepository extends JpaRepository<Countries, Long> {
	
	//1. Vratiti pripadajuće country i state objekte po kontinent kodu (ISO2).
	@Query(value = "SELECT *"
			+ " FROM countries c"
			+ " JOIN states s ON c.iso2=s.country_code"
			+ " ORDER BY continent_code",
			nativeQuery = true)
	List<Countries> findAllAndOrderByCode();		
}
