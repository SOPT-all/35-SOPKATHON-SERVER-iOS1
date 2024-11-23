package org.sopt.sopkathon.domain.item.api.vo.response;

import java.util.ArrayList;
import java.util.List;
import org.sopt.sopkathon.domain.problem.api.vo.ProblemsVo;

public record ProblemsResponseVo (
    List<ProblemResponseVo> problems
){
    public static ProblemsResponseVo toProblemsResponseVo(final List<ProblemResponseVo> problems) {
        return new ProblemsResponseVo(problems);
    }
}
