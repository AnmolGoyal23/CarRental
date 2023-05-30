package com.example.New.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.New.Exception.VehicleNotFoundException;
import com.example.New.dao.CarModelEntity;
import com.example.New.model.CarModel;
import com.example.New.service.CarService;

@RestController
public class CarController {

	@Autowired
	private CarService carService;

	@PostMapping("/addCars")
	public ResponseEntity<String> addCars(@RequestBody final CarModel car) {
		return ResponseEntity.ok(carService.addCars(car));

	}

	@GetMapping("/getallexisting")
	public ResponseEntity<List<CarModelEntity>> getAll() {
		return ResponseEntity.ok(carService.getall());

	}

	@GetMapping("/getCar/{carType}")
	public ResponseEntity<List<CarModelEntity>> getCar(@PathVariable("carType") final String carType)
			throws VehicleNotFoundException {
		return ResponseEntity.ok(carService.getCar(carType));
	}

	@GetMapping("/getCarId/{carNum}")
	public ResponseEntity<CarModelEntity> getCarbyId(@PathVariable("carNum") final String carNum)
			throws VehicleNotFoundException {
		return ResponseEntity.ok(carService.getCarById(carNum));
	}

}
