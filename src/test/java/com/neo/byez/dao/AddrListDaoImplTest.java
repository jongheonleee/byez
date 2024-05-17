package com.neo.byez.dao;

import com.neo.byez.domain.AddressEntryDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class AddrListDaoImplTest {

    @Autowired
    AddrListDaoImpl addrListDao;
    @Test
    public void count() throws Exception {
        // 1. 전체삭제
        addrListDao.deleteAll();
        assertTrue(addrListDao.count() == 0);

    }

    @Test
    public void selectAll() throws Exception {
        // 1. 전체삭제
        addrListDao.deleteAll();
        assertTrue(addrListDao.count() == 0);

        // 2. 추가
        AddressEntryDto insertAddress1 = new AddressEntryDto("userId1","김가나", "집", "12345", "중동로 280번길 63", "10000동 10000호", "", "010-1234-5678");
        AddressEntryDto insertAddress2 = new AddressEntryDto("userId2", "김다라", "집", "12345", "중동로 280번길 63", "10000동 10000호", "", "010-1234-5678");
        addrListDao.insert(insertAddress1);
        addrListDao.insert(insertAddress2);

        List<AddressEntryDto> selectedAddresses1 = addrListDao.selectById("userId1");
        List<AddressEntryDto> selectedAddresses2 = addrListDao.selectById("userId2");
        AddressEntryDto selectedAddress1 = selectedAddresses1.get(0);
        AddressEntryDto selectedAddress2 = selectedAddresses2.get(0);

        assertTrue(selectedAddress1.equals(insertAddress1));
        assertTrue(selectedAddress2.equals(insertAddress2));

        // 3. 전체 조회
        List<AddressEntryDto> allAddresses = addrListDao.selectAll();

        assertTrue(allAddresses.size() == 2);
        assertTrue(allAddresses.get(0).getNick().equals("집") && allAddresses.get(1).getNick().equals(("집")));

    }

    @Test
    public void selectById() throws Exception {
        // 1. 전체삭제
        addrListDao.deleteAll();
        assertTrue(addrListDao.count() == 0);

        // 2. 추가
        AddressEntryDto insertAddress = new AddressEntryDto("userId1","김가나", "집", "12345", "중동로 280번길 63", "10000동 10000호", "", "010-1234-5678");
        addrListDao.insert(insertAddress);

        // 3. 조회

        List<AddressEntryDto> selectedAddresses = addrListDao.selectById("userId1");
        AddressEntryDto selectedAddress = selectedAddresses.get(0);

        assertTrue(selectedAddress.equals(insertAddress));
    }

    @Test
    public void selectBySeq() throws Exception {

        // 1. 전체삭제
        addrListDao.deleteAll();
        assertTrue(addrListDao.count() == 0);

        // 2. 추가
        AddressEntryDto insertAddress = new AddressEntryDto("userId1","김가나", "집", "12345", "중동로 280번길 63", "10000동 10000호", "", "010-1234-5678");
        addrListDao.insert(insertAddress);

        // 3. 조회 (id로 조회) -> seq는 db가 생성하므로 적어도 1번의 조회를 해야 seq를 알 수 있음
        List<AddressEntryDto> selectedAddresses = addrListDao.selectById("userId1");
        AddressEntryDto selectedAddress = selectedAddresses.get(0);

        assertTrue(selectedAddress.equals(insertAddress));

        // 4. 조회 (seq로 조회)

        int seq = selectedAddress.getSeq();
        AddressEntryDto selectedAddressBySeq = addrListDao.selectBySeq(seq);

        assertTrue(selectedAddressBySeq.equals(insertAddress));
    }
    @Test
    public void delete() throws Exception {

        // 1. 전체삭제
        addrListDao.deleteAll();
        assertTrue(addrListDao.count() == 0);

        // 2. 추가
        AddressEntryDto insertAddress1 = new AddressEntryDto("userId1","김가나", "집", "12345", "중동로 280번길 63", "10000동 10000호", "", "010-1234-5678");
        AddressEntryDto insertAddress2 = new AddressEntryDto("userId2", "김다라", "집", "12345", "중동로 280번길 63", "10000동 10000호", "", "010-1234-5678");
        addrListDao.insert(insertAddress1);
        addrListDao.insert(insertAddress2);

        // 3. 조회
        List<AddressEntryDto> selectedAddresses1 = addrListDao.selectById("userId1");
        List<AddressEntryDto> selectedAddresses2 = addrListDao.selectById("userId2");
        AddressEntryDto selectedAddress1 = selectedAddresses1.get(0);
        AddressEntryDto selectedAddress2 = selectedAddresses2.get(0);

        assertTrue(selectedAddress1.equals(insertAddress1));
        assertTrue(selectedAddress2.equals(insertAddress2));

        // 4. 부분 삭제
        int seq1 = selectedAddress1.getSeq();
        addrListDao.delete(seq1);

        // 5. 조회
        selectedAddresses1 = addrListDao.selectById("userId1");
        selectedAddresses2 = addrListDao.selectById("userId2");

        assertTrue(selectedAddresses1.isEmpty());
        assertTrue(!selectedAddresses2.isEmpty());

    }

    @Test
    public void update() throws Exception {

        // 1. 전체삭제
        addrListDao.deleteAll();
        assertTrue(addrListDao.count() == 0);

        // 2. 추가
        AddressEntryDto insertAddress = new AddressEntryDto("userId1","김가나", "집", "12345", "중동로 280번길 63", "10000동 10000호", "", "010-1234-5678");
        addrListDao.insert(insertAddress);

        // 3. 조회
        List<AddressEntryDto> selectedAddresses = addrListDao.selectById("userId1");
        AddressEntryDto selectedAddress = selectedAddresses.get(0);

        assertTrue(selectedAddress.equals(insertAddress));

        // 4. 변경
        AddressEntryDto updateAddress = selectedAddress;
        updateAddress.setMainAddr("서울");
        updateAddress.setDetailAddr("1234동 1234호");
        assertTrue(addrListDao.update(updateAddress) == 1);

        // 5. 조회
        selectedAddresses = addrListDao.selectById("userId1");
        selectedAddress = selectedAddresses.get(0);

        assertTrue(selectedAddress.equals(updateAddress));
    }

    @Test
    public void bulkInsert() throws Exception {

        // 1. 전체삭제
        addrListDao.deleteAll();
        assertTrue(addrListDao.count() == 0);

        // 2. 대량 추가
        final int ADDITIONAL_AMOUNT = 1000; // 추가하는 양 조절 가능
        int count = 0;

        AddressEntryDto insertAddress = new AddressEntryDto("userId1", "김가나", "집", "12345", "중동로 280번길 63", "10000동 10000호", "", "010-1234-5678");
        for(int i=0; i<ADDITIONAL_AMOUNT; i++) {
            count += addrListDao.insert(insertAddress);
        }

        assertTrue(count == ADDITIONAL_AMOUNT);

        // 3. 조회
        assertTrue(addrListDao.count() == ADDITIONAL_AMOUNT);

        List<AddressEntryDto> selectedAddresses = addrListDao.selectById("userId1");
        assertTrue(selectedAddresses.size() == ADDITIONAL_AMOUNT);

        AddressEntryDto selectedAddress = selectedAddresses.get(0);
        assertTrue(selectedAddress.equals(insertAddress));

    }

    @Test
    public void InvalidInsertRequest() throws Exception {

        // 1. 전체삭제
        addrListDao.deleteAll();
        assertTrue(addrListDao.count() == 0);

        // 2. 유효하지 않은 값으로 추가

        // 2-1. 수령자가 없을 때
        AddressEntryDto insertAddress = new AddressEntryDto("userId1",null, "집", "12345", "중동로 280번길 63", "10000동 10000호", "", "010-1234-5678");
        try {
            addrListDao.insert(insertAddress);
            fail("수령자가 없음에도 예외가 발생하지 않았습니다.");
        } catch(DataIntegrityViolationException e) {

        }

        // 2-2. 주소지 별명이 없을 때
        insertAddress = new AddressEntryDto("userId1", "김가나", null, "12345", "중동로 280번길 63", "10000동 10000호", "", "010-1234-5678");
        try {
            addrListDao.insert(insertAddress);
            fail("주소지 별명이 없음에도 예외가 발생하지 않았습니다.");
        } catch(DataIntegrityViolationException e) {

        }

        // 2-3. 우편번호가 없을 때
        insertAddress = new AddressEntryDto("userId1", "김가나", "집", "", "중동로 280번길 63", "10000동 10000호", "", "010-1234-5678");
        try {
            addrListDao.insert(insertAddress);
            fail("우편번호가 없음에도 예외가 발생하지 않았습니다.");
        } catch(UncategorizedSQLException e) {

        }
        // 2-4. 기본주소가 없을 때
        insertAddress = new AddressEntryDto("userId1", "김가나", "집", "12345", null, "10000동 10000호", "", "010-1234-5678");
        try {
            addrListDao.insert(insertAddress);
            fail("기본주소가 없음에도 예외가 발생하지 않았습니다.");
        } catch(DataIntegrityViolationException e) {

        }
        // 2-5. 상세주소가 없을 때
        insertAddress = new AddressEntryDto("userId1", "김가나", "집", "12345", "중동로 280번길 63", null, "", "010-1234-5678");
        try {
            addrListDao.insert(insertAddress);
            fail("상세주소가 없음에도 예외가 발생하지 않았습니다.");
        } catch(DataIntegrityViolationException e) {

        }
        // 2-6. 전화번호가 없을 때
        insertAddress = new AddressEntryDto("userId1", "김가나", "집", "12345", "중동로 280번길 63", "10000동 10000호", "", null);
        try {
            addrListDao.insert(insertAddress);
            fail("전화번호가 없음에도 예외가 발생하지 않았습니다.");
        } catch(DataIntegrityViolationException e) {

        }
    }

    @Test
    public void InvalidUpdateRequest() throws Exception {

        // 1. 전체삭제
        addrListDao.deleteAll();
        assertTrue(addrListDao.count() == 0);

        // 2. 추가
        AddressEntryDto insertAddress = new AddressEntryDto("userId1","김가나", "집", "12345", "중동로 280번길 63", "10000동 10000호", "", "010-1234-5678");
        addrListDao.insert(insertAddress);

        // 3. 조회
        List<AddressEntryDto> selectedAddresses = addrListDao.selectById("userId1");
        AddressEntryDto selectedAddress = selectedAddresses.get(0);

        System.out.println(insertAddress.toString());
        System.out.println(selectedAddress.toString());
        assertTrue(selectedAddress.equals(insertAddress));

        // 4. 유효하지 않은 값으로 변경

        // 4-1. 수령자가 없을 때
        AddressEntryDto updateAddress = new AddressEntryDto("userId1",null, "집", "12345", "중동로 280번길 63", "10000동 10000호", "", "010-1234-5678");
        assertTrue(addrListDao.update(updateAddress) == 0);

        // 4-2. 주소지 별명이 없을 때
        updateAddress = new AddressEntryDto("userId1", "김가나", null, "12345", "중동로 280번길 63", "10000동 10000호", "", "010-1234-5678");
        assertTrue(addrListDao.update(updateAddress) == 0);

        // 4-3. 우편번호가 없을 때
        updateAddress = new AddressEntryDto("userId1", "김가나", "집", "12345", "중동로 280번길 63", "10000동 10000호", "", "010-1234-5678");
        assertTrue(addrListDao.update(updateAddress) == 0);

        // 4-4. 기본주소가 없을 때
        updateAddress = new AddressEntryDto("userId1", "김가나", "집", "12345", null, "10000동 10000호", "", "010-1234-5678");
        assertTrue(addrListDao.update(updateAddress) == 0);

        // 4-5. 상세주소가 없을 때
        updateAddress = new AddressEntryDto("userId1", "김가나", "집", "12345", "중동로 280번길 63", null, "", "010-1234-5678");
        assertTrue(addrListDao.update(updateAddress) == 0);

        // 4-6. 전화번호가 없을 때
        updateAddress = new AddressEntryDto("userId1", "김가나", "집", "12345", "중동로 280번길 63", "10000동 10000호", "", null);
        assertTrue(addrListDao.update(updateAddress) == 0);

        // 5. 조회 후 기존 조회와 비교
        List<AddressEntryDto> retrievedAddresses = addrListDao.selectById("userId1");
        AddressEntryDto retrievedAddress = retrievedAddresses.get(0);

        assertTrue(retrievedAddress.equals(selectedAddress));
    }
}