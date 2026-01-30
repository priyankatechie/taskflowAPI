package com.taskflow.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	private String title;
	
	private String description;
	
	  @Enumerated(EnumType.STRING)
	    private Priority priority=Priority.high;

	    @Enumerated(EnumType.STRING)
	    private Status status = Status.PENDING;
	    
	    private LocalDate dueDate;
	    
	    @CreationTimestamp
	    private LocalDateTime created;
	    
	    @UpdateTimestamp
	    private LocalDateTime updatedAt;

	    
	    //getter & Setter
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
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

		public Priority getPriority() {
			return priority;
		}

		public void setPriority(Priority priority) {
			this.priority = priority;
		}

		public Status getStatus() {
			return status;
		}

		public void setStatus(Status status) {
			this.status = status;
		}

		public LocalDate getDueDate() {
			return dueDate;
		}

		public void setDueDate(LocalDate dueDate) {
			this.dueDate = dueDate;
		}

		public LocalDateTime getCreated() {
			return created;
		}

		public void setCreated(LocalDateTime created) {
			this.created = created;
		}

		public LocalDateTime getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(LocalDateTime updatedAt) {
			this.updatedAt = updatedAt;
		}

		public Task(Long id, User user, String title, String description, Priority priority, Status status,
				LocalDate dueDate, LocalDateTime created, LocalDateTime updatedAt) {
			super();
			this.id = id;
			this.user = user;
			this.title = title;
			this.description = description;
			this.priority = priority;
			this.status = status;
			this.dueDate = dueDate;
			this.created = created;
			this.updatedAt = updatedAt;
		}

		public Task() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "Task [id=" + id + ", user=" + user + ", title=" + title + ", description=" + description
					+ ", priority=" + priority + ", status=" + status + ", dueDate=" + dueDate + ", created=" + created
					+ ", updatedAt=" + updatedAt + "]";
		}

	 
	    
		
	    
}
