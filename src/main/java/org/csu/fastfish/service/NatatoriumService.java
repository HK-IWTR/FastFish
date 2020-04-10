package org.csu.fastfish.service;

import org.csu.fastfish.domain.Natatorium;
import org.csu.fastfish.persistence.NatatoriumMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NatatoriumService {
    @Autowired
    private NatatoriumMapper natatoriumMapper;

    public List<Natatorium> findAllNatatoriums(){
        return natatoriumMapper.findAllNatatoriums();
    }

    public Natatorium findNatatoriumByName(String name){
        return natatoriumMapper.findNatatoriumByName(name);
    }

    public Natatorium findNatatoriumById(int id){
        return natatoriumMapper.findNatatoriumById(id);
    }




}
