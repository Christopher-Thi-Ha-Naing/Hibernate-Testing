package demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "insurance_company")
public class Insurance extends Company{
    private int rating;

    @OneToMany(mappedBy = "insuranceList")
    private List<Car> carList=new ArrayList<>();

    public Insurance(String name, String address, int rating) {
        super(name, address);
        this.rating = rating;
    }

    public Insurance() {
    }

    public void addCar(Car car){
        car.setInsuranceList(this);
        carList.add(car);
    }
}
