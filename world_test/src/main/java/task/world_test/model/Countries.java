package task.world_test.model;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.NaturalId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Countries", uniqueConstraints=@UniqueConstraint(columnNames="iso2"))
public class Countries implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name= "country_name")
	private String countryName;
	
	@Column(name= "native_name")
	private String nativeName;
	
	@Column(name= "phone")
	private String phone;
	
	@ManyToOne(targetEntity = Continents.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "continent_code",referencedColumnName = "iso2")
	private Continents continentCode;
	
	@Column(name= "capital")
	private String capital;
	
	@Column(name= "currency")
	private String currency;
	
	@NaturalId
	private String iso2;
	
	
	@Column(name= "languages_code")
	private String languagesCode;
	
	@Column(name= "languages_name")
	private String languagesName;
	
	@Column(name= "languages_native_name")
	private String languagesNativeName;	
}
