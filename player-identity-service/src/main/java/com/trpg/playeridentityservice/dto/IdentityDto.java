package com.trpg.playeridentityservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.immutables.value.Value;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Value.Immutable
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class IdentityDto {
    abstract public UUID getIdentity_uuid();
    abstract public UUID getWorld_uuid();
    abstract public UUID getUser_uuid();
    abstract public UUID getGame_uuid();
    abstract public String getImg_url();
    abstract public Map<Integer,Integer> getAttribute_value();


}
