package co.com.foo.test.memory.repository.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class DummyEntity {

	@Id
	@GeneratedValue
	private Long id;

	private String value;

}
