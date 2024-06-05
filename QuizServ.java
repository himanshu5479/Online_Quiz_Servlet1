package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QuizServ extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String c = request.getParameter("coffee");
            String p = request.getParameter("population");
            String a = request.getParameter("area");
            int cnt = 0;

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Quiz Results</title>");
            // Add CSS style
            out.println("<style>");
            out.println("body {");
            out.println("  font-family: Arial, sans-serif;");
            out.println("  background-color: #f3f3f3;");
            out.println("  margin: 0;");
            out.println("  padding: 0;");
            out.println("}");
            out.println(".container {");
            out.println("  width: 80%;");
            out.println("  margin: 0 auto;");
            out.println("}");
            out.println("h1, h2 {");
            out.println("  text-align: center;");
            out.println("  color: #333;");
            out.println("}");
            out.println(".result {");
            out.println("  padding: 20px;");
            out.println("  border: 2px solid #ccc;");
            out.println("  border-radius: 5px;");
            out.println("  background-color: #fff;");
            out.println("  margin: 20px auto;");
            out.println("}");
            out.println(".correct {");
            out.println("  color: #008000;");
            out.println("}");
            out.println(".incorrect {");
            out.println("  color: #ff0000;");
            out.println("}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<h1>Quiz Results</h1>");

            out.println("<div class='result'>");
            if (c != null && c.equals("kn")) {
                out.println("<p class='correct'>Your answer for the first question is correct: Karnataka</p>");
                cnt++;
            } else {
                out.println("<p class='incorrect'>Incorrect answer for the first question. The correct answer is Karnataka.</p>");
            }

            if (p != null && p.equals("up")) {
                out.println("<p class='correct'>Your answer for the second question is correct: Uttar Pradesh</p>");
                cnt++;
            } else {
                out.println("<p class='incorrect'>Incorrect answer for the second question. The correct answer is Uttar Pradesh.</p>");
            }

            if (a != null && a.equals("rj")) {
                out.println("<p class='correct'>Your answer for the third question is correct: Rajasthan</p>");
                cnt++;
            } else {
                out.println("<p class='incorrect'>Incorrect answer for the third question. The correct answer is Rajasthan.</p>");
            }

            out.println("</div>");

            if (cnt == 3) {
                out.println("<h2>Congratulations!! You got all answers correct!</h2>");
            } else {
                out.println("<h2>You have scored " + cnt + " out of 3 points.</h2>");
            }

            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Quiz Servlet";
    }
}
