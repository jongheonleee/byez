package com.neo.byez.service.item;


import com.neo.byez.dao.item.LikeItemDao;
import com.neo.byez.dao.item.LikeItemDaoImpl;
import com.neo.byez.domain.item.LikeItemDto;
import com.neo.byez.domain.item.LikeItemDtos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LikeItemServiceImpl implements LikeItemService {

    @Autowired
    private LikeItemDaoImpl dao;

    public LikeItemServiceImpl() {}



    // 00. 유저 좋아요 상품 목록 조회
    @Override
    public List<LikeItemDto> getLikeItem(String id) throws Exception {
        try {
            List<LikeItemDto> dtos = dao.selectAll(id);
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
    @Override
    public boolean register(LikeItemDto dto) {
        int rowCnt = 0;

        try {
            rowCnt = dao.insert(dto);
            if (rowCnt != 1) {
                throw new Exception("상품이 정상적으로 등록되지 않았습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rowCnt == 1;
    }

    // 02. 유저 좋아요 상품 삭제
    @Override
    public boolean remove(LikeItemDto dto) {
        int rowCnt = 0;

        try {
            rowCnt = dao.delete(dto);
            if (rowCnt != 1) {
                throw new Exception("상품이 정상적으로 삭제되지 않았습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rowCnt == 1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean removeSeveral(LikeItemDtos dtos) throws Exception {
        int totalCnt = dtos.getList().size();
        int rowCnt = 0;

        try {
            for (LikeItemDto dto : dtos.getList()) {
                System.out.println(dto);
                rowCnt += dao.delete(dto);
            }

            System.out.println(rowCnt);
            System.out.println(totalCnt);

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
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean removeAll(String id) throws Exception {
        int totalCnt = dao.count(id);
        int rowCnt = 0;

        try {
            rowCnt = dao.deleteAll(id);
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
    @Override
    public boolean modify(LikeItemDto dto) {
        int rowCnt = 0;

        try {
            rowCnt = dao.update(dto);
            if (rowCnt != 1) {
                throw new Exception("상품을 정상적으로 변경하지 못했습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rowCnt == 1;
    }

}
