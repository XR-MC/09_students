package edu.shifan.servlet;


import edu.shifan.mapper.StudentMapper;
import edu.shifan.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/del")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        int id = Integer.parseInt(req.getParameter("id"));

        SqlSession session = SessionUtil.getSession();

        StudentMapper mapper = session.getMapper(StudentMapper.class);

        int count = mapper.delById(id);

        SessionUtil.close();

        System.out.println("count = "+count);

        req.getRequestDispatcher("list").forward(req,resp);




    }
}
