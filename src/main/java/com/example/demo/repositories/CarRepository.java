package com.example.demo.repositories;

import com.example.demo.models.Car;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CarRepository {
    private List<Car> listaDeCar = new ArrayList<>();

    public CarRepository(){
        listaDeCar.add(new Car(1,"fiat","estrada", 2020));
        listaDeCar.add(new Car(2,"chevorlet","s10", 2025));
    }

    public List<Car> getAllCars(){
        return listaDeCar;
    }

    public Car getCarById(int id) {
        return listaDeCar
                .stream()
                .filter(item -> item.getId() == id)
                .findFirst()
                .orElseThrow();
    }

    public Car createCar(Car car){
        listaDeCar.add(car);
        return car;
    }

    public void deleteCar(int id){
        Car car = listaDeCar
                .stream()
                .filter(item -> item.getId()== id)
                .findFirst()
                .orElseThrow();
        listaDeCar.remove(car);
    }

    public Car updateCar(Car carRequest, int id) {
        Car car = listaDeCar
                .stream()
                .filter(item -> item.getId() == id)
                .findFirst()
                .orElseThrow();

        car.setAno(carRequest.getAno());
        car.setMarca(carRequest.getMarca());
        car.setModelo(carRequest.getModelo());

        return car;
    }


}