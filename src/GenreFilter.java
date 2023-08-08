import java.io.IOException;
import java.util.ArrayList;

/**
 * Write a description of GenreFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GenreFilter implements Filter {
 private final String genres;
 public GenreFilter(String genre){
   genres=genre; 
    
    }   
   @Override 
   public boolean satisfies(String id){
       return MovieDatabase.getGenres(id).contains(genres);
   }

}
