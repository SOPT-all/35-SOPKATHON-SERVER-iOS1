package org.sopt.sopkathon.domain.item.api.vo.response;

import java.util.List;

public record ItemsResponseVo(
        List<ItemResponseVo> items
) {
    public static ItemsResponseVo toItemsResponseVo(final List<ItemResponseVo> itemResponseVos) {
        return new ItemsResponseVo(itemResponseVos);
    }
}
