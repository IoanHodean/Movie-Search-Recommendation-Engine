import java.io.IOException;
import java.security.Key;
import java.util.*;


public class MovieDatabase {
    private static HashMap<String, Movie> ourMovies;

    public static void initialize(String moviefile) throws IOException {
        if (ourMovies == null) {
            ourMovies = new HashMap<String,Movie>();
            try {
                loadMovies(moviefile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void initialize() throws IOException {
        if (ourMovies == null) {
            ourMovies = new HashMap<String,Movie>();
            loadMovies("ratedmoviesfull.csv");
        }
    }	

	
    private static void loadMovies(String filename) throws IOException {
        FirstRatings fr = new FirstRatings();
        ArrayList<Movie> list = fr.loadMovies(filename);
        for (Movie m : list) {
            ourMovies.put(m.getID(), m);
        }
    }

    public static boolean containsID(String id) throws RuntimeException {
        try {
            initialize();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ourMovies.containsKey(id);
    }

    public static int getYear(String id) throws RuntimeException {
        try {
            initialize();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ourMovies.get(id).getYear();
    }

    public static String getGenres(String id) {
        try {
            initialize();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ourMovies.get(id).getGenres();
    }

    public static String getTitle(String id) {
        try {
            initialize();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ourMovies.get(id).getTitle();
    }

    public static Movie getMovie(String id) {
        try {
            initialize();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ourMovies.get(id);
    }

    public static String getPoster(String id) {
        try {
            initialize();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ourMovies.get(id).getPoster();
    }

    public static int getMinutes(String id) {
        try {
            initialize();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ourMovies.get(id).getMinutes();
    }

    public static String getCountry(String id) {
        try {
            initialize();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ourMovies.get(id).getCountry();
    }

    public static String getDirector(String id) {
        try {
            initialize();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ourMovies.get(id).getDirector();
    }

    public static int size() {
        return ourMovies.size();
    }

    public static ArrayList<String> filterBy(Filter f) {
        try {
            initialize();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ArrayList<String> list = new ArrayList<String>();
        for(String id : ourMovies.keySet()) {
            if (f.satisfies(id)) {
                list.add(id);
            }
        }
        
        return list;
    }

    public boolean hasGenre(String id){
      ArrayList<String> genres=new ArrayList<>();
      for (Map.Entry entry: ourMovies.entrySet()){
        Movie m= (Movie) entry.getValue();
        String curr= m.getGenres();
        String [] c=curr.split(",");
        for (int k=0;k<c.length;k++){
            if (!genres.contains(c[k])){
                genres.add(c[k]);
            }
        }
      }
        return genres.contains(id);
    }

}

