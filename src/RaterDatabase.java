
/**
 * Write a description of RaterDatabase here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class RaterDatabase {
    private static HashMap<String,Rater> ourRaters;

    private static void initialize() {
        // this method is only called from addRatings
        if (ourRaters == null) {
            ourRaters = new HashMap<String,Rater>();
        }
    }

    public static void initialize(String filename) {
        if (ourRaters == null) {
            ourRaters= new HashMap<String,Rater>();
            try {
                addRatings("data/" + filename);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void addRatings(String filename) throws IOException {
        initialize();
        FileReader fr = null;
        try {
            fr = new FileReader(filename);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader br=new BufferedReader(fr);
        br.lines().map(line -> line.split(",")).forEach(s -> {
            String id = s[0];
            String item = s[1];
            String rating = s[2];
            addRaterRating(id, item, Double.parseDouble(rating));
        });
    }

    public static void addRaterRating(String raterID, String movieID, double rating) {
        initialize();
        Rater rater =  null;
        if (ourRaters.containsKey(raterID)) {
            rater = ourRaters.get(raterID);
        }
        else {
            rater = new EfficientRater(raterID);
            ourRaters.put(raterID,rater);
        }
        rater.addRating(movieID,rating);
    }

    public static Rater getRater(String id) {
        initialize();

        return ourRaters.get(id);
    }

    public static ArrayList<Rater> getRaters() {
        initialize();
        ArrayList<Rater> list = new ArrayList<Rater>(ourRaters.values());

        return list;
    }

    public static int size() {
        return ourRaters.size();
    }



}