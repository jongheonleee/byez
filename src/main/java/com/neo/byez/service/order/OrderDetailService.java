package com.neo.byez.service.order;


import com.neo.byez.domain.ReviewDto;
import com.neo.byez.domain.order.ItemOptionDto;
import com.neo.byez.domain.order.OrderDetailDto;

import java.util.List;
import java.util.Map;

public interface OrderDetailService {

    public List<OrderDetailDto> selectOneOrdDetail(String ord_num) throws Exception;

    public List<OrderDetailDto> getOrderDetailsList(String id) throws Exception;

    List<OrderDetailDto> getPage(Map map) throws Exception;

    public int getCount() throws Exception;

    List<ItemOptionDto> selectColorOption(String num);

    List<ItemOptionDto> selectSizeOption(String num);

    public int getCountColor(String num);

    public int getCountSize(String num);

    public int updateOption(OrderDetailDto orderDetailDto) throws Exception;



//    public int updateOrdState(List list) throws Exception;


    //주문번호와 seq로 주문내역 확인(dao테스트 완료)
    public OrderDetailDto selectOneSeqForExchange(String ord_num, Integer seq) throws Exception;

    //옵션 변경 여부 확인 후 업데이트 진행(현재는 변경사항이 없어도 update가능)
    public int updateIfChanged(OrderDetailDto orderDetailDto) throws Exception;
    public List<OrderDetailDto>  selectAllEtc(String id) throws Exception;

    //---------------------------찬빈추가
    public List<OrderDetailDto> searchById(String id);

    public OrderDetailDto searchOrdItem(String ord_num, String item_num, String id);

    public int changeReviewState(ReviewDto reviewDto);
    public boolean validateSearchOrdItem(String ord_num,String item_num,String id);

}
