package com.perfumeReco.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@perfumeReco_medium?TNS_ADMIN=E:/web-workspace/workspace-perfumeReco/backend/src/main/webapp/resources/wallet";
        String username = "admin";
        String password = "Zxcv12341234";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // 데이터베이스 연결
            connection = DriverManager.getConnection(url, username, password);

            // SQL 쿼리 작성
            String query = "INSERT INTO IMAGES (ID) VALUES (?)";

            // PreparedStatement 생성
            preparedStatement = connection.prepareStatement(query);

            // ID 설정
            String id = "peter";
            preparedStatement.setString(1, id);

            // SQL 실행
            int rowsInserted = preparedStatement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("데이터가 성공적으로 삽입되었습니다.");
            } else {
                System.out.println("데이터 삽입에 실패하였습니다.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 리소스 해제
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}