package com.mphasis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.mphasis.models.Result;
import com.mphasis.dao.DBUtil;

public class ResultDao {

    public boolean saveResult(Result r) {
        try {
            Connection con = DBUtil.getConnection();
            String sql = "INSERT INTO results(user_id,quiz_id,score,total_questions) VALUES(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, r.getUserId());
            ps.setInt(2, r.getQuizId());
            ps.setInt(3, r.getScore());
            ps.setInt(4, r.getTotalQuestions());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Result> getResultsByUser(int userId) {
        List<Result> list = new ArrayList<>();

        try {
            Connection con = DBUtil.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM results WHERE user_id=?");
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Result r = new Result();
                r.setId(rs.getInt("id"));
                r.setUserId(rs.getInt("user_id"));
                r.setQuizId(rs.getInt("quiz_id"));
                r.setScore(rs.getInt("score"));
                r.setTotalQuestions(rs.getInt("total_questions"));
                r.setTakenAt(rs.getTimestamp("taken_at"));
                list.add(r);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}

