package io.mero.app.domain.diary.repository;

import io.mero.app.domain.diary.entity.Diary;
import io.mero.app.domain.diary.entity.Photo;
import io.mero.app.domain.diary.entity.UploadStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {

    List<Photo> findByDiaryOrderByOrderIndexAsc(Diary diary);

    List<Photo> findByIsSyncedFalse();

    long countByDiary(Diary diary);

}
