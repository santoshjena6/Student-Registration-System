package com.sk.Entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="STUDENT")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor

public class Student {
	
	
	@Column(name="studentId")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sId;
	
	@NonNull
	@Column(name="studentName",length = 20)
	private String studentName;
	
	
	@NonNull
//	@Transient
	@Column(name="address",length = 20)
	private String address;
	
	
	@NonNull
//	@Transient
	@Column(name="phone_number")
	private Long number;
	
	
}
