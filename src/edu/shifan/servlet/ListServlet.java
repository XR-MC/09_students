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
import java.util.List;

/**
 * Servlet
 *  Servlet既可以像web资源一样进行访问，也可以执行Java代码
 *
 *  步骤：
 *      1、创建类并继承于HttpServlet
 *      2、使用@WebServlet注解或在配置文件中配置映射
 *      3、重写service()方法
 */
@WebServlet("/list")
public class ListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ListServlet is do...............");

        //获取Session对象
        SqlSession session = SessionUtil.getSession(false);
        //获取mapper映射对象
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        //执行查询
        List<Student> list = mapper.findAll();
        //关闭session
        SessionUtil.close();

        //输出查询结果
        //System.out.println(list);

        //把数据交给Jsp页面(将数据放到作用域--一块内存空间)
        req.setAttribute("list",list);

        //跳转到列表页面(index.jsp)
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
