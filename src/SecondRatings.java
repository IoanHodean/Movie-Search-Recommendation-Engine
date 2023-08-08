
/**
 * Write a description of SecondRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.io.IOException;
import java.util.*;

public class SecondRatings {
    private final ArrayList<Movie> myMovies;
    private final ArrayList<Rater> myRaters;
    
    public SecondRatings() throws IOException {
        // default constructor
        this("ratedmoviesfull.csv", "ratings.csv");
    }
    public SecondRatings(String moviefile, String ratingsfile) throws IOException {
      FirstRatings fr=new FirstRatings();
      myMovies=fr.loadMovies(moviefile);
      myRaters=fr.loadRaters(ratingsfile);    
      
    }
    public int getMovieSize(){
    return myMovies.size();    
    }
    public int getRaterSize(){
        return myRaters.size();       
}
public String getID(String title){
String test="NO SUCH TITLE";
for (Movie m:myMovies){
if (m.getTitle().equals(title)){
    test=m.getID();
}
}
return test;
}

public ArrayList<Movie> getMovies(){
    return myMovies;
}
public ArrayList<Rater> getRaters(){
    return myRaters;
}
}