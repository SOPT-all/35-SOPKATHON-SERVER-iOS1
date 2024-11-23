package org.sopt.sopkathon.domain.item.api.vo.response;

import org.sopt.sopkathon.domain.item.api.vo.ItemVo;

public record ItemResponseVo(
        long id,
        String content,
        boolean isSelected
) {
    public static ItemResponseVo toItemResponseVo(final ItemVo itemVo) {
        return new ItemResponseVo(
                itemVo.id(),
                itemVo.content(),
                itemVo.isSelected()
        );
    }
}
