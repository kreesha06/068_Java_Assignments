package servlets;

import java.io.IOException;
import java.sql.*;
import db.dbConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Forward GET request to register.jsp
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1️⃣ Get form parameters
        String username = request.getParameter("username");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String userCaptchaStr = request.getParameter("captcha");

        // 2️⃣ Basic validation
        if (username == null || username.trim().isEmpty()
                || login == null || login.trim().isEmpty()
                || password == null || password.trim().isEmpty()
                || email == null || email.trim().isEmpty()
                || userCaptchaStr == null || userCaptchaStr.trim().isEmpty()) {

            request.setAttribute("error", "All fields are required!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        // 3️⃣ Validate captcha
        HttpSession session = request.getSession();
        Object sessionCaptchaObj = session.getAttribute("captcha");
        if (sessionCaptchaObj == null) {
            request.setAttribute("error", "Captcha expired, please try again");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        int sessionCaptcha = (int) sessionCaptchaObj;
        int userCaptcha = 0;
        try {
            userCaptcha = Integer.parseInt(userCaptchaStr);
        } catch (Exception e) {
            request.setAttribute("error", "Invalid captcha format");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        if (sessionCaptcha != userCaptcha) {
            request.setAttribute("error", "Captcha does not match");
            request.getRequestDispatcher("register.jsp").forward(request, response);
            return;
        }

        // 4️⃣ Insert into database
        try (Connection con = dbConnection.getConnection(); PreparedStatement ps = con.prepareStatement(
                "INSERT INTO user_master(username, login_id, password, email) VALUES (?, ?, ?, ?)")) {

            ps.setString(1, username);
            ps.setString(2, login);
            ps.setString(3, password);
            ps.setString(4, email);
            ps.executeUpdate();

            // 5️⃣ Success → redirect to login
            response.sendRedirect(request.getContextPath() + "/login.jsp");

        } catch (SQLIntegrityConstraintViolationException e) {
            // Duplicate login ID
            request.setAttribute("error", "Login ID already exists");
            request.getRequestDispatcher("register.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Internal error, please try again");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "User Registration Servlet with validation and captcha";
    }
}
