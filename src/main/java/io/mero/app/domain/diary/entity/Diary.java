package io.mero.app.domain.diary.entity;

import io.mero.app.domain.trip.entity.Trip;
import io.mero.app.domain.user.entity.User;
import io.mero.app.global.embedded.Location;
import io.mero.app.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Diary extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_id", nullable = false)
    private Trip trip;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false)
    private LocalDate date;

    @Embedded
    private Location location;

    @Column(name = "weather_info", length = 100)
    private String weatherInfo;

    @Column(name = "is_synced", nullable = false)
    private Boolean isSynced = false;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Version
    private Long version;

    @Column(name = "last_modified_at", nullable = false)
    private LocalDateTime lastModifiedAt;

    @Builder
    public Diary(User user, Trip trip, String title, String content,
                 LocalDate date, Location location, String weatherInfo) {
        this.user = user;
        this.trip = trip;
        this.title = title;
        this.content = content;
        this.date = date;
        this.location = location;
        this.weatherInfo = weatherInfo;
        this.isSynced = false;
        this.lastModifiedAt = LocalDateTime.now();
    }

    public void updateTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("일기 제목은 필수입니다");
        }
        this.title = title;
        this.lastModifiedAt = LocalDateTime.now();
    }

    public void updateContent(String content) {
        this.content = content;
        this.lastModifiedAt = LocalDateTime.now();
    }

    public void updateDate(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("날짜는 필수입니다");
        }
        this.date = date;
        this.lastModifiedAt = LocalDateTime.now();
    }

    public void updateLocation(Location location) {
        this.location = location;
        this.lastModifiedAt = LocalDateTime.now();
    }

    public void updateWeather(String weatherInfo) {
        this.weatherInfo = weatherInfo;
        this.lastModifiedAt = LocalDateTime.now();
    }

    // === 동기화 관리 ===
    public void markAsSynced() {
        this.isSynced = true;
        this.lastModifiedAt = LocalDateTime.now();
    }

    public void markAsUnsynced() {
        this.isSynced = false;
        this.lastModifiedAt = LocalDateTime.now();
    }

    // === Soft Delete ===
    public void delete() {
        this.deletedAt = LocalDateTime.now();
        this.lastModifiedAt = LocalDateTime.now();
    }

    public void restore() {
        this.deletedAt = null;
        this.lastModifiedAt = LocalDateTime.now();
    }

    public boolean isDeleted() {
        return this.deletedAt != null;
    }

}
