package com.example.New.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.New.Exception.VehicleNotFoundException;
import com.example.New.dao.*;
import com.example.New.model.CarModel;
import com.example.New.repository.CarRepository;

@Service
public class CarServiceImplementation implements CarService {

	@Autowired
	private CarRepository Repository;

	@Override
	public String addCars(CarModel car) {

		final CarModelEntity entity = new CarModelEntity();
		entity.setCarNumber(car.getCarNumber());
		entity.setCarName(car.getCarName());
		entity.setCarRent(car.getCarRent());
		entity.setCarType(car.getCarType());
		Repository.saveAndFlush(entity);
		String message = entity.getCarName() + " is added to the database";
		return message;

	}

	@Override
	public List<CarModelEntity> getall() {
		return Repository.findAll();
	}

	@Override
	public List<CarModelEntity> getCar(final String carType) throws VehicleNotFoundException {
		final Optional<List<CarModelEntity>> entity = Repository.findByCarType(carType);
		if (entity.isPresent())
			return entity.get();
		else
			throw new VehicleNotFoundException("Vehile requested Not Available");

	}

	@Override
	public CarModelEntity getCarById(String carNumber) throws VehicleNotFoundException {
		final Optional<CarModelEntity> entity = Repository.findById(carNumber);
		if (entity.isPresent())
			return entity.get();

		else
			throw new VehicleNotFoundException("Vehile requested Not Available");

	}

}
