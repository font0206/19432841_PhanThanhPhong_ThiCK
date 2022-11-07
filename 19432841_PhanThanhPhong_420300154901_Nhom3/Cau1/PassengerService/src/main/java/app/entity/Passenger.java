package app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "passengers")
@Getter@Setter
public class Passenger implements Serializable {
	@Id
	@Column(name = "passengerId", columnDefinition = "varchar(9)")
	private String id;
	private String name;
	private String address;
}
