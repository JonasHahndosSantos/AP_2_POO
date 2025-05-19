package com.example.demo.services;

import com.example.demo.models.Car;
import com.example.demo.repositories.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllUsers() {
        return this.carRepository.getAllCars();
    }

    public Car getUserById(int id) {
        return this.carRepository.getCarById(id);
    }


    public Car createCar(Car car) {
        return this.carRepository.createCar(car);
    }


    public void deleteCar(int id) {
        this.carRepository.deleteCar(id);
    }


    public Car updateCar(Car userRequest, int id) {
        return this.carRepository.updateCar(userRequest, id);
    }
}


