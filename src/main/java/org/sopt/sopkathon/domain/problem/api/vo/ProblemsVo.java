package org.sopt.sopkathon.domain.problem.api.vo;

import java.util.List;

public record ProblemsVo(
        List<ProblemVo> problems
) {
    public static ProblemsVo toProblemsVo(final List<ProblemVo> problems) {
        return new ProblemsVo(problems);
    }
}
