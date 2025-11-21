package io.mero.app.domain.user.dto;

import io.mero.app.domain.user.entity.User;
import io.mero.app.global.enums.Currency;
import io.mero.app.global.enums.Timezone;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UserResponse {

    private Long id;
    private String email;
    private String nickname;
    private String profileImage;
    private Currency defaultCurrency;
    private Timezone timezone;
    private LocalDateTime createdAt;

    public static UserResponse from(User user) {
        return new UserResponse(
                user.getId(),
                user.getEmail(),
                user.getNickname(),
                user.getProfileImageUrl(),
                user.getDefaultCurrency(),
                user.getTimezone(),
                user.getCreatedAt()
        );
    }
}