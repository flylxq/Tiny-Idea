package com.tinyIdea.DAO;

import com.tinyIdea.util.UserInfo;

public interface UserDAO {
    public void insert(UserInfo userInfo);
    
    public boolean update(UserInfo userInfo);
    
    public boolean delete(UserInfo userInfo);
    
    public UserInfo selectById(long userId);
}
