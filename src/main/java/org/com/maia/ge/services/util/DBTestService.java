package org.com.maia.ge.services.util;

import java.text.ParseException;

import org.com.maia.ge.entity.Address;
import org.com.maia.ge.entity.City;
import org.com.maia.ge.entity.District;
import org.com.maia.ge.entity.Institution;
import org.com.maia.ge.entity.Room;
import org.com.maia.ge.repository.AddressRepository;
import org.com.maia.ge.repository.CityRepository;
import org.com.maia.ge.repository.DistrictRepository;
import org.com.maia.ge.repository.InstitutionRepository;
import org.com.maia.ge.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBTestService {

	@Autowired
	private DistrictRepository districtRepository;

	@Autowired
	private CityRepository cityRespo;

	@Autowired
	private AddressRepository addressRepo;

	@Autowired
	private InstitutionRepository institutionRepo;

	@Autowired
	private RoomRepository roomRepo;

	public void instanciateTestDatabase() throws ParseException {

		/* District */
		District d1 = new District(null, "Goias", "Go");
		District d2 = new District(null, "Maranhão", "MA");
		districtRepository.save(d1);
		districtRepository.save(d2);
		/*-/ */

		// City
		City city = new City(null, "Maya", d1);
		cityRespo.save(city);

		City city2 = new City(null, "Praia Grande", d1);
		cityRespo.save(city2);

		City city3 = new City(null, "Montreal", d1);
		cityRespo.save(city3);

		City city4 = new City(null, "Maios", d1);
		cityRespo.save(city4);

		City city5 = new City(null, "Ahya", d1);
		cityRespo.save(city5);

		City city6 = new City(null, "Aplay", d1);
		cityRespo.save(city6);

		City city7 = new City(null, "Amm Ploi", d1);
		cityRespo.save(city7);

		// ************************************

		City city8 = new City(null, "Niagre", d2);
		cityRespo.save(city8);

		City city9 = new City(null, "Polly Stor", d2);
		cityRespo.save(city9);

		City city10 = new City(null, "City Plus", d2);
		cityRespo.save(city10);

		City city11 = new City(null, "Catedral", d2);
		cityRespo.save(city11);

		// ***************** END - CITY *******************

		Address a1 = new Address(null, "Av. C", "Centro", "74.658", "10-AB", "Qd.14 ,Lt -10", null, city);
		addressRepo.save(a1);

		Address a2 = new Address(null, "Av. C", "Centro", "74.658", "10-AB", "Qd.14 ,Lt -10", null, city7);
		addressRepo.save(a2);

		// ************

		Institution school_1 = new Institution(null, "Maia Institution", "maia.org.edu", "000-9999-7777", null, a1);
		Room room = new Room(null, "Sala-B2", "01ª Piso", school_1);
		school_1.getRooms().add(room);
		institutionRepo.save(school_1);
		roomRepo.save(room);

	}

}
