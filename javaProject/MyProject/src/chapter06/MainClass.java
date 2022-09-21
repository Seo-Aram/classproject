package chapter06;

public class MainClass {

	public static void main(String[] args) {
		int[] korScore = new int[10];
		int[] mathScore = new int[10];
		int[] engScore = new int[10];
		int[][] score = new int[10][3];
		for(int i = 0; i < 10; ++i) {
			korScore[i] = (int)(Math.random() * 100);
			mathScore[i] = (int)(Math.random() * 100);
			engScore[i] = (int)(Math.random() * 100);
			int sum = korScore[i] + mathScore[i] + engScore[i];
			
			System.out.println("==========Data" + (i + 1) + "==========");
			System.out.println("국어: " + korScore[i]
					+ ", 수학: " + mathScore[i]
					+ ", 영어: " + engScore[i]);
			System.out.println("총점: " + sum);
			System.out.println("평균: " + (double)Math.round(((double)sum / 3) * 100) / 100);
		}
		System.out.println();

		for(int i = 0; i < 10; ++i) {
			for(int j = 0; j < 3; ++j) {
				score[i][j] = (int)(Math.random() * 100);
			}
		}
		for(int i = 0; i < 10; ++i) {
			int sum = 0;
			System.out.println("==========Data" + (i + 1) + "==========");
			for(int j = 0; j < 3; ++j) {
				sum += score[i][j];
				System.out.print("과목 " + (j + 1) + ": " + score[i][j] + "\t");
			}
			System.out.println();
			
			System.out.println("총점: " + sum);
			System.out.println("평균: " + (double)Math.round(((double)sum / 3) * 100) / 100);
		}
		System.out.println();

		System.out.println();
		System.out.println("============Student Class============");
		System.out.println();
		
		Student[] students = new Student[10];
		
		for(int i = 0; i < students.length; ++i ) {
			students[i] = new Student("name" + i);
			students[i].setLanguage((int)(Math.random() * 100));
			students[i].setMath((int)(Math.random() * 100));
			students[i].setEnglish((int)(Math.random() * 100));
		}
		
		for(int i = 0; i < students.length; ++i) {
			System.out.println("==========Data" + (i + 1) + "==========");
			System.out.println("이름: " + students[i].getName());
			System.out.println("국어: " + students[i].getLanguage()
					+ ", 수학: " + students[i].getMath()
					+ ", 영어: " + students[i].getEnglish());
			System.out.println("총점: " + students[i].getTotalScore());
			System.out.println("평균: " + students[i].getAverage());
		}

	}

}
