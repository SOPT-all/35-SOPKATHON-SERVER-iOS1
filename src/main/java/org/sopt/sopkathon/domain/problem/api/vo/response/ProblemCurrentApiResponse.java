package org.sopt.sopkathon.domain.problem.api.vo.response;

import java.time.format.DateTimeFormatter;
import org.sopt.sopkathon.domain.problem.api.vo.ProblemVo;

public record ProblemCurrentApiResponse(
        boolean isEmpty,
        ProblemCurrentResponseVo problem
) {
    public static ProblemCurrentApiResponse of(boolean isEmpty, ProblemVo problem) {
        ProblemCurrentResponseVo problemCurrentResponseVo = null;
        if (problem != null) {
            problemCurrentResponseVo = ProblemCurrentResponseVo.toProblemCurrentResponseVo(problem, problem.createdAt());
        }
        return new ProblemCurrentApiResponse(
                isEmpty,
                problemCurrentResponseVo
        );
    }
}
