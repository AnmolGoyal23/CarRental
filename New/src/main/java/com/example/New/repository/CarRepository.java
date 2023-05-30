package com.example.New.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.New.dao.CarModelEntity;

import jakarta.transaction.Transactional;

@Repository
public interface CarRepository extends JpaRepository<CarModelEntity, String> {

	public Optional<List<CarModelEntity>> findByCarType(String carType);

}
