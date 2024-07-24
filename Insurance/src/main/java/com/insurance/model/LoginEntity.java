package com.insurance.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@NoArgsConstructor
//@Entity
public class LoginEntity {
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private long id;

//	    @NotBlank(message = "Name is mandatory")
//	    @Pattern(regexp = "^[a-zA-Z]+$", message = "Name must contain only letters")
//	    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
//	    private String name;

	    @NotBlank(message = "Phone number is mandatory")
	    @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Phone number is invalid")
	    @Size(min = 10, max = 10, message = "Phone Number must be 10 characters")
	    
	    private String phoneNumber;

	    @NotBlank(message = "Email ID is mandatory")
	    @Email(message = "Email should be valid")
	    @Size(max = 100, message = "Email must be less than or equal to 100 characters")
	    private String emailId;
	    
	    @NotBlank(message = "Password is mandatory")
	    @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
	    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$", 
	             message = "Password must contain at least one digit, one lowercase and one uppercase letter, and one special character")
	    private String password;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

//		public String getName() {
//			return name;
//		}
//
//		public void setName(String name) {
//			this.name = name;
//		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		

		@Override
		public String toString() {
			return "LoginEntity [id=" + id + ", phoneNumber=" + phoneNumber + ", emailId=" + emailId + ", password="
					+ password + "]";
		}
	    
	    // Getters and setters are generated by lombok's @Data annotation
	    
	}

