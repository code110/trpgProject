package com.trpg.playeridentityservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "world_attribute")
public class WorldAttribute {
    @Id
    private long id;
    @Column(
            name = "attribute_num"
    )
    private int attribute_num;
    @Column(
            name = "world_uuid",
            nullable = false
    )
    private UUID world_uuid;
    @Column(
            name = "attribute_name",
            nullable = false
    )
    private String attribute_name;

    public WorldAttribute() {}

    private WorldAttribute(Builder builder) {
        setId(builder.id);
        setAttribute_num(builder.attribute_num);
        setWorld_uuid(builder.world_uuid);
        setAttribute_name(builder.attribute_name);
    }

    public WorldAttribute(Integer attribute_num, String attribute_name, UUID world_uuid) {
        setAttribute_num(attribute_num);
        setAttribute_name(attribute_name);
        setWorld_uuid(world_uuid);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAttribute_num() {
        return attribute_num;
    }

    public void setAttribute_num(int attribute_num) {
        this.attribute_num = attribute_num;
    }

    public UUID getWorld_uuid() {
        return world_uuid;
    }

    public void setWorld_uuid(UUID world_uuid) {
        this.world_uuid = world_uuid;
    }

    public String getAttribute_name() {
        return attribute_name;
    }

    public void setAttribute_name(String attribute_name) {
        this.attribute_name = attribute_name;
    }

    public static final class Builder {
        private long id;
        private int attribute_num;
        private UUID world_uuid;
        private String attribute_name;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder withId(long val) {
            id = val;
            return this;
        }

        public Builder withAttribute_num(int val) {
            attribute_num = val;
            return this;
        }

        public Builder withWorld_uuid(UUID val) {
            world_uuid = val;
            return this;
        }

        public Builder withAttribute_name(String val) {
            attribute_name = val;
            return this;
        }

        public WorldAttribute build() {
            return new WorldAttribute(this);
        }
    }
}
