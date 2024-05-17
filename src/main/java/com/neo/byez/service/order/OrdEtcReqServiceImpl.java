package com.neo.byez.service.order;

import com.neo.byez.dao.order.*;
import com.neo.byez.domain.order.DeliveryDto;
import com.neo.byez.domain.order.OrdEtcReqDto;
import com.neo.byez.domain.order.OrderDto;
import com.neo.byez.domain.order.OrderDetailDto;
import com.neo.byez.domain.order.OrderStateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrdEtcReqServiceImpl implements OrdEtcReqService {

    //트랜잭션

    OrdEtcReqDaoImpl ordEtcReqDao;
    OrderDetailDaoImpl orderDetailDao;
    OrderDaoImpl orderDao;
    OrderStateDaoImpl orderStateDao;
    DeliveryDaoImpl deliveryDao;

    @Autowired
    OrderDetailServiceImpl orderDetailService;

    @Autowired
    public OrdEtcReqServiceImpl(OrdEtcReqDaoImpl ordEtcReqDao, OrderDetailDaoImpl orderDetailDao, OrderDaoImpl orderDao, OrderStateDaoImpl orderStateDao, DeliveryDaoImpl deliveryDao) {
        this.ordEtcReqDao = ordEtcReqDao;
        this.orderDetailDao = orderDetailDao;
        this.orderDao = orderDao;
        this.orderStateDao = orderStateDao;
        this.deliveryDao = deliveryDao;
    }

    // 주문 취소 시 취소관련 정보 저장 및 갱신
    /*
        주문 취소
       //TODO  a. 취소관련정보 입력
        b. 환불처리(결제취소)
        c. 사용된 쿠폰 돌려주기(쿠폰)

        취소시 변경 및 추가되어야 하는 정보
        1. 주문 취소 정보 insert
        2. 주문진행상태 insert
        3. 주문의 진행상태 update
        4. 주문내역의 진행상태 update

        선택된 ord_detail 정보를 불러오는 메서드

     */

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean insertCancelInfo(OrdEtcReqDto ordEtcReqDto, OrderDetailDto orderDetailDto, OrderDto orderDto, OrderStateDto orderStateDto) throws Exception {
        int rowCnt = 0;

        try {
            rowCnt += ordEtcReqDao.insertCancel(ordEtcReqDto);
            rowCnt += orderDao.updateStateCode(orderDto);
            rowCnt += orderStateDao.insertOrderState(orderStateDto);
            int updateCnt = orderDetailDao.updateOrdState(orderDetailDto);

            List<OrderDetailDto> list = orderDetailDao.selectByOrdNum(orderDetailDto.getOrd_num());
            int DBCnt = list.size();

            if (updateCnt == DBCnt) {
                rowCnt++;
            }
            System.out.println(rowCnt);
            if (rowCnt != 4) {
                throw new Exception("insertCancel ERROR rowCnt에러");
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    // 주문 반품 시 반품관련 정보 저장 및 갱신
    /*
        주문 반품
       //TODO  a. 반품관련정보 입력
        b. 환불처리(결제취소)
        //TODO c. 배송완료된 제품 반품수거처리(배송)
        d. 사용된 쿠폰 돌려주기(쿠폰)

        반품시 변경 및 추가되어야 하는 정보
        1. 주문 취소 정보 insert
        2. 주문진행상태 insert
        3. 주문의 진행상태 update
        4. 주문내역의 진행상태 update
        5. 배송정보 insert

        선택된 ord_detail 정보를 불러오는 메서드
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean insertRefundInfo(OrdEtcReqDto ordEtcReqDto, OrderDetailDto ordDetailDto, OrderDto orderDto, OrderStateDto orderStateDto, DeliveryDto deliveryDto) throws Exception {
        int rowCnt = 0;

        try {
            rowCnt += ordEtcReqDao.insertRefund(ordEtcReqDto);
            rowCnt += orderDao.updateStateCode(orderDto);
            rowCnt += orderStateDao.insertOrderState(orderStateDto);
            rowCnt += deliveryDao.insertRefundDlvInfo(deliveryDto);
            int updateCnt = orderDetailDao.updateOrdState(ordDetailDto);

            List list = orderDetailDao.selectByOrdNum(ordDetailDto.getOrd_num());
            int DBCnt = list.size();

            if (updateCnt == DBCnt) {
                rowCnt++;
            }
            System.out.println(rowCnt);
            if (rowCnt != 5) {
                throw new Exception("insertRefund ERROR rowCnt에러");
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public boolean confirmPurchase(OrderDto orderDto, OrderDetailDto ordDetailDto, OrderStateDto orderStateDto) throws Exception {
        int rowCnt = 0;

        try {
            rowCnt += orderDao.updateStateCode(orderDto);
            rowCnt += orderStateDao.insertOrderState(orderStateDto);
            int updateCnt = orderDetailDao.updateOrdState(ordDetailDto);

            List list = orderDetailDao.selectByOrdNum(ordDetailDto.getOrd_num());
            int DBCnt = list.size();

            if (updateCnt == DBCnt) {
                rowCnt++;
            }
            System.out.println(rowCnt);
            if (rowCnt != 3) {
                throw new Exception("Confirm Purchase ERROR rowCnt에러");
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(rowCnt);
            throw e;
        }
    }


    // 주문 교환 시 교환관련 정보 저장 및 갱신
    /*
        주문 반품
       //TODO  a. 교환관련정보 입력-
        //TODO b. 배송완료된 제품 교환수거처리(배송)

        교환시 변경 및 추가되어야 하는 정보
        1. 주문 취소 정보 insert
        2. 주문진행상태 insert
        3. 주문의 진행상태 update
        4-1 주문내역의 진행상태 update
        --> 주문번호의 각 seq를 선택해서 업데이트를 하기때문에
        교환기능을 위한 진행상태업데이트 쿼리문을 새로 만들었다
        (updateEachOrdState)
        4-2. 주문내역의 옵션 update(이것이 핵심!)
        --> 자스로 옵션이 잘 바뀌었는지 확인을 하지만 서비스단에서도
        변경된 옵션이 있는지 체크한다.(옵션이 하나도 바뀌지 않았으면 교환신청 자체가
        의미가 없어지므로)
        5. 배송정보 insert

        선택된 ord_detail 정보를 불러오는 메서드
        교환신청폼
     */

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean insertExchangeInfo(OrdEtcReqDto ordEtcReqDto, OrderDetailDto ordDetailDto, OrderDto orderDto, OrderStateDto orderStateDto, DeliveryDto deliveryDto) throws Exception {
        int rowCnt = 0;

        try {
            rowCnt += ordEtcReqDao.insertRefund(ordEtcReqDto);
            rowCnt += orderDao.updateStateCode(orderDto);
            rowCnt += orderStateDao.insertOrderState(orderStateDto);
            rowCnt += deliveryDao.insertRefundDlvInfo(deliveryDto);
            rowCnt += orderDetailService.updateIfChanged(ordDetailDto);
            System.out.println("옵션업데이트 이전 카운트"+ rowCnt);
            rowCnt += orderDetailDao.updateEachOrdState(ordDetailDto);
            System.out.println("업데이트될 dto? : " + ordDetailDto);
            System.out.println(rowCnt);
            if (rowCnt != 6) {
                throw new Exception("insertExchange ERROR rowCnt에러");
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
//    public int updateCnt(OrdDetailDto ordDetailDto) throws Exception {
//        int updateCnt = ordDetailDao.updateOrdState(ordDetailDto);
//        List list = ordDetailDao.selectByOrdNum(ordDetailDto.getOrd_num());
//        int DBCnt = list.size();
//
//        if (updateCnt == DBCnt) {
//            return 1;
//        }return 0;
//    }

    @Override
    public int insertCancel(OrdEtcReqDto ordEtcReqDto) {
        return ordEtcReqDao.insertCancel(ordEtcReqDto);
    }

    @Override
    public int updateStateCode(OrderDto orderDto) throws Exception {
        return orderDao.updateStateCode(orderDto);
    }

    @Override
    public int insertOrderState(OrderStateDto orderStateDto) throws Exception {
        return orderStateDao.insertOrderState(orderStateDto);
    }

    @Override
    public int updateOrdState(OrderDetailDto ordDetailDto) throws Exception {
        return orderDetailDao.updateOrdState(ordDetailDto);
    }

    @Override
    public List<DeliveryDto> selectByOrdNum(String ord_num) {
        return deliveryDao.selectByOrdNum(ord_num);
    }

    @Override
    public int insertRefundDlvInfo(DeliveryDto deliveryDto) {
        return deliveryDao.insertRefundDlvInfo(deliveryDto);
    }
}