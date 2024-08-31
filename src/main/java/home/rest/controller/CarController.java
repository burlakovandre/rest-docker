package home.rest.controller;

import home.rest.model.Car;
import home.rest.repository.CarRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/rst/cars", produces = "application/json")
@CrossOrigin(origins = "http://localhost:8080")
public class CarController {
    private CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Car createCar(@RequestBody Car car) {
        return carRepository.save(car);
    }
    @GetMapping
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        Optional<Car> optionalCar = carRepository.findById(id);
        if (optionalCar.isPresent()) {
            return new ResponseEntity<>(optionalCar.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping(consumes = "application/json")
    public ResponseEntity<Car> updateCar(@RequestBody Car car) {
        Car сar = carRepository.save(car);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }
    @PatchMapping(consumes = "application/json", path = "/{carId}")
    public ResponseEntity<Car> patchCar(@PathVariable Long carId, @RequestBody Car patch){
        Optional<Car> optionalCar = carRepository.findById(carId);
        if (optionalCar.isPresent()) {
            Car carToUpdate = optionalCar.get();
            if (patch.getBrand() != null){
                carToUpdate.setBrand(patch.getBrand());
            }
            if (patch.getModel() != null){
                carToUpdate.setModel(patch.getModel());
            }
            if (patch.getEngine() != null){
                carToUpdate.setEngine(patch.getEngine());
            }
            Car c = carRepository.save(carToUpdate);
            return new ResponseEntity<>(c, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCar(@PathVariable("id") Long id){
        try {
            carRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){}
    }
}
