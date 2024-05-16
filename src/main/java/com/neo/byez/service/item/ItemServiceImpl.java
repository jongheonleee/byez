package com.neo.byez.service.item;


import com.neo.byez.dao.item.ItemDao;
import com.neo.byez.dao.item.ItemDaoImpl;
import com.neo.byez.domain.item.ItemDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ItemServiceImpl {

    @Autowired
    private ItemDaoImpl dao;

    public ItemServiceImpl() {}

    // 상품 수량 카운트
    public int getCount() {
        // dao를 통해 카운트
            // 예외 -> -1
            // 성공 -> n
        int totalCnt = 0;

        try {
            totalCnt = dao.count();
        } catch (Exception e) {
            e.printStackTrace();
            totalCnt = -1;
        }

        return totalCnt;
    }

    // 상품 모두 조회
    public List<ItemDto> getAllItem() throws Exception {
        // dao를 통해 전체 상품 조회
            // 예외 -> E
            // 성공 -> list
        List<ItemDto> dtos = dao.selectAll();
        return dtos;
    }

//    @Transactional(rollbackFor = Exception.class)
//    public List<ItemDto> getListItem() throws Exception {
//        기준에 따라 그룹핑 가능, 그 말은 sql문 다 세분화하지 않고 자바 코드로 할 수 있음
//        성능은 떨어짐
//    }

    // 상품 단건 조회
    public ItemDto getItem(String num) throws Exception {
        // dao를 통해 특정 상품 조회
            // 예외 -> E
            // 성공 -> dto

        // dao로 상품을 조회
            // 널인지 확인
                // 널이면 예외 되던지기

            // 널이 아님
                // 조회된 dto 반환
        try {
            ItemDto dto = dao.select(num);
            if (dto == null) {
                throw new Exception("상품을 조회하지 못했습니다.");
            }

            return dto;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean add(ItemDto dto) throws Exception {
        try {
            // 상품 등록
            // 상태 등록
            // 가격 등록
            int rowCnt = dao.insert(dto);
            if (rowCnt != 1) {
                throw new Exception("상품을 등록하지 못했습니다.");
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    // 상품 수정
    @Transactional(rollbackFor = Exception.class)
    public boolean modify(ItemDto dto) throws Exception {
        // dao를 통해 특정 상품 수정
            // 성공 -> true
            // 실페 -> false
            // 예외

        // dao를 통해서 상품 업데이트
            // 1 확인
                // true 반환

            // 0 확인
                // 예외 발생
        try {
            int rowCnt = dao.update(dto);
            if (rowCnt != 1) {
                throw new Exception("상품을 업데이트하지 못했습니다.");
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    // 상품 삭제
    @Transactional(rollbackFor = Exception.class)
    public boolean remove(ItemDto dto) throws Exception {
        // dao를 통해 특정 상품 삭제
            // 예외, 실패 -> f
            // 성공 -> t

        // dao를 통해서 상품 삭제
            // 1 확인
                // true 반환

            // 0 확인
                // 예외 발생
        try {
            int rowCnt = dao.delete(dto);
            if (rowCnt != 1) {
                throw new Exception("상품을 삭제하지 못했습니다.");
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    // 상품 모두 삭제
    @Transactional(rollbackFor = Exception.class)
    public boolean removeAll() throws Exception {
        // dao를 통해 특정 상품 모든 삭제
            // 예외, 실패 -> f
            // 성공 -> t

        // dao를 통해서 전체 상품 카운트
            // n

        // dao를 통해서 상품 삭제
            // n
                // true 반환

            // n이 아님
                // 예외 발생
        int totalCnt = dao.count();
        try {
            int rowCnt = dao.deleteAll();
            if (rowCnt != totalCnt) {
                throw new Exception("상품을 모두 삭제하지 못했습니다.");
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }




    //     메인 페이지 여성 top 8 보주기
    public List<ItemDto> showWTop8(ItemDto dto) throws Exception {
        dto.setItem_type("02");
        return dao.selectWTop8(dto);
    }

    //     메인 페이지 남성 top 8 보주기
    public List<ItemDto> showMTop8(ItemDto dto) throws Exception {
        dto.setItem_type("01");
        return dao.selectWTop8(dto);
    }

    //     메인 페이지 혼성 top 8 보주기git commit -m [feat] 상품파트 service 2차 구현"
    public List<ItemDto> showUTop8(ItemDto dto) throws Exception {
        dto.setItem_type("03");
        return dao.selectWTop8(dto);
    }


}
