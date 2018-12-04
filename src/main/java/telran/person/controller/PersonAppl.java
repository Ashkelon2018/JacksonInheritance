package telran.person.controller;

import java.io.IOException;
import java.time.LocalDate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import telran.person.domain.Address;
import telran.person.domain.Child;
import telran.person.domain.Employee;
import telran.person.domain.Person;

public class PersonAppl {
	static ObjectMapper mapper;
	static {
		mapper = new ObjectMapper();
		mapper.findAndRegisterModules();
	}

	public static void main(String[] args) throws IOException {
		Person[] persons = {
				new Child(123, "Mosche",
						LocalDate.of(2014, 5, 12), 
						new Address("Lod", "Sokolov", 10, 12),
						"Tapuz"),
				new Employee(124, "George", LocalDate.of(1970, 12 , 21), new Address("Kfar Saba", "Herzl", 23, 1), "Motorola", 16000)
		};
		//Serializing to json
		String json = mapper.writeValueAsString(persons);
		System.out.println(json);
		
		//Deserializing from json
		Iterable<Person> personsRestore = 
				mapper.readValue(json, new TypeReference<Iterable<Person>>() {
				});
		for (Person person : personsRestore) {
			System.out.println(person);
		}

	}

}
