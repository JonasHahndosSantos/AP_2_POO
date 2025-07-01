package com.example.demo.services;

import com.example.demo.dto.CarDto;
import com.example.demo.models.Car;
import com.example.demo.models.Revendedor;
import com.example.demo.repositories.CarRepository;
import com.example.demo.repositories.RevendedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final RevendedorRepository revendedorRepository;

    public CarService(CarRepository carRepository, RevendedorRepository revendedorRepository) {
        this.carRepository = carRepository;
        this.revendedorRepository = revendedorRepository;
    }

    public List<CarDto> getAllCars() {
        return carRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public CarDto getCarById(int id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carro não encontrado com id: " + id));
        return convertToDto(car);
    }

    public CarDto createCar(CarDto dto) {
        Revendedor revendedor = revendedorRepository.findById(dto.getRevendedorId())
                .orElseThrow(() -> new RuntimeException("Revendedor não encontrado com id: " + dto.getRevendedorId()));

        Car car = new Car();
        car.setMarca(dto.getMarca());
        car.setModelo(dto.getModelo());
        car.setAno(dto.getAno());
        car.setRevendedor(revendedor);

        return convertToDto(carRepository.save(car));
    }

    public CarDto updateCar(int id, CarDto dto) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carro não encontrado com id: " + id));

        Revendedor revendedor = revendedorRepository.findById(dto.getRevendedorId())
                .orElseThrow(() -> new RuntimeException("Revendedor não encontrado com id: " + dto.getRevendedorId()));

        car.setMarca(dto.getMarca());
        car.setModelo(dto.getModelo());
        car.setAno(dto.getAno());
        car.setRevendedor(revendedor);

        return convertToDto(carRepository.save(car));
    }

    public void deleteCar(int id) {
        carRepository.deleteById(id);
    }

    private CarDto convertToDto(Car car) {
        int revendedorId = 0;
        String nome = null;
        String telefone = null;

        if (car.getRevendedor() != null) {
            revendedorId = car.getRevendedor().getId();
            nome = car.getRevendedor().getNome();
            telefone = car.getRevendedor().getTelefone();
        }

        return new CarDto(
                car.getId(),
                car.getMarca(),
                car.getModelo(),
                car.getAno(),
                revendedorId,
                nome,
                telefone
        );
    }
}
