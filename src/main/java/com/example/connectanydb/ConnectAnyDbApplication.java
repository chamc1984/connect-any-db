package com.example.connectanydb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConnectAnyDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConnectAnyDbApplication.class, args);
		
		try {
		    new ConnectAnyDbApplication().connect_postgres();
		} catch (Exception e) {
		    System.out.println(e);
		}

	}

    private void connect_postgres() throws Exception {

        // TODO: ひとまずベタで、外出しなり環境変数にする
        String uri = "jdbc:postgresql://localhost:25432/postgres";
        String user = "postgres";
        String pass = "admin123";

        // 接続
        Connection conn = DriverManager.getConnection(uri, user, pass);
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select 1 as col");

        // 結果を取得
        while(rs.next()) {
            System.out.println("結果：" + rs.getString("col"));
        }

        // 後片付け
        st.close();
        conn.close();
    }

}
