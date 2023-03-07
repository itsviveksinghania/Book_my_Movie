package com.example.book_my_show.Service;

import com.example.book_my_show.Convertor.UserConvertor;
import com.example.book_my_show.EntryDtos.UserEntryDto;
import com.example.book_my_show.Models.UserEntity;
import com.example.book_my_show.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String addUser(UserEntryDto userEntryDto) throws Exception, NullPointerException{

        /*Here we need to convert and save.
        1st Method
        Old method : create an object and set attributes.
        userEntity.setAge(userEntryDto.getAge())
        userEntity.setAddress(userEntryDto.getAddress())

        2nd Method
        //creating the objects
        UserEntity userEntity = UserEntity.builder().age(userEntryDto.getAge()).name(userEntryDto.getName())
                .address(userEntryDto.getAddress()).email(userEntryDto.getEmail()).mobNo(userEntryDto.getMobNo())
                .build();
        userRepository.save(userEntity);
        return "ADDED";
        //This is to set all the attributes in 1 go.

        3rd Method is to create a Package of Convertors
        */

        UserEntity userEntity = UserConvertor.convertDtoToEntity(userEntryDto);
        userRepository.save(userEntity);
        return "User Added Successfully";

    }
}
