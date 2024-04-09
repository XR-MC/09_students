package edu.shifan.servlet;


import edu.shifan.mapper.StudentMapper;
import edu.shifan.pojo.Student;
import edu.shifan.util.SessionUtil;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/load")
public class LoadServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        SqlSession session = SessionUtil.getSession(false);

        StudentMapper mapper = session.getMapper(StudentMapper.class);

        Student stu = mapper.findById(id);


        SessionUtil.close();

        System.out.println(stu);

        req.setAttribute("student",stu);


        req.getRequestDispatcher("update.jsp").forward(req,resp);


    }
}
