package inti.SAhomepage.article.repository;

import inti.SAhomepage.article.model.FileModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface FileJpaRepository extends  JpaRepository<FileModel, Integer> {
    FileModel findByFileName(String file_name);
    FileModel findByFileId(Integer id);

    @Transactional
    void deleteByFileName(String file_name); // delete 처럼 데이터 수정하는? 일을 수행하는 method의 경우 @Transactional 추가
}
