package com.neo.byez.service;

import com.neo.byez.domain.AddressEntryDto;

import java.util.List;

public interface AddrListService {
    int getTotalAddrCount() throws Exception;

    List<AddressEntryDto> getAllAddr() throws Exception;

    List<AddressEntryDto> getUsersAddrById(String id) throws Exception;

    AddressEntryDto getUsersAddrBySeq(Integer seq) throws Exception;

    int registerAddr(AddressEntryDto addressEntryDto) throws Exception;

    int deleteAllAddr() throws Exception;

    int deleteAddrBySeq(Integer seq) throws Exception;

    int changeAddr(AddressEntryDto addressEntryDto) throws Exception;
}
