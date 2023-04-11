package com.trpg.playeridentityservice.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "attribute_value")
public class AttributeValue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "attribute_num")
    private int attribute_num;
    @Column(name = "identity_uuid")
    private UUID identity_uuid;
    @Column(name = "attribute_value")
    private int attribute_value;

    private AttributeValue(Builder builder) {
        id = builder.id;
        setAttribute_num(builder.attribute_num);
        setIdentity_uuid(builder.identity_uuid);
        setAttribute_value(builder.attribute_value);
    }

    public AttributeValue() {

    }

    public AttributeValue(Integer attribute_num, Integer attribute_value, UUID identity_uuid) {
        setAttribute_num(attribute_num);
        setIdentity_uuid(identity_uuid);
        setAttribute_value(attribute_value);
    }


    public int getAttribute_num() {
        return attribute_num;
    }

    public void setAttribute_num(int attribute_num) {
        this.attribute_num = attribute_num;
    }

    public UUID getIdentity_uuid() {
        return identity_uuid;
    }

    public void setIdentity_uuid(UUID identity_uuid) {
        this.identity_uuid = identity_uuid;
    }

    public int getAttribute_value() {
        return attribute_value;
    }

    public void setAttribute_value(int attribute_value) {
        this.attribute_value = attribute_value;
    }

    public static final class Builder {
        private UUID world_attribute_uuid;
        private UUID identity_uuid;
        private int attribute_value;
        private long id;
        private int attribute_num;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder withWorld_attribute_uuid(UUID val) {
            world_attribute_uuid = val;
            return this;
        }

        public Builder withIdentity_uuid(UUID val) {
            identity_uuid = val;
            return this;
        }

        public Builder withAttribute_value(int val) {
            attribute_value = val;
            return this;
        }

        public AttributeValue build() {
            return new AttributeValue(this);
        }

        public Builder withId(long val) {
            id = val;
            return this;
        }

        public Builder withAttribute_num(int val) {
            attribute_num = val;
            return this;
        }

    }
}
