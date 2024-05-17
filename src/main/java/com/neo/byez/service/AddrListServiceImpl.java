package com.neo.byez.service;

import com.neo.byez.dao.AddrListDaoImpl;
import com.neo.byez.domain.AddressEntryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddrListServiceImpl implements AddrListService {

    @Autowired
    AddrListDaoImpl addrListDao;

    @Override
    public int getTotalAddrCount() throws Exception {
        return addrListDao.count();
    }

    @Override
    public List<AddressEntryDto> getAllAddr() throws Exception {
        return addrListDao.selectAll();
    }

    @Override
    public List<AddressEntryDto> getUsersAddrById(String id) throws Exception {
        return addrListDao.selectById(id);
    }

    @Override
    public AddressEntryDto getUsersAddrBySeq(Integer seq) throws Exception {
        return addrListDao.selectBySeq(seq);
    }

    @Override
    public int registerAddr(AddressEntryDto addressEntryDto) throws Exception {
        return addrListDao.insert(addressEntryDto);
    }

    @Override
    public int deleteAllAddr() throws Exception {
        return addrListDao.deleteAll();
    }

    @Override
    public int deleteAddrBySeq(Integer seq) throws Exception {
        return addrListDao.delete(seq);
    }

    @Override
    public int changeAddr(AddressEntryDto addressEntryDto) throws Exception {
        return addrListDao.update(addressEntryDto);
    }

}
