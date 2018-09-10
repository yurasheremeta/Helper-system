package ua.logos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.logos.domain.UserDTO;
import ua.logos.entity.UserEntity;
import ua.logos.repository.UserRepository;
import ua.logos.service.UserService;
import ua.logos.utils.ObjectMapperUtils;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ObjectMapperUtils modelMapper;
	@Override
	public void save(UserDTO dto) {
		UserEntity entity = modelMapper.map(dto, UserEntity.class);
		userRepository.save(entity);
	}
	@Override
	public List<UserDTO> findAllUsers() {
		List<UserEntity> entity = userRepository.findAll();
		List<UserDTO> dto = modelMapper.mapAll(entity, UserDTO.class);
		return dto;
	}
	@Override
	public UserDTO findById(Long id) {
		UserEntity entity = userRepository.findById(id).get();
		return modelMapper.map(entity, UserDTO.class);
	}
	@Override
	public void upate(UserDTO dto) {
		userRepository.save(modelMapper.map(dto, UserEntity.class));
	}
	@Override
	public void delete(Long id) {
		userRepository.deleteById(id);
	}
	
	

}