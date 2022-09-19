
public class StarPrint {
	public static void main(String[] args) {
		printSnowStar();
	}
	
	public static void printSnowStar() {
		for(int i = 0; i < 9; ++i) {
			for(int j = 0; j < 9; ++j) {
				if(i == j || i == 4 || j == 4 || j == 9-i-1) {
					System.out.print(" * ");
				}
				else {
					System.out.print("   ");
				}
			}
			System.out.println();
		}
	}
}
