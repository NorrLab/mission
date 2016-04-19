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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name="Client.getAll",query = "SELECT c FROM Client c "),
	@NamedQuery(name="Client.GetByCity",query = "SELECT c FROM Client c WHERE c.city LIKE :x")
})
@Entity
@Table(name="client")
public class Client implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String firstname;
	
	private String lastname;
	
	private Date birth;
	
	private Byte photo; 
	
	private String adress;
	
	private String zipCode;
	
	private String email;
	
	private String country;
	
	private String city;
	
	private String password;
	
	private String phone;
	@Enumerated
	private Gender sex;
	
	@OneToMany(mappedBy="clientAnnonce",cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private Collection<Annonce> annoces;
	
	@OneToMany(mappedBy="clientMessage",cascade = CascadeType.ALL)
	private Collection<Message> messages;
	
	@OneToMany(mappedBy="ownerClient",cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private Collection<Avis>clientAvis;
	
	@OneToMany(mappedBy="destinationClient",cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private Collection<Avis>othersAvis;
	
	public Collection<Avis> getOthersAvis() {
		return othersAvis;
	}

	public void setOthersAvis(Collection<Avis> othersAvis) {
		this.othersAvis = othersAvis;
	}

	public static final String NAMED_QUERY_GETALL="Client.getAll";
	public static final String NAMED_QUERY_GEt_BY_CITY="Client.GetByCity";
	public Client() {
		super();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Byte getPhoto() {
		return photo;
	}

	public void setPhoto(Byte photo) {
		this.photo = photo;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Gender getSex() {
		return sex;
	}

	public void setSex(Gender sex) {
		this.sex = sex;
	}

	public Collection<Annonce> getAnnoces() {
		return annoces;
	}

	public void setAnnoces(Collection<Annonce> annoces) {
		this.annoces = annoces;
	}

	public Collection<Message> getMessages() {
		return messages;
	}

	public void setMessages(Collection<Message> messages) {
		this.messages = messages;
	}
		

	

	public Collection<Avis> getClientAvis() {
		return clientAvis;
	}

	public void setClientAvis(Collection<Avis> clientAvis) {
		this.clientAvis = clientAvis;
	}


	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birth == null) ? 0 : birth.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
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
		Client other = (Client) obj;
		if (birth == null) {
			if (other.birth != null)
				return false;
		} else if (!birth.equals(other.birth))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Client [firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", country=" + country
				+ "]";
	}
	
	 
	

}
