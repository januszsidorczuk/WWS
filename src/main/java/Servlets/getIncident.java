package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Optional;


@WebServlet("/welcome")
public class getIncident extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] godziny = new String[24];
        for (int i = 0; i < 24; i++) {
            godziny[i] = Optional.ofNullable(req.getParameter("godziny" + i)).orElse("NULL");
        }


        Writer writer = resp.getWriter();
        for (int n = 0; n < 24; n++) {
            writer.write(" "+n+" "+godziny[n]);
        }

    }
}