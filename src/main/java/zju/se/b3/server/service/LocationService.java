package zju.se.b3.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zju.se.b3.server.entity.Location;
import zju.se.b3.server.entity.online;
import zju.se.b3.server.mapper.LocationMapper;
import zju.se.b3.server.mapper.onlineMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationService {
    @Autowired
    private LocationMapper locationMapper;
    @Autowired
    private zju.se.b3.server.mapper.onlineMapper onlineMapper;

    public List<Location> search_all_inisland(){
        List<Location> ans = new ArrayList<Location>();
        List<online> online_list = onlineMapper.select_by_status("in_island");
        for (online online1 : online_list){
            ans.add(locationMapper.search(online1.getUser_id()));
        }
        return ans;
    }
}
