package io.api.crud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tb_user")
public class User {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private Integer age;
	private String address;
	
	
}
