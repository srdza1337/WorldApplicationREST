package task.world_test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import task.world_test.model.States;

@Service
public interface StatesService  {
	public List<States> findAllByState();
	public Optional<States> findByStateCode(String stateCode);
	public States save(States states);
	public States get(Long id);
	public Page<States> getAllStates(int offset, int pageSize);
}
