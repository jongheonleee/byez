package com.neo.byez.service.item;


import com.neo.byez.dao.item.ItemDaoImpl;
import com.neo.byez.dao.item.LikeItemDao;
import com.neo.byez.dao.item.LikeItemDaoImpl;
import com.neo.byez.domain.item.ItemDto;
import com.neo.byez.domain.item.LikeItemDto;
import com.neo.byez.domain.item.LikeItemDtos;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LikeItemServiceImpl {

    @Autowired
    private ItemDaoImpl itemDao;
    @Autowired
    private LikeItemDaoImpl likeDao;

    public LikeItemServiceImpl() {}

    // 00. 유저 좋아요 상품 목록 조회
    public List<LikeItemDto> getLikeItem(String id) throws Exception {
        try {
            List<LikeItemDto> dtos = likeDao.selectAll(id);
            if (dtos == null) {
                throw new Exception("정상적으로 조회되지 않았습니다.");
            }

            return dtos;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    // 01. 유저 좋아요 상품 등록
    @Transactional(rollbackFor = Exception.class)
    public boolean register(LikeItemDto dto) {
        // 상품 조회
        // 아이디 조회
        // LikeItemDto 생성
        // 인서트
        int rowCnt = 0;

        try {
            ItemDto target = itemDao.select(dto.getNum());
            dto.setName(target.getName());
            dto.setType(target.getCust_type());
            dto.setReview_cnt(target.getReview_cnt());
            dto.setPrice(target.getPrice());
            dto.setDisc_price(target.getDisc_price());
            dto.setMain_img(target.getMain_img());
            dto.setLike_cnt(target.getLike_cnt());
            dto.setItem_comt(",,");
            dto.setState_code(",,");
            rowCnt = likeDao.insert(dto);
            if (rowCnt != 1) {
                throw new Exception("상품이 정상적으로 등록되지 않았습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rowCnt == 1;
    }

    // 02. 유저 좋아요 상품 삭제
    public boolean remove(LikeItemDto dto) {
        int rowCnt = 0;

        try {
            rowCnt = likeDao.delete(dto);
            if (rowCnt != 1) {
                throw new Exception("상품이 정상적으로 삭제되지 않았습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rowCnt == 1;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean removeSeveral(LikeItemDtos dtos) throws Exception {
        int totalCnt = dtos.getList().size();
        int rowCnt = 0;

        try {
            for (LikeItemDto dto : dtos.getList()) {
                rowCnt += likeDao.delete(dto);
            }

            if (totalCnt != rowCnt) {
                throw new Exception("상품을 제대로 삭제하지 못했습니다.");
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


    // 03. 유저 좋아요 상품 모두 삭제
    @Transactional(rollbackFor = Exception.class)
    public boolean removeAll(String id) throws Exception {
        int totalCnt = likeDao.count(id);
        int rowCnt = 0;

        try {
            rowCnt = likeDao.deleteAll(id);
            if (totalCnt != rowCnt) {
                throw new Exception("모든 상품이 정상적으로 삭제되지 않았습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        return rowCnt == totalCnt;
    }

    // 04. 유저 좋아요 상품 변경
    public boolean modify(LikeItemDto dto) {
        int rowCnt = 0;

        try {
            rowCnt = likeDao.update(dto);
            if (rowCnt != 1) {
                throw new Exception("상품을 정상적으로 변경하지 못했습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rowCnt == 1;
    }

    // 05. 유저 좋아요 상품 페이징 조회
    public List<LikeItemDto> getSelectedPage(String id, Integer offSet, Integer pageSize) throws Exception {
        Map map = new HashMap();

        map.put("id", id);
        map.put("offset", offSet);
        map.put("pageSize", pageSize);

        return likeDao.selectPage(map);
    }

    // 06. 유저의 상품 수량
    public int getCount(String id) throws Exception {
        return likeDao.count(id);
    }
}
