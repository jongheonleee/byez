package com.neo.byez.service.order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class PayServiceImplTest {
    @Autowired
    PayServiceImpl payService;

    @DisplayName("결제 테스트")
    @Test
    public void paytest(){
//        System.out.println(payService.paymentMakeRequest());
    }
}