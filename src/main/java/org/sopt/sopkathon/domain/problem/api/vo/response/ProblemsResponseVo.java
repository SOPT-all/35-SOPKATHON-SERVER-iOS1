package org.sopt.sopkathon.domain.problem.api.vo.response;

import java.util.List;

public record ProblemsResponseVo (
    List<ProblemResponseVo> problems
){
    public static ProblemsResponseVo toProblemsResponseVo(final List<ProblemResponseVo> problems) {
        return new ProblemsResponseVo(problems);
    }
}
