package com.example.demo.services;

import com.example.demo.dto.CarInfoDto;
import com.example.demo.dto.RevendedorDto;
import com.example.demo.models.Car;
import com.example.demo.models.Revendedor;
import com.example.demo.repositories.CarRepository;
import com.example.demo.repositories.RevendedorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RevendedorService {

    private final RevendedorRepository revendedorRepository;
    private final CarRepository carRepository;

    public RevendedorService(RevendedorRepository revendedorRepository, CarRepository carRepository) {
        this.revendedorRepository = revendedorRepository;
        this.carRepository = carRepository;
    }

    private RevendedorDto convertToDto(Revendedor revendedor) {
        List<CarInfoDto> carrosDto = new ArrayList<>();
        if (revendedor.getCarros() != null) {
            carrosDto = revendedor.getCarros().stream()
                    .map(this::convertCarToCarInfoDto)
                    .collect(Collectors.toList());
        }

        return new RevendedorDto(
                revendedor.getId(),
                revendedor.getNome(),
                revendedor.getEmail(),
                revendedor.getTelefone(),
                carrosDto
        );
    }
    private CarInfoDto convertCarToCarInfoDto(Car car) {
        return new CarInfoDto(
                car.getId(),
                car.getMarca(),
                car.getModelo(),
                car.getAno()
        );
    }

    private Revendedor convertToEntity(RevendedorDto dto) {
        Revendedor revendedor = new Revendedor();
        revendedor.setNome(dto.getNome());
        revendedor.setEmail(dto.getEmail());
        revendedor.setTelefone(dto.getTelefone());
        return revendedor;
    }


    public List<RevendedorDto> getAll() {
        List<Revendedor> revendedores = revendedorRepository.findAll();
        return revendedores.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public RevendedorDto getById(int id) {
        Revendedor revendedor = revendedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Revendedor não encontrado com id: " + id));
        return convertToDto(revendedor);
    }

    public RevendedorDto create(RevendedorDto dto) {
        Revendedor revendedor = convertToEntity(dto);
        Revendedor saved = revendedorRepository.save(revendedor);
        return new RevendedorDto(saved.getId(), saved.getNome(), saved.getEmail(), saved.getTelefone(), new ArrayList<>());
    }

    public RevendedorDto update(int id, RevendedorDto dto) {
        Revendedor existente = revendedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Revendedor não encontrado com id: " + id));

        existente.setNome(dto.getNome());
        existente.setEmail(dto.getEmail());
        existente.setTelefone(dto.getTelefone());

        Revendedor updated = revendedorRepository.save(existente);
        return convertToDto(updated);
    }

    public void delete(int id) {
        revendedorRepository.deleteById(id);
    }
}