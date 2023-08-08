
/**
 * Write a description of DirectorsFilter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DirectorsFilter implements Filter {
    private final String[] dir;
    public DirectorsFilter(String directors){
        dir=directors.split(",");
    }

    @Override public boolean satisfies(String id){

        for (String s : dir){
            if (MovieDatabase.getDirector(id).contains(s)){
                return true;
            }

        }
        return false;
    }
}