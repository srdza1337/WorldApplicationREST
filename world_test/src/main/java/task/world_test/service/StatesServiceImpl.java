package task.world_test.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.world_test.exception.StateCodeNotFoundException;
import task.world_test.model.States;
import task.world_test.repository.StatesRepository;

@Service
public class StatesServiceImpl implements StatesService{

	private final StatesRepository statesRepository; 
	
	@Autowired
	public StatesServiceImpl(StatesRepository statesRepository) {
		super();
		this.statesRepository = statesRepository;
	}
	
	public List<States> findAllByState(){
		return statesRepository.findAllByState();
	}
	
	public Optional<States> findByStateCode(String stateCode){
		Optional<States> states = Optional.ofNullable((statesRepository.findByStateCode(stateCode).orElseThrow(()->
					new StateCodeNotFoundException( "State with stateCode: " + stateCode + " could not be found. Please check again!"))));
		return states;
	}

	public States save(States states){
		return statesRepository.save(states);
	}
	
	public States get(Long id) {
		return statesRepository.findById(id).get();
	}
	
	public List<States> getAllStates(){
		return statesRepository.getAllStates();
	}
}
