package ru.netology.sql.data;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.Date;

public class DataHelper {

    private DataHelper() {

    }

    @Data
    @NoArgsConstructor
    public static class User {
        private String id;
        private String login;
        private String password;
        private String status;
    }

    @Data
    @NoArgsConstructor
    public static class AuthCode {
        private String id;
        private String user_id;
        private String code;
        private Date created;
    }

    @Value
    public static class Password {
        public String password;
    }

    public static Password getPassword() {
        return new Password("qwerty123");
    }
}
