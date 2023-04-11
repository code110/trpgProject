package com.trpg.playeridentityservice.repository;

import com.trpg.playeridentityservice.model.WorldAttribute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WorldAttributeRepository extends JpaRepository<WorldAttribute, UUID> {
}
