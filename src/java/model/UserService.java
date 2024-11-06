/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 12906
 */
public class UserService {
    private static List<User> users = new ArrayList<>();

    public static boolean register(User user) {
        if (isUsernameValid(user.getUsername()) && isPasswordValid(user.getPassword())) {
            users.add(user);
            return true;
        }
        return false;
    }

    public static int login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return 0;
            } else if (user.getUsername().equals(username)) {
                return 1;//密码错误
            }
        }
        return 2;//账户不存在
    }

    // 验证用户名和密码规则的方法
    private static boolean isUsernameValid(String username) {
        return username.length() >= 8;
    }

    private static boolean isPasswordValid(String password) {
        // 密码规则：至少8个字符，至少包含一个大写字母和一个小写字母等
        return password.length() >= 8;
    }
    
}
