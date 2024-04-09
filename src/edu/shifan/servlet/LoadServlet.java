package edu.shifan.servlet;


import edu.shifan.mapper.GradeMapper;
import edu.shifan.mapper.StudentMapper;
import edu.shifan.pojo.Grade;
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
import java.util.List;

@WebServlet("/load")
public class LoadServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        SqlSession session = SessionUtil.getSession(false);

        StudentMapper mapper = session.getMapper(StudentMapper.class);

        Student stu = mapper.findById(id);

        //获取年级mapper对象
        GradeMapper gradeMapper = session.getMapper(GradeMapper.class);
        //调用mapper方法
        List<Grade> gradeList = gradeMapper.findAll();

        SessionUtil.close();

        System.out.println(stu);

        //作用域
        req.setAttribute("student",stu);
        req.setAttribute("grades",gradeList);


        req.getRequestDispatcher("update.jsp").forward(req,resp);


    }
}
