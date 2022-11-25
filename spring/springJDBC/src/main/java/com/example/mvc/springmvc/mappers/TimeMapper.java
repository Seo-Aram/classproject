package com.example.mvc.springmvc.mappers;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TimeMapper {
    String getTime();
}
