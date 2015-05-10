package model;

// Generated May 9, 2015 4:50:58 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SystemManger generated by hbm2java
 */
@Entity
@Table(name = "SystemManger", catalog = "library")
public class SystemManger implements java.io.Serializable {

	private int systemMangerNo;
	private String systemMangerName;
	private String password;

	public SystemManger() {
	}

	public SystemManger(int systemMangerNo, String systemMangerName,
			String password) {
		this.systemMangerNo = systemMangerNo;
		this.systemMangerName = systemMangerName;
		this.password = password;
	}

	@Id
	@Column(name = "SystemMangerNo", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	public int getSystemMangerNo() {
		return this.systemMangerNo;
	}

	public void setSystemMangerNo(int systemMangerNo) {
		this.systemMangerNo = systemMangerNo;
	}

	@Column(name = "SystemMangerName", nullable = false, length = 45)
	public String getSystemMangerName() {
		return this.systemMangerName;
	}

	public void setSystemMangerName(String systemMangerName) {
		this.systemMangerName = systemMangerName;
	}

	@Column(name = "Password", nullable = false, length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
