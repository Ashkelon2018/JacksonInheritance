package telran.person.domain;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Child extends Person {
	String kindergarten;

	public Child(int id, String name, LocalDate birthDate, Address address, String kindergarten) {
		super(id, name, birthDate, address);
		this.kindergarten = kindergarten;
	}

	@Override
	public String toString() {
		return "Child [kindergarten=" + kindergarten + ", id=" + id + ", name=" + name + ", birthDate=" + birthDate
				+ ", address=" + address + "]";
	}

}
