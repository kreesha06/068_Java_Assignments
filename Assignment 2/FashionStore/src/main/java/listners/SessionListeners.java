/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/ServletListener.java to edit this template
 */
package listners; // correct spelling

import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import db.dbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class SessionListeners implements HttpSessionListener { // corrected class name

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        try (Connection con = dbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(
                "INSERT INTO session_log(session_id, created_at) VALUES(?, NOW())")) {
            ps.setString(1, se.getSession().getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        try (Connection con = dbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(
                "UPDATE session_log SET destroyed_at = NOW() WHERE session_id = ?")) {
            ps.setString(1, se.getSession().getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
