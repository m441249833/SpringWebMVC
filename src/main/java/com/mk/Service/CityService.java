package com.mk.Service;

import com.mk.Dao.CityDao;
import com.mk.Entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityDao cityDao;

    public List<City> getAllCity(){
        return cityDao.getAllCity();
    }
    public List<City> getCityById(int id){
        return cityDao.getCityById(id);
    }

}
