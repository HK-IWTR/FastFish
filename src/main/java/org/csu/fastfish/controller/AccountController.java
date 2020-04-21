package org.csu.fastfish.controller;

import org.csu.fastfish.domain.Account;
import org.csu.fastfish.service.AccountService;
import org.csu.fastfish.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:63342", maxAge = 3600, allowCredentials = "true")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private HttpServletRequest request;

    private Account account = new Account();
    private boolean authenticated;

    public Account getAccount() {
        return this.account;
    }
    public void setAccount(Account account) {
         this.account = account;
    }

    @PostMapping("/account/signon")
    public Map<String,String> signon(String username, String password, HttpSession session){
        System.out.println(session.getId());
        Map<String, String> result = new  HashMap<>();
        account = accountService.getAccount(username,password);

        if (account == null) {
            String value = "Invalid username or password.  Signon failed.";
            result.put("result", "false");
            result.put("errorlog", value);
            clear();
            return result;
        } else {
            account.setPassword(null);
//            myList = catalogService.getProductListByCategory(account.getFavouriteCategoryId());
            authenticated = true;
            session.setAttribute("accountBean", this);
            result.put("result", "true");
            return result;
        }
    }

    @GetMapping("/account/issignon")
    public Map<String, String> isSignOn() {
        Map<String, String> result = new HashMap<>();
        if (isAuthenticated()) {
            result.put("result", "true");
            result.put("username", account.getUsername());
        } else {
            result.put("result", "false");
        }
        return result;
    }

    @GetMapping("/account/money")
    public Map<String, Float> accountMoney(){
        Map<String,Float> result = new HashMap<>();
        result.put("money", account.getMoney());
        return result;
    }
    @GetMapping("/account/point")
    public Map<String, Integer> accountPoint(){
        Map<String,Integer> result = new HashMap<>();
        result.put("point", account.getPoint());
        return result;
    }
    @GetMapping("account/profile")
    public Map<String, String> accountProfile(){
        Map<String,String> result = new HashMap<>();
        result.put("username", account.getUsername());
        result.put("phonenumber", account.getPhonenumber());
        result.put("email", account.getEmail());
        result.put("address", account.getAddress());
        return result;
    }

    @GetMapping("/account/signoff")
    public void signOff(HttpSession session) {
        session.invalidate();
        clear();
    }

    @PostMapping("account/editPassword")
    public Map<String, String> editProfile(){
        Map<String, String> result = new HashMap<>();

        return result;
    }

    @PostMapping("/account/editProfile")
    public Map<String, String> editAccount(Account account) {
        System.out.println(account);
        HttpSession session = request.getSession();
        System.out.println(session.getId());
        Map<String, String> result = new HashMap<>();
        accountService.updateProfile(account);
        this.account = accountService.getAccount(account.getUsername());
        System.out.println(this.account);
        session.setAttribute("accountBean", this);
        result.put("result", "true");
        return result;
    }

    @PostMapping("/account/new")
    public Map<String, String> newAccount(Account account, String repeatedPassword, HttpSession session) {
        Map<String, String> result = new HashMap<>();
        System.out.println("new account:"+account);
        String username = account.getUsername();
        String password = account.getPassword();
        System.out.println(username);

        if (username.isEmpty()) {
            result.put("result", "false");
            result.put("error", "usernameEmpty");
            return result;
        }

        if (password.isEmpty() || repeatedPassword.isEmpty()) {
            result.put("result", "false");
            result.put("error", "passwordEmpty");
            return result;
        }

        if (password.equals(repeatedPassword)) {
            Account resultAccount = accountService.getAccount(username);
            if (resultAccount == null) {
                account.setUsername(username);
                account.setPassword(password);
            } else {
                result.put("result", "false");
                result.put("error", "exist");
                return result;
            }
        } else {
            result.put("result", "false");
            result.put("error", "repeat");
            return result;
        }
        accountService.insertAccount(account);
        this.account = accountService.getAccount(account.getUsername());
        authenticated = true;
        session.setAttribute("accountBean", this);
        result.put("result", "true");
        return result;
    }





    public boolean isAuthenticated() {
        return authenticated && account != null && account.getUsername() != null;
    }

    public void clear() {
        account = new Account();
//        myList = null;
        authenticated = false;
    }



}
