package br.com.cpsoftware.avancaif.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cpsoftware.avancaif.app.provider.postgres.model.UserModel;
import br.com.cpsoftware.avancaif.app.provider.postgres.repository.UserRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel userModel = userRepository.findByUsername(username);
        if (userModel == null) {
            throw new UsernameNotFoundException("User not found");
        }

        Set<SimpleGrantedAuthority> grantedAuthorities = userModel.getAuthorities().stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(
                userModel.getUsername(),
                userModel.getPassword(),
                grantedAuthorities);
    }
}
