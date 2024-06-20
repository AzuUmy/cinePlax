package com.cinema.Controller;
import java.util.ArrayList;
import java.util.List;
import com.cinema.Model.movieDates;

public class catalogueDatesController {
    private static List<movieDates> datesCartaz = new ArrayList<>();


    public static movieDates moviesDatesAndTime(String id, String[] datas, String[] movieDuration){

        movieDates datesAndTime = new movieDates(id, movieDuration, datas);

     
        fillMovieDataAndTime(datesAndTime);
        return datesAndTime;


       
    }


    private static void fillMovieDataAndTime(movieDates datesEtime){
            datesCartaz.add(datesEtime);
    }


    public static List<movieDates> getMovieDatesAndTime(){
        return datesCartaz;
        
    }

}
