package task.world_test.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "States")
public class States implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(targetEntity = Countries.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "country_code",referencedColumnName = "iso2")
	private Countries countryCode;
	
	@Column(name= "state_code")
	private String stateCode;
	
	@Column(name= "state_name")
	private String stateName;
	

}
