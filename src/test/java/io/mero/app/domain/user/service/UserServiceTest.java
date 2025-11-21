package io.mero.app.domain.user.service;

import io.mero.app.domain.user.dto.SignUpRequest;
import io.mero.app.domain.user.dto.UserResponse;
import io.mero.app.domain.user.entity.User;
import io.mero.app.domain.user.repository.UserRepository;
import io.mero.app.domain.user.service.UserService;
import io.mero.app.global.enums.Currency;
import io.mero.app.global.enums.Timezone;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    @DisplayName("회원가입 성공")
    void 회원가입_성공() {
        // given
        SignUpRequest request = new SignUpRequest(
                "test@example.com",
                "password123",
                "테스트유저",
                null,
                null
        );

        User savedUser = User.builder()
                .email(request.getEmail())
                .passwordHash(request.getPassword())
                .nickname(request.getNickname())
                .defaultCurrency(Currency.KRW)
                .timezone(Timezone.ASIA_SEOUL)
                .build();

        given(userRepository.existsByEmail(request.getEmail())).willReturn(false);
        given(userRepository.save(any(User.class))).willReturn(savedUser);

        // when
        UserResponse response = userService.signUp(request);

        // then
        assertThat(response.getEmail()).isEqualTo("test@example.com");
        assertThat(response.getNickname()).isEqualTo("테스트유저");
        assertThat(response.getDefaultCurrency()).isEqualTo(Currency.KRW);
        assertThat(response.getTimezone()).isEqualTo(Timezone.ASIA_SEOUL);

        verify(userRepository).existsByEmail(request.getEmail());
        verify(userRepository).save(any(User.class));
    }

    @Test
    @DisplayName("회원가입 실패 - 이메일 중복")
    void 회원가입_실패_이메일_중복() {
        // given
        SignUpRequest request = new SignUpRequest(
                "duplicate@example.com",
                "password123",
                "테스트유저",
                null,
                null
        );

        given(userRepository.existsByEmail(request.getEmail())).willReturn(true);

        // when & then
        assertThatThrownBy(() -> userService.signUp(request))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이미 사용 중인 이메일입니다");

        verify(userRepository).existsByEmail(request.getEmail());
    }

    @Test
    @DisplayName("회원가입 - 기본값 설정")
    void 회원가입_기본값_설정() {
        // given
        SignUpRequest request = new SignUpRequest(
                "test@example.com",
                "password123",
                "테스트유저",
                null,  // defaultCurrency null
                null   // timezone null
        );

        User savedUser = User.builder()
                .email(request.getEmail())
                .passwordHash(request.getPassword())
                .nickname(request.getNickname())
                .defaultCurrency(Currency.KRW)
                .timezone(Timezone.ASIA_SEOUL)
                .build();

        given(userRepository.existsByEmail(request.getEmail())).willReturn(false);
        given(userRepository.save(any(User.class))).willReturn(savedUser);

        // when
        UserResponse response = userService.signUp(request);

        // then
        assertThat(response.getDefaultCurrency()).isEqualTo(Currency.KRW);
        assertThat(response.getTimezone()).isEqualTo(Timezone.ASIA_SEOUL);
    }

    @Test
    @DisplayName("회원가입 실패 - 닉네임 중복")
    void 회원가입_실패_닉네임_중복() {
        // given
        SignUpRequest request = new SignUpRequest(
                "test@example.com",
                "password123",
                "중복닉네임",
                null,
                null
        );

        given(userRepository.existsByEmail(request.getEmail())).willReturn(false);
        given(userRepository.existsByNickname(request.getNickname())).willReturn(true);

        // when & then
        assertThatThrownBy(() -> userService.signUp(request))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이미 사용 중인 닉네임입니다");

        verify(userRepository).existsByEmail(request.getEmail());
        verify(userRepository).existsByNickname(request.getNickname());
    }
}