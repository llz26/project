package com.stylefeng.guns.modular.vocabulary.dao;

import com.stylefeng.guns.modular.system.model.Hsk1;
import com.stylefeng.guns.modular.vocabulary.Domain.HSK;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HSKDao {
    //查询hsk表
    public List<HSK> getHskList(int level){
        Transaction tx = null;
        String hql;
        try{
            Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
            hql = "from HSK s where s.level=?";
            tx = session.beginTransaction();
            Query query = session.createQuery(hql);
            query.setParameter(0,level);
            List<HSK> list = query.list();
            tx.commit();
            return list;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally{
            if(tx!=null){
                tx=null;
            }
        }
    }
}
