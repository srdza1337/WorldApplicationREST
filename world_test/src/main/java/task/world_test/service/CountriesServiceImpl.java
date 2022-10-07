package task.world_test.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.world_test.model.Countries;
import task.world_test.repository.CountriesRepository;

@Service
public class CountriesServiceImpl implements CountriesService {
	
	private final CountriesRepository countriesRepository;
	
	@Autowired
	public CountriesServiceImpl(CountriesRepository countriesRepository) {
		this.countriesRepository = countriesRepository;
	}
	
	public List<Countries> findAllAndOrderByCode(){
		List<Countries> countries= countriesRepository.findAllAndOrderByCode();
		return countries;
	}
}
