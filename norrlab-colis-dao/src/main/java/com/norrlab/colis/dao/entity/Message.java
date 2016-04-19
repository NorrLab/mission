package com.norrlab.colis.dao.entity;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Message implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateMessage;
	
	private String message;
	
	@ManyToOne
	@JoinColumn(name="CLI_ID",nullable=true)
	private Client clientMessage;
	
	@ManyToOne
	@JoinColumn(name="ANN_ID",nullable= true)
	private Annonce annonceMessage;
	
	public Message() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateMessage() {
		return dateMessage;
	}

	public void setDateMessage(Date dateMessage) {
		this.dateMessage = dateMessage;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Client getClientMessage() {
		return clientMessage;
	}

	public void setClientMessage(Client clientMessage) {
		this.clientMessage = clientMessage;
	}

	public Annonce getAnnonceMessage() {
		return annonceMessage;
	}

	public void setAnnonceMessage(Annonce annonceMessage) {
		this.annonceMessage = annonceMessage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((annonceMessage == null) ? 0 : annonceMessage.hashCode());
		result = prime * result + ((clientMessage == null) ? 0 : clientMessage.hashCode());
		result = prime * result + ((dateMessage == null) ? 0 : dateMessage.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (annonceMessage == null) {
			if (other.annonceMessage != null)
				return false;
		} else if (!annonceMessage.equals(other.annonceMessage))
			return false;
		if (clientMessage == null) {
			if (other.clientMessage != null)
				return false;
		} else if (!clientMessage.equals(other.clientMessage))
			return false;
		if (dateMessage == null) {
			if (other.dateMessage != null)
				return false;
		} else if (!dateMessage.equals(other.dateMessage))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
