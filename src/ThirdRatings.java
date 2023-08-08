
/**
 * Write a description of SecondRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class ThirdRatings {
       private final ArrayList<Rater> myRaters;
    
    public ThirdRatings() {
        // default constructor
        this("ratings.csv");
    }
    public ThirdRatings(String ratingsfile){
      FirstRatings fr=new FirstRatings();      
      myRaters=fr.loadRaters(ratingsfile);    
      
    }
        public int getRaterSize(){
        return myRaters.size();       
    }
    public ArrayList<Rater> getRaters(){
    return myRaters;
    }
     public ArrayList<Rating> getAverageRatingsByFilter(int minimalRaters, Filter filterCriteria) {
    	ArrayList<String> movies = MovieDatabase.filterBy(filterCriteria);
    	ArrayList<Rating> ratings = new ArrayList<Rating>();
       	for(String id: movies) {
    		double averageRating = getAverageByID(id,minimalRaters);
    		if(averageRating!=0){
    			Rating r = new Rating(id, averageRating);
    			ratings.add(r);
    		}
    	}
    	return ratings;
    }
    
   public double getAverageByID(String id,int minimalRaters){
    double result=0;
    int currRaters=0;
    double currAvg=0;
    
    ArrayList<Rater> raters=getRaters();
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