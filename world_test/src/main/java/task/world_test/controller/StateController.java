package task.world_test.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import task.world_test.exception.StateCodeNotFoundException;
import task.world_test.model.States;
import task.world_test.service.StatesService;

@RestController
@RequestMapping("/api2")
public class StateController {
	
	private final StatesService statesService;

	@Autowired
	public StateController(StatesService statesService) {
		this.statesService = statesService;
	}
	
	@GetMapping("/findAllByState")
	public ResponseEntity<List<States>> findAllByState(){
			List<States> states=statesService.findAllByState();
		return new ResponseEntity<>(states,HttpStatus.OK);
	}
	
	@GetMapping("/findByStateCode/{stateCode}")
	public ResponseEntity<Optional<States>> findByStateCode(@PathVariable String stateCode){
		Optional<States> states= statesService.findByStateCode(stateCode);
		return new ResponseEntity<>(states,HttpStatus.OK);
	}
	
	@PostMapping("/createState")
	public ResponseEntity<States> save(@RequestBody States states){
			States states2 = statesService.save(states);
		return new ResponseEntity<>(states2,HttpStatus.OK);
	}
	
	@PutMapping("/updateState/{id}")
	public ResponseEntity<?> update(@RequestBody States states,
						@PathVariable Long id) {
		try {
				States existStates = statesService.get(id);
				statesService.save(states);
				return new ResponseEntity<>(HttpStatus.OK);
			} catch (StateCodeNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getAllStates/{offset}/{pageSize}")
	public Page<States> getAllStates(@PathVariable int offset, @PathVariable int pageSize){
		Page<States> page= statesService.getAllStates(offset, pageSize);
		return page;
	}
	
}
