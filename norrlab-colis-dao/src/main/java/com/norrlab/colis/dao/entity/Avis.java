package com.norrlab.colis.dao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
@NamedQueries({
	@NamedQuery(name="Avis.getByCLient",query="SELECT c FROM Avis c WHERE c.ownerClient.id = :x"),
	@NamedQuery(name="Avis.getByDescription",query="SELECT c FROM Avis c WHERE c.description LIKE :y"),
	@NamedQuery(name="Avis.getAll",query="SELECT c FROM Avis c ")
})

@Entity
public class Avis implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	private Date dateAvis;
	
	private String description;
	
	@ManyToOne
	@JoinColumn(name="CLI_ID",nullable=true)
	private Client ownerClient;
	//try
	@ManyToOne
	@JoinColumn(name="DESCLI_ID",nullable=true)
	private Client destinationClient;
	
	//end try
	
	public Client getDestinationClient() {
		return destinationClient;
	}

	public void setDestinationClient(Client destinationClient) {
		this.destinationClient = destinationClient;
	}

	public static final String GET_BY_CLIENT = "Avis.getByCLient";
	public static final String GET_BY_DESCRIPTION = "Avis.getByDescription";
	public static final String GET_ALL = "Avis.getAll";
	

	public Avis() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateAvis() {
		return dateAvis;
	}

	public void setDateAvis(Date dateAvis) {
		this.dateAvis = dateAvis;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Client getOwnerClient() {
		return ownerClient;
	}

	public void setOwnerClient(Client ownerClient) {
		this.ownerClient = ownerClient;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateAvis == null) ? 0 : dateAvis.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ownerClient == null) ? 0 : ownerClient.hashCode());
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
		Avis other = (Avis) obj;
		if (dateAvis == null) {
			if (other.dateAvis != null)
				return false;
		} else if (!dateAvis.equals(other.dateAvis))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ownerClient == null) {
			if (other.ownerClient != null)
				return false;
		} else if (!ownerClient.equals(other.ownerClient))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Avis [id=" + id + "\n, dateAvis=" + dateAvis + "\n, description=" + description + ",\n ownerClient="
				+ ownerClient + "]";
	}

	 
	
}
