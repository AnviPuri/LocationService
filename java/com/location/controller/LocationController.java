package com.location.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.location.entities.Location;
import com.location.service.LocationService;
import com.location.util.EmailUtil;

@Controller
public class LocationController {

	@Autowired
	private LocationService locationService;

	@Autowired
	private EmailUtil emailUtility;

	@RequestMapping("/show-create-loaction")
	public String showCreate() {
		return "CreateLocation";
	}

	@RequestMapping("/save-location")
	public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		Location locationSaved = locationService.saveLocation(location);
		String message = "Location saved with id " + locationSaved.getId();
		modelMap.addAttribute("message", message);
		//To send mail from application
		//emailUtility.sendEmail("to some email address", "Test Mail", "Testing Mail Body");
		return "CreateLocation";
	}

	@RequestMapping("/view-locations")
	public String viewAllLocations(ModelMap modelMap) {
		List<Location> locations = locationService.getAllLocations();
		modelMap.addAttribute("locations", locations);
		return "viewAllLocations";
	}

	@RequestMapping("/delete-location")
	public String deleteLocation(@RequestParam("id") int id, ModelMap modelMap) {
		Location location = new Location();
		location.setId(id);
		locationService.deleteLocation(location);
		List<Location> locations = locationService.getAllLocations();
		modelMap.addAttribute("locations", locations);
		return "viewAllLocations";
	}

	@RequestMapping("/call-update-location")
	public String callUpdateLocation(@RequestParam("id") int id, ModelMap modelMap) {
		Location location = locationService.getLocationById(id);
		modelMap.addAttribute("location", location);
		return "updateLocation";
	}

	@RequestMapping("/update-location")
	public String updateLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		locationService.updateLocation(location);
		List<Location> locations = locationService.getAllLocations();
		modelMap.addAttribute("locations", locations);
		return "viewAllLocations";
	}

}
