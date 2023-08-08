
/**
 * Write a description of MinutesFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MinutesFilter implements Filter {
private final int minimum;
private final int maximum;
	
	public MinutesFilter(int min, int max) {
		minimum = min;
		maximum= max;
	}
	
	@Override
	public boolean satisfies(String id) {
	    int time=MovieDatabase.getMinutes(id);
        return time >= minimum && time <= maximum;
    }
}


