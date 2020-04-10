package org.csu.fastfish.persistence;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.csu.fastfish.domain.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountMapper {
    //定义User相关的参数，使用@注解将sql语句和方法绑定
    @Select("select * from account")
    List<Account> findAllUsers ();

    @Select("select * from account where username = #{username}")
    Account findUserByName(String username);

    @Select("select * from account where username = #{username}")
    Account getAccountByUsername(String username);

    @Select("select * from account where username = #{username} and password = #{password}")
    Account getAccountByUsernameAndPassword(String username, String password);

//    @Insert("INSERT INTO account (username, password, phonenumber,email, address, photo, money, point) " +
//            "values (#{username}, #{password}, #{phonenumber}, #{email}, #{address}, #{photo}, #{money}, #{point} )")
//    void insertAccount(Account account);

    @Insert("INSERT INTO account (username, password, phonenumber) " +
            "values (#{username}, #{password}, #{phonenumber})")
    void insertAccount(Account account);

    @Update("update account set username = #{username}, phonenumber = #{phonenumber}, address = #{address}, email = #{email} " )
    void updateProfile(Account account);

    @Update( "UPDATE SIGNON SET PASSWORD = #{password}  WHERE USERNAME = #{username}")
    void updateSignon(Account account);

}
