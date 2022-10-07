package task.world_test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import task.world_test.model.Countries;
import task.world_test.service.CountriesService;

@RestController
@RequestMapping("/api1")
public class CountriesController {

	private final CountriesService countriesService;

	@Autowired
	public CountriesController(CountriesService countriesService) {
		this.countriesService = countriesService;
	}

	@GetMapping("/order")
	public ResponseEntity<List<Countries>> findAllAndOrderByCode(){
			List<Countries> countries= countriesService.findAllAndOrderByCode();
		return new ResponseEntity<>(countries,HttpStatus.OK);
		}
}
