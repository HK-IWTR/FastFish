package org.csu.fastfish.controller;

import org.csu.fastfish.domain.Natatorium;
import org.csu.fastfish.service.NatatoriumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:63342", maxAge = 3600, allowCredentials = "true")
public class NatatoriumController {
    @Autowired
    private NatatoriumService natatoriumService;

    @GetMapping("/natatorium/allNatatoriums")
    public Map<String, List<Natatorium>> findAllNatatoriums(){
        Map<String, List<Natatorium>> result = new HashMap<>();
        result.put("natatoriums", natatoriumService.findAllNatatoriums());
        return result;
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
