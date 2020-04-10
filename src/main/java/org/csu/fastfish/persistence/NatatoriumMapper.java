package org.csu.fastfish.persistence;

import org.apache.ibatis.annotations.Select;
import org.csu.fastfish.domain.Natatorium;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NatatoriumMapper {
    @Select("select * from natatorium")
    List<Natatorium> findAllNatatoriums();

    @Select("select * from natatorium where nata_name = #{name}")
    Natatorium findNatatoriumByName(String name);

    @Select("select * from natatorium where id = #{id}")
    Natatorium findNatatoriumById(int id);


}
