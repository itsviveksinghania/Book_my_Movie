package com.example.book_my_show.Convertor;

import com.example.book_my_show.EntryDtos.MovieEntryDto;
import com.example.book_my_show.Models.MovieEntity;

public class MovieConvertor {

    public static MovieEntity convertEntryDtoToEntity(MovieEntryDto movieEntryDto){
        MovieEntity movieEntity = MovieEntity.builder()
                .movieName(movieEntryDto.getMovieName()).duration(movieEntryDto.getDuration()).ratings(movieEntryDto.getRatings())
                .language(movieEntryDto.getLanguage()).genre(movieEntryDto.getGenre()).build();
        return movieEntity;
    }
}
