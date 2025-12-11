package com.mphasis.dao;
import com.mphasis.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class AdminDao {

        public User login(String email, String password) {
            try {
                Connection con = DBUtil.getConnection();
                String sql = "SELECT * FROM user WHERE email=? AND password=?";
                PreparedStatement ps = con.prepareStatement(sql);

                ps.setString(1, email);
                ps.setString(2, password);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    User admin = new User();
                    admin.setId(rs.getInt("id"));
                    admin.setName(rs.getString("name"));
                    admin.setEmail(rs.getString("email"));
                    return admin;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }

