/* Anna Tolen
APCS1 pd10
HW20 -- Karmacomma
2015-10-22 */

public class Commafier {
    // helper function lastThree() returns the last three digits of int n
    public static String lastThree( int n ) {
	String retStr = "";
	for(int i = n; i < 100; i += 90) {
	    retStr += 0;
	}
	return retStr + n;
    }

    // commafy() takes a non-negative integer input and returns the number as a String with commas inserted appropriately

    public static String commafyR( int n ) { // employs recursion
	String retStr = "";
	if( (n > 999) && ((n % 10) >= 0 ) ) {
	    String lastThree = lastThree(n % 1000);
	    retStr += commafyR( n / 1000 ) + "," + lastThree;
	}
	else {
	    retStr += n;
	}
	return retStr;
    }
    
    public static String commafyF( int n ) { // employs for loop
	String retStr = "";
	if( n < 999 ) {
	    retStr += n;
	}
	else {
	    retStr += n / 1000 + ",";
	    String lastThree = lastThree(n % 1000);
	    retStr += lastThree;
	}
	return retStr;
    }
    
    public static String commafyTBM( int n ) {
	String retStr = n + "";
	int i = retStr.length();
	while( i > 3 ) {
	    retStr = retStr.substring(0,i-3) + "," + retStr.substring(i-3);
	    i -= 3;
	}
	return retStr;
    }
    
    public static void main( String[] args ) {
	for( String s : args ) {
	    int temp = Integer.parseInt(s);
      	    System.out.println(commafyF(temp));
      	    System.out.println(commafyR(temp));
	    System.out.println(commafyTBM(temp));
	}
    }
}
