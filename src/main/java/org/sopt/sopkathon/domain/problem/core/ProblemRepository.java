package org.sopt.sopkathon.domain.problem.core;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemRepository extends JpaRepository<Problem, Long> {
    List<Problem> getProblemByIsCompleted(Boolean isCompleted);
}
