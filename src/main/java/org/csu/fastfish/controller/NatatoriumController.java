package org.csu.fastfish.controller;

import org.csu.fastfish.domain.Natatorium;
import org.csu.fastfish.service.NatatoriumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NatatoriumController {
    @Autowired
    private NatatoriumService natatoriumService;

    @GetMapping("/natatorium/allNatatoriums")
    public List<Natatorium> findAllNatatoriums(){
        return natatoriumService.findAllNatatoriums();
    }

    @GetMapping("/natatorium/name")
    public Natatorium findNatatoriumByName(String name){
        return natatoriumService.findNatatoriumByName(name);
    }

    @GetMapping("/natatorium/id")
    public Natatorium findNatatoriumById(int id){
        return natatoriumService.findNatatoriumById(id);
    }
}
