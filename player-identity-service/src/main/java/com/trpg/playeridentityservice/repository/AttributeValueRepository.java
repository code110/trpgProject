package com.trpg.playeridentityservice.repository;

import com.trpg.playeridentityservice.model.AttributeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AttributeValueRepository extends JpaRepository<AttributeValue, Long> {
}
