
public class ApproxPi {
	
	public static final int DEFAULT_POINTS = 100000000;
	public static final String TOTAL_POINTS_STAT = "Total number of points: ";
	public static final String POINTS_INSIDE_CIRCLE_STAT = "Points within the circle: ";
	public static final String PI_ESTIMATION_STAT = "Pi estimation: ";

	public static void main(String[] args) throws InterruptedException {
		int points_count  = args.length < 1? DEFAULT_POINTS: Integer.parseInt(args[0]);
		int points_circle = 0;
		double pi_value   = 0.0;
		
		// GET half the points from MAIN THREAD
		int points_circle_m = getPointsCircle(points_count/2);
		// ---------------------------------------------------------
		
		// GET half the points from a THREAD
		final int[] points_circle_t = new int[1];
		Thread t1 = new Thread( () -> {
			
			points_circle_t[0] = getPointsCircle(points_count/2);
		});
		
		t1.start();
		t1.join();
		// ---------------------------------------------------------
		
		/*SUMING BOTH VALUES*/
		points_circle =  points_circle_t[0] + points_circle_m;
		
		pi_value = 4*((double)points_circle)/((double)points_count);
		
		printStatistics(points_count, points_circle, pi_value);
		
	}
	
	private static int getPointsCircle(int points_count) {
		int res = 0;
		
		for(int i = 0; i < points_count; i++) {
			double x, y;
			x = Math.random();
			y = Math.random();
			if((x*x + y*y) <= 1)
				res++;
			
		}
		
		
		return res;
	}
	
	private static void printStatistics(int points_count, int points_circle, double pi_value) {
		System.out.println(TOTAL_POINTS_STAT + points_count);
		System.out.println(POINTS_INSIDE_CIRCLE_STAT + points_circle);
		System.out.println(PI_ESTIMATION_STAT + pi_value);
	}
}
