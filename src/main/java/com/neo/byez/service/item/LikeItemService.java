package com.neo.byez.service.item;


import com.neo.byez.domain.item.LikeItemDto;
import com.neo.byez.domain.item.LikeItemDtos;
import java.util.List;

public interface LikeItemService {

    // 00. 유저 좋아요 상품 목록 조회
    List<LikeItemDto> getLikeItem(String id) throws Exception ;

    // 01. 유저 좋아요 상품 등록
    boolean register(LikeItemDto dto);

    // 02. 유저 좋아요 상품 삭제
    boolean remove(LikeItemDto dto);

    // 03. 유저 좋아요 상품 모두 삭제
    boolean removeAll(String id) throws Exception;

    boolean removeSeveral(LikeItemDtos dtos) throws Exception;

    // 04. 유저 좋아요 상품 변경
    boolean modify(LikeItemDto dto);
}
