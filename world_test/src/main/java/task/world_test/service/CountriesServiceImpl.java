package task.world_test.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import task.world_test.exception.StateCodeNotFoundException;
import task.world_test.model.Countries;
import task.world_test.model.States;
import task.world_test.repository.CountriesRepository;
import task.world_test.repository.StatesRepository;

@Service
public class CountriesServiceImpl implements CountriesService {
	
	private final CountriesRepository countriesRepository;
	
	@Autowired
	public CountriesServiceImpl(CountriesRepository countriesRepository) {
		this.countriesRepository = countriesRepository;
	}
	
	public List<Countries> findAllAndOrderByCode(){
		return countriesRepository.findAllAndOrderByCode();
	}
}
