package com.example.testthu.repository;

import com.example.testthu.model.KhachHang;
import com.example.testthu.util.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class KhachHangRepository {
    public List<KhachHang> getAll(){
        List<KhachHang> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            list = session.createQuery("from KhachHang", KhachHang.class).getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public KhachHang getOne(String id){
        KhachHang kh = new KhachHang();
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            kh = session.createQuery("from KhachHang kh where kh.id=:id", KhachHang.class)
                    .setParameter("id",id)
                    .getSingleResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        return kh;
    }
    public Boolean add(KhachHang kh){
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            session.getTransaction().begin();
            session.persist(kh);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public Boolean delete(KhachHang kh){
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            session.getTransaction().begin();
            session.delete(kh);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public Boolean update(KhachHang kh){
        try (Session session = HibernateUtil.getFACTORY().openSession()){
            session.getTransaction().begin();
            session.merge(kh);
            session.getTransaction().commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new KhachHangRepository().getOne("A28542A5-6175-4238-B7FD-6857A610155B"));
    }

}
