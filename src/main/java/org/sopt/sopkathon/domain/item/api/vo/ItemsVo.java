package org.sopt.sopkathon.domain.item.api.vo;

import java.util.List;

public record ItemsVo(
        List<ItemVo> items
) {
    public static ItemsVo toItemsVo(final List<ItemVo> items) {
        return new ItemsVo(items);
    }
}
