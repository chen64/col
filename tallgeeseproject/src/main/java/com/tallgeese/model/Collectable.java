package com.tallgeese.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Collectable")
public class Collectable {

	@Id
	@Column(name="collect_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int collectableID;
	
	@Column(name="name", unique=true, nullable=false)
	private String name;
	
	//nullable=false???
	@Column(name="image")
	private String imageURL;
	
	@Column(name="power")
	private int power;
	
	@Column(name="rarity")
	private int rarity;
	
	public Collectable() {
		
	}

	public Collectable(int collectableID, String name, String imageURL, int power, int rarity) {
		super();
		this.collectableID = collectableID;
		this.name = name;
		this.imageURL = imageURL;
		this.power = power;
		this.rarity = rarity;
	}

	public Collectable(String name, String imageURL, int power, int rarity) {
		super();
		this.name = name;
		this.imageURL = imageURL;
		this.power = power;
		this.rarity = rarity;
	}

	public int getCollectableID() {
		return collectableID;
	}

	public void setCollectableID(int collectableID) {
		this.collectableID = collectableID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getRarity() {
		return rarity;
	}

	public void setRarity(int rarity) {
		this.rarity = rarity;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Collectable other = (Collectable) obj;
		if (collectableID != other.collectableID)
			return false;
		if (imageURL == null) {
			if (other.imageURL != null)
				return false;
		} else if (!imageURL.equals(other.imageURL))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (power != other.power)
			return false;
		if (rarity != other.rarity)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Collectable [collectableID=" + collectableID + ", name=" + name + ", imageURL=" + imageURL + ", power="
				+ power + ", rarity=" + rarity + "]";
	}

}
