//Kõik eespool toodud sisu on tehtud õppeprogrammi ja isiklike huvide eesmärkides ning ei sisalda tõsiselt võetavad sisu
import java.util.Scanner;

public class Nadal2{

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String pause;

        Car car1 = new Car();
        Car car2 = new Car("Jaan Karu", "Valge", AutomobileMark.VOLVO, true);
        Car car3 = new Car("Kert Siil", "Sinine", AutomobileMark.BMW, true);
        Car car4 = new Car("Kätlin Lumi", "Roheline", AutomobileMark.PORSCHE, false);
        Car car5 = new Car("Anton Ivanov", "Hall", AutomobileMark.BMW, false);
        CarsInPark cars = new CarsInPark();

        cars.addCar(car1);
        cars.addCar(car2);
        cars.addCar(car3);
        cars.addCar(car4);
        cars.addCar(car5);

        for(int i = 0; i < cars.size(); i++){
            cars.getInfo(i);
            System.out.println();
        }

        //Näidis olukord
        pause = in.nextLine();
        car1.parkCar(ParkingPlace.ONE, cars);
        pause = in.nextLine();
        car2.parkCar(ParkingPlace.ONE, cars);
        pause = in.nextLine();
        car3.parkCar(ParkingPlace.ONE, cars);
        pause = in.nextLine();
        car1.leave();
        pause = in.nextLine();
        car2.parkCar(ParkingPlace.ONE, cars);
        pause = in.nextLine();
        car4.leave();
        pause = in.nextLine();
        car2.parkCar(ParkingPlace.TWO, cars);
        pause = in.nextLine();
        car4.parkCar(ParkingPlace.INVALID, cars);
        pause = in.nextLine();
        car4.leave();
        pause = in.nextLine();
        car4.getInfo();
        pause = in.nextLine();
        car4.payFine();
        pause = in.nextLine();
        car4.leave();
        pause = in.nextLine();
        car1.parkCar(ParkingPlace.INVALID, cars);
        pause = in.nextLine();
        car3.parkCar(ParkingPlace.THREE, cars);
        pause = in.nextLine();
        car3.leave();
        pause = in.nextLine();
        car3.parkCar(ParkingPlace.ONE, cars);
        pause = in.nextLine();
        car3.parkCar(ParkingPlace.THREE, cars);
        pause = in.nextLine();
        car5.parkCar(ParkingPlace.THREE, cars);
        pause = in.nextLine();
        car3.leave();
        pause = in.nextLine();
        car5.parkCar(ParkingPlace.FOUR, cars);
        pause = in.nextLine();
        car3.payFine();

        System.out.println(pause);
        in.close();;
    }
}