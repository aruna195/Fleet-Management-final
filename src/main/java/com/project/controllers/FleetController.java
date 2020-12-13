 package com.project.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.fleet.FleetInfo;

import FleetDao.FleetDao;
import FleetDao.FleetDaoImpl;
@Controller

public class FleetController {
	
	@Autowired
	private FleetDao fleetDao;

	@RequestMapping(value = "/fleetlist")
	public String showHomePage(Model model) throws SQLException {

		System.out.println("In HomePage");		
		
		List<FleetInfo> allFleetInfo = new FleetDaoImpl().getAllFleet();
		 System.out.println(allFleetInfo);
		 model.addAttribute("FleetList", allFleetInfo); 
		 return "fleetlist";
		

		
	} 

	@RequestMapping(value = "/createFleetInfo", method = RequestMethod.GET)
	public String newFleetInfoPage(Model model) throws SQLException{
		FleetInfo newFleetInfo = new FleetInfo();
		

		model.addAttribute("fleet", newFleetInfo);
		
		return "newfleetform";

	}

/*	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String newCustomerPage(@RequestParam String searchId, Model model) throws SQLException{
		FleetInfo fleet = fleetDao.getFleetInfo(Integer.parseInt(searchId));
		List customers = new ArrayList();
		fleetlist.add(fleet);
		
		model.addAttribute("FleetList", fleetlist);

		return "fleetlist";

	} */

	@PostMapping(value = "/saveFleetInfo")
	public String  save(@RequestParam("fleet_id") int fleet_id, 
			@RequestParam("fleet_name") String fleet_name, 
			@RequestParam("fleet_model") String fleet_model,
			@RequestParam("fleet_make") String fleet_make,
			@RequestParam("latitude") String latitude,
			@RequestParam("longitude") String longitude,
			@RequestParam("category") String category,
			@RequestParam("serial_number") String serial_number,
			ModelMap modelMap) 
	{
		
		FleetInfo fleet = new FleetInfo();
		fleet.setFleet_id(fleet_id);
		fleet.setFleet_name(fleet_name);
		fleet.setFleet_model(fleet_model);
		fleet.setFleet_make(fleet_make);		
		fleet.setLatitude(Double.parseDouble(latitude));
		fleet.setLongitude(Double.parseDouble(longitude));
		fleet.setCategory(category);
		fleet.setSerial_number(serial_number);
		
		fleetDao.createFleetInfo(fleet);
		
		return "redirect:/fleetlist";
	
		
	
	} 
	

	@RequestMapping(value = "/edit/fleet/{fleet_id}")
	public String editFleetInfo(@PathVariable int fleet_id, Model model) {

		
		FleetInfo fleet = fleetDao.getFleetInfo(fleet_id);
		
		model.addAttribute("fleet", fleet);
		return "/newfleetform";
	}
	/*@RequestMapping(value = "/editSave", method = RequestMethod.GET)
	
	public String  editSave(@ModelAttribute FleetInfo fleet) {
		fleetDao.updateFleetInfo(fleet);
		
		return "redirect:/fleetlist";
} 
	

	@RequestMapping(value = "/delete/fleet/{fleet_id}", method = RequestMethod.GET)
	public String deleteFleetInfo(@PathVariable int fleet_id) {

		fleetDao.deleteFleetInfo(fleet_id);

		return "redirect:/fleetlist";
	} */

} 



