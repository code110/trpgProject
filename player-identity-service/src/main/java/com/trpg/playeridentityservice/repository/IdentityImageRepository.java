package com.trpg.playeridentityservice.repository;

import com.trpg.playeridentityservice.model.IdentityImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IdentityImageRepository extends JpaRepository<IdentityImage, UUID> {
}
