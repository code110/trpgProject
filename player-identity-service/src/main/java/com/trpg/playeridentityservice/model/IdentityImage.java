package com.trpg.playeridentityservice.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "identity_img")
public class IdentityImage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "identity_uuid",nullable = false)
    private UUID identity_uuid;
    @Column(name = "img_url")
    private String img_url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getIdentity_uuid() {
        return identity_uuid;
    }

    public void setIdentity_uuid(UUID identity_uuid) {
        this.identity_uuid = identity_uuid;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    protected IdentityImage(){}

    public IdentityImage fromDto(IdentityImage copy){
        return IdentityImage.Builder.newBuilder()
                .withIdentityUUID(copy.getIdentity_uuid())
                .withImgUrl(copy.getImg_url())
                .build();
    }

    public static class Builder {
        private UUID identity_uuid;
        private String img_url;

        private Builder(){}
        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder withIdentityUUID(UUID identity_uuid) {
            this.identity_uuid = identity_uuid;
            return this;
        }

        public Builder withImgUrl(String img_url) {
            this.img_url = img_url;
            return this;
        }

        public IdentityImage build() {
            IdentityImage identityImage = new IdentityImage();
            identityImage.setIdentity_uuid(this.identity_uuid);
            identityImage.setImg_url(this.img_url);
            return identityImage;
        }
    }

}
