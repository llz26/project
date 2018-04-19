package com.stylefeng.guns.modular.vocabulary.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Created by Administrator on 2017/5/31.
 */
public class MyHibernateSessionFactory {
    private static SessionFactory sessionFactory; //会话工厂
    //单例模式，构造函数私有化
    private MyHibernateSessionFactory(){

    }
    //静态方法获取会话工厂对象
    public static SessionFactory getSessionFactory(){
        if(sessionFactory==null){
            Configuration configuration=new Configuration();
            configuration.configure();
            sessionFactory=configuration.buildSessionFactory();
        }
        return sessionFactory;
    }
}
