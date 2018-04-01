package com.example.jar的加载顺序;

import com.example.config.DemoInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URL;

/**
 * Created by tom on 2018/1/13.
 */
public class TestJarOrder {
    protected static Logger logger = LoggerFactory.getLogger(DemoInterceptor.class);

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println("bootstrap classloader \n");
        //获得bootstrap classloader加载了那些核心类库
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urls.length; i++) {
            System.out.println(urls[i].toExternalForm());
        }
        System.out.println("extension classloader\n");
        /**
         * extension classloader －扩展类加载器，它负责加载JRE的扩展目录（JAVA_HOME/jre/lib/ext或者由java.ext.dirs系统属性指定的）中JAR的类包。
         * 这为引入除Java核心类以外的新功能提供了一个标准机制。
         * 因为默认的扩展目录对所有从同一个JRE中启动的JVM都是通用的，
         * 所以放入这个目录的 JAR类包对所有的JVM和system classloader都是可见的。
         */
        System.out.println(System.getProperty("java.ext.dirs"));
        ClassLoader extensionClassloader = ClassLoader.getSystemClassLoader().getParent();
        System.out.println("the parent of extension classloader : " + extensionClassloader.getParent());
        System.out.println("system classloader \n");
        /**
         * system classloader －系统（也称为应用）类加载器，
         * 它负责在JVM被启动时，加载来自在命令java中的-classpath或者java.class.path系统属性或者 CLASSPATH操作系统属性所指定的JAR类包和类路径。
         * 总能通过静态方法ClassLoader.getSystemClassLoader()找到该类加载器。
         * 如果没有特别指定，则用户自定义的任何类加载器都将该类加载器作为它的父加载器。
         */
        System.out.println(System.getProperty("java.class.path"));


        oracle.jdbc.driver.OracleDriver od = new oracle.jdbc.driver.OracleDriver();
//            OracleDriver od = new OracleDriver();
        URL url = od.getClass().getProtectionDomain().getCodeSource().getLocation();
        String dbpath = java.net.URLDecoder.decode(url.toString(), "UTF-8");
        logger.debug("OracleDriver path" + url);
        logger.debug("dbpath " + dbpath);
    }
}
