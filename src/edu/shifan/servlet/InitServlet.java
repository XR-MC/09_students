package edu.shifan.servlet;


import edu.shifan.mapper.GradeMapper;
import edu.shifan.pojo.Grade;
import edu.shifan.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/init")
public class InitServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取SqlSession对象
        SqlSession session = SessionUtil.getSession();

        //获取Mapper映射对象
        GradeMapper mapper = session.getMapper(GradeMapper.class);

        //调用mapper对象的方法
        List<Grade> list = mapper.findAll();

        //关闭session
        SessionUtil.close();

        //把数据交给Jsp页面(将数据放到作用域--一块内存空间)
        req.setAttribute("list",list);

        //跳转到列表页面(index.jsp)
        req.getRequestDispatcher("add.jsp").forward(req,resp);
    }
}
