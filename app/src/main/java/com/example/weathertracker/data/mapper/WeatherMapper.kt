package com.example.weathertracker.data.mapper

import com.example.weathertracker.data.dto.ConditionDto
import com.example.weathertracker.data.dto.CurrentDto
import com.example.weathertracker.data.dto.LocationDto
import com.example.weathertracker.data.dto.WeatherDto
import com.example.weathertracker.domain.model.ConditionModel
import com.example.weathertracker.domain.model.CurrentModel
import com.example.weathertracker.domain.model.LocationModel
import com.example.weathertracker.domain.model.WeatherResponseModel


fun CurrentDto.toCurrent() = CurrentModel(
    cloud = cloud ?: 0,
    condition = conditionDtoCondition(condition),
    dewpoint_c = dewpoint_c ?: 0.0,
    dewpoint_f = dewpoint_f ?: 0.0,
    feelslike_c = feelslike_c ?: 0.0,
    feelslike_f = feelslike_f ?: 0.0,
    gust_kph = gust_kph ?: 0.0,
    gust_mph = gust_mph ?: 0.0,
    heatindex_c = heatindex_c ?: 0.0,
    heatindex_f = heatindex_f ?: 0.0,
    humidity = humidity ?: 0,
    is_day = is_day ?: 0,
    last_updated = last_updated ?: "",
    last_updated_epoch = last_updated_epoch ?: 0,
    precip_in = precip_in ?: 0.0,
    precip_mm = precip_mm ?: 0.0,
    pressure_in = pressure_in ?: 0.0,
    pressure_mb = pressure_mb ?: 0.0,
    temp_c = temp_c ?: 0.0,
    temp_f = temp_f ?: 0.0,
    uv = uv ?: 0.0,
    vis_km = vis_km ?: 0.0,
    vis_miles = vis_miles ?: 0.0,
    wind_degree = wind_degree ?: 0,
    wind_dir = wind_dir ?: "",
    wind_kph = wind_kph ?: 0.0,
    wind_mph = wind_mph ?: 0.0,
    windchill_c = windchill_c ?: 0.0,
    windchill_f = windchill_f ?: 0.0

)


fun ConditionDto.toCondition() = ConditionModel(
    code = code ?: 0,
    icon = icon ?: "",
    text = text ?: ""
)


fun LocationDto.toLocation() = LocationModel(
    country = country ?: "",
    lat = lat ?: 0.0,
    localtime = localtime ?: "",
    localtime_epoch = localtime_epoch ?: 0,
    lon = lon ?: 0.0,
    name = name ?: "",
    region = region ?: "",
    tz_id = tz_id ?: ""
)


fun conditionDtoCondition(
    conditionDto: ConditionDto
) = ConditionModel(
    code = conditionDto.code ?: 0,
    icon = conditionDto.icon ?: "",
    text = conditionDto.text ?: ""
)


fun locationDtoLocation(
   locationDto: LocationDto
) = LocationModel(
    country = locationDto.country ?: "",
    lat = locationDto.lat ?: 0.0,
    localtime = locationDto.localtime ?: "",
    localtime_epoch = locationDto.localtime_epoch ?: 0,
    lon = locationDto.lon ?: 0.0,
    name = locationDto.name ?: "",
    region = locationDto.region ?: "",
    tz_id = locationDto.tz_id ?: ""
)

/*fun currentDtoCurrent(
    currentDto: CurrentDto,
    conditionDto: ConditionDto
) = CurrentModel(
    cloud = currentDto.cloud ?: 0,
    condition = conditionDtoCondition(conditionDto),
    dewpoint_c = currentDto.dewpoint_c ?: 0.0,
    dewpoint_f = currentDto.dewpoint_f ?: 0.0,
    feelslike_c = currentDto.feelslike_c ?: 0.0,
    feelslike_f = currentDto.feelslike_f ?: 0.0,
    gust_kph = currentDto.gust_kph ?: 0.0,
    gust_mph = currentDto.gust_mph ?: 0.0,
    heatindex_c = currentDto.heatindex_c ?: 0.0,
    heatindex_f = currentDto.heatindex_f ?: 0.0,
    humidity = currentDto.humidity ?: 0,
    is_day = currentDto.is_day ?: 0,
    last_updated = currentDto.last_updated ?: "",
    last_updated_epoch = currentDto.last_updated_epoch ?: 0,
    precip_in = currentDto.precip_in ?: 0.0,
    precip_mm = currentDto.precip_mm ?: 0.0,
    pressure_in =currentDto.pressure_in ?: 0.0,
    pressure_mb = currentDto.pressure_mb ?: 0.0,
    temp_c = currentDto.temp_c ?: 0.0,
    temp_f = currentDto.temp_f ?: 0.0,
    uv = currentDto.uv ?: 0.0,
    vis_km = currentDto.vis_km ?: 0.0,
    vis_miles = currentDto.vis_miles ?: 0.0,
    wind_degree = currentDto.wind_degree ?: 0,
    wind_dir = currentDto.wind_dir ?: "",
    wind_kph = currentDto.wind_kph ?: 0.0,
    wind_mph = currentDto.wind_mph ?: 0.0,
    windchill_c = currentDto.windchill_c ?: 0.0,
    windchill_f = currentDto.windchill_f ?: 0.0
)*/

fun WeatherDto.toWeather() = WeatherResponseModel(
    current = current!!.toCurrent(),
    location = locationDtoLocation(location!!)
)