/*
 * Lab2Tester.java
 *
 * A tester for the methods in Lab2.java
 *
 */
import java.util.Arrays;

public class Lab2Tester {
    
	private static int testPassCount = 0;
	private static int testCount = 0;

	// for approximate comparison of floating point numbers
	private static final double THRESHOLD = 0.01;

	public static void main(String[] args) {
		
		testGetHigherGradeStudent();
		testIsGradeAbove();
		testGetClasslist();
		testCountAbove();
		testGetClassAverage();
		testRegisterStudent();

		System.out.println("Passed " + testPassCount + " / " + testCount + " tests");
	}
	
	public static void testGetHigherGradeStudent() {
		// TODO: once you have implemented getHigherGradeStudent in Lab2.java
		//  uncomment the following tests - make sure you understand what they are testing

		
		Student s0  = new Student("abc", 50);
		Student s1a = new Student("def", 56);
		Student s1b = new Student("xyz", 56);
		Student s2  = new Student("xyz", 99);

		Student result;

		result = Lab2.getHigherGradeStudent(s0,s1a);
		System.out.println("should be  " + s1a + " is " + result);
		displayResults(result.equals(s1a), "testGetHigherGradeStudent");

		result = Lab2.getHigherGradeStudent(s1a,s0);
		System.out.println("should be  " + s1a + " is " + result);
		displayResults(result.equals(s1a), "testGetHigherGradeStudent");

		result = Lab2.getHigherGradeStudent(s1b,s1a);
		System.out.println("should be  " + s1b + " is " + result);
		displayResults(result.equals(s1b) && result == s1b, "testGetHigherGradeStudent");

		result = Lab2.getHigherGradeStudent(s1b,s2);
		System.out.println("should be  " + s2 + " is " + result);
		displayResults(result.equals(s2), "testGetHigherGradeStudent");
		
	}

	public static void testIsGradeAbove() {
		// TODO: write tests for Lab2.isGradeAbove
		Student s0  = new Student("abc", 50);
		Student s1 = new Student("def", 56);
		Student s2  = new Student("xyz", 99);

		int t1 = 49;
		int t2 = 51;
		int t3 = 56;
		int t4 = 100;

		boolean result;

		result = Lab2.isGradeAbove(s0,t1);
		System.out.println("should be  " + true + " is " + result);
		displayResults(result == true, "testIsGradeAbove");

		result = Lab2.isGradeAbove(s0,t2);
		System.out.println("should be  " + false + " is " + result);
		displayResults(result == false, "testIsGradeAbove");

		result = Lab2.isGradeAbove(s1,t3);
		System.out.println("should be  " + false + " is " + result);
		displayResults(result == false, "testIsGradeAbove");

		result = Lab2.isGradeAbove(s2,t4);
		System.out.println("should be  " + false + " is " + result);
		displayResults(result == false, "testIsGradeAbove");


	}

	public static void testGetClasslist() {
		// TODO: write tests for Lab2.getClasslist

		// NOTE: the Arrays library has been imported for you.
		//       you can use the Arrays.equals method to compare
		//       2 arrays of String objects as String has a equals method
		// The API for Arrays.equals:
		//       equals(Object[] a, Object[] a2)
		//       Returns true if the two specified arrays are equal to one another.

		// TODO: once you have implemented getClasslist in Lab2.java
		// uncomment the following test. We have gotten you started with 
		// some initial test data and one test, but you should consider 
		// other cases (empty array, longer array)

		
		Student s0  = new Student("abc", 50);
		Student s1 = new Student("def", 56);
		Student s2  = new Student("xyz", 99);

		Student[] student0 = {};
		String[] expected0 = {};

		Student[] students1 = {s0};
		String[] expected1 = {"abc"};

		Student[] students2 = {s0, s1, s2};
		String[] expected2 = {"abc", "def", "xyz"};

		String[] result;

		result = Lab2.getClasslist(student0);
		displayResults(Arrays.equals(result, expected0), "testGetClasslist - 0 elements");

		result = Lab2.getClasslist(students1);
		displayResults(Arrays.equals(result, expected1), "testGetClasslist - 1 elements");
		
		result = Lab2.getClasslist(students2);
		displayResults(Arrays.equals(result, expected2), "testGetClasslist - 3 elements");
	}


	public static void testCountAbove() {
		// TODO: write tests for Lab2.countAbove
		Student s1 = new Student("abc", 50);
		Student s2 = new Student("def", 88); 
		Student s3 = new Student("xyz", 99);
		Student s0 = new Student();

		Student[] students0 = {};
		Student[] students1 = {s0};
		Student[] students2 = {s1, s2, s3};
		Student[] students3 = {s0, s1, s2};

		int t1 = 49;
		int t2 = 56;
		int t3 = 90;
		int t4 = 100;

		int result;

		result = Lab2.countAbove(students0, t1);
		displayResults(result == 0, "testCountAbove - 0 students");

		result = Lab2.countAbove(students1, t1);
		displayResults(result == 0, "testCountAbove - 1 empty students");

		result = Lab2.countAbove(students2, t1);
		displayResults(result == 3, "testCountAbove - 3 students");

		result = Lab2.countAbove(students2, t3);
		displayResults(result == 1, "testCountAbove - 3 students");

	}


	public static void testGetClassAverage() {
		Student s0 = new Student("abc", 50);
		Student s1 = new Student(); // considered invalid for average average calculation
		Student s2 = new Student("xyz", 99);
		Student s3 = new Student("def", 88);

		Student[] students0 = {};
		Student[] students1 = {s0};
		Student[] students2 = {s0, s1, s2};
		Student[] students3 = {s0, s2, s3};

		double result = 0.0;
		double expected = 0.0;
		
		// Some of you noticed in Lab1 that floating point arithmetic sometimes
		// produces results with many decimals places. We use the threshold
		// (defined as a global variable at the top) to specify the margin 
		// of error we are okay with, and just make sure the expected and 
		// returned results are within the threshold of acceptable error.

		
		result = Lab2.getClassAverage(students0);
		expected = 0;
		displayResults(Math.abs(result-expected)<THRESHOLD, "testGetClasslist - empty");

		result = Lab2.getClassAverage(students1);
		expected = 50.0;
		displayResults(Math.abs(result-expected)<THRESHOLD, "testGetClasslist - 1 student");

		result = Lab2.getClassAverage(students2);
		expected = (50 + 99) / 2.0; // because s1 does not have a "real" grade
		displayResults(Math.abs(result-expected)<THRESHOLD, "testGetClasslist - 3 students, count 2");

		result = Lab2.getClassAverage(students3);
		expected = (50 + 99 + 88) / 3.0;
		displayResults(Math.abs(result-expected)<THRESHOLD, "testGetClasslist - 3 students, count 3");
        
	}

	public static void testRegisterStudent() {
		// TODO: write tests for Lab2.registerStudent
		// HINT: the Student class also has a equals method so you
		// can use Arrays.equals again to compare 2 Student arrays
		Student s0 = new Student("abc", 50);
		Student s1 = new Student(); // considered invalid for average average calculation
		Student s2 = new Student("xyz", 99);
		Student s3 = new Student("def", 88);

		Student[] students0 = {};
		Student[] students1 = {s0};
		Student[] students2 = {s0, s1, s2};
		Student[] students3 = {s0, s2, s3};

		Student[] result;
		Student[] expected;

		result = Lab2.registerStudent(students0, s0);
		expected = new Student[]{s0};
		displayResults(Arrays.equals(result, expected), "registerStudent - 1 element");

		result = Lab2.registerStudent(students1, s1);
		expected = new Student[]{s0, s1};
		displayResults(Arrays.equals(result, expected), "registerStudent - 2 element");

		result = Lab2.registerStudent(students2, s2);
		expected = new Student[]{s0, s1, s2, s2};
		displayResults(Arrays.equals(result, expected), "registerStudent - 4 element");

	}
	
	public static void displayResults (boolean passed, String testName) {
		/* There is some magic going on here getting the line number
		 * Borrowed from:
		 * http://blog.taragana.com/index.php/archive/core-java-how-to-get-java-source-code-line-number-file-name-in-code/
		 */
		
		testCount++;
		if (passed) {
			System.out.println ("Passed test: " + testName);
			testPassCount++;
		} else {
			System.out.println ("Failed test: " + testName + " at line "
								+ Thread.currentThread().getStackTrace()[2].getLineNumber());
		}

	}

}
