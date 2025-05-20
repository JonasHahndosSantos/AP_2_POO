package com.example.demo.services;

import com.example.demo.models.Car;
import com.example.demo.repositories.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car getCarById(int id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carro não encontrado com id: " + id));
    }

    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    public void deleteCar(int id) {
        carRepository.deleteById(id);
    }

    public Car updateCar(Car carRequest, int id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carro não encontrado com id: " + id));

        car.setMarca(carRequest.getMarca());
        car.setModelo(carRequest.getModelo());
        car.setAno(carRequest.getAno());

        return carRepository.save(car);
    }
}
