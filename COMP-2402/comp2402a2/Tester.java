package comp2402a2;
import java.util.List;


/**
 */
public class Tester {
	public static boolean testPart1(List<Integer> ell) {

		// Tester 
		int K = 10000;
		Stopwatch s = new Stopwatch();
		s.start();
		for (int i = 0; i < K; i++) {
			ell.add(i);
		}
		s.stop();
		if (s.elapsedSeconds() > 2) return false;


		//Tester
		s.start();
		for (int i = 0; i < K; i++) {
			ell.add(0, i);
		}
		s.stop();
		if (s.elapsedSeconds() > 2) return false;

		
		// Tester
		s.start();
		for (int i = 0; i < K; i++) {
			ell.add(ell.size()/2, i);
		}
		s.stop();
		if (s.elapsedSeconds() > 2) return false;


		//Tester
		s.start();
		for (int i = 0; i < K; i++) {
			ell.remove(ell.size()-1);
		}
		s.stop();
		if (s.elapsedSeconds() > 2) return false;

		//Tester
		s.start();
		for (int i = 0; i < K; i++) {
			ell.remove(0);
		}
		s.stop();
		if (s.elapsedSeconds() > 2) return false;

		//Tester
		s.start();
		for (int i = 0; i < K; i++) {
			ell.remove(ell.size()/2);
		}
		s.stop();
		if (s.elapsedSeconds() > 2) return false;


		return true;

	}

	public static boolean testPart2(List<Integer> ell) {

		int K = 10000;
		Stopwatch s = new Stopwatch();

		//Tester 
		s.start();
		for (int i = 0; i < K; i++) {
			ell.add(i);
		}
		s.stop();
		if (s.elapsedSeconds() > 2) return false;

		//Tester
		s.start();
		for (int i = 0; i < K; i++) {
			ell.add(0, i);
		}
		s.stop();
		if (s.elapsedSeconds() > 2) return false;

		//Tester
		s.start();
		for (int i = 0; i < K; i++) {
			ell.remove(ell.size()-1);
		}
		s.stop();
		if (s.elapsedSeconds() > 2) return false;

		//Tester
		s.start();
		for (int i = 0; i < K; i++) {
			ell.remove(0);
		}
		s.stop();
		if (s.elapsedSeconds() > 2) return false;


		return true;	}

	public static boolean testPart3(AbstractTable<Integer> ell) {
		int nrows = 9, ncols = 6;
		for (int i = 0; i < ncols; i++) {
			ell.addCol(ell.cols());
		}
		for (int i = 0; i < nrows; i++) {
			ell.addRow(ell.rows());
		}
		for (int i = 1; i <= nrows; i++) {
			ell.set(i-1, (i-1)%ell.cols(), 1111*i);
		}
		ell.addCol(2);
		ell.addRow(3);

		if (ell.get(4, 4) != 4444) return false;
		return true;
	}

}
