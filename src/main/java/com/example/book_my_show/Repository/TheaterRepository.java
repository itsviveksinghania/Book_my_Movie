package com.example.book_my_show.Repository;

import com.example.book_my_show.Models.TheaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<TheaterEntity, Integer> {
}
