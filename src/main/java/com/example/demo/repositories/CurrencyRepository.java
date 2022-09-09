package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Currency;

public interface CurrencyRepository extends JpaRepository<Currency, Integer> {

}
