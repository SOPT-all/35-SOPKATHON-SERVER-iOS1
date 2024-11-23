package org.sopt.sopkathon.domain.item.api.vo;

import org.sopt.sopkathon.domain.item.core.Item;

public record ItemVo(
        long id,
        String content,
        boolean isSelected
) {
    public static ItemVo itemVo(final Item item) {
        return new ItemVo(
                item.getId(),
                item.getContent(),
                item.getSelected()
        );
    }
}
