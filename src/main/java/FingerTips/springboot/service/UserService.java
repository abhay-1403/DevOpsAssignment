package FingerTips.springboot.service;

import FingerTips.springboot.model.User;
import FingerTips.springboot.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
