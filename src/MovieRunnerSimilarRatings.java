import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class MovieRunnerSimilarRatings {

    public void printSimilarRatings(String id, int minimalRaters, int numSimilarRaters) {
        FourthRatings fr = new FourthRatings();
        RaterDatabase.initialize("raters.csv");

        try {
            MovieDatabase.initialize("ratedmoviesfull.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ArrayList<Rating> ratings= fr.getSimilarRatings(id, numSimilarRaters, minimalRaters);
        Collections.sort(ratings, Collections.reverseOrder());
        System.out.println("Found "+ratings.size()+" movies. Here are the top 15.");
        for (int i=0;i<15;i++) {
            Rating r =ratings.get(i);
            System.out.println(MovieDatabase.getTitle(r.getItem()));
        }
    }

    public void printSimilarRatingsByGenre(String id, int numSimilarRaters, int minimalRaters, String genre) {
        FourthRatings fr = new FourthRatings();
        RaterDatabase.initialize("raters.csv");
        System.out.println("read data for " + RaterDatabase.size() + " raters");
        MovieDatabase md = new MovieDatabase();
        try {
            MovieDatabase.initialize("ratedmoviesfull.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("read data for " + MovieDatabase.size() + " movies");
        System.out.println("read data for " + RaterDatabase.size() + " raters");
        GenreFilter f = new GenreFilter(genre);
        if (md.hasGenre(genre)) {
            ArrayList<Rating> ratings = fr.getSimilarRatingsByFilter(id, numSimilarRaters, minimalRaters, f);
            Collections.sort(ratings, Collections.reverseOrder());
            System.out.println("Found "+ratings.size()+" movies. Here are the top 15.");
            for (int i=0;i<15;i++) {
                Rating r =ratings.get(i);
                System.out.println(MovieDatabase.getTitle(r.getItem()) + " " + MovieDatabase.getYear(r.getItem()));
                System.out.println("\t" + MovieDatabase.getGenres(r.getItem()));
                }
        } else {
            System.out.println("your specific genre is not present in this database. Check again for typos.");
        }
    }

    public void printSimilarRatingsByDirector(String id, int numSimilarRaters, int minimalRaters, String director) {

        FourthRatings fr = new FourthRatings();
        RaterDatabase.initialize("raters.csv");
        System.out.println("read data for " + RaterDatabase.size() + " raters");
                try {
            MovieDatabase.initialize("ratedmoviesfull.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("read data for " + MovieDatabase.size() + " movies");
        System.out.println("read data for " + RaterDatabase.size() + " raters");
        DirectorsFilter f = new DirectorsFilter(director);
        ArrayList<Rating> ratings = fr.getSimilarRatingsByFilter(id, numSimilarRaters, minimalRaters, f);
        ratings.sort(Collections.reverseOrder());
        if (!ratings.isEmpty()) {
            Collections.sort(ratings, Collections.reverseOrder());
            System.out.println("Found "+ratings.size()+" movies. Here are the top 15.");
            for (int i=0;i<15;i++) {
                Rating r =ratings.get(i);
                System.out.println(MovieDatabase.getTitle(r.getItem()) + " " + MovieDatabase.getYear(r.getItem()));
                System.out.println("\t" + MovieDatabase.getDirector(r.getItem()));
            }
        } else {
            System.out.println("The director/s selected doesn-t appear with the current filter criteria in the database.");
            System.out.println("Here is a list of what you might like without the directors filter:");
            ArrayList<Rating> ratingsatings = fr.getSimilarRatings(id, numSimilarRaters, minimalRaters);
            ratingsatings.sort(Collections.reverseOrder());
            for (Rating r : ratingsatings) {
                System.out.println(MovieDatabase.getTitle(r.getItem()));
            }
        }
    }

    public void printSimilarRatingsByGenreAndMinutes(String id, int numSimilarRaters, int minimalRaters, String genre, int minMinutes, int maxMinutes) {
        FourthRatings fr = new FourthRatings();
        RaterDatabase.initialize("raters.csv");
        System.out.println("read data for " + RaterDatabase.size() + " raters");
        MovieDatabase md = new MovieDatabase();
        try {
            MovieDatabase.initialize("ratedmoviesfull.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("read data for " + MovieDatabase.size() + " movies");
        System.out.println("read data for " + RaterDatabase.size() + " raters");
        AllFilters f = new AllFilters();
        GenreFilter f1 = new GenreFilter(genre);
        if (!md.hasGenre(genre)) {
            System.out.println("Your genre input is not present in the database.");
        }
        f.addFilter(f1);
        MinutesFilter f2 = new MinutesFilter(minMinutes, maxMinutes);
        f.addFilter(f2);
        ArrayList<Rating> ratings = fr.getSimilarRatingsByFilter(id, numSimilarRaters, minimalRaters, f);
        ratings.sort(Collections.reverseOrder());
        if (!ratings.isEmpty()) {
            Collections.sort(ratings, Collections.reverseOrder());
            System.out.println("Found "+ratings.size()+" movies. Here are the top 15.");
            for (int i=0;i<15;i++) {
                Rating r =ratings.get(i);
                System.out.println(MovieDatabase.getTitle(r.getItem()) + " " + MovieDatabase.getYear(r.getItem()));
                System.out.println("\t" + MovieDatabase.getDirector(r.getItem()));
            }

        }
    }
        public void printSimilarRatingsByGenreAndYear(String id, int numSimilarRaters, int minimalRaters, String genre,int year){
            FourthRatings fr = new FourthRatings();
            RaterDatabase.initialize("raters.csv");
            System.out.println("read data for " + RaterDatabase.size() + " raters");
            MovieDatabase md = new MovieDatabase();
            try {
                MovieDatabase.initialize("ratedmoviesfull.csv");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            System.out.println("read data for " + MovieDatabase.size() + " movies");
            System.out.println("read data for " + RaterDatabase.size() + " raters");
            AllFilters f = new AllFilters();
            GenreFilter f1 = new GenreFilter(genre);
            if (!md.hasGenre(genre)) {
                System.out.println("Your genre input is not present in the database.");
            }
            f.addFilter(f1);
            YearAfterFilter f2 = new YearAfterFilter(year);
            f.addFilter(f2);
            ArrayList<Rating> ratings = fr.getSimilarRatingsByFilter(id, numSimilarRaters, minimalRaters, f);
            ratings.sort(Collections.reverseOrder());
            if (!ratings.isEmpty()) {
                Collections.sort(ratings, Collections.reverseOrder());
                System.out.println("Found "+ratings.size()+" movies. Here are the top 15.");
                for (int i=0;i<15;i++) {
                    Rating r =ratings.get(i);
                        System.out.println(MovieDatabase.getTitle(r.getItem()) + " " + MovieDatabase.getYear(r.getItem()));
                        System.out.println("\t" + MovieDatabase.getGenres(r.getItem()));
                    }
                }
            }



    public void printSimilarRatingsByYearAfterAndMinutes (String id, int numSimilarRaters, int minimalRaters, int year, int minMinutes, int maxMinutes){
        FourthRatings fr = new FourthRatings();
        RaterDatabase.initialize("raters.csv");
        System.out.println("read data for " + RaterDatabase.size() + " raters");
        try {
            MovieDatabase.initialize("ratedmoviesfull.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        YearAfterFilter f1=new YearAfterFilter(year);
        System.out.println("read data for " + MovieDatabase.size() + " movies");
        System.out.println("read data for " + RaterDatabase.size() + " raters");
        AllFilters f = new AllFilters();
        f.addFilter(f1);
        MinutesFilter f2 = new MinutesFilter(minMinutes, maxMinutes);
        f.addFilter(f2);
        ArrayList<Rating> ratings = fr.getSimilarRatingsByFilter(id, numSimilarRaters, minimalRaters, f);
        ratings.sort(Collections.reverseOrder());
        if (!ratings.isEmpty()) {
            Collections.sort(ratings, Collections.reverseOrder());
            System.out.println("Found "+ratings.size()+" movies. Here are the top 15.");
            for (int i=0;i<15;i++) {
                Rating r =ratings.get(i);
                System.out.println(MovieDatabase.getTitle(r.getItem()) + " " + MovieDatabase.getYear(r.getItem()));
                System.out.println("\t" + MovieDatabase.getMinutes(r.getItem())+" minutes");
            }

        }
    }
}








