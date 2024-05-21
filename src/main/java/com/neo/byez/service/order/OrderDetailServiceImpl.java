package com.neo.byez.service.order;

import com.neo.byez.dao.order.ItemOptionDaoImpl;
import com.neo.byez.dao.order.OrderDetailDaoImpl;
import com.neo.byez.domain.ReviewDto;
import com.neo.byez.domain.order.ItemOptionDto;
import com.neo.byez.domain.order.OrderDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class OrderDetailServiceImpl implements  OrderDetailService{

    @Autowired
    OrderDetailDaoImpl ordDetailDao;
    @Autowired
    ItemOptionDaoImpl itemOptionDao;


    @Override
    public List<OrderDetailDto> selectOneOrdDetail(String ord_num) throws Exception {
        return ordDetailDao.selectByOrdNum(ord_num);
    }


    @Override
    public List<OrderDetailDto> getOrderDetailsList(String id) throws Exception {
        return ordDetailDao.selectAll(id);
    }

    @Override
    public List<OrderDetailDto> getPage(Map map) throws Exception {
        return ordDetailDao.selectPage(map);
    }

    @Override
    public int getCount() throws Exception {
        return ordDetailDao.getCount();
    }

    @Override
    public List<ItemOptionDto> selectColorOption(String num) {
        return itemOptionDao.selectColor(num);
    }

    @Override
    public List<ItemOptionDto> selectSizeOption(String num) {
        return itemOptionDao.selectSize(num);
    }

//    @Override
//    public List<ItemOptionDto> selectItemOption(String num) {
//        return itemOptionDao.selectOption(num);
//    }

    @Override
    public int getCountColor(String num) {
        return itemOptionDao.getCountColor(num);
    }

    @Override
    public int getCountSize(String num) {
        return itemOptionDao.getCountSize(num);
    }


    //기존에 사용하던 옵션업데이트 메서드
    @Override
    public int updateOption(OrderDetailDto orderDetailDto) throws Exception {
        return ordDetailDao.updateOption(orderDetailDto);
    }

    @Override
    public OrderDetailDto selectOneSeqForExchange(String ord_num, Integer seq) throws Exception {
        return ordDetailDao.selectNumAndSeq(ord_num, seq);
    }

    //updateOption 메서드를 발전시킴
    //옵션이 변경되었을때 주문내역 업데이트를 진행한다.
    @Override
    public int updateIfChanged(OrderDetailDto orderDetailDto) throws Exception {
        OrderDetailDto currentOrdDetail = ordDetailDao.selectNumAndSeq(orderDetailDto.getOrd_num(), orderDetailDto.getSeq());
        boolean needsUpdate = false;

        // opt1 또는 opt2가 변경되었는지 확인
        if (!Objects.equals(currentOrdDetail.getOpt1(), orderDetailDto.getOpt1()) ||
                !Objects.equals(currentOrdDetail.getOpt2(), orderDetailDto.getOpt2())) {
            needsUpdate = true;
        }

        // 변경이 필요한 경우 업데이트 실행
        if (needsUpdate) {
            ordDetailDao.updateOption(orderDetailDto);
            return 1;
        }return 0;
    }
    //--------------------------찬빈추가
    @Override
    public List<OrderDetailDto> searchById(String id) {
        return ordDetailDao.selectById(id);
    }

    @Override
    public OrderDetailDto searchOrdItem(String ord_num, String item_num, String id) {
        return ordDetailDao.selectOrdItem(ord_num,item_num,id);
    }

    @Override
    public int changeReviewState(ReviewDto reviewDto) {
        return ordDetailDao.updateReviewState(reviewDto);
    }

    @Override
    public List<OrderDetailDto> selectAllEtc(String id) throws Exception {
        return ordDetailDao.selectAllEtc(id);
    }
}
