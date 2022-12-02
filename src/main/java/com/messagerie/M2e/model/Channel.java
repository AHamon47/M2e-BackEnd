package com.messagerie.M2e.model;

import javax.persistence.*;

@Entity
@Table(name = "channels")
public class Channel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	private User creator;
	@Column(name = "title")
	private String title;
	@Column(name = "description")
	private String description;
	@Column(name = "hasNews")
	private Boolean news;

	public Channel(String title, String description, Boolean news) {
		this.title = title;
		this.description = description;
		this.news = news;
	}

	public Channel() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public Boolean hasNews() {
		return news;
	}

	public void setNews(Boolean news) {
		this.news = news;
	}

	@Override
	public String toString() {
		return "Channel [id=" + id + ", creator=" + creator + ", title=" + title + ", description=" + description + ", news=" + news + "]";
	}

	public void patch(Channel dataToUpdate) {
		if (dataToUpdate.getTitle() != null) {
			this.title = dataToUpdate.getTitle();
		}
		if (dataToUpdate.getDescription() != null) {
			this.description = dataToUpdate.getDescription();
		}
		if (dataToUpdate.hasNews() != null) {
			this.news = dataToUpdate.hasNews();
		}
	}
}
