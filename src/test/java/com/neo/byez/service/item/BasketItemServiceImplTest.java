package com.neo.byez.service.item;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

// 결과 : [✅]테스트 완료(24/24) 추후에 여유있으면 테스트 코드 리팩토링
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@ExtendWith(SpringExtension.class)
public class BasketItemServiceImplTest {
    @Autowired
    private BasketItemService basketItemService;

    // 0. 초기 테스트[✅]

    @Before
    public void 주입_확인() throws Exception {
        assertNotNull(basketItemService);
    }


    // 1. 핵심 테스트 1차 테스트(성공, 실패, 예외)[✅]
        // 1-0. 카운트
            // 카운트_성공() => 특정 유저에 여러 상품 카운트
            // 카운트_실패() => 없는 유저의 상품 카운트, 0

        // 1-1. 조회
            // 조회_성공() => 특정 유저의 상품 목록 조회
            // 조회_실패() => 없는 유저의 상품 목록 조회, 0

        // 1-2. 등록
            // 상품_등록_성공() => 특정 유저의 새로운 상품 등록(중복x), 1
            // 중복_상품_등록_실패() => 특정 유저의 새로운 상품 등록(중복o), -1
            // 없는_유저_상품_등록_실패() => 없는 유저의 상품 등록, 예외

        // 1-3. 삭제
            // 1-3-0. 특정 상품 삭제(id, seq)
                // 상품_삭제_성공_1() => 특정 유저의 상품 삭제, 1
                // 없는_상품_삭제_실패_1() => 특정 유저의 없는 상품 삭제, 0
                // 없는_유저_상품_삭제_실패_1() => 없는 유저의 상품 삭제, 0 or 예외

            // 1-3-1. 특정 상품 삭제(id, dto)
                // 상품_삭제_성공_2() => 특정 유저의 상품 삭제, 1
                // 없는_상품_삭제_실패_2() => 특정 유저의 없는 상품 삭제, 0
                // 없는_유저_상품_삭제_실패_2() => 없는 유저 상품 삭제 실패, 0

            // 1-3-2. 모든 상품 삭제(id)
                // 모든_상품_삭제_성공() => 특정 유저의 모든 상품 삭제, n
                // 모든_상품_삭제_실패() => 없는 유저의 모든 상품 삭제, 0


        // 1-4. 수정 ⚒️(강화하기)2
            // 1-4-0. 특정 유저의 상품 변경
                // 1-4-0-0. 상품 변경 실패
                    // 없는_유저_상품_변경_실패() => 변경 x, 0
                    // 없는_상품_변경_실패() => 변경 x, 0

                // 1-4-0-1. 수량만 변경
                    // 다른_상품_겹침_수량만_변경_성공() => 변경 상품이 이미 장바구니에 존재, 삭제 & 업데이트, 적용 로우수 2, 수량 업데이트 확인
                    // 다른_상품_안겹침_수량만_변경_성공() => 변경 상품이 장바구니에 존재하지 않음, 업데이트, 적용 로우수 1, 해당 상품

                // 1-4-0-2. 옵션 변경
                    // 다른_상품_겹침_옵션_변경_성공() => 변경 상품이 이미 장바구니에 존재, 삭제 & 업데이트, 적용 로우수 2, 수량 업데이트
                    // 다른_상품_안겹침_옵션_변경_성공() => 변경 상품이 장바구니에 존재하지 않음, 삭제 & 등록, 적용 로우수 2, 새로운 상품으로 등록

                  // 1-4-0-3. 수량이랑 옵션 동시에 변경
                    // 다른_상품_겹침_옵션_수량_변경_성공() => 변경 상품이 이미 장바구니에 존재, 삭제 & 업데이트, 적용 로우수 2, 수량 및 옵션 확인
                    // 다른_상품_안겹침_옵션_수량_변경_성공() => 변경 상품이 장바구니에 존재하지 않음, 삭제 & 등록, 적용 로우수 2, 수량 및 옵션 확인
//
//    @Test
//    public void 카운트_성공() throws Exception {
//        for (int i=1; i<=5; i++) {
//            int numberOfUser = i*10, numberOfItem = i*10, eachBasketItem = i*5;
//            helper.cleanDB();
//            helper.insertData(numberOfUser, numberOfItem, eachBasketItem);
//
//            for (int userId=1; userId<=10; userId++) {
//                String id = String.valueOf(userId);
//                mock.setId(id);
//                int cnt = service.getCount(mock);
//                assertTrue(eachBasketItem == cnt);
//            }
//        }
//    }
//
//    @Test
//    public void 카운트_실패() throws Exception {
//        for (int i=1; i<=5; i++) {
//            int numberOfUser = i*10, numberOfItem = i*10, eachBasketItem = i*5;
//            helper.cleanDB();
//            helper.insertData(numberOfUser, numberOfItem, eachBasketItem);
//            String id = String.valueOf("xxx");
//            mock.setId(id);
//            int cnt = service.getCount(mock);
//            assertTrue(0 == cnt);
//        }
//    }
//
//    @Test
//    public void 조회_성공() throws Exception {
//        for (int i=1; i<=5; i++) {
//            int numberOfUser = i*10, numberOfItem = i*10, eachBasketItem = i*5;
//            helper.cleanDB();
//            helper.insertData(numberOfUser, numberOfItem, eachBasketItem);
//
//            for (int userId=1; userId<=10; userId++) {
//                String id = String.valueOf(userId);
//                mock.setId(id);
//                List<BasketItemDto> list = service.getBasketItem(mock);
//                assertTrue(eachBasketItem == list.size());
//            }
//        }
//    }
//
//    @Test
//    public void 조회_실패() throws Exception {
//        for (int i=1; i<=5; i++) {
//            int numberOfUser = i*10, numberOfItem = i*10, eachBasketItem = i*5;
//            helper.cleanDB();
//            helper.insertData(numberOfUser, numberOfItem, eachBasketItem);
//            String id = String.valueOf("xxx");
//            mock.setId(id);
//            List<BasketItemDto> list = service.getBasketItem(mock);
//            assertTrue(0 == list.size());
//
//        }
//    }
//
//    @Test
//    public void 상품_등록_성공() throws Exception {
//        for (int i=1; i<=5; i++) {
//            int numberOfUser = i*10, numberOfItem = i*10, eachBasketItem = i*5;
//            helper.cleanDB();
//            helper.insertData(numberOfUser, numberOfItem, eachBasketItem);
//
//            for (int userId=1; userId<=10; userId++) {
//                String id = String.valueOf(userId);
//                mock.setId(id);
//                int beforeCnt = service.getCount(mock);
//                BasketItemDto dto = new BasketItemDto(100, id, "123421", "dededede",
//                        5000000, 5, "XL", "COL1", "M", null, null, "Y", null, null, null, null);
//                dto.setId(mock.getId());
//                assertTrue(service.register(dto));
//
//                int afterCnt = service.getCount(dto);
//                assertTrue(beforeCnt+1 == afterCnt);
//            }
//        }
//
//    }
//
//    @Test
//    public void 중복_상품_등록_실패() throws Exception {
//        for (int i=1; i<=5; i++) {
//            int numberOfUser = i*10, numberOfItem = i*10, eachBasketItem = i*5;
//            helper.cleanDB();
//            helper.insertData(numberOfUser, numberOfItem, eachBasketItem);
//
//            for (int userId=1; userId<=10; userId++) {
//                String id = String.valueOf(userId);
//                mock.setId(id);
//                int beforeCnt = service.getCount(mock);
//                BasketItemDto dto = new BasketItemDto(100, id, "123421", "dededede",
//                        5000000, 5, "XL", "COL1", "M", null, null, "Y", null, null, null, null);
//
//                assertTrue(service.register(dto));
//                assertTrue(!service.register(dto));
//
//                int afterCnt = service.getCount(dto);
//                assertTrue(beforeCnt+1 == afterCnt);
//            }
//        }
//    }
//
//    @Test
//    public void 없는_유저_상품_등록_실패() throws Exception {
//        for (int i=1; i<=5; i++) {
//            int numberOfUser = i*10, numberOfItem = i*10, eachBasketItem = i*5;
//            helper.cleanDB();
//            helper.insertData(numberOfUser, numberOfItem, eachBasketItem);
//
//            for (int userId=1; userId<=10; userId++) {
//                String id = "xxx";
//                BasketItemDto dto = new BasketItemDto(100, id, "123421", "dededede",
//                        5000000, 5, "XL", "COL1", "M", null, null, "Y", null, null, null, null);
//                assertTrue(!service.register(dto));
//            }
//        }
//    }
//
//    @Test
//    public void 상품_삭제_성공_1() throws Exception {
//        for (int i=1; i<=5; i++) {
//            int numberOfCust = i*10, numberOfItem = i*10, eachBasketItem = i*5;
//            helper.cleanDB();
//            helper.insertData(numberOfCust, numberOfItem, eachBasketItem);
//
//            for (int userId=1; userId<=10; userId++) {
//                String id = String.valueOf(userId);
//                mock.setId(id);
//                List<BasketItemDto> list = service.getBasketItem(mock);
//
//                for (BasketItemDto dto : list) {
//                    int seq = dto.getSeq();
//                    mock.setSeq(seq);
//                    assertTrue(service.remove(mock));
//                }
//
//                int cnt = service.getCount(mock);
//                assertTrue(0 == cnt);
//            }
//        }
//    }
//
//    // 💥속도가 매우 느린 부분 i를 1로 해도 실행 속도가 매우 느림
//    @Test
//    public void 없는_상품_삭제_실패_1() throws Exception {
//        for (int i=1; i<=10; i++) {
//            int numberOfCust = i*10, numberOfItem = i*10, eachBasketItem = i*5;
//            helper.cleanDB();
//            helper.insertData(numberOfCust, numberOfItem, eachBasketItem);
//
//            for (int userId=1; userId<=10; userId++) {
//                String id = String.valueOf(userId);
//                mock.setId(id);
//                List<BasketItemDto> list = service.getBasketItem(mock);
//
//                int seq = -11111;
//                mock.setSeq(seq);
//                assertTrue(!service.remove(mock));
//
//            }
//        }
//    }
//
//    @Test
//    public void 없는_유저_상품_삭제_실패_1() throws Exception {
//        for (int i=1; i<=5; i++) {
//            int numberOfCust = i*10, numberOfItem = i*10, eachBasketItem = i*5;
//            helper.cleanDB();
//            helper.insertData(numberOfCust, numberOfItem, eachBasketItem);
//
//            String id = String.valueOf("xxx");
//            mock.setId(id);
//            mock.setSeq(-111);
//            assertTrue(!service.remove(mock));
//        }
//    }
//
//    @Test
//    public void 상품_삭제_성공_2() throws Exception {
//        for (int i=1; i<=5; i++) {
//            int numberOfCust = i*10, numberOfItem = i*10, eachBasketItem = i*5;
//            helper.cleanDB();
//            helper.insertData(numberOfCust, numberOfItem, eachBasketItem);
//
//            for (int userId=1; userId<=numberOfCust; userId++) {
//                String id = String.valueOf(userId);
//                mock.setId(id);
//                List<BasketItemDto> list = service.getBasketItem(mock);
//
//                for (BasketItemDto dto : list) {
//                    dto.setId(mock.getId());
//                    int rowCnt = service.removeByContent(dto);
//                    assertTrue(1 == rowCnt);
//                }
//
//                int cnt = service.getCount(mock);
//                assertTrue(0 == cnt);
//            }
//        }
//    }
//
//    @Test
//    public void 없는_상품_삭제_실패_2() throws Exception {
//        for (int i=1; i<=5; i++) {
//            int numberOfCust = i*10, numberOfItem = i*10, eachBasketItem = i*5;
//            helper.cleanDB();
//            helper.insertData(numberOfCust, numberOfItem, eachBasketItem);
//
//            for (int userId=1; userId<=numberOfCust; userId++) {
//                String id = String.valueOf(userId);
//                mock.setId(id);
//                List<BasketItemDto> list = service.getBasketItem(mock);
//                int seq = -11111;
//                int num = -1111;
//
//                for (BasketItemDto dto : list) {
//                    dto.setId(mock.getId());
//                    dto.setSeq(seq);
//                    dto.setNum(String.valueOf(num));
//
//                    int rowCnt = service.removeByContent(dto);
//                    assertTrue(0 == rowCnt);
//                }
//            }
//        }
//    }
//
//    @Test
//    public void 없는_유저_상품_삭제_실패_2() throws Exception {
//        for (int i=1; i<=5; i++) {
//            int numberOfCust = i*10, numberOfItem = i*10, eachBasketItem = i*5;
//            helper.cleanDB();
//            helper.insertData(numberOfCust, numberOfItem, eachBasketItem);
//
//            String id = "xxx";
//            BasketItemDto dto = new BasketItemDto(100, id, "123421", "dededede",
//                    5000000, 5, "XL", "COL1", "M", null, null, "Y", null, null, null, null);
//            int rowCnt = service.removeByContent(dto);
//            assertTrue(0 == rowCnt);
//        }
//    }
//
//    @Test
//    public void 모든_상품_삭제_성공() throws Exception {
//        for (int i=1; i<=5; i++) {
//            int numberOfCust = i*10, numberOfItem = i*10, eachBasketItem = i*5;
//            helper.cleanDB();
//            helper.insertData(numberOfCust, numberOfItem, eachBasketItem);
//
//            for (int userId=1; userId<=numberOfCust; userId++) {
//                String id = String.valueOf(userId);
//                mock.setId(id);
//                assertTrue(service.removeAll(mock));
//
//                int totalCnt = service.getCount(mock);
//                assertTrue(0 == totalCnt);
//            }
//        }
//    }
//
//    @Test
//    public void 모든_상품_삭제_실패() throws Exception {
//        for (int i=1; i<=5; i++) {
//            int numberOfCust = i*10, numberOfItem = i*10, eachBasketItem = i*5;
//            helper.cleanDB();
//            helper.insertData(numberOfCust, numberOfItem, eachBasketItem);
//
//            String id = String.valueOf("xxx");
//            mock.setId(id);
//            // 💥 이거 항상 true 나옴.. 어떻게 처리할지
//            assertTrue(service.removeAll(mock));
//        }
//    }
//
//    @Test(expected = Exception.class)
//    public void 없는_유저_상품_변경_실패() throws Exception {
//        for (int i=1; i<=5; i++) {
//            int numberOfCust = i*10, numberOfItem = i*10, eachBasketItem = i*5;
//            helper.cleanDB();
//            helper.insertData(numberOfCust, numberOfItem, eachBasketItem);
//            String id = "xxx";
//            BasketItemDto dto = new BasketItemDto(100, id, "123421", "dededede",
//                    5000000, 5, "XL", "COL1", "M", null, null, "Y", null, null, null, null);
//            assertTrue(!service.modify(dto));
//
//        }
//
//    }
//
//
//    @Test(expected = Exception.class)
//    public void 없는_상품_변경_실패() throws Exception {
//        for (int i=1; i<=5; i++) {
//            int numberOfCust = i*10, numberOfItem = i*10, eachBasketItem = i*5;
//            helper.cleanDB();
//            helper.insertData(numberOfCust, numberOfItem, eachBasketItem);
//
//            for (int userId=1; userId<=numberOfCust; userId++) {
//                String id = String.valueOf(userId);
//                mock.setId(id);
//                List<BasketItemDto> list = service.getBasketItem(mock);
//
//                for (BasketItemDto dto : list) {
//                    int seq = -100;
//                    int qty = 100;
//                    String num = dto.getNum();
//                    String opt1 = dto.getOpt1();
//                    String opt2 = dto.getOpt2();
//                    String opt3 = dto.getOpt3();
//
//                    BasketItemDto updateDto = new BasketItemDto(seq, id, num, "dededede",
//                            0, qty, opt1, opt2,  opt3, null, null, "Y", null, null, null, null);
//                    assertTrue(!service.modify(updateDto));
//                }
//            }
//        }
//    }
//
//
//    @Test
//    public void 다른_상품_겹침_수량만_변경_성공() throws Exception {
//        for (int i=1; i<=5; i++) {
//            int numberOfCust = i * 10, numberOfItem = i * 10, eachBasketItem = i * 5;
//            helper.cleanDB();
//            helper.insertData(numberOfCust, numberOfItem, eachBasketItem);
//
//            for (int userId = 1; userId <= numberOfCust; userId++) {
//                String id = String.valueOf(userId);
//                mock.setId(id);
//                List<BasketItemDto> list = service.getBasketItem(mock);
//
//                for (BasketItemDto dto : list) {
//                    int seq = dto.getSeq();
//                    int qty = 100;
//                    String num = dto.getNum();
//                    String name = dto.getName();
//                    String opt1 = dto.getOpt1();
//                    String opt2 = dto.getOpt2();
//                    String opt3 = dto.getOpt3();
//
//                    BasketItemDto updateDto = new BasketItemDto(seq, id, num, name,
//                            0, qty, opt1, opt2, opt3, null, null, "Y", null, null, null, null);
//                    assertTrue(service.modify(updateDto));
//
//                    List<BasketItemDto> updatedList = service.getBasketItem(mock);
//                    assertTrue(updatedList.stream()
//                            .anyMatch(item -> item.equals(updateDto)));
//
//                    int totalCnt = updatedList.size();
//                    assertTrue(eachBasketItem == totalCnt);
//                }
//            }
//        }
//    }
//
//    @Test
//    public void 다른_상품_안겹침_수량만_변경_성공() throws Exception {
//        for (int i=1; i<=5; i++) {
//            int numberOfCust = i*10, numberOfItem = i*10, eachBasketItem = i*5;
//            helper.cleanDB();
//            helper.insertData(numberOfCust, numberOfItem, eachBasketItem);
//
//            for (int userId=1; userId<=numberOfCust; userId++) {
//                String id = String.valueOf(userId);
//                mock.setId(id);
//                List<BasketItemDto> list = service.getBasketItem(mock);
//
//                for (BasketItemDto dto : list) {
//                    int seq = dto.getSeq();
//                    int qty = 100;
//                    String num = "new" + dto.getNum();
//                    String name = "new" + dto.getName();
//                    String opt1 = "new" + dto.getOpt1();
//                    String opt2 = "new" + dto.getOpt2();
//                    String opt3 = "new" + dto.getOpt3();
//
//                    BasketItemDto updateDto = new BasketItemDto(seq, id, num, name,
//                            0, qty, opt1, opt2,  opt3, null, null, "Y", null, null, null, null);
//                    assertTrue(service.modify(updateDto));
//
//                    List<BasketItemDto> updatedList = service.getBasketItem(mock);
//                    assertTrue(updatedList.stream()
//                            .anyMatch(item -> item.equals(updateDto)));
//
//                    int totalCnt = updatedList.size();
//                    assertTrue(eachBasketItem == totalCnt);
//                }
//            }
//        }
//    }
//
//    @Test
//    public void 다른_상품_겹침_옵션_변경_성공() throws Exception {
//        // given & when : 변경할 데이터(이미 DB에 있는 데이터), 유저
//        // do(assert) : service로 변경 시도
//        // assert(compare) : 적용된 로우수 1, 내용 비교, 수량비교, 전체 상품 개수 비교
//        for (int i=1; i<=1; i++) {
//            int numberOfCust = i*10, numberOfItem = i*10, eachBasketItem = i*5;
//            helper.cleanDB();
//            helper.insertData(numberOfCust, numberOfItem, eachBasketItem);
//
//            for (int userId=1; userId<=numberOfCust; userId++) {
//                String id = String.valueOf(userId);
//                mock.setId(id);
//                List<BasketItemDto> list = service.getBasketItem(mock);
//
//                BasketItemDto dto1 = null;
//                BasketItemDto dto2 = null;
//
//                for (BasketItemDto dto : list) {
//                    if (dto1 == null) {
//                        dto1 = dto;
//                    } else if (!dto.equals(dto1)) {
//                        dto2 = dto;
//                        break;
//                    }
//                }
//
//                int qty1 = dto1.getQty();
//                int qty2 = dto2.getQty();
//
//
//                dto1.setNum(dto2.getNum());
//                dto1.setName(dto2.getName());
//                dto1.setOpt1(dto2.getOpt1());
//                dto1.setOpt2(dto2.getOpt2());
//                dto1.setOpt3(dto2.getOpt3());
//
//                // 서비스로 변경
//
//                // 변경할 데이터 삭제 + 변경 내용 데이터 업데이트
//                assertTrue(service.modify(dto1));
//
//                // 변경된 수량 확인
//                List<BasketItemDto> updatedList = service.getBasketItem(mock);
//                BasketItemDto target = dto2;
//
//                BasketItemDto updatedDto = updatedList.stream()
//                                                      .filter(item -> item.equals(target))
//                                                      .findFirst()
//                                                      .orElse(new BasketItemDto());
//
//                assertTrue(qty1 + qty2 == updatedDto.getQty());
//            }
//        }
//
//    }
//
//    @Test
//    public void 다른_상품_안겹침_옵션_변경_성공() throws Exception {
//        for (int i=1; i<=5; i++) {
//            int numberOfCust = i*10, numberOfItem = i*10, eachBasketItem = i*5;
//            helper.cleanDB();
//            helper.insertData(numberOfCust, numberOfItem, eachBasketItem);
//
//            for (int userId=1; userId<=numberOfCust; userId++) {
//                String id = String.valueOf(userId);
//                mock.setId(id);
//                List<BasketItemDto> list = service.getBasketItem(mock);
//
//                BasketItemDto dto1 = null;
//                BasketItemDto dto2 = null;
//
//                for (BasketItemDto dto : list) {
//                    if (dto1 == null) {
//                        dto1 = dto;
//                    } else if (!dto.equals(dto1)) {
//                        dto2 = dto;
//                        break;
//                    }
//                }
//
//                dto1.setNum("new" + dto2.getNum());
//                dto1.setName("new" + dto2.getName());
//                dto1.setOpt1("new" + dto2.getOpt1());
//                dto1.setOpt2("new" + dto2.getOpt2());
//                dto1.setOpt3("new" + dto2.getOpt3());
//
//                // 서비스로 변경
//
//                // 변경할 데이터 삭제 + 변경 내용 데이터 업데이트
//                assertTrue( service.modify(dto1));
//
//                // 변경된 수량 확인
//                List<BasketItemDto> updatedList = service.getBasketItem(mock);
//                BasketItemDto target = dto1;
//                assertTrue(updatedList.stream()
//                        .anyMatch(item -> item.getSeq() != target.getSeq() && item.equals(target)));
//            }
//        }
//
//    }
//
//    @Test
//    public void 다른_상품_겹칩_상품_수량_옵션_변경_성공() throws Exception {
//        // given & when : 변경할 데이터, 유저
//        // do(assert) : service로 변경 시도
//        // assert(compare) : 적용된 로우수 1, 내용 비교, 전체 상품 개수 비교
//        for (int i=1; i<=5; i++) {
//            int numberOfCust = i*10, numberOfItem = i*10, eachBasketItem = i*5;
//            helper.cleanDB();
//            helper.insertData(numberOfCust, numberOfItem, eachBasketItem);
//
//            for (int userId=1; userId<=numberOfCust; userId++) {
//                String id = String.valueOf(userId);
//                mock.setId(id);
//                List<BasketItemDto> list = service.getBasketItem(mock);
//
//                BasketItemDto dto1 = null;
//                BasketItemDto dto2 = null;
//
//                for (BasketItemDto dto : list) {
//                    if (dto1 == null) {
//                        dto1 = dto;
//                    } else if (!dto.equals(dto1)) {
//                        dto2 = dto;
//                        break;
//                    }
//                }
//
//                dto1.setNum(dto2.getNum());
//                dto1.setName(dto2.getName());
//                dto1.setOpt1(dto2.getOpt1());
//                dto1.setOpt2(dto2.getOpt2());
//                dto1.setOpt3(dto2.getOpt3());
//
//                int qty1 = dto1.getQty();
//                int qty2 = dto2.getQty();
//
//                // 서비스로 변경
//
//                // 변경할 데이터 삭제 + 변경 내용 데이터 업데이트
//                assertTrue(service.modify(dto1));
//
//                // 변경된 수량 확인
//                List<BasketItemDto> updatedList = service.getBasketItem(mock);
//                BasketItemDto target = dto1;
//                // 💥
//                assertTrue(updatedList.stream()
//                                      .anyMatch(item -> item.getSeq() != target.getSeq() &&
//                                                        item.equals(target) &&
//                                                        qty1 + qty2 == item.getQty()));
//
//            }
//        }
//
//    }
//
//    @Test
//    public void 다른_상품_안겹침_수량_옵션_변경_성공() throws Exception {
//        for (int i = 1; i <= 5; i++) {
//            int numberOfCust = i * 10, numberOfItem = i * 10, eachBasketItem = i * 5;
//            helper.cleanDB();
//            helper.insertData(numberOfCust, numberOfItem, eachBasketItem);
//
//            for (int userId = 1; userId <= numberOfCust; userId++) {
//                String id = String.valueOf(userId);
//                mock.setId(id);
//                List<BasketItemDto> list = service.getBasketItem(mock);
//
//                for (BasketItemDto dto : list) {
//                    int seq = dto.getSeq();
//                    int qty = 100;
//                    String num = dto.getNum();
//                    String opt1 = "new size";
//                    String opt2 = "new color";
//                    String opt3 = "new one";
//
//                    BasketItemDto updateDto = new BasketItemDto(seq, id, num, "dededede",
//                            0, qty, opt1, opt2, opt3, null, null, "Y", null, null, null, null);
//                    assertTrue(service.modify(updateDto));
//
//                    List<BasketItemDto> updatedList = service.getBasketItem(mock);
//                    assertTrue(updatedList.stream()
//                            .anyMatch(item -> item.equals(updateDto)));
//
//                    assertTrue(updatedList.stream()
//                            .filter(item -> item.equals(updateDto))
//                            .findFirst()
//                            .get()
//                            .getQty() == qty);
//
//                    int totalCnt = updatedList.size();
//                    assertTrue(eachBasketItem == totalCnt);
//                }
//            }
//
//        }
//    }
}