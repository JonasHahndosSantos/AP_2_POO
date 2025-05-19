package com.example.demo.controllers;

import com.example.demo.models.Car;
import com.example.demo.services.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {


    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<List<Car>> getAllUsers() {
        return ResponseEntity.ok(carService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getUserById(@PathVariable int id) {
        return ResponseEntity.ok(this.carService.getUserById(id));
    }


    @PostMapping
    public ResponseEntity<Car> createUser(@RequestBody Car car) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(car.getId()).toUri();
        return ResponseEntity.created(uri).body(this.carService.createCar(car));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
        this.carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateUser(@RequestBody Car carRequest, @PathVariable int id) {
        return ResponseEntity.ok(this.carService.updateCar(carRequest, id));
    }


}
