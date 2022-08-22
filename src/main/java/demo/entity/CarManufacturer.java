package demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter@Setter
@Table(name = "car_manufacturer")
public class CarManufacturer extends Company {
    private int numberOfEmployee;
    private int yearEstablished;

    @OneToMany(mappedBy = "carManufacturer")
    private List<Car> carList=new ArrayList<>();

    public CarManufacturer(String name, String address, int numberOfEmployee, int yearEstablished) {
        super(name, address);
        this.numberOfEmployee = numberOfEmployee;
        this.yearEstablished = yearEstablished;
    }

    public CarManufacturer() {
    }

    public void addCar(Car car){
        car.setCarManufacturer(this);
        carList.add(car);
    }
}
