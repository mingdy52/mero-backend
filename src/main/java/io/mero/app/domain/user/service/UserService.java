package io.mero.app.domain.user.service;

import io.mero.app.domain.user.dto.SignUpRequest;
import io.mero.app.domain.user.dto.UserResponse;
import io.mero.app.domain.user.entity.User;
import io.mero.app.domain.user.repository.UserRepository;
import io.mero.app.global.enums.Currency;
import io.mero.app.global.enums.Timezone;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserResponse signUp(SignUpRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("이미 사용 중인 이메일입니다");
        }

        User user = User.builder()
                .email(request.getEmail())
                .passwordHash(passwordEncoder.encode(request.getPassword()))
                .nickname(request.getNickname())
                .defaultCurrency(request.getDefaultCurrency() != null ? request.getDefaultCurrency() : Currency.KRW)
                .timezone(request.getTimezone() != null ? request.getTimezone() : Timezone.ASIA_SEOUL)
                .build();

        User savedUser = userRepository.save(user);

        return UserResponse.from(savedUser);
    }
}