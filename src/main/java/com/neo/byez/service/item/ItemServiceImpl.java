package com.neo.byez.service.item;


import com.neo.byez.dao.item.ItemColorDaoImpl;
import com.neo.byez.dao.item.ItemDao;
import com.neo.byez.dao.item.ItemDaoImpl;
import com.neo.byez.dao.item.ItemDetailDaoImpl;
import com.neo.byez.dao.item.ItemPriceDaoImpl;
import com.neo.byez.dao.item.ItemSizeDaoImpl;
import com.neo.byez.dao.item.ItemStateDaoImpl;
import com.neo.byez.domain.item.AdminItemDto;
import com.neo.byez.domain.item.Category;
import com.neo.byez.domain.item.ItemDetailDto;
import com.neo.byez.domain.item.ItemDetailPageDto;
import com.neo.byez.domain.item.ItemDto;
import com.neo.byez.domain.item.ItemOptDto;
import com.neo.byez.domain.item.ItemPriceDto;
import com.neo.byez.domain.item.ItemRegisterInfo;
import com.neo.byez.domain.item.ItemStateDto;
import com.neo.byez.domain.item.SearchCondition;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ItemServiceImpl {
    /* 필요 dao */

    // 1. item : 메인페이지에 띄워줄 대상
    // 2. item_state : 변경이 자주 일어나는 컬럼 기록, 갱신
    // 3. item_detail : 무겁고 상세한 내용 포함
    // 4. item_price : 가격 정보, 선분 이력으로 할인율 관리
    // 5. item_color : 보여줄 상품 색상 옵션
    // 6. item_size : 보여줄 상품 사이즈 옵션
    // 7. review : 별점, 리뷰수 계산

    // # 추후에 재고 테이블도 따로 만들어야함

    private static final StringBuilder sb = new StringBuilder();

    private ItemDaoImpl itemDao;
    private ItemStateDaoImpl itemStateDao;
    private ItemDetailDaoImpl itemDetailDao;
    private ItemPriceDaoImpl itemPriceDao;
    private ItemColorDaoImpl itemColorDao;
    private ItemSizeDaoImpl itemSizeDao;

//    private ReviewDaoImpl reviewDao;


    public ItemServiceImpl() {}
    @Autowired
    public ItemServiceImpl(ItemDaoImpl itemDao, ItemStateDaoImpl itemStateDao, ItemDetailDaoImpl itemDetailDao,
                           ItemPriceDaoImpl itemPriceDao, ItemColorDaoImpl itemColorDao, ItemSizeDaoImpl itemSizeDao) {
        this.itemDao = itemDao;
        this.itemStateDao = itemStateDao;
        this.itemDetailDao = itemDetailDao;
        this.itemPriceDao = itemPriceDao;
        this.itemColorDao = itemColorDao;
        this.itemSizeDao = itemSizeDao;
    }


    // 상품 수량 카운트
    public int getCount() {
        // dao를 통해 카운트
            // 예외 -> -1
            // 성공 -> n
        int totalCnt = 0;

        try {
            totalCnt = itemDao.count();
        } catch (Exception e) {
            e.printStackTrace();
            totalCnt = -1;
        }

        return totalCnt;
    }

    // 상품 모두 조회
    public List<ItemDto> getAllItem(Integer page, Integer pageSize) throws Exception {
        // dao를 통해 전체 상품 조회
            // 예외 -> E
            // 성공 -> list
//        List<ItemDto> dtos = itemDao.selectAll();
        return itemDao.selectAll(page, pageSize);
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
            ItemDto dto = itemDao.select(num);
            if (dto == null) {
                throw new Exception("상품을 조회하지 못했습니다.");
            }

            return dto;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Transactional(rollbackFor = Exception.class) // 상품 정보 등록, TX 처리(중복 등록 방지)
    public boolean add(ItemDto itemDto, ItemDetailDto itemDetailDto, ItemStateDto itemStateDto,
            List<ItemOptDto> itemSizeDtos, List<ItemOptDto> itemColorDtos, ItemPriceDto itemPriceDto) throws Exception {
        /* 처리 작업 */
            // 상품 등록 => 1, ItemDto
            // 상품 상세 등록 => 1, ItemDetailDto
            // 상품 상태 등록 => 1, ItemStateDto
                // 재고량 n, 이외의 값 0

            // 상품 사이즈 등록 => n1, List<ItemOptDto>
                // 등록된 사이즈 n 추가

            // 상품 색상 등록 => n2, List<ItemOptDto>
                // 등록된 색상 n 추가
                // 상품 테이블의 col에 여러개 넣어주기

            // 상품 가격 등록 => 2, ItemPriceDto
                // 할인율 등록 => 1
                // 상품 테이블의 할인가 계산해서 수정 => 1
                    // 해당 상품 조회
                    // 해당 상품 가격 할인율 조회
                    // 필드값 계산
                    // 수정 => 1


        /* 예외 판별 */
            // 총합이 5 + n1 + n2 가 나와야 정상적으로 적용된 것, 그외의 경우 예외 발생
            // 쿼리 과정에서 예외 발생

        /* 반환 */
            // 성공 void
            // 실패 예외

        int rowCnt = 0, n1 = itemSizeDtos.size(), n2 = itemColorDtos.size(); // 적용된 쿼리수 확인용

        // 등록하면서 쿼리수 계산
        rowCnt += itemDao.insert(itemDto) + itemDetailDao.insert(itemDetailDto) + itemStateDao.insert(itemStateDto);
        for (ItemOptDto itemSizeDto : itemSizeDtos) {
            rowCnt += itemSizeDao.insert(itemSizeDto);
        }


        // 상품 색상 정보 등록, 메인 테이블 col에 red,black,blue 형식으로 저장
        sb.setLength(0);
        for (ItemOptDto color : itemColorDtos) {
            rowCnt += itemColorDao.insert(color);
            sb.append(color.getCode()).append("/");
        }


        // 할인율 등록했으면 할인가 계산하기
        rowCnt += itemPriceDao.insert(itemPriceDto);
        ItemDto target = itemDao.select(itemDto.getNum());
        ItemPriceDto targetPrice = itemPriceDao.select(itemDto.getNum());
        double discountRate = targetPrice.getDisc_rate();

        // 잘못된 할인가가 등록됐으면 예외 발생
        if (!(0 < discountRate && discountRate <= 1)) {
            throw new Exception("잘못된 할인율이 저장되었습니다.");
        }

        // 할인가 계산
        int discountPrice = (int)(target.getPrice() * discountRate);
        target.setDisc_price(discountPrice); // 할인가 적용해서 저장
        target.setCol(sb.toString()); // 색상 정보 저장
        rowCnt += itemDao.update(target); // 테이블 변경

        // 적용된 로우수가 기대한 값과 다른 경우 롤백 처리
        if (rowCnt != 5 + n1 + n2) {
            throw new Exception("적용되지 못한 쿼리문이 존재합니다.");
        }

        return rowCnt != 5 + n1 + n2;
    }

    // 모든 상품을 조회, 임시적으로 구현(사용x)
    public List<ItemDto> readAll(Integer page, Integer pageSize) throws Exception {
        /* 처리 작업 */
            // itemDao를 통해 모든 상품을 조회함
            // 그때 전체 상품 개수와 맞는지 확인, 다르면 예외 처리

        /* 예외 판별 */
            // 조회한 상품의 개수와 전체 카운트 개수가 다른 경우
            // 내부적으로 예외 발생하는 경우

        /* 반환 */
            // 조회된 상품 리스트 반환
        List<ItemDto> itemDtos = itemDao.selectAll(page, pageSize);
        int totalCnt = itemDao.count();

        if (totalCnt != itemDtos.size()) {
            throw new Exception("상품이 정상적으로 조회되지 않았습니다.");
        }


        return itemDtos;
    }


    public List<ItemDto> readBySearchCondition(SearchCondition sc) throws Exception {
        return itemDao.selectBySearchCondition(sc);
    }

    public int countSearchCondition(SearchCondition sc) throws Exception {
        return itemDao.countSearchResult(sc);
    }

    public List<ItemDto> readDiscountItem(SearchCondition sc) throws Exception {
        return itemDao.selectDiscountItem(sc);
    }

    public int countDiscountItem(SearchCondition sc) throws Exception {
        return itemDao.countDiscountItem(sc);
    }

    public ItemDetailPageDto readDetailItem(String num) throws Exception {
        // 상세 페이지 dto 조회
        ItemDetailPageDto itemDetailPageDto = itemDao.selectDetailItem(num);

        // 옵션값 추가
        sb.setLength(0);
        List<ItemOptDto> sizes = itemSizeDao.select(num);
        sizes.stream().forEach(size -> sb.append(size.getCode()).append("/"));
        itemDetailPageDto.setSize(sb.toString());

        sb.setLength(0);
        List<ItemOptDto> colors = itemColorDao.select(num);
        colors.stream().forEach(color -> sb.append(color.getCode()).append("/"));
        itemDetailPageDto.setCol(sb.toString());


        return itemDetailPageDto;
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
            int rowCnt = itemDao.update(dto);
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
            int rowCnt = itemDao.delete(dto);
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
        int totalCnt = itemDao.count();
        try {
            int rowCnt = itemDao.deleteAll();
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
        return itemDao.selectWTop8(dto);
    }

    //     메인 페이지 남성 top 8 보주기
    public List<ItemDto> showMTop8(ItemDto dto) throws Exception {
        dto.setItem_type("01");
        return itemDao.selectWTop8(dto);
    }

    //     메인 페이지 혼성 top 8 보주기git commit -m [feat] 상품파트 service 2차 구현"
    public List<ItemDto> showUTop8(ItemDto dto) throws Exception {
        dto.setItem_type("03");
        return itemDao.selectWTop8(dto);
    }


    // 관리자 페이지 상품 목록 조회
    public List<AdminItemDto> readAllItemOnAdmin(SearchCondition sc) throws Exception {
        return itemDao.selectAllItemOnAdmin(sc);
    }

    // 관리자 페이지 상품 재고 목록 조회
    public List<AdminItemDto> readAllItemStockOnAdmin(SearchCondition sc) throws Exception {
        return itemDao.selectAllItemStockInfoOnAdmin(sc);
    }

    // 관리자 페이지 상세 상품 조회
    public ItemRegisterInfo readItemDetailInfoOnAdmin(String num) throws Exception {
        // 단건 필드 조회
        ItemRegisterInfo selected = itemDao.selectItemDetailInfoOnAdmin(num);

        // 여러 필드로 구성된 것 조회
        List<ItemOptDto> cols = itemColorDao.select(num);
        List<ItemOptDto> sizes = itemSizeDao.select(num);

        // 필드에 담기
        sb.setLength(0);
        cols.stream().forEach(i -> sb.append(i.getCode()).append("/"));
        selected.setCol(sb.toString());

        sb.setLength(0);
        sizes.stream().forEach(i -> sb.append(i.getCode()).append("/"));
        selected.setSize(sb.toString());

        // dto 생성 및 반환
        return selected;
    }

    // 관리자 페이지 재고 추가
    public boolean increaseStockQty(String num, Integer qty) {
        int rowCnt = 0;
        try {
            rowCnt = itemDao.increaseStockQty(num, qty);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowCnt == 1;
    }

    // 관리자 페잊 상품 업데이트(쿼리문 추가)

    // 관리자 페이지 상품 삭제




}
