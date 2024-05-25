package com.neo.byez.service.order;


import com.neo.byez.domain.ReviewDto;
import com.neo.byez.domain.order.ItemOptionDto;
import com.neo.byez.domain.order.OrderDetailDto;
import com.neo.byez.domain.order.OrderDetailJoinItemDto;

import java.util.List;
import java.util.Map;

public interface OrderDetailService {

    public List<OrderDetailDto>  selectOneOrdDetail(String ord_num) throws Exception;
    //240524 유경추가
    public OrderDetailDto selectNumAndSeq(String ord_num, Integer seq) throws Exception;

    public List<OrderDetailDto> getOrderDetailsList(String id) throws Exception;

    List<OrderDetailDto> getPage(Integer curPage, Integer pageSize, String userId) throws Exception;

    public int getCount(String userId) throws Exception;

    List<ItemOptionDto> selectColorOption(String num);

    List<ItemOptionDto> selectSizeOption(String num);

    public int getCountColor(String num);

    public int getCountSize(String num);

    public int updateOption(OrderDetailDto orderDetailDto) throws Exception;





//    public int updateOrdState(List list) throws Exception;


    //240524 유경 메서드명 수정 --> 반품/구매확정에도 함께 활용하기위함
    //주문번호와 seq로 주문내역 확인(dao테스트 완료)
    public OrderDetailDto selectOneSeq(String ord_num, Integer seq) throws Exception;

    //옵션 변경 여부 확인 후 업데이트 진행(현재는 변경사항이 없어도 update가능)
    public int updateIfChanged(OrderDetailDto orderDetailDto) throws Exception;
    public List<OrderDetailDto>  selectAllEtc(String id) throws Exception;

    //---------------------------찬빈추가
    public List<OrderDetailJoinItemDto> searchById(String id);

    public OrderDetailJoinItemDto searchOrdItem(String ord_num, String item_num, String id);

    public int changeReviewState(ReviewDto reviewDto);
    public boolean validateSearchOrdItem(String ord_num,String item_num,String id);




}
