package at.hausberger.restaurant_app.config;

import at.hausberger.restaurant_app.model.Kunde;
import at.hausberger.restaurant_app.repository.KundeRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class KundeDetailsService implements UserDetailsService {

    private final KundeRepository kundeRepository;

    public KundeDetailsService(KundeRepository kundeRepository) {
        this.kundeRepository = kundeRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        Kunde kunde = kundeRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Kunde nicht gefunden"));

        return User.withUsername(kunde.getEmail())
                .password(kunde.getHashedPassword())
                .roles(kunde.getRolle().name())
                .build();
    }
}