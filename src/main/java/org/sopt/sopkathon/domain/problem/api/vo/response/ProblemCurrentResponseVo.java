package org.sopt.sopkathon.domain.problem.api.vo.response;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.sopt.sopkathon.domain.item.api.vo.ItemVo;
import org.sopt.sopkathon.domain.item.api.vo.ItemsVo;
import org.sopt.sopkathon.domain.problem.api.vo.ProblemVo;

public record ProblemCurrentResponseVo(
        long id,
        String title,
        ItemsVo itemsVo,
        LocalDateTime afterTime
) {
    public static ProblemCurrentResponseVo toProblemCurrentResponseVo(final ProblemVo problemVo, final LocalDateTime afterTime) {
        return new ProblemCurrentResponseVo(
                problemVo.id(),
                problemVo.title(),
                ItemsVo.toItemsVo(problemVo.items().items()),
                afterTime
        );
    }
}
