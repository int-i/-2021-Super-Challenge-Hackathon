package inti.SAhomepage.Board.domain.repository;

import inti.SAhomepage.Board.domain.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {
}
