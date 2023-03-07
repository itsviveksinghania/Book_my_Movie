package com.example.book_my_show.Convertor;

import com.example.book_my_show.EntryDtos.TheaterEntryDto;
import com.example.book_my_show.Models.TheaterEntity;
import lombok.Data;

@Data
public class TheaterConvertor {

    public static TheaterEntity convertDtoToEntity(TheaterEntryDto theaterEntryDto){

        return TheaterEntity.builder().location(theaterEntryDto.getLocation())
                .name(theaterEntryDto.getName()).build();

    }
}
