package com.messagerie.M2e.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "messages")
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	private User user;
	@ManyToOne
	private Channel channel;
	@Column(name = "content",columnDefinition = "TEXT")
	private String content;
	@Column(name = "post_date")
	private Date postDate;
	@Column(name = "edit_date")
	private Date editDate;
	@Column(name = "is_edited")
	private Boolean edited;

	public Message(User user, String content, Date postDate, Date editDate, Boolean edited) {
		this.user = user;
		this.content = content;
		this.postDate = postDate;
		this.editDate = editDate;
		this.edited = edited;
	}

	public Message() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public Date getEditDate() {
		return editDate;
	}

	public void setEditDate(Date editDate) {
		this.editDate = editDate;
	}

	public Boolean isEdited() {
		return edited;
	}

	public void setEdited(Boolean edited) {
		this.edited = edited;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	
	
	@Override
	public String toString() {
		return "Message [id=" + id + ", user=" + user + ", channel=" + channel + ", content=" + content + ", postDate=" + postDate
				+ ", editDate=" + editDate + ", edited=" + edited + "]";
	}

	public void patch(Message dataToUpdate) {
		if (dataToUpdate.getContent() != null) {
			this.content = dataToUpdate.getContent();
		}
		if (dataToUpdate.getEditDate() != null) {
			this.editDate = dataToUpdate.getEditDate();
		}
		if (dataToUpdate.isEdited() != null) {
			this.edited = dataToUpdate.isEdited();
		}
	}
}
