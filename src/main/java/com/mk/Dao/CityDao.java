package com.mk.Dao;

import com.mk.Entity.City;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CityDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    public List<City> getAllCity(){
        String sql = "SELECT * FROM city";
        List<City> cityList = jdbcTemplate.query(sql, new RowMapper<City>() {
            City city = null;
            @Override
            public City mapRow(ResultSet rs, int i) throws SQLException {
                city = new City();
                city.setId(Integer.parseInt(rs.getString("ID")));
                city.setName(rs.getString("Name"));
                city.setCountryCode(rs.getString("CountryCode"));
                city.setDistrict(rs.getString("District"));
                city.setPopulation(Integer.parseInt(rs.getString("Population")));
                return city;
            }
        });
        return cityList;
    }

    public List<City> getCityById(int id){
        String sql = "SELECT * FROM city WHERE ID="+id;
        List<City> cityList = jdbcTemplate.query(sql, new RowMapper<City>() {
            City city = null;
            @Override
            public City mapRow(ResultSet rs, int i) throws SQLException {
                city = new City();
                city.setId(Integer.parseInt(rs.getString("ID")));
                city.setName(rs.getString("Name"));
                city.setCountryCode(rs.getString("CountryCode"));
                city.setDistrict(rs.getString("District"));
                city.setPopulation(Integer.parseInt(rs.getString("Population")));
                return city;
            }
        });
        return cityList;
    }
}
