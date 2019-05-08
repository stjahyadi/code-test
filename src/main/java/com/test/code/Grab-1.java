import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
	public String solution(int A, int B) {
		int total = A + B;
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < total; i++) {			
			if (result.size() > 2) {
				if (result.get(i - 1).equals("a") && result.get(i - 1).equals("a")) {
					result.add("b");
				}else if(result.get(i - 1).equals("b") && result.get(i - 1).equals("b")){
					result.add("a");
				}
			}
		}
		return Arrays.toString(result.toArray());
	}
}

public class Grab-1 {
	public static void main(String[] args) {
		//System.out.println(solution(5,3));
		System.out.println(solution1(1,4));
	}
	
	public static String solution1(int A, int B) {
		int total = A + B;
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < total; i++) {	
			if(result.isEmpty()){
				result.add("a");
				if(A != 0)
					A--;
			}else{
				if(B != 0 && result.get(i-1).equals("a")){
					result.add("b");
					if(B != 0)
						B--;
				}else if(A!=0 && result.get(i-1).equals("b")){
					result.add("a");
					if(A != 0)
						A--;
				}
			}
		}
		return result.stream().map(Object::toString)
                .collect(Collectors.joining(""));
	}
	
	public static String solution(int A, int B) {
		int total = A + B;
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < total; i++) {	
			if (result.size() > 0) {
				if (result.get(i - 1).equals("a")  && B != 0) {
					if(result.size() > 1 && result.get(i - 2).equals("a")){
						result.add("b");
						if(B != 0){
							B--;
						}
					}else{
						if(A != 0){
							result.add("a");
							if(B != 0){
								B--;
							}
						}
						
					}
					
				}else if(result.get(i - 1).equals("b") && result.get(i - 2).equals("b") && A != 0){
					result.add("a");
					if(A != 0){
						A--;
					}
				}
			}else{
				if (A != 0) {
					result.add("a");
					if(A != 0){
						A--;
					}
				}else if(B != 0){
					result.add("b");
					if(B != 0){
						B--;
					}
				}
			}
		}
		return Arrays.toString(result.toArray());
	}

}