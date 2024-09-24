package JavaProject.Sqlite.global.security.auth;


import JavaProject.Sqlite.domain.user.entity.User;
import JavaProject.Sqlite.domain.user.exception.UserNotFoundException;
import JavaProject.Sqlite.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String accountId) {

        User user = userRepository.findByAccountId(accountId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        return new AuthDetails(user.getAccountId());

    }
}
