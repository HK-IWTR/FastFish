package org.csu.fastfish.controller;

import org.csu.fastfish.domain.Account;
import org.csu.fastfish.domain.Order;
import org.csu.fastfish.service.AccountService;
import org.csu.fastfish.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:63342", maxAge = 3600, allowCredentials = "true")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private HttpServletRequest request;

    private Order order = new Order();
    private AccountController accountBean;
    private List<Order> orderList = new ArrayList<>();

    @GetMapping("/order/orders")
    public List<Order> listOrders(HttpSession session) {
        accountBean = (AccountController) session.getAttribute("accountBean");
        Account account = accountBean.getAccount();
        orderList = orderService.getOrdersByUsername(account.getUsername());
        return orderList;
    }

    @GetMapping("/order/this")
    public Order getThisOrder(HttpSession session){
        return this.order;
    }

    @GetMapping("/order/cancel")
    public Map<String, String> cancelOrder (HttpSession session, int orderId, float price){
        System.out.println(session.getId());
        Map<String, String> result = new HashMap<>();
        orderService.cancelOrderById(orderId);
        accountBean = (AccountController) session.getAttribute("accountBean");
        Account account = accountBean.getAccount();
        float money = account.getMoney() + price;
        account.setMoney(money);
        accountService.updateMoney(money, account.getUsername());
        accountBean.setAccount(account);
        session.setAttribute("accountBean", accountBean);
        result.put("result", "成功取消预约");
        return result;

    }

    @PostMapping("/order/new")
    public Map<String,String> newOrder(Order order, HttpSession session){
        accountBean = (AccountController) session.getAttribute("accountBean");
        System.out.println(session.getId());
        Map<String, String> result = new HashMap<>();
        Account account = accountBean.getAccount();
        float money = account.getMoney();
        orderList = orderService.getOrdersByUsername(order.getUsername());

        System.out.println(orderList);

        for (int i = 0; i < orderList.size(); i++){
            if ( orderList.get(i).getNata_name().equals(order.getNata_name())  && orderList.get(i).getEvent_date().equals(order.getEvent_date())
                    && orderList.get(i).getEvent_time().equals(order.getEvent_time())  ){
                result.put("result", "请勿重复预定！");
                return result;
            }
        }
        if (money < order.getPrice()){
            result.put("result", "余额不足");
        }
        else {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String order_time = df.format(date);
            order.setOrder_time(order_time);
            orderService.insertOrder(order);
            money = money - order.getPrice();
            accountService.updateMoney(money, account.getUsername());
            account = accountService.getAccount(order.getUsername());
            accountBean.setAccount(account);
            session.setAttribute("accountBean", accountBean);
            result.put("result", "预定成功");
        }
        return result;
    }

}
