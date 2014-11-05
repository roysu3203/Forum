package com.forum.entity;

import java.io.Serializable;

import javax.persistence.*;

/** 使用者 */
@Entity
@Table(name = "users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 使用者編號 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	/** 帳號 */
	private String account;

	/** 密碼 */
	private String password;

	/** 姓名 */
	private String name;

	/** Email */
	private String email;

	/** 電話 */
	private String phone;

	/** 地址 */
	private String address;

	/** 生日 */
	private String birthday;

	/** 使用者身份 */
	private Integer identity;

	/** 無參數建構子 */
    public User() {
    	
    }

	/** 接受id參數建構子 */
	public User(Integer id) {
		this.id = id;
	}

	/** 以下get與set */
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Integer getIdentity() {
		return identity;
	}

	public void setIdentity(Integer identity) {
		this.identity = identity;
	}
}
