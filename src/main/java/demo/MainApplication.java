package demo;

import demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Arrays;

public class MainApplication {
    private static SessionFactory sessionFactory;

    static {
        sessionFactory=HibernateUtils.getSessionFactory(Arrays.asList(Car.class,CarManufacturer.class,Company.class,
                Driver.class,Insurance.class,Owner.class,Person.class));
    }

    public static void main(String[] args) {
        try(Session session= sessionFactory.openSession()){
            CarDAO obj=new CarDAO(session);
            obj.createDB();

        }

        JPAUtil.checkData("select * from car");
        JPAUtil.checkData("select * from car_manufacturer");
        JPAUtil.checkData("select * from insurance_company");
        JPAUtil.checkData("select * from car_insurance");
        JPAUtil.checkData("select * from person");
        JPAUtil.checkData("select * from owner");
        JPAUtil.checkData("select * from driver");
        JPAUtil.checkData("select * from car_owner");
        JPAUtil.checkData("select * from car_driver");


    }
}
/**/