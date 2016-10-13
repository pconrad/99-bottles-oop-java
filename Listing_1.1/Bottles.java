import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class Bottles {
    
    public String song() {
	return verses(99, 0);
    }
    
    public String verses(int hi, int lo) {
	return IntStream
	    .rangeClosed(hi,lo)
	    .mapToObj( n -> verse(n) )
	    .collect(Collectors.joining("\n"));
    }

    public String verse(int n) {
	    String a =  (n == 0 ? "No more" : Integer.toString(n)) +
	    " bottle" + (n != 1 ? "s" : "") +
	    " of beer on the wall, " +
	    (n == 0 ? "no more" : n) + " bottle" + (n!=1 ? "s" : "") + " of beer.\n" +
            ( n > 0 ?
	     ( "Take " + ( n>1 ? "one" : "it") + " down and pass it around" ) :
	     "Go to the store and buy some more"
	      ) + (
		(  ( n-1 < 0 ? 99 : n-1 ) == 0 ) ?  "no more" :  Integer.toString(n-1) +
		"bottle" +
		(n-1!=1  ? "s" : "" ) + " of beer on the wall.\n" ) ;
	    return a;
    }

    public static void main (String [] args) {
	Bottles b = new Bottles();
	String s = b.verse(1);
	System.out.println("s=" + s);
	System.out.println(new Bottles().song());
    }

}
