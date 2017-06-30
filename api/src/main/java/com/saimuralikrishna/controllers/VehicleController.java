package com.saimuralikrishna.controllers;

import com.saimuralikrishna.entities.Vehicle;
import com.saimuralikrishna.pojo.VehicleWrapper;
import com.saimuralikrishna.service.VehicleService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by saimuralikrishnasriadibhatla on 6/28/17.
 */
@RestController
@RequestMapping(value = "vehicles")
@CrossOrigin(origins = "*")
public class VehicleController {

    private VehicleService vehicleService;
    public VehicleController(VehicleService vehicleService){
        this.vehicleService = vehicleService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value="Fetch all vehicles", notes="Returns a list of vehicles")
    @ApiResponses(value={
            @ApiResponse(code = 200, message="Success"),
            @ApiResponse(code = 500, message="Internal Server Error")
    })
    public List<Vehicle> getAll(){
        return this.vehicleService.getAll();
    }

    @RequestMapping(method=RequestMethod.PUT, consumes="application/json", produces="application/json")
    @ApiOperation(value="Create and Update Vehicles", notes="Adds vehicle if not exists and Update the vehicle data if exits")
    @ApiResponses(value={
            @ApiResponse(code = 200, message="Success"),
            @ApiResponse(code = 500, message="Internal Server Error")
    })
    public List<Vehicle> addVehicles(@RequestBody VehicleWrapper listOfVehicles){
        for(Vehicle vehicle : listOfVehicles){
            this.vehicleService.createVehicle(vehicle);
        }
        return listOfVehicles;
    }
}