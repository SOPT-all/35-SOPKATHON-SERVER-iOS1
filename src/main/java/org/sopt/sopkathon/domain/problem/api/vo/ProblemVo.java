package org.sopt.sopkathon.domain.problem.api.vo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.sopt.sopkathon.domain.item.api.vo.ItemVo;
import org.sopt.sopkathon.domain.item.api.vo.ItemsVo;
import org.sopt.sopkathon.domain.item.core.Item;
import org.sopt.sopkathon.domain.problem.core.Problem;

public record ProblemVo(
        long id,
        String title,
        ItemsVo items,
        LocalDateTime createdAt,
        LocalDateTime completedAt,
        boolean isCompleted
) {
    public static ProblemVo toProblemVo(final Problem problem) {
        List<ItemVo> items = new ArrayList<>();
        problem.getItems().forEach(item -> {
            items.add(ItemVo.itemVo(item));
        });

        return new ProblemVo(
                problem.getId(),
                problem.getTitle(),
                ItemsVo.toItemsVo(items),
                problem.getCreatedAt(),
                problem.getCompletedAt(),
                problem.isCompleted()
        );
    }
}
