package demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "owner")
public class Owner extends Person{
    private String ownerRegistration;

    @ManyToMany
    @JoinTable(name = "car_owner",
    joinColumns = @JoinColumn(name = "owner_id"),
    inverseJoinColumns = @JoinColumn(name = "car_id"))
    private List<Car> carList=new ArrayList<>();

    public Owner(String name, LocalDate dob, String ownerRegistration) {
        super(name, dob);
        this.ownerRegistration = ownerRegistration;
    }

    public Owner() {
    }
}
