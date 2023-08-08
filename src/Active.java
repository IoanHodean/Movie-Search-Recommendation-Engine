import java.util.Scanner;

public class Active {

    public static void scannerAndRunner() {
        MovieRunnerSimilarRatings movieRunnerSimilarRatings = new MovieRunnerSimilarRatings();
        MovieRunnerWithFilters MovieRunnerWithFilters = new MovieRunnerWithFilters();
        Scanner s = new Scanner(System.in);
        String id="1049";
        String genre; String director;
        int minimalRaters, year, minMinutes, maxMinutes, numSimilarRaters;



        System.out.println("Do you want your preferences to be personalized? That includes you rating 10 movies first.");
        System.out.println("Answer with Yes or No.");
        String a = s.next();
        switch (a) {
            case "Yes": {
                me();
                System.out.println("Please choose how many similar raters would you want to parse along. Recommended:15-20. ");
                numSimilarRaters = s.nextInt();
                s.nextLine();
                System.out.println("Please choose the number of minimum raters for the movies. Recommended:3-5.");
                minimalRaters = s.nextInt();
                s.nextLine();
                System.out.println("Please choose the number in front of your desired selection:");
                System.out.println("1. Movies similar to your basic preferences.");
                System.out.println("2. Movies sorted by genre.");
                System.out.println("3. Movies sorted  by year and by genre.");
                System.out.println("4. Movies sorted by director.");
                System.out.println("5. Movies sorted by genre and length.");
                System.out.println("6. Movies sorted by year and length.");

                int choice = s.nextInt();
                s.nextLine();
                switch (choice) {
                    case 1:
                        movieRunnerSimilarRatings.printSimilarRatings(id, numSimilarRaters, minimalRaters);
                        break;
                    case 2:
                        System.out.println("Please choose a genre. The first letter should be capitalized.");
                        genre = s.nextLine();
                        movieRunnerSimilarRatings.printSimilarRatingsByGenre(id, numSimilarRaters, minimalRaters, genre);
                        break;
                    case 3:

                        System.out.println("Please choose a a year as the earliest value.");
                        year = s.nextInt();
                        s.nextLine();
                        System.out.println("Please choose a genre. The first letter should be capitalized.");
                        genre = s.nextLine();
                        movieRunnerSimilarRatings.printSimilarRatingsByGenreAndYear(id, numSimilarRaters, minimalRaters, genre, year);
                        break;

                    case 4:

                        System.out.println("Please choose the director/s. The first letter should be capitalized. If multiple, separate by a comma without space before it.");
                        director = s.nextLine();
                        movieRunnerSimilarRatings.printSimilarRatingsByDirector(id, numSimilarRaters, minimalRaters, director);
                        break;
                    case 5:

                        System.out.println("Please choose a genre. The first letter should be capitalized.");
                        genre = s.nextLine();
                        System.out.println("Please enter the minimum minutes:");
                        minMinutes = s.nextInt();
                        s.nextLine();
                        System.out.println("Please enter the maximum minutes:");
                        maxMinutes = s.nextInt();
                        s.nextLine();
                        movieRunnerSimilarRatings.printSimilarRatingsByGenreAndMinutes(id, numSimilarRaters, minimalRaters, genre, minMinutes, maxMinutes);
                        break;
                    case 6:

                        System.out.println("Please choose a year as the earliest value.");
                        year = s.nextInt();
                        s.nextLine();
                        System.out.println("Please enter the minimum minutes:");
                        minMinutes = s.nextInt();
                        s.nextLine();
                        System.out.println("Please enter the maximum minutes:");
                        maxMinutes = s.nextInt();
                        s.nextLine();
                        movieRunnerSimilarRatings.printSimilarRatingsByYearAfterAndMinutes(id, numSimilarRaters, minimalRaters, year, minMinutes, maxMinutes);
                        break;
                }

            }
            case "No": {

                //unweighted(objective)  ratings
                System.out.println("Please choose the number of minimum raters for the movies. Recommended:3-5.");
                minimalRaters = s.nextInt();
                s.nextLine();
                System.out.println("Please choose the option for the filters by entering the number in front of your choice.");
                System.out.println("1. Filter movies only by minimum number of raters.");
                System.out.println("2. Filter movies by year.");
                System.out.println("3. Filter movies by directors.");
                System.out.println("4. Filter movies by genre.");
                System.out.println("5. Filter movies by length.");
                System.out.println("6. Filter movies by director and length.");
                System.out.println("7. Filter movies by year and genre.");

                int b =  s.nextInt();
                s.nextLine();
                switch (b) {
                    case 1 -> MovieRunnerWithFilters.printAverageRatings(minimalRaters);
                    case 2 -> {
                        System.out.println("Please enter the year as the earliest value:");
                        year = s.nextInt();
                        s.nextLine();
                        MovieRunnerWithFilters.printAverageRatingsByYear(year, minimalRaters);
                    }
                    case 3 -> {
                        System.out.println("Please enter the director/s. Remember to capitalize each word and, if multiple, separate by a comma without space before it.");
                        director = s.nextLine();
                        MovieRunnerWithFilters.printAverageRatingsByDirectors(director, minimalRaters);
                    }
                    case 4 -> {
                        System.out.println("Please choose the genre. Remember to capitalize the word.");
                        genre = s.nextLine();
                        MovieRunnerWithFilters.printAverageRatingsByGenre(genre, minimalRaters);
                    }
                    case 5 -> {
                        System.out.println("Please choose the mininum value of minutes scope.");
                        minMinutes = s.nextInt();
                        s.nextLine();
                        System.out.println("And now the maximum.");
                        maxMinutes = s.nextInt();
                        s.nextLine();
                        MovieRunnerWithFilters.printAverageRatingsByMinutes(minMinutes, maxMinutes, minimalRaters);
                    }
                    case 6 -> {
                        System.out.println("Please enter the director/s. Remember to capitalize each word and, if multiple, separate by a comma without space before it.");
                        director = s.nextLine();
                        System.out.println("Please choose the mininum value of minutes scope.");
                        minMinutes = s.nextInt();
                        s.nextLine();
                        System.out.println("And now the maximum.");
                        maxMinutes = s.nextInt();
                        s.nextLine();
                        MovieRunnerWithFilters.printAverageRatingsByDirectorsAndMinutes(director, minMinutes, maxMinutes, minimalRaters);
                    }
                    case 7 -> {
                        System.out.println("Please choose the genre. Remember to capitalize the word.");
                        genre = s.nextLine();
                        System.out.println("Please enter the year as the earliest value:");
                        year = s.nextInt();
                        s.nextLine();
                        MovieRunnerWithFilters.printAverageRatingsByYearAfterAndGenre(year, genre, minimalRaters);
                    }
                }
            }
        }
    }



    public static void me(){
        Scanner s=new Scanner(System.in);
        System.out.println("Now we will rate ten movies to determine your personalized recommendations.");
        System.out.println("Rate the following movies from 1 to 10. If uncertain or haven't seen it, choose 5.");
        RaterDatabase.initialize("ratings.csv");

        System.out.println("Please rate Matrix (1999).");
        RaterDatabase.addRaterRating("1049","133093",s.nextInt());
        System.out.println("Please rate Annie Hall (1977).");
        RaterDatabase.addRaterRating("1049","75686",s.nextInt());
        System.out.println("Please rate The Lord of the Rings:The Return of the King(2003).");
        RaterDatabase.addRaterRating("1049","167260",s.nextInt());
        System.out.println("Please rate Inception(2010).");
        RaterDatabase.addRaterRating("1049","1375666",s.nextInt());
        System.out.println("Please rate Schindler's list(1993).");
        RaterDatabase.addRaterRating("1049","108052",s.nextInt());
        System.out.println("Please rate 300: Rise of an Empire(2014).");
        RaterDatabase.addRaterRating("1049","1253863",s.nextInt());
        System.out.println("Please rate  Fast and Furious 6 (2013)");
        RaterDatabase.addRaterRating("1049","1905041",s.nextInt());
        System.out.println("Please rate Mr. 3000.");
        RaterDatabase.addRaterRating("1049","339412",s.nextInt());
        System.out.println("Please rate The Soloist.");
        RaterDatabase.addRaterRating("1049","821642",s.nextInt());
        System.out.println("Please rate Grown Ups(2010).");
        RaterDatabase.addRaterRating("1049","1375670",s.nextInt());

    }
}
