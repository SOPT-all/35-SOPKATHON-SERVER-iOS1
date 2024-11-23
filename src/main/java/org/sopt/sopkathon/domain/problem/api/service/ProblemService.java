package org.sopt.sopkathon.domain.problem.api.service;

import org.sopt.sopkathon.domain.problem.api.vo.ProblemVo;
import org.sopt.sopkathon.domain.problem.api.vo.ProblemsVo;
import org.sopt.sopkathon.domain.problem.core.Problem;
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

    @Transactional
    public void patchProblem(
            final long problemId,
            final long itemId
    ) {
        Problem problem = problemRepository.findById(problemId).orElseThrow(
                () -> new IllegalArgumentException()
        );

        problem.getItems().forEach(item -> {
            if (item.getId() == itemId) {
                item.setIsSelected(true);
            }
        });
    }
}
