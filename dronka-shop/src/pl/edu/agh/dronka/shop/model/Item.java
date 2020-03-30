package pl.edu.agh.dronka.shop.model;

import java.time.LocalDate;

public class Item {

	private String name;

	private Category category;

	private int price;

	private int quantity;

	private boolean secondhand;

	private boolean polish;

	private int numberOfPages;

	private boolean hardcover;

	private boolean mobile;

	private boolean warranty;

	private LocalDate expirationDate;

	private Genre genre;

	private boolean includedVideo;

	public Item(String name, Category category, int price, int quantity) {
		this.name = name;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
	}

	public Item() {
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Category getCategory() {
		return category;
	}

	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setSecondhand(boolean secondhand) {
		this.secondhand = secondhand;
	}

	public boolean isSecondhand() {
		return secondhand;
	}

	public void setPolish(boolean polish) {
		this.polish = polish;
	}

	public boolean isPolish() {
		return polish;
	}

	// books

	public void setNumberOfPages(int number){ this.numberOfPages = number; }

	public int getNumberOfPages(){ return this.numberOfPages; }

	public void setHardcover(boolean hardcover) { this.hardcover = hardcover; }

	public boolean hasHardcover() { return this.hardcover; }

	//electronics

	public void setMobile(boolean mobile) { this.mobile = mobile; }

	public boolean isMobile() { return this.mobile; }

	public void setWarranty(boolean warranty) { this.warranty = warranty; }

	public boolean hasWarranty() { return this.warranty; }

	//food

	public void setExpirationDate(LocalDate date) { this.expirationDate = date; }

	public LocalDate getExpirationDate() { return this.expirationDate; }

	//music

	public void setGenre(Genre genre) { this.genre = genre; }

	public Genre getGenre() { return this.genre; }

	public void setIncludedVideo(boolean included) { this.includedVideo = included; }

	public boolean isVideoIncluded() { return this.includedVideo; }

	@Override
	public String toString() {
		return getName();
	}

}
