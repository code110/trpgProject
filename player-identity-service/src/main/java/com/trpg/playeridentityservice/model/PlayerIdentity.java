package com.trpg.playeridentityservice.model;

import jakarta.persistence.*;

import java.util.UUID;
@Entity
@Table(name = "identity_record")
public class PlayerIdentity {
    @Id
    @Column(name = "identity_uuid")
    private UUID identity_uuid;
    @Column(name = "game_uuid",
            nullable = true)
    private UUID game_uuid;
    @Column(name = "user_uuid",
            nullable = false)
    private UUID user_uuid;
    @Column(
            name = "world_uuid",
            nullable = false
    )
    private UUID world_uuid;

    private PlayerIdentity(Builder builder) {
        setIdentity_uuid(builder.identity_uuid);
        setGame_uuid(builder.game_uuid);
        setUser_uuid(builder.user_uuid);
        setWorld_uuid(builder.world_uuid);
    }

    public UUID getIdentity_uuid() {
        return identity_uuid;
    }

    public void setIdentity_uuid(UUID identity_uuid) {
        this.identity_uuid = identity_uuid;
    }

    public UUID getGame_uuid() {
        return game_uuid;
    }

    public void setGame_uuid(UUID game_uuid) {
        this.game_uuid = game_uuid;
    }

    public UUID getUser_uuid() {
        return user_uuid;
    }

    public void setUser_uuid(UUID user_uuid) {
        this.user_uuid = user_uuid;
    }

    public UUID getWorld_uuid() {
        return world_uuid;
    }

    public void setWorld_uuid(UUID world_uuid) {
        this.world_uuid = world_uuid;
    }

    protected PlayerIdentity(){}


    public static final class Builder {
        private UUID identity_uuid;
        private UUID game_uuid;
        private UUID user_uuid;
        private UUID world_uuid;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder withIdentity_uuid(UUID val) {
            identity_uuid = val;
            return this;
        }

        public Builder withGame_uuid(UUID val) {
            game_uuid = val;
            return this;
        }

        public Builder withUser_uuid(UUID val) {
            user_uuid = val;
            return this;
        }

        public Builder withWorld_uuid(UUID val) {
            world_uuid = val;
            return this;
        }

        public PlayerIdentity build() {
            return new PlayerIdentity(this);
        }
    }
}
