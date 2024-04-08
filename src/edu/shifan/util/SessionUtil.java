package edu.shifan.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * SQLSession工具类
 */
public class SessionUtil {
    //SqlSession的最佳范围：应用程序(static的成员在整个应用程序运行期间都存在)
    //private修饰的成员无法直接被访问(封装思想)
    private static SqlSessionFactory factory=null;
    //ThreadLocal:为每个线程创建一个独立的空间(存储SqlSession对象)
    //相当于：万德隆超市的储物柜
    private static ThreadLocal<SqlSession> threadLocal  = new ThreadLocal<>();

    /**
     * 静态代码块
     *  静态代码块在类加载结束后被执行(且只能被执行1次)
     */
    static{
        //以流方式读取MyBatis核心配置文件
        InputStream is = SessionUtil.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
        //通过SqlSessionFactoryBuilder对象构建facotry对象
        factory  = new SqlSessionFactoryBuilder().build(is);
    }

    /**
     * 返回一个SqlSession对象
     *  该Sqlsession对象使用了事务管理器
     * @return
     */
    public static SqlSession getSession(){
        //从ThreadLocal中获取当前线程的SqlSession对象
        SqlSession session = threadLocal.get();

        //判断session对象是否有用
        if(session==null){
            //通过工厂类来构建一个session对象
            session = factory.openSession(true);
            //将session对象添加到threadLocal中
            threadLocal.set(session);
        }

        return session;
    }

    /**
     * 返回一个SqlSession对象
     *  该Sqlsession对象使用了事务管理器
     * @return
     */
    public static SqlSession getSession(boolean state){
        //从ThreadLocal中获取当前线程的SqlSession对象
        SqlSession session = threadLocal.get();

        //判断session对象是否有用
        if(session==null){
            //通过工厂类来构建一个session对象
            session = factory.openSession(state);
            //将session对象添加到threadLocal中
            threadLocal.set(session);
        }

        return session;
    }

    /**
     * 关闭session对象
     */
    public static void close(){
        //从ThreadLocal中获取当前线程的SqlSession对象
        SqlSession session = threadLocal.get();

        //判断session是否有效
        if(session !=null)
            //关闭session对象
            session.close();

        //从threadLocal中移除session对象
        threadLocal.remove();
    }
}
