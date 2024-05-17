package com.neo.byez.dao;

import com.neo.byez.domain.AddressEntryDto;

import java.util.List;

public interface AddrListDao {
    int count() throws Exception;

    List<AddressEntryDto> selectAll() throws Exception;

    AddressEntryDto selectBySeq(Integer seq) throws Exception;

    List<AddressEntryDto> selectById(String id) throws Exception;

    int insert(AddressEntryDto addressEntryDto) throws Exception;

    int deleteAll() throws Exception;

    int delete(Integer seq) throws Exception;

    int update(AddressEntryDto addressEntryDto) throws Exception;
}
