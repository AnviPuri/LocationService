package com.location.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.location.entities.Location;
import com.location.repository.LocationRepository;
import com.location.service.LocationService;

@RestController
@RequestMapping("/location")
public class LocationRestController {

	@Autowired
	LocationRepository locationRepository;

	@Autowired
	private LocationService locationService;

	private Location location;

	@PostMapping
	@RequestMapping("/create-location")
	public ResponseEntity<Location> createLocation(@RequestBody Location location) {

		Location savedLocation = locationService.saveLocation(location);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedLocation);
	}

	@PutMapping
	@RequestMapping("/update-location/{id}")
	public ResponseEntity<Location> updateLocation(@RequestBody Location location, @PathVariable("id") int id) {

		location = locationService.getLocationById(id);
		locationService.updateLocation(location);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping("/delete-location/{id}")
	public ResponseEntity<Location> deleteLocation(@PathVariable("id") int id) {

		locationService.deleteLocation(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping
	public List<Location> getLocations() {

		return locationService.getAllLocations();

	}

	@GetMapping("/{id}")
	public Location getLocation(@PathVariable("id") int id) {

		return locationService.getLocationById(id);
	}

}
