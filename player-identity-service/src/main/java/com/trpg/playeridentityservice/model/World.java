package com.trpg.playeridentityservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "world")
public class World {
    @Id
    @Column(
            name = "world_uuid"
    )
    private UUID world_uuid;
    @Column(
            name = "world_name"
    )
    private String world_name;
    @Column(
            name = "intro"
    )
    private String intro;

    private World(Builder builder) {
        setWorld_uuid(builder.world_uuid);
        setWorld_name(builder.world_name);
        setIntro(builder.intro);
    }

    public World() {

    }

    public UUID getWorld_uuid() {
        return world_uuid;
    }

    public void setWorld_uuid(UUID world_uuid) {
        this.world_uuid = world_uuid;
    }

    public String getWorld_name() {
        return world_name;
    }

    public void setWorld_name(String world_name) {
        this.world_name = world_name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public static final class Builder {
        private UUID world_uuid;
        private String world_name;
        private String intro;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder withWorld_uuid(UUID val) {
            world_uuid = val;
            return this;
        }

        public Builder withWorld_name(String val) {
            world_name = val;
            return this;
        }

        public Builder withIntro(String val) {
            intro = val;
            return this;
        }

        public World build() {
            return new World(this);
        }
    }
}
