package com.location.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.location.entities.Location;
import com.location.repository.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationRepository locationRepository;

	@Override
	public Location saveLocation(Location location) {

		location.setActive(true);
		return locationRepository.save(location);
	}

	@Override
	public Location updateLocation(Location location) {

		return locationRepository.save(location);
	}

	@Override
	public void deleteLocation(int id) {

		Location location = new Location();
		location.setId(id);
		location.setActive(false);
		locationRepository.save(location);
	}

	@Override
	public Location getLocationById(int id) {
		Optional<Location> location = locationRepository.findById(id);
		if (location.isPresent())
			return location.get();
		return null;
	}

	@Override
	public List<Location> getAllLocations() {
		return locationRepository.findAll();
	}

}
