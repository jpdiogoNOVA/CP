
public class ApproxPi {
	
	public static final int DEFAULT_POINTS = 1000;
	public static final String TOTAL_POINTS_STAT = "Total number of points: ";
	public static final String POINTS_INSIDE_CIRCLE_STAT = "Points within the circle: ";
	public static final String PI_ESTIMATION_STAT = "Pi estimation: ";

	public static void main(String[] args) {
		
		int points_count  = args.length < 1? DEFAULT_POINTS: Integer.parseInt(args[0]);
		int points_circle = 0;
		double pi_value   = 0.0;
		
		for(int i = 0; i < points_count; i++) {
			double x, y;
			x = Math.random();
			y = Math.random();
			if((x*x + y*y) <= 1)
				points_circle++;
			
		}
		
		pi_value = 4*((double)points_circle)/((double)points_count);
		
		printStatistics(points_count, points_circle, pi_value);
	}
	
	private static void printStatistics(int points_count, int points_circle, double pi_value) {
		System.out.println(TOTAL_POINTS_STAT + points_count);
		System.out.println(POINTS_INSIDE_CIRCLE_STAT + points_circle);
		System.out.println(PI_ESTIMATION_STAT + pi_value);
	}
}
