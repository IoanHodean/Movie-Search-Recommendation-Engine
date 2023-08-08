
import java.util.*;

import java.io.*;
import java.nio.*;
public class MovieRunnerWithFilters {

    ThirdRatings tr=new ThirdRatings("ratings.csv");
    
public void printAverageRatings(int minimalRaters){
    System.out.println("read data for "+tr.getRaterSize()+" raters");
    MovieDatabase md=new MovieDatabase();
    try {
        MovieDatabase.initialize("ratedmoviesfull.csv");
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    System.out.println("read data for "+ MovieDatabase.size()+" movies");
    ArrayList<Rating> ratings=getAverageRatings(minimalRaters);
    Collections.sort(ratings, Collections.reverseOrder());
    System.out.println("Found "+ratings.size()+" movies. Here are the top 15.");
    for (int i=0;i<15;i++) {
        Rating r =ratings.get(i);
    System.out.println(r.getValue()+" "+ MovieDatabase.getTitle(r.getItem()));
    }
    
    
    
}
public void printAverageRatingsByYear(int year, int minimalRaters){
    System.out.println("read data for "+tr.getRaterSize()+" raters");
    MovieDatabase md=new MovieDatabase();
    try {
        MovieDatabase.initialize("ratedmoviesfull.csv");
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    System.out.println("read data for "+ MovieDatabase.size()+" movies");
    YearAfterFilter f=new YearAfterFilter(year);
    ArrayList<Rating> ratings=tr.getAverageRatingsByFilter(minimalRaters,f);
    Collections.sort(ratings, Collections.reverseOrder());
    System.out.println("Found "+ratings.size()+" movies. Here are the top 15.");
    for (int i=0;i<15;i++) {
        Rating r =ratings.get(i);
            System.out.println(r.getValue() + " " + MovieDatabase.getYear(r.getItem()) + " " + MovieDatabase.getTitle(r.getItem()));
        }

}
public void printAverageRatingsByGenre(String genre, int minimalRaters){
System.out.println("read data for "+tr.getRaterSize()+" raters");
    MovieDatabase md=new MovieDatabase();
    try {
        MovieDatabase.initialize("ratedmoviesfull.csv");
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    System.out.println("read data for "+ MovieDatabase.size()+" movies");
    GenreFilter f=new GenreFilter(genre);
    ArrayList<Rating> ratings=tr.getAverageRatingsByFilter(minimalRaters,f);
    Collections.sort(ratings, Collections.reverseOrder());
    System.out.println("Found "+ratings.size()+" movies. Here are the top 15.");
    for (int i=0;i<15;i++) {
        Rating r =ratings.get(i);
    System.out.println(r.getValue()+" "+ MovieDatabase.getTitle(r.getItem()));
    System.out.println("\t"+ MovieDatabase.getGenres(r.getItem()));
    }
    
}
public void printAverageRatingsByMinutes(int minutesMin,int minutesMax, int minimalRaters){
System.out.println("read data for "+tr.getRaterSize()+" raters");
    MovieDatabase md=new MovieDatabase();
    try {
        MovieDatabase.initialize("ratedmoviesfull.csv");
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    System.out.println("read data for "+ MovieDatabase.size()+" movies");
    MinutesFilter f=new MinutesFilter(minutesMin,minutesMax);
    ArrayList<Rating> ratings=tr.getAverageRatingsByFilter(minimalRaters,f);
    Collections.sort(ratings, Collections.reverseOrder());
    System.out.println("Found "+ratings.size()+" movies. Here are the top 15.");
    for (int i=0;i<15;i++) {
        Rating r =ratings.get(i);
    System.out.println(r.getValue()+" "+" Time: "+ MovieDatabase.getMinutes(r.getItem())+" "+ MovieDatabase.getTitle(r.getItem()));
    }
}
public void printAverageRatingsByDirectors(String directors,int minimalRaters){
System.out.println("read data for "+tr.getRaterSize()+" raters");
    MovieDatabase md=new MovieDatabase();
    try {
        MovieDatabase.initialize("ratedmoviesfull.csv");
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    System.out.println("read data for "+ MovieDatabase.size()+" movies");
    DirectorsFilter f=new DirectorsFilter(directors);
    ArrayList<Rating> ratings=tr.getAverageRatingsByFilter(minimalRaters,f);
    Collections.sort(ratings, Collections.reverseOrder());
    System.out.println("Found "+ratings.size()+" movies. Here are the top 15.");
    for (int i=0;i<15;i++) {
        Rating r =ratings.get(i);
    System.out.println(r.getValue()+" "+ MovieDatabase.getTitle(r.getItem()));
    System.out.println("\t"+ MovieDatabase.getDirector(r.getItem()));
    }
}
public void printAverageRatingsByYearAfterAndGenre(int year, String genre, int minimalRaters){
  System.out.println("read data for "+tr.getRaterSize()+" raters");
    MovieDatabase md=new MovieDatabase();
    try {
        MovieDatabase.initialize("ratedmoviesfull.csv");
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    System.out.println("read data for "+ MovieDatabase.size()+" movies");
    YearAfterFilter f1=new YearAfterFilter(year);
    GenreFilter f2=new GenreFilter(genre);
    AllFilters f=new AllFilters();
    f.addFilter(f1);
    f.addFilter(f2);      
    ArrayList<Rating> ratings=tr.getAverageRatingsByFilter(minimalRaters,f);
    Collections.sort(ratings, Collections.reverseOrder());
    System.out.println("Found "+ratings.size()+" movies. Here are the top 15.");
    for (int i=0;i<15;i++) {
        Rating r =ratings.get(i);
    System.out.println(r.getValue()+" "+ MovieDatabase.getYear(r.getItem()));
    System.out.println("\t"+ MovieDatabase.getGenres(r.getItem()));
    }  
}

public void printAverageRatingsByDirectorsAndMinutes(String directors, int minutesMin, int minutesMax,int minimalRaters){
System.out.println("read data for "+tr.getRaterSize()+" raters");
    MovieDatabase md=new MovieDatabase();
    try {
        MovieDatabase.initialize("ratedmoviesfull.csv");
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    System.out.println("read data for "+ MovieDatabase.size()+" movies");
    DirectorsFilter f1=new DirectorsFilter(directors);
    MinutesFilter f2=new MinutesFilter(minutesMin,minutesMax);
    AllFilters f=new AllFilters();
    f.addFilter(f1);
    f.addFilter(f2);      
    ArrayList<Rating> ratings=tr.getAverageRatingsByFilter(minimalRaters,f);
    Collections.sort(ratings, Collections.reverseOrder());
    System.out.println("Found "+ratings.size()+" movies. Here are the top 15.");
    for (int i=0;i<15;i++) {
        Rating r =ratings.get(i);
    System.out.println(r.getValue()+" Time: "+ MovieDatabase.getMinutes(r.getItem())+" "+ MovieDatabase.getTitle(r.getItem()));
    System.out.println("\t"+ MovieDatabase.getDirector(r.getItem()));
    } 


}
     private double getAverageByID(String id,int minimalRaters){
    double result=0;
    int currRaters=0;
    double currAvg=0;
    
    ArrayList<Rater> raters=tr.getRaters();
    HashMap<Rater,ArrayList<String>> map=new HashMap<Rater,ArrayList<String>>();
    for (int i=0;i<raters.size();i++){
        map.put(raters.get(i),raters.get(i).getItemsRated());
    }
    for (Map.Entry<Rater,ArrayList<String>> entry:map.entrySet()){
    for (String s:entry.getValue()){
        if (s.equals(id)){
        currRaters++;
        currAvg+=entry.getKey().getRating(id);
        }
    }    
    }
    
    if (currRaters>=minimalRaters){
    result=currAvg/currRaters;
        return result;
}
    else{
    return 0.0;    
    }
}

public ArrayList<Rating> getAverageRatings(int minimalRaters){
ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
ArrayList<Rating> lisst=new ArrayList<Rating>();

for (String s:movies){
    Double avg=(getAverageByID(s,minimalRaters));
    Rating r=new Rating(s,avg);
    if (avg>0){
    lisst.add(r);
}
}
return lisst;
}
}



