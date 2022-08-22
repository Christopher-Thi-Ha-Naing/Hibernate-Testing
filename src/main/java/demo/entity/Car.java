package demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String model;
    private String make;
    private int year;
    private int millage;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "manufacturer_id")
    private CarManufacturer carManufacturer;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "car_insurance")
    private List<Insurance> insuranceList=new ArrayList<>();

    @ManyToMany(mappedBy = "carList",cascade = CascadeType.PERSIST)
    private List<Owner> ownerList=new ArrayList<>();

    @ManyToMany(mappedBy = "carList",cascade = CascadeType.PERSIST)
    private List<Driver> driverList=new ArrayList<>();

    public Car() {
    }

    public Car(String model, String make, int year, int millage) {
        this.model = model;
        this.make = make;
        this.year = year;
        this.millage = millage;
    }

    public void addInsurance(Insurance insurance){
        insuranceList.add(insurance);
        insurance.getCarList().add(this);
    }

    public void addOwner(Owner owner){
        owner.getCarList().add(this);
        ownerList.add(owner);
    }

    public void addDriver(Driver driver){
        driver.getCarList().add(this);
        driverList.add(driver);
    }

}
