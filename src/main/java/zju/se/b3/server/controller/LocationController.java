package zju.se.b3.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import zju.se.b3.server.entity.Location;
import zju.se.b3.server.service.LocationService;

import java.util.List;

@RestController
public class LocationController {
    @Autowired
    private LocationService locationService;

    @GetMapping("/Location")
    List<Location> search_all_inisland(){
        return locationService.search_all_inisland();
    }
}
