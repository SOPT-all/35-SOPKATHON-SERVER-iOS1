package org.sopt.sopkathon.domain.item.api.dto.response;

import java.util.List;
import org.sopt.sopkathon.domain.item.api.vo.response.ProblemResponseVo;
import org.sopt.sopkathon.domain.item.api.vo.response.ProblemsResponseVo;

public record ProblemsApiResponse(
        List<ProblemResponseVo> problems
) {
    public static ProblemsApiResponse toProblemsApiResponse(final ProblemsResponseVo problemsResponseVo) {
        return new ProblemsApiResponse(problemsResponseVo.problems());
    }
}
