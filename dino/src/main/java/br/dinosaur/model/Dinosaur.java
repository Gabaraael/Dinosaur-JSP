package br.dinosaur.model;

public class Dinosaur {
	
	private Long id;
	private String specie;	
	private String diet; 	
	private String habitat;	
	private String period;		
	private String description;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSpecie() {
		return specie;
	}
	public void setSpecie(String specie) {
		this.specie = specie;
	}
	public String getDiet() {
		return diet;
	}
	public void setDiet(String diet) {
		this.diet = diet;
	}
	public String getHabitat() {
		return habitat;
	}
	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}			

	public Dinosaur(String specie, String diet, String habitat, String period, String description) {
		 this.specie = specie;
		 this.diet = diet;
		 this.habitat = habitat;
		 this.period = period;
		 this.description = description;		 
	}	
	
	@Override
	public String toString() {
		return "Dinosaur [id=" + id + ", specie=" + specie + ", diet=" + diet + ", habitat=" + habitat + ", period="
				+ period + ", description=" + description + "]";
	}

}
