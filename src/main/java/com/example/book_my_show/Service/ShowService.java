package com.example.book_my_show.Service;

import com.example.book_my_show.Convertor.ShowConvertor;
import com.example.book_my_show.EntryDtos.ShowEntryDto;
import com.example.book_my_show.Enums.SeatType;
import com.example.book_my_show.Models.*;
import com.example.book_my_show.Repository.MovieRepository;
import com.example.book_my_show.Repository.ShowRepository;
import com.example.book_my_show.Repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    ShowRepository showRepository;

    public String addShow(ShowEntryDto showEntryDto)
    {
        //1. Create a showEntity
        ShowEntity showEntity = ShowConvertor.convertEntryToEntity(showEntryDto);

        int movieId = showEntryDto.getMovieId();
        int theaterId = showEntryDto.getTheaterId();

        MovieEntity movieEntity = movieRepository.findById(movieId).get();
        TheaterEntity theaterEntity = theaterRepository.findById(theaterId).get();


        //Setting the attribute of foreignKe
        showEntity.setMovieEntity(movieEntity);
        showEntity.setTheaterEntity(theaterEntity);

        //Pending attributes the listOfShowSeatsEnity

        List<ShowSeatEntity> seatEntityList = createShowSeatEntity(showEntryDto,showEntity);

        showEntity.setListOfShowSeat(seatEntityList);


        //Now we  also need to update the parent entities


        showEntity = showRepository.save(showEntity);

        movieEntity.getShowEntityList().add(showEntity);
        theaterEntity.getShowEntityList().add(showEntity);


        movieRepository.save(movieEntity);

        theaterRepository.save(theaterEntity);

        return "The show has been added successfully";

    }

    private List<ShowSeatEntity> createShowSeatEntity(ShowEntryDto showEntryDto,ShowEntity showEntity){



        //Now the goal is to create the ShowSeatEntity
        //We need to set its attribute

        TheaterEntity theaterEntity = showEntity.getTheaterEntity();

        List<TheaterSeatEntity> theaterSeatEntityList = theaterEntity.getTheaterSeatEntityList();

        List<ShowSeatEntity> seatEntityList = new ArrayList<>();

        for(TheaterSeatEntity theaterSeatEntity : theaterSeatEntityList){

            ShowSeatEntity showSeatEntity = new ShowSeatEntity();

            showSeatEntity.setSeatNo(theaterSeatEntity.getSeatNo());
            showSeatEntity.setSeatType(theaterSeatEntity.getSeatType());

            if(theaterSeatEntity.getSeatType().equals(SeatType.CLASSIC))
                showSeatEntity.setPrice(showEntryDto.getClassicSeatPrice());

            else
                showSeatEntity.setPrice(showEntryDto.getPremiumSeatPrice());

            showSeatEntity.setBooked(false);
            showSeatEntity.setShowEntity(showEntity); //parent : foreign key for the showSeat Entity

            seatEntityList.add(showSeatEntity); //Adding it to the list
        }

        return  seatEntityList;

    }
}
