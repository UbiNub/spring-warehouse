package nl.averageflow.springwarehouse.domain.user;

import nl.averageflow.springwarehouse.domain.user.repository.UserRepository;
import nl.averageflow.springwarehouse.domain.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService, UserServiceContract {

    @Autowired
    private UserRepository userRepository;

    public Page<User> getUsers(final Pageable pageable) {
        return this.userRepository.findAll(pageable);
    }

    public Optional<User> getUserByUid(final UUID uid) {
        return this.userRepository.findByUid(uid);
    }

    public void deleteUserByUid(final UUID uid) {
        this.userRepository.deleteByUid(uid);
    }

    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        final Optional<User> user = this.userRepository.findByEmail(email);

        if (user.isEmpty()) {
            throw new UsernameNotFoundException("could not find email: " + email);
        }

        return new nl.averageflow.springwarehouse.domain.authentication.dto.UserDetails(user.get());
    }
}
