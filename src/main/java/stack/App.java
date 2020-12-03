/**
 * 
 */
package stack;

/**
 * @author umeshkhunt
 *
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stack theStack = new Stack(3);
		theStack.push(20);
		theStack.push(40);
		theStack.push(60);
		theStack.push(80);
		
		while(!theStack.isEmpty()){
			long value = theStack.pop();
			System.out.println(value);
		}

	}
	
	public static String reverseString(String str){
		return str;
	}

}
