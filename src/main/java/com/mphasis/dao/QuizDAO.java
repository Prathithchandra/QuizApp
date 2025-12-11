package com.mphasis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.mphasis.models.Quiz;
import com.mphasis.dao.DBUtil;

public class QuizDAO {

    public int createQuiz(Quiz quiz) {
        try {
            Connection con = DBUtil.getConnection();
            String sql = "INSERT INTO quiz(title,category) VALUES(?,?)";
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, quiz.getTitle());
            ps.setString(2, quiz.getCategory());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public boolean addQuestionToQuiz(int quizId, int questionId) {
        try {
            Connection con = DBUtil.getConnection();
            String sql = "INSERT INTO quiz_questions(quiz_id,question_id) VALUES(?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, quizId);
            ps.setInt(2, questionId);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

