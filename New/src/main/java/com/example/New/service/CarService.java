package com.example.New.service;

import com.example.New.model.CarModel;

import java.util.List;

import com.example.New.Exception.VehicleNotFoundException;
import com.example.New.dao.*;

public interface CarService {

	public String addCars(CarModel car);

	public List<CarModelEntity> getall();

	public List<CarModelEntity> getCar(final String carType) throws VehicleNotFoundException;

	public CarModelEntity getCarById(final String carNumber) throws VehicleNotFoundException;
}
