package edu.shifan.servlet;

import edu.shifan.mapper.StudentMapper;
import edu.shifan.pojo.Student;
import edu.shifan.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/update")
public class updateServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求的编码格式
        req.setCharacterEncoding("UTF-8");
        //获取用户提交的数据
        Student stu = new Student();

        //获取参数中的数据
        //getParameter()：获取请求参数的字符串类型返回值
        stu.setStuName(req.getParameter("userName"));
        stu.setGender("1".equals(req.getParameter("gender")));
        stu.setAge(Integer.parseInt(req.getParameter("age")));
        stu.setTel(req.getParameter("tel"));
        stu.setAddress(req.getParameter("address"));
        stu.setGradeId(Integer.parseInt(req.getParameter("gradeId")));
        stu.setStuNo(Integer.parseInt(req.getParameter("stuNo")));

        System.out.println("update");
        System.out.println(stu);


        SqlSession session = SessionUtil.getSession();

        StudentMapper mapper = session.getMapper(StudentMapper.class);

        mapper.update(stu);

        SessionUtil.close();

        req.getRequestDispatcher("list").forward(req,resp);
    }
}
