package com.example.wheather_api.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.wheather_api.model.WheatherRequestResponse;

public interface WheatherRepository extends JpaRepository <WheatherRequestResponse, Long> {

}


