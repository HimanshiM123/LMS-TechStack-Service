package com.bridgelabz.techstackservice.repository;

import com.bridgelabz.techstackservice.model.TechStackModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITechStackRepository  extends JpaRepository<TechStackModel, Long> {
}
