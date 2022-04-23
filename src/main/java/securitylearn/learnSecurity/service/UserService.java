package securitylearn.learnSecurity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import securitylearn.learnSecurity.domain.User;
import securitylearn.learnSecurity.dto.UserDto;
import securitylearn.learnSecurity.repository.UserRepository;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    /*
    ==Spring Security 필수 메소드==
    @param email
    @return UserDetails
    @throws UsernameNotFoundException -> 유저 없을때 예외
     */

    @Override
    public User loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException((email)));
    }

    /*
    회원 정보 저장
    @param UserDto
    @return 저장되어있는 회원의 pk
     */

    public Long save(UserDto userDto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        userDto.setPassword(encoder.encode(userDto.getPassword()));  //pw암호화

        return userRepository.save(User.builder()
                .email(userDto.getEmail())
                .auth(userDto.getAuth())
                .password(userDto.getPassword()).build()
        ).getCode();  //id값 반환
    }
}
