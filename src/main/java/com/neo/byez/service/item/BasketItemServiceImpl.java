package com.neo.byez.service.item;


import com.neo.byez.dao.item.BasketItemDaoImpl;
import com.neo.byez.domain.item.BasketItemDto;
import com.neo.byez.domain.item.BasketItemDtos;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BasketItemServiceImpl implements BasketItemService {

    @Autowired
    private BasketItemDaoImpl dao;

    public BasketItemServiceImpl() {}

    // 00. 유저 장바구니 상품 계산(id)
    @Override
    public int getCount(BasketItemDto dto) throws Exception {
        return dao.count(dto);
    }

    // 01. 유저 장바구니 상품 예상 주문 가격 계산
    @Override
    public int getPrice(BasketItemDto dto) throws Exception {
        // 유저의 장바구니 상품 목록 조회
        List<BasketItemDto> list = dao.getList(dto);
        // 주문 예상 금액 계산
        return list.stream()
                   .mapToInt(item -> item.getPrice() * item.getQty())
                   .sum();
    }

    // 02. 유저 장바구니 상품 조회(id)
    // 수정
    @Override
    public List<BasketItemDto> getBasketItem(BasketItemDto dto) throws Exception {
        List<BasketItemDto> list = null;
        try {
            list = dao.getList(dto);
            if (list == null) {
                throw new Exception("상품 조회 실패");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return list;
    }

    // 03. 유저 장바구니 상품 단건 조회(id, seq)
    // 수정
    @Override
    public BasketItemDto getOneBasketIem(BasketItemDto dto) throws Exception {
        BasketItemDto selectedDto = null;

        try {
             selectedDto = dao.get(dto);
             if (selectedDto == null) {
                 throw new Exception("상품을 정상적으로 조회하지 못함");
             }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        return selectedDto;
    }


    // 04. 유저 장바구니 상품 등록(id, dto => dto)
        // 04-0. 같은 상품이 있을 경우
            // -1 반환해서, 정상적으로 처리 안됐음을 알림

        // 04-1. 같은 상품이 없는 경우
            // dao.insert(dto) 반환

    // tx : 중간에 끼어들지 못하게 막기, 예외 났을 때 롤백 처리하기

    // tx x : 끼어들지 못하게 막음
    // 수정
    @Override
    public boolean register(BasketItemDto dto) {
        int rowCnt = 0;
        try {
            // 유저의 장바구니 상품 목록 조회
            List<BasketItemDto> list = dao.getList(dto);

            // 중복되는 상품 확인
            boolean isDuplicated = list.stream()
                                       .anyMatch( item -> item.equals(dto));

            if (!isDuplicated) {
                rowCnt = dao.insert(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rowCnt == 1;
    }

    // 05. 유저 장바구니 상품 삭제(id, seq)
    // 수정
    @Override
    public boolean remove(BasketItemDto dto) {
        int rowCnt = 0;

        try {
            rowCnt = dao.delete(dto);
            if (rowCnt != 1) {
                throw new Exception("상품을 정상적으로 삭제하지 못했습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowCnt == 1;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean removeSeveral(BasketItemDtos dtos) throws Exception {
        List<BasketItemDto> list = dtos.getOrders();
        int selectedCnt = list.size();
        int removeCnt = 0;

        try {
            for (BasketItemDto dto : list) {
                removeCnt += remove(dto) ? 1 : 0;
            }

            if (removeCnt != selectedCnt) {
                throw new Exception("제대로 삭제되지 않았습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        return removeCnt == selectedCnt;
    }

    // 06. 유저 장바구니 상품 모두 삭제(id)
    // 수정

    @Override
    public boolean removeAll(BasketItemDto dto) {
        int rowCnt = 0;
        int totalCnt = 0;

        try {
            // 기존의 장바구니 상품 카운트
            totalCnt = dao.count(dto);

            // 적용된 로우수
            rowCnt = dao.deleteAll(dto);

            // 기존의 장바구니 상품 카운트와 적용된 로우수가 다른 경우 예외 발생
            if (totalCnt != rowCnt) {
                throw new Exception("모든 상품이 정상적으로 삭제되지 않았습니다.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rowCnt == totalCnt;
    }

    // 07. 유저 장바구니 상품 내용으로 삭제(id, dto => dto)
    // 수정
    @Override
    public int removeByContent(BasketItemDto dto) throws Exception {
        return dao.deleteByContent(dto);
    }

    // 05. 💥 유저 장바구니 상품 업데이트(id, dto => dto)
        // 05-0. 변경하려는 상품이 기존의 상품과 중복되는 경우
            // 기존의 상품과 변경하려는 상품의 수량을 합산해서
            // 기존의 상품 수량만 업데이트해서 새로운 상품 등록
            // 기존의 상품 삭제

        // 05-1. 중복되지 않는 경우
            // 업데이트

    // 수정?
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean modify(BasketItemDto updatedDto) throws Exception {
        // 변경하려는 상품 조회(단건 조회)
        Optional<BasketItemDto> originalDto = Optional.ofNullable(dao.get(updatedDto));

        try {
            // 존재하지 않는 상품
            if (originalDto.isEmpty()) {
                throw new Exception("기존의 변경하려는 상품이 장바구니에 존재하지 않습니다.");
            }


            // 수량만 바뀐 경우
            if (originalDto.get().equals(updatedDto)) {
                return dao.update(updatedDto) == 1;
            }

            // 옵션도 변경하는 경우
            List<BasketItemDto> list = dao.getList(updatedDto);
            Optional<BasketItemDto> duplicatedDto = list.stream()
                                                         .filter(dto -> dto.equals(updatedDto) && dto.getSeq() != updatedDto.getSeq())
                                                         .findFirst();


            int rowCnt = 0;
            // 해당 상품이 장바구니에 이미 존재하는 경우, 수량만 바꿔줌
            if (duplicatedDto.isPresent()) {
                int sumQty = updatedDto.getQty() + duplicatedDto.get().getQty();
                updatedDto.setQty(sumQty);

                // 기존의 상품 삭제하고, 이미 존재하는 상품 삭제, 상품 재등록
                rowCnt = dao.delete(updatedDto) + dao.delete(duplicatedDto.get()) + dao.insert(updatedDto);

                // 정상적으로 처리되지 않음
                if (rowCnt != 3) {
                    throw new Exception("상품이 정상적으로 업데이트 되지 않았습니다.");
                }

                return rowCnt == 3;
            } else { // 해당 상품이 장바구니에 없는 경우
                // 기존의 상품 삭제하고 새로운 상품으로 등록
                rowCnt = dao.delete(originalDto.get()) + dao.insert(updatedDto);

                // 정상적으로 처리되지 않음
                if (rowCnt != 2) {
                    throw new Exception("상품이 정상적으로 업데이트 되지 않았습니다.");
                }

                return rowCnt == 2;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
