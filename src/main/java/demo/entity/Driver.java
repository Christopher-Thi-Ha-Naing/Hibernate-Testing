package demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class Driver extends Person{
    private String driverRegistration;

    @ManyToMany
    @JoinTable(name = "car_driver",
            joinColumns = @JoinColumn(name = "driver_id"),
            inverseJoinColumns = @JoinColumn(name = "car_id"))
    private List<Car> carList=new ArrayList<>();

    public Driver(String name, LocalDate dob, String driverRegistration) {
        super(name, dob);
        this.driverRegistration = driverRegistration;
    }

    public Driver() {
    }
}
