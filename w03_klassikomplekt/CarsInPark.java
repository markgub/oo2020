import java.util.ArrayList;
import java.util.List;

class CarsInPark {

    private List<Car> cars = new ArrayList<>();

    public void addCar(Car car){
        cars.add(car);
    }

    public void removeCar(Car car){
        for(Car otherCar : cars){
            if(car == otherCar){
                cars.remove(otherCar);
                break;
            }
        }
    }

    public void getInfo(int index){
        cars.get(index).getInfo();
    }

    public int size(){
        return cars.size();
    }

    public Car get(int index){
        return cars.get(index);
    }
}