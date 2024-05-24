package com.neo.byez.service.item;

import com.neo.byez.domain.item.*;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

public interface BasketItemService {

    // 00. 유저 장바구니 상품 계산
    int getCount(BasketItemDto dto) throws Exception;

    // 01. 유저 장바구니 상품 조회
    List<BasketItemDto> getBasketItem(BasketItemDto dto) throws Exception;

    BasketItemDto getOneBasketIem(BasketItemDto dto) throws Exception;

    // 02. 같은 상품이 없는 경우
    // dao.insert(dto) 반환
    boolean register(BasketItemDto dto);

    // 03. 유저 장바구니 상품 삭제
    boolean remove(BasketItemDto dto);

    boolean removeSeveral(BasketItemDtos dtos);


    // 04. 유저 장바구니 상품 모두 삭제
    boolean removeAll(BasketItemDto dto);

    // 05. 유저 장바구니 상품 내용으로 삭제
    int removeByContent(BasketItemDto dto) throws Exception;

    // 06. 중복되지 않는 경우
    // 업데이트
    @Transactional(rollbackFor = Exception.class)
    boolean modify(BasketItemDto dto) throws Exception;

    int getPrice(BasketItemDto dto) throws Exception;

    BasketItemDto readByContent(BasketItemDto dto) throws Exception;
}
