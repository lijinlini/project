package com.lijinlin.project.learn.OOM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Example {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // 加载 MySQL 驱动程序
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 获取数据库连接并开启自动重连和预处理语句缓存
        String url = "jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC&autoReconnect=true&cachePrepStmts=true";
        String user = "root";
        String password = "l5976877";
        Connection connection = DriverManager.getConnection(url, user, password);

        // 执行查询
        String sql = "SELECT * FROM t2";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();

        // 处理查询结果
        while (resultSet.next()) {
            // TODO: 处理每行记录
        }

        // 关闭连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
