package org.csu.fastfish.service;

import org.csu.fastfish.domain.Account;
import org.csu.fastfish.persistence.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountMapper accountMapper;

    //实现mapper中定义的功能
    public List<Account> findAllUsers(){
        return accountMapper.findAllUsers();
    }

    public Account findUserByName(String username){
        return accountMapper.findUserByName(username);
    }

    public Account getAccount(String username){return accountMapper.getAccountByUsername(username);}

    public Account getAccount(String username, String password){
        return accountMapper.getAccountByUsernameAndPassword(username, password);
    }

    @Transactional
    public void insertAccount(Account account){
        accountMapper.insertAccount(account);
    }

    @Transactional
    public void updateProfile(Account account) {
        accountMapper.updateProfile(account);
    }

    public void updateMoney(float money, String username){
        accountMapper.updateMoney(money, username);
    }
}
