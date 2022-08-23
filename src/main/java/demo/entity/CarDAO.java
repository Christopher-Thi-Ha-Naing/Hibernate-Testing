package demo.entity;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;

public class CarDAO {
    private Session session;

    public CarDAO(Session session) {
        this.session = session;
    }
    public void createDB(){

        Car car1=new Car("Mustang","USA",1996,40000);
        Car car2=new Car("Lexus","Japan",2022,50000);
        Car car3=new Car("MayBench","German",2020,20000);
        Car car4=new Car("Defender","USA",2020,20000);

        CarManufacturer manufacturer1=new CarManufacturer("Ford","Dream Land",300,1789);
        CarManufacturer manufacturer2=new CarManufacturer("Toyota","Love Land",500,1996);
        CarManufacturer manufacturer3=new CarManufacturer("Mercedes","Joy Land",100,1889);

        Insurance insurance1=new Insurance("ABC", "Sule", 20);
        Insurance insurance2=new Insurance("GAG", "Tarmwe", 10);

        Owner owner1=new Owner("John Doe", LocalDate.of(1996, 5, 12),"55-55-555");
        Owner owner2=new Owner("Suzan", LocalDate.of(1990, 7, 10),"55-66-666");
        Owner owner3=new Owner("John William", LocalDate.of(1998, 4, 21),"55-77-777");
        Owner owner4=new Owner("Thomas Hardy", LocalDate.of(1992, 9, 1),"55-88-888");
        Owner owner5=new Owner("Andrew Ng", LocalDate.of(1993, 6, 10),"55-99-999");

        Driver driver1=new Driver("Sue Yin", LocalDate.of(1994, 3, 21), "99-11-111");
        Driver driver2=new Driver("Sai Lau", LocalDate.of(1992, 4, 30), "99-22-222");

        manufacturer1.addCar(car1);
        manufacturer1.addCar(car4);
        manufacturer2.addCar(car2);
        manufacturer3.addCar(car3);

        insurance1.addCar(car1);
        insurance2.addCar(car2);
        insurance1.addCar(car3);

        car1.addOwner(owner1);
        car1.addOwner(owner2);
        car2.addOwner(owner3);
        car3.addOwner(owner4);
        car4.addOwner(owner5);

        car1.addDriver(driver1);
        car1.addDriver(driver2);
        car2.addDriver(driver2);

        Transaction tx= session.beginTransaction();
        session.persist(car1);
        session.persist(car2);
        session.persist(car3);
        session.persist(car4);
        tx.commit();
    }
}
