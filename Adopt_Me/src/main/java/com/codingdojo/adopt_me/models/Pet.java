package com.codingdojo.adopt_me.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="pets")
public class Pet {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message="Pet name is required!")
    @Size(min=1, max=15, message="Pet name must be between 1 and 15 characters")
    private String petName;
    
    
    @NotBlank(message="Pet type is required!")
    @Size(min=3, max=20, message="Pet type must be between 3 and 20 characters")
    private String petType;
    
    @Min(value = 0, message="Pet age must be between 0 - 200 years old")
    @Max(value = 200, message="Pet age must be between 0 - 200 years old")
    private int petAge;
    
    @Size(max=120, message="List of pet likes must not exceed 120 Character count")
    private String petLikes;
    
    @Size(max=120, message="List of pet dislikes must not exceed 120 Character count")
    private String petDislikes;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    @PrePersist
    protected void onCreate() {
    	this.createdAt = new Date();
    }
    
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
      
    public Pet() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getPetType() {
		return petType;
	}

	public void setPetType(String petType) {
		this.petType = petType;
	}

	public int getPetAge() {
		return petAge;
	}

	public void setPetAge(int petAge) {
		this.petAge = petAge;
	}

	public String getPetLikes() {
		return petLikes;
	}

	public void setPetLikes(String petLikes) {
		this.petLikes = petLikes;
	}

	public String getPetDislikes() {
		return petDislikes;
	}

	public void setPetDislikes(String petDislikes) {
		this.petDislikes = petDislikes;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

    
}