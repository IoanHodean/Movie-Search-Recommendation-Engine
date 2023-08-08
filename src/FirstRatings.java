
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.util.*;
import java.io.*;
import java.nio.*;

import static java.nio.charset.StandardCharsets.ISO_8859_1;


public class FirstRatings {

        public ArrayList<Movie> loadMovies (String filename) throws IOException {
    ArrayList<Movie> answer=new ArrayList<Movie>();
    File f=new File("data/"+filename);
   // FileReader fr=new FileReader(f);
            CSVParser parser = CSVParser.parse(f,ISO_8859_1, CSVFormat.DEFAULT);

     int nr=0;
            for (CSVRecord r: parser){
                String id=r.get(0);
                String title=r.get(1);
                String year=r.get(2);
                String genre =r.get(4);
                String director=r.get(5);
                String country=r.get(3);
                String poster=r.get(7);
                int time=Integer.parseInt(r.get(6));
       Movie m=new Movie(id,title,year,genre,director,country,poster,time);
       answer.add(nr,m);
       nr++;
    }
    return answer;
}
public void testLoadMovies() throws IOException {
    try {
        ArrayList<Movie> list=loadMovies("ratedmoviesfull.csv");
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    int nr=0;
// to see all movies
/*    for (int i=0;i<list.size();i++){
        nr++;
        System.out.println (list.get(i));

}
 System.out.println(nr);
 */

// to see all Comedy genre movies
/* for (int i=0;i<list.size();i++){
    if (list.get(i).getGenres().contains("Comedy")){
        nr++;
}
}
System.out.println(nr);
*/

// to see length>150 minutes
/* for (int i=0;i<list.size();i++){
    if (list.get(i).getMinutes()>150){
        nr++;
    }
}
System.out.println(nr);
*/

// to check director movie max number
/*
HashMap<String,Integer> map=new HashMap<String,Integer>();

for (int i=0;i<list.size();i++){
   String[] dir=list.get(i).getDirector().split(",");
   for (int k=0;k<dir.length;k++){
       String curr=dir[k].trim();
       if (!map.containsKey(curr)){
       map.put(curr,1);
        }
        else {
            map.put(curr,map.get(curr)+1);
    }
}
}

// to print each director and movies number
for (Map.Entry<String,Integer> entry: map.entrySet()){
    System.out.println("The director "+entry.getKey() +"has directed "+entry.getValue());
}

//to find out which director had most movies
int max=0;
for (Map.Entry<String,Integer> entry:map.entrySet()){
    if (entry.getValue()>max){
        max=entry.getValue();}
}
for (Map.Entry<String,Integer> entry:map.entrySet()){
    if (entry.getValue()==max){
        System.out.println("The director with most movies from the list is " + entry.getKey() + " with " + max +" movies.");
}
}
*/
}

public ArrayList<Rater> loadRaters(String filename) {
        //Empty ArrayList of type Rater
        ArrayList<Rater> output = new ArrayList<Rater>();

        //Get the file of interest
        String file = "data/" + filename;
    FileReader fr = null;
    try {
        fr = new FileReader(file);
    } catch (FileNotFoundException e) {
        throw new RuntimeException(e);
    }
    BufferedReader br=new BufferedReader(fr);
    try {
        for(String line = br.readLine(); line != null; line = br.readLine()){
         //for each record (row), put info into rater object
            String[] l=line.split(",");
                //Use this as index for previous rater ID (genius)
                int prevIdx = output.size() - 1;
                //Get rater ID of ith row as an integer
                int currID = Integer.parseInt(l[0]);
                //Get previous rater ID
                int prevID;
                if (output.size() == 0) {
                    //To prevent duplicate of first rater
                    prevID = -1;
                } else {
                    prevID = Integer.parseInt(output.get(prevIdx).getID());
                }


                //If current row raterID is equal to previous raterID
                if (currID == prevID) {
                    //Then just add rating to previous Rater without creating a new Rater object
                    output.get(prevIdx).addRating(l[1], Double.parseDouble(l[2]));
                } else {
                    //If Current ID and previous ID DON'T match, then this means that
                    //We have come to next rater, so we can make a new Rater object
                    EfficientRater newRater = new EfficientRater(l[1]);
                    newRater.addRating(l[1], Double.parseDouble(l[2]));

                    //Add created rater object to 'output' array list
                    output.add(newRater);
                }


            }
    } catch (IOException e) {
        throw new RuntimeException(e);
    }

    return output;

    }

public void testLoadRaters(){
ArrayList<Rater> list=loadRaters("ratings");
int nr=0;
//to see all raters id
/*
 for (int i=0;i<list.size();i++){
        nr++;
        System.out.println ("Rater with id "+list.get(i).getID());  
}
System.out.println("There are "+nr+" raters");
*/

//print raters id and number of ratings and the ratings
/*
for (int i=0;i<list.size();i++){
  System.out.println("the rater with id "+list.get(i).getID()+" has "+list.get(i).numRatings() +" ratings");
  for (int k=0;k<list.get(i).getItemsRated().size();k++){
  System.out.println("the movie with id "+list.get(i).getItemsRated().get(k)+ " and has been rated as "+
  list.get(i).getRating(list.get(i).getItemsRated().get(k))); 
}
}
*/

// how many ratings for a specific rater
/*
String tester="193";
for (int i=0;i<list.size();i++){
String curr=list.get(i).getID();
if (curr.equals(tester)){
    System.out.println ("the tester with id "+tester+ " has "+ list.get(i).numRatings() +" ratings.");
}
}
*/

//how many ratings a movie has
/*
String movieID="1798709";
int movieNr=0;
HashMap<Rater,ArrayList<String>> map=new HashMap<Rater,ArrayList<String>>();
for (int i=0;i<list.size();i++){
map.put(list.get(i),list.get(i).getItemsRated());
}
for (Map.Entry<Rater,ArrayList<String>> entry: map.entrySet()){
  //to check if map loaded correctly
  //  System.out.println("rater "+entry.getKey() +" movies "+entry.getValue());
  if (entry.getValue().contains(movieID)){
      movieNr++;}
    }
    System.out.println("the movie with id "+movieID+" has "+movieNr+" reviews.");
*/
//max number of ratings by any rater
/*
int curr=0;
for (Map.Entry<Rater,ArrayList<String>> entry: map.entrySet()){
    if(entry.getValue().size()>curr){
        curr=entry.getValue().size();
    }
}
for (Map.Entry<Rater,ArrayList<String>> entry: map.entrySet()){
if (entry.getValue().size()==curr){
System.out.println("the rater with most ratings is "+entry.getKey().getID() + " with "+curr+" ratings.");
}
}
    
*/
//how many movies rated by raters and how many (unique) movies are
/*
HashMap<Rater,ArrayList<String>> map1=new HashMap<Rater,ArrayList<String>>();
for (int i=0;i<list.size();i++){
map1.put(list.get(i),list.get(i).getItemsRated());
}
ArrayList<String> uniqueMovies=new ArrayList<String>();
for (Map.Entry<Rater,ArrayList<String>> entry:map1.entrySet()){
    for (String m:entry.getValue()){
        if (!uniqueMovies.contains(m)){
            uniqueMovies.add(m);}
        }
    
}
System.out.println("there are "+uniqueMovies.size()+" movies rated in total.");
*/
}
}
