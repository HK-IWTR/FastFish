package org.csu.fastfish.controller;

import org.csu.fastfish.domain.Collection;
import org.csu.fastfish.domain.Natatorium;
import org.csu.fastfish.service.CollectService;
import org.csu.fastfish.service.NatatoriumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:63342", maxAge = 3600, allowCredentials = "true")
public class CollectController {
    @Autowired
    private CollectService collectService;

    @Autowired
    private NatatoriumService natatoriumService;

    @Autowired
    private HttpServletRequest request;

    private AccountController accountBean;
    private List<Collection> collections;

    @GetMapping("/collect/collections")
    public List<Natatorium> getCollections(HttpSession session){
        System.out.println(session.getId());
        accountBean = (AccountController) session.getAttribute("accountBean");
        collections = collectService.getCollectionsByUsername(accountBean.getAccount().getUsername());
        List<Natatorium> natatoriums = new ArrayList<>();
        for (int i = 0; i < collections.size(); i++){
            natatoriums.add(natatoriumService.findNatatoriumById(collections.get(i).getNata_id()));
        }
        return natatoriums;
    }

    @GetMapping("/collect/new")
    public Map<String, String> collectNata(int nata_id, String username){
        System.out.println("aaaa");
        Map<String,String> result = new HashMap<>();
        collectService.addCollection(nata_id,username);
        System.out.println("aaaa");
        result.put("result", "收藏成功");
        return result;
    }

    @GetMapping("/collect/cancel")
    public void cancelCollet(int nata_id, String username){
        collectService.cancelCollect(nata_id, username);
    }

    @GetMapping("/collect/isCollected")
    public Map<String, String> isCollected(int nata_id, String username){
        Map<String,String> result = new HashMap<>();
        String flag = "false";
        collections = collectService.getCollectionsByUsername(username);
        for (int i = 0; i < collections.size(); i++){
            if (nata_id == collections.get(i).getNata_id()){
                flag = "true";
                break;
            }
        }
        result.put("result",flag);
        return result;
    }
}
