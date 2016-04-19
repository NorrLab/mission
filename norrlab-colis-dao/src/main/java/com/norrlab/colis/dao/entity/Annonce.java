package com.norrlab.colis.dao.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Annonce implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateAnnonce;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateStart;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateEnd;
	
	private String description;
	
	@OneToMany(mappedBy="annonce",cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private Collection<Colis>listColis;
	
	@OneToMany(mappedBy="annonceMessage",cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private Collection<Message> messages;
	
	@Enumerated
	private Status status;
	
	private String tranportType;
	
	private String cityEnd;
	
	private String cityStart;
	
	
	@OneToOne
	@JoinColumn(name="CLI_ID", nullable=false)
	private Client clientAnnonce;//TODO have to resolve the SQL duplicate key
	
	

	public Annonce() {
		super();
	}
	
	public Client getClientAnnonce() {
		return clientAnnonce;
	}

	public void setClientAnnonce(Client clientAnnonce) {
		this.clientAnnonce = clientAnnonce;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateAnnonce() {
		return dateAnnonce;
	}

	public void setDateAnnonce(Date dateAnnonce) {
		this.dateAnnonce = dateAnnonce;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Collection<Colis> getListColis() {
		return listColis;
	}

	public void setListColis(Collection<Colis> listColis) {
		this.listColis = listColis;
	}

	public Collection<Message> getMessages() {
		return messages;
	}

	public void setMessages(Collection<Message> messages) {
		this.messages = messages;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getTranportType() {
		return tranportType;
	}

	public void setTranportType(String tranportType) {
		this.tranportType = tranportType;
	}

	public String getCityEnd() {
		return cityEnd;
	}

	public void setCityEnd(String cityEnd) {
		this.cityEnd = cityEnd;
	}

	public String getCityStart() {
		return cityStart;
	}

	public void setCityStart(String cityStart) {
		this.cityStart = cityStart;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
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
		Annonce other = (Annonce) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
