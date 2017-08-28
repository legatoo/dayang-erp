package com.dayanghome.dayangerp.utils;

import com.dayanghome.dayangerp.constant.CityData;
import com.dayanghome.dayangerp.vo.CityModel;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DistrictIdMap {
    public static final Map<Integer, CityModel> PROVINCE_MAP = new HashMap<>();
    public static final Map<Integer, CityModel> CITY_MAP = new HashMap<>();

    static {
        Gson gson = new Gson();
        List<CityModel> provinceData =
                gson.fromJson(CityData.province_json, TypeToken.getParameterized(List.class, CityModel.class).getType());

        for(CityModel each : provinceData){
            PROVINCE_MAP.put(each.getProvinceId(), each);
        }

        Map<Integer, List<CityModel>> cityData =
                gson.fromJson(CityData.city_json, new TypeToken<Map<Integer, List<CityModel>>>(){}.getType());

        for(Integer provinceId : cityData.keySet()){
            for(CityModel each : cityData.get(provinceId)){
                CITY_MAP.put(each.getCityId(), each);
            }
        }
    }

    public static String provinceName(Integer provinceId){
        CityModel cityModel = PROVINCE_MAP.get(provinceId);
        return cityModel == null ? "" : cityModel.getProvinceName();
    }
    public static String cityName(Integer cityId){
        CityModel cityModel = CITY_MAP.get(cityId);
        return cityModel == null ? "" : cityModel.getCityName();
    }
}
