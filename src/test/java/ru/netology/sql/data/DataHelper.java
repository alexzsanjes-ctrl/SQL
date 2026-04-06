package ru.netology.sql.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.Date;

public class DataHelper {

    private DataHelper() {

    }

    @Data
    @NoArgsConstructor
    public static class AuthCode {
        private String code;
    }

    @Value
    public static class UserInfo {
        public String login;
        public String password;
    }

    public static UserInfo getUserInfo() {
        return new UserInfo("vasya","qwerty123");
    }

}
