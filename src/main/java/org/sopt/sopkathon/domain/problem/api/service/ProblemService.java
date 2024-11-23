package org.sopt.sopkathon.domain.problem.api.service;

import org.sopt.sopkathon.domain.problem.api.vo.ProblemVo;
import org.sopt.sopkathon.domain.problem.api.vo.ProblemsVo;
import org.sopt.sopkathon.domain.problem.core.ProblemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProblemService {

    private final ProblemRepository problemRepository;

    public ProblemService(ProblemRepository problemRepository) {
        this.problemRepository = problemRepository;
    }

    @Transactional(readOnly = true)
    public ProblemsVo getNotCompletedProblems() {
        return ProblemsVo.toProblemsVo(
                problemRepository.getProblemByCompletedFalse().stream()
                        .map(ProblemVo::toProblemVo)
                        .toList()
        );
    }
}
