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

/**
 * 实现步骤
 *  1、创建类并继承于HttpServlet
 *  2、使用@WebServlet注解进行标注
 *  3、重写Service方法
 */
@WebServlet("/add")
public class AddServlet extends HttpServlet {
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
        stu.setGradeId(1);

        System.out.println(stu);

        //调用mapper的方法进行数据的添加
        //1、获取SqlSession对象
        SqlSession session = SessionUtil.getSession();
        //2、获取Mapper对象
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        //3、执行add方法
        int result=mapper.add(stu);
        //4、关闭session对象
        SessionUtil.close();

        System.out.println("result="+result);
        //执行成功后跳转会index.jsp页面
        req.getRequestDispatcher("list").forward(req,resp);
    }
}
