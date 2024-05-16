package com.neo.byez.dao.item;

import com.neo.byez.domain.item.LikeItemDto;
import java.util.List;

public interface LikeItemDao {

    // 00. 유저 좋아요 상품 카운트
    int count(String id) throws Exception;

    // 01. 유저 좋아요 상품 단건 조회
    LikeItemDto select(LikeItemDto dto) throws Exception;

    // 02. 유저 좋아요 상품 리스트 조회
    List<LikeItemDto> selectAll(String id) throws Exception;

    // 03. 유저 좋아요 상품 등록
    int insert(LikeItemDto dto) throws Exception;

    // 04. 유저 좋아요 상품 삭제
    int delete(LikeItemDto dto) throws Exception;

    // 05. 유저 좋아요 상품 모두 삭제
    int deleteAll(String id) throws Exception;

    // 06. 유저 좋아요 상품 업데이트
    int update(LikeItemDto dto) throws Exception;
}
