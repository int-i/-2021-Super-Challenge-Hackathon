package inti.SAhomepage.Board.domain.repository;

import inti.SAhomepage.Board.domain.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
