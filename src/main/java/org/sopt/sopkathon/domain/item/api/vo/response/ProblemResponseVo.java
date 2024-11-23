package org.sopt.sopkathon.domain.item.api.vo.response;

import java.util.ArrayList;
import java.util.List;
import org.sopt.sopkathon.domain.problem.api.vo.ProblemVo;

public record ProblemResponseVo(
        long id,
        String title,
        ItemsResponseVo items,
        String startDate,
        String endDate
) {
    public static ProblemResponseVo of(
            final ProblemVo problemVo,
            final String startDate,
            final String endDate
    ) {
        List<ItemResponseVo> itemResponseVos = new ArrayList<>();
        problemVo.items().items().forEach(item -> {
            itemResponseVos.add(ItemResponseVo.toItemResponseVo(item));
        });
        return new ProblemResponseVo(
                problemVo.id(),
                problemVo.title(),
                ItemsResponseVo.toItemsResponseVo(itemResponseVos),
                startDate,
                endDate
        );
    }
}
