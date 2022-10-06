package task.world_test.service;

import java.util.List;
import org.springframework.stereotype.Service;
import task.world_test.model.Countries;

@Service
public interface CountriesService {

	public List<Countries> findAllAndOrderByCode();
}
