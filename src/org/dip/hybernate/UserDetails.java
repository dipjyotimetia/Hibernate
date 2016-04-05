package org.dip.hybernate;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity												// this is entity class
@Table (name="User_Details_Class")
public class UserDetails {
    @Id																	// userId is primary key
    @Column (name="User_ID")
    private int userId;

    @Column (name="User_name")
    private String username;
    
    
    @Temporal (TemporalType.DATE)					// it will only give the date not time
    private Date joinedDate;
    @Embedded
    private Address address;
    private String description;
    
    public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(java.util.Date date) {
		this.joinedDate = date;
	}

	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getUserId() {
    	return userId;
    }
    public void setUserId(int userId) {
    	this.userId = userId;
    }
    
    public String getUsername() {
    	return username;
    }
    public void setUsername(String username) {
    	this.username = username;
    }

	
	
	
}
