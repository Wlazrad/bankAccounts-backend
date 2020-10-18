package pl.wlazrad.demo.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.wlazrad.demo.security.User;
import pl.wlazrad.demo.security.repository.UserRepository;
import pl.wlazrad.demo.security.services.UserDetailsImpl;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String pesel) throws UsernameNotFoundException {
        User user = userRepository.findByPesel(pesel)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + pesel));

        return UserDetailsImpl.build(user);
    }
}
