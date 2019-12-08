package hu.vkzsa.alkfejlbead.service;

import hu.vkzsa.alkfejlbead.entity.User;
import hu.vkzsa.alkfejlbead.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save (UserRegistrationDto registrationDto);
}
