package ru.netology.sql.data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;


public class SQLHelper {
    private static final QueryRunner runner = new QueryRunner();

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "vasya", "qwerty123");
    }

    private SQLHelper() {

    }

    @SneakyThrows
    public static DataHelper.AuthCode getAuthCode() {
        var codeSQL = "SELECT * FROM auth_codes ORDER BY created DESC LIMIT 1";
        try (var conn = getConnection()) {
            return runner.query(conn, codeSQL, new BeanHandler<>(DataHelper.AuthCode.class));
        }
    }

    @SneakyThrows
    public static void cleanAuthCodesTable() {
        var authCodesSQL = "DELETE FROM auth_codes";
        try (var conn = getConnection()) {
            runner.update(conn, authCodesSQL);
        }
    }

    @SneakyThrows
    public static void cleanCardsTable() {
        var CardsSQL = "DELETE FROM cards";
        try (var conn = getConnection()) {
            runner.update(conn, CardsSQL);
        }
    }

    @SneakyThrows
    public static void cleanUsersTable() {
        var usersSQL = "DELETE FROM users";
        try (var conn = getConnection()) {
            runner.update(conn, usersSQL);
        }
    }
}
