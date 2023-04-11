package com.trpg.playeridentityservice.repository;

import com.trpg.playeridentityservice.model.World;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WorldRepository extends JpaRepository<World, UUID> {
}
