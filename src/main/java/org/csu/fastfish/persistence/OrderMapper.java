package org.csu.fastfish.persistence;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.csu.fastfish.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {

    @Select("select * from orders where username = #{username} ")
    List<Order> getOrdersByUsername(String username);

    @Insert("insert into orders (username, nata_name, event_date, event_time, order_time, price, picture) " +
            "values (#{username},#{nata_name},#{event_date},#{event_time}, #{order_time}, #{price}, #{picture}) ")
    void insertOrder(Order order);

    @Delete("delete from orders where id = #{orderId}")
    void cancelOrderById(int orderId);
}
