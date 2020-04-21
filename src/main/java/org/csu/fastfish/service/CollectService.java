package org.csu.fastfish.service;

import org.csu.fastfish.domain.Collection;
import org.csu.fastfish.persistence.CollectionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectService {
    @Autowired
    private CollectionMapper collectionMapper;

    public List<Collection> getCollectionsByUsername(String username){
        return collectionMapper.getCollectionsByUsername(username);
    }

    public void addCollection(int nata_id, String username){
        collectionMapper.addCollection(nata_id, username);
    }

    public void cancelCollect(int nata_id, String username){
        collectionMapper.cancelCollect(nata_id, username);
    }
}
