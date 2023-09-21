package com.validboot.Simple.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class User {
	@Size(min = 3, max = 50)
	private String name;

	@NotBlank
	@Email(message = "Please enter a valid e-mail address")
	private String email;

	@NotBlank
	@Size(min = 8, max = 15)
	private String password;

	// @NotBlank
	// private String gender;
	//
	// @Size(max = 100)
	// private String note;
	//
	// @AssertTrue
	// private boolean married;

	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date birthday;

	@NotBlank
	private String profession;

	public User() {
		super();
	}

	public User(@Size(min = 3, max = 50) String name,
			@NotBlank @Email(message = "Please enter a valid e-mail address") String email,
			@NotBlank @Size(min = 8, max = 15) String password, Date birthday, @NotBlank String profession) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.birthday = birthday;
		this.profession = profession;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", password=" + password + ", birthday=" + birthday
				+ ", profession=" + profession + "]";
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	// @Min(value = 20_000)
	// @Max(value = 200_000)
	// private long income;

}
