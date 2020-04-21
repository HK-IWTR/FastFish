package org.csu.fastfish.persistence;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.csu.fastfish.domain.Collection;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectionMapper {

    @Select("select * from collections")
    public List<Collection> getCollectionsByUsername(String username);

    @Insert("insert into collections (nata_id, username) values (#{nata_id}, #{username})")
    public void addCollection(int nata_id, String username);

    @Delete("delete from collections where nata_id=#{nata_id} and username=#{username}")
    public void cancelCollect(int nata_id, String username);

}
