import java.util.*;

import java.io.*;

public class MovieRunnerAverage {
    SecondRatings sr;

    public MovieRunnerAverage() {
        try {
            sr = new SecondRatings();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void printAverageRatings(){

    System.out.println(sr.getRaterSize());
    double x=getAverageByID("1798709", 1);
    System.out.println(x);
    System.out.println("there are "+sr.getMovieSize()+" movies.");
    ArrayList<Movie> list=sr.getMovies();
    ArrayList<Rating> lister=getAverageRatings(20);
    Collections.sort(lister);
    for (Rating r:lister){
            String id=r.getItem();
            String title=getTitle(r.getItem());

        System.out.println(r.getValue()+title);
}
    }



    private double getAverageByID(String id,int minimalRaters){
    double result=0;
    int currRaters=0;
    double currAvg=0;
    ArrayList<Rater> raters=sr.getRaters();
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
    lisst.add(r);
}

/*

ArrayList<Rating> list=new ArrayList<Rating>();
ArrayList<Rater> rater=sr.getRaters();
ArrayList<Rating> lister=new ArrayList<Rating>();
for (Rater r: rater){
    for (String s:r.getItemsRated()){
        double x=r.getRating(s);
        Rating ra=new Rating(s,x);
        list.add(ra);
    }
    }
   // for (Rating ra:list){
   //     System.out.println(ra.getItem() + ra.getValue());
    //}

HashMap<String, Integer> map= new HashMap<String, Integer>();
for (int i=0;i<list.size();i++){
String x=list.get(i).getItem();
int y=1;
if (map.containsKey(x)){
map.put(x,map.get(x)+y);
}
else {
map.put(x,y);
}
}
for (Map.Entry entry: map.entrySet()){
    String s=entry.getKey().toString();
    Double avg=getAverageByID(s,minimalRaters);
    if (avg>0){
    Rating ra=new Rating(s,avg);
    lister.add(ra);
}
}
for (Rating r:lister){
System.out.println(r.getItem()+" "+r.getValue());
}
*/
return lisst;
}

public String getTitle (String id){
ArrayList<Movie> movies=sr.getMovies();
String tit="ID was not found";
for (Movie m:movies){
    if( m.getID().equals(id)){
        tit= m.getTitle();
        }
}

return tit;
}

public void getAverageRatingOneMovie(){
String id=sr.getID("Vacation");
System.out.println(getAverageByID(id,1));
}
}



