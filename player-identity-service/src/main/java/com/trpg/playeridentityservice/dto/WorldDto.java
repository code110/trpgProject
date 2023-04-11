package com.trpg.playeridentityservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.immutables.value.Value;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Value.Immutable
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class WorldDto {
    abstract public UUID getWorld_uuid();
    abstract public String getWorld_name();
    abstract public String getIntro();
    abstract public  Map<Integer,String> getAttribute_name();
}
