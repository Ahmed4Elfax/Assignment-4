package eg.edu.alexu.csd.datastructure.linkedList;
/**
*
* @author Ahmed Elfax
* @author Khalid Eltawagny
*/
import static java.lang.Math.pow;
public class PolynomialSolver implements IPolynomialSolver {
	/** The A*/
	  private DoublyLinkedList a = new DoublyLinkedList();
	  
	  /** The B*/
	  private DoublyLinkedList b = new DoublyLinkedList();
	 
	  /** The C*/
	  private DoublyLinkedList c = new DoublyLinkedList();
	 
	  /** The R*/
	  private DoublyLinkedList r = new DoublyLinkedList();
	  
	 int max[]=new int [4];
	 int min[]=new int [4];
	@Override
	public void setPolynomial(char poly, int[][] terms) {
		// bubble sort
        order(terms);
        if (poly != 'A' && poly != 'B' && poly != 'C' && poly != 'R') {
			throw new IllegalArgumentException("Operation on polynomial "
		+ poly + " is not permitted");
		}
        if (terms == null || terms.length == 0) {
			throw null;
		}
		for (int i = 0; i < terms.length - 1; i++) {
			if (terms[i][1] < terms[i + 1][1]) {
				throw new RuntimeException();
			}}
		
			switch (poly) {
		      case 'A':
		        if (!a.isEmpty()) {
		          a.clear();
		        } 
		        break;
		      case 'B':
		        if (!b.isEmpty()) {
		          b.clear();
		        } 
		        break;
		      case 'C':
		        if (!c.isEmpty()) {
		          c.clear();
		        } 
		        break;
		      case 'R':
			    if (!r.isEmpty()) {
			      r.clear();
			    } 
			    break;
		      default:
		        break;
		    }
		DoublyLinkedList temp= new DoublyLinkedList();
		int index = 0;
		temp.add(terms[0][0]);
		for (int i = 0; i < terms.length - 1; i++) {
			if (terms[i][1] == terms[i + 1][1]) {
				temp.set(index, (int) temp.get(index)+ terms[i + 1][0]);
			} else if (terms[i][1] - terms[i + 1][1] == 1) {
				temp.add(terms[i + 1][0]);
				index++;
			} else {
				for (int j = terms[i][1] - 1;j > terms[i + 1][1];j--) {
					temp.add(0);
					index++;
				}
				temp.add(terms[i + 1][0]);
			}}
		switch (poly) {
		case 'A':
		a=temp ;
		min[0] = terms [terms.length-1][1];
		max[0] = terms [0][1];
			break;
        case 'B':
		b=temp;	
		min[1] = terms [terms.length-1][1];
		max[1] = terms [0][1];
			break;
        case 'C':
		c=temp;
		min[2] = terms [terms.length-1][1];
		max[2] = terms [0][1];
			break;
        case 'R':
    	r=temp;
    	min[3] = terms [terms.length-1][1];
    	max[3] = terms [0][1];
    			break;
		default:
			break;
		}
	}

	@Override
	public String print(char poly) {
		DoublyLinkedList equ = new DoublyLinkedList();
		int emax=0,emin=0;
		String polynomial = "";
		switch (poly) {
		case 'A':
		equ=a;
        emax = max[0];
        emin = min[0];
			break;
        case 'B':
	    equ = b;
	    emax = max[1];
        emin = min[1];
			break;
        case 'C':
		equ = c;
		emax = max[2];
        emin = min[2];
			break;
        case 'R':
        equ = r;
        emax = max[3];
        emin = min[3];
			break;
		default:
			break;
		}
		
		if (equ.size() == 0) {
			return null;
		}
		int i = 0;
		while (emax >= emin) {
			if (equ.get(i) != null && (int) equ.get(i) != 0) {
				if (emax == 0) {
					polynomial = polynomial +  equ.get(i);
				} else if (emax == 1) {
					if ((int) equ.get(i) != 1) {
						polynomial = polynomial +  equ.get(i) + "x";
					} else {
						polynomial = polynomial + "x";
					}
				} else {
					if ((int) equ.get(i) != 1) {
						polynomial = polynomial + equ.get(i) + "x^" +  emax;
					} else {
						polynomial = polynomial + "x^" + emax;
					}
				}
			}
			if (emax != emin) {
				if ((int) equ.get(i + 1) > 0) {
					polynomial += "+";
				}
			}
			i++;
			emax--;
		
			
		}
	    return polynomial;
	}
	  /*
	   * Clear the polynomial.
	   * @param poly
	   *          name of the polynomial.
	   */
	@Override
	public void clearPolynomial(char poly) {
		switch (poly) {
	      case 'A':
	        if (!a.isEmpty()) {
	          a.clear();
	        } else {
	          throw new RuntimeException("Check Clear");
	        }
	        break;
	      case 'B':
	        if (!b.isEmpty()) {
	          b.clear();
	        } else {
	          throw new RuntimeException("Check Clear");
	        }
	        break;
	      case 'C':
	        if (!c.isEmpty()) {
	          c.clear();
	        } else {
	          throw new RuntimeException("Check Clear");
	        }
	        break;
	      case 'R':
		    if (!r.isEmpty()) {
		      r.clear();
		    } else {
		      throw new RuntimeException("Check Clear");
		    }
		    break;
	      default:
	        break;
	    }
		
	}

	@Override
	public float evaluatePolynomial(char poly, float value) {
		float result=0;
		DoublyLinkedList equ = new DoublyLinkedList();
		int emax=0,emin=0;
		 if (poly != 'A' && poly != 'B' && poly != 'C' && poly != 'R') {
				throw new IllegalArgumentException("Operation on polynomial "
			+ poly + " is not permitted");
			}
		 switch (poly) {
			case 'A':
			equ=a;
	        emax = max[0];
	        emin = min[0];
	        if (a.isEmpty()) {
	        	throw new IllegalArgumentException("No polynomial");}
				break;
	        case 'B':
		    equ = b;
		    emax = max[1];
	        emin = min[1];
	        if (b.isEmpty()) {
	        	throw new IllegalArgumentException("No polynomial");}
				break;
	        case 'C':
			equ = c;
			emax = max[2];
	        emin = min[2];
	        if (c.isEmpty()) {
	        	throw new IllegalArgumentException("No polynomial");}
				break;
	        case 'R':
	        equ = r;
	        emax = max[3];
	        emin = min[3];
	        if (r.isEmpty()) {
	        	throw new IllegalArgumentException("No polynomial");}
				break;
			default:
				break;
			}
	int i=0;
    int coef=0;
    float coef1=0;
    while(emax >= emin ) {
    	
    	if (equ.get(i) != null || (int) equ.get(i) != 0) {
    		coef = (int) equ.get(i);
    		coef1 = (float) coef;
    		result = (float) (result+ (coef1* (pow(value,emax))));
		}
		i++;
		emax--;}
    
		return result;
	}

	@Override
	public int[][] add(char poly1, char poly2) {
           DoublyLinkedList x = new  DoublyLinkedList();
           DoublyLinkedList y = new  DoublyLinkedList();
           if (poly1 != 'A' && poly1 != 'B' && poly1 != 'C' ) {
   			throw new IllegalArgumentException("Operation on polynomial "
   		+ poly1 + " is not permitted");
   		}
           if (poly2 != 'A' && poly2 != 'B' && poly2 != 'C' ) {
   			throw new IllegalArgumentException("Operation on polynomial "
   		+ poly2 + " is not permitted");
   		}   int emax1=0,emax2=0,emin1=0,emin2=0;
           switch (poly1) {
   		   case 'A':
   		   x=a;
   		   emax1 = max[0];
           emin1 = min[0];
   			break;
           case 'B':
   	       x = b;
   	       emax1 = max[1];
           emin1 = min[1];
   			break;
           case 'C':
   		   x = c;
   		   emax1 = max[2];
           emin1 = min[2];
   			break;   
   		default:
   			break;
   		}
           switch (poly2) {
   		   case 'A':
   		   y=a;
   		   emax2 = max[0];
           emin2 = min[0];
   			break;
           case 'B':
   	       y = b;
   	       emax2 = max[1];
           emin2 = min[1];
   			break;
           case 'C':
   		   y = c;
   		   emax2 = max[2];
           emin2 = min[2];
   			break;
   		default:
   			break;
   		}
           int[][] add = new int[x.size() + y.size()][2];
   		if (x.isEmpty()) {
   			throw new IllegalArgumentException("Solver evaluated unseted polynomial");
   		}
   		if (y.isEmpty()) {
   			throw new IllegalArgumentException("Solver evaluated unseted polynomial");
   		}int i;
   		for (i = 0; i < x.size(); i++) {
			add[i][0] = (int) x.get(i);
			add[i][1] = emax1;
			emax1--;
		}
   		for (; i < x.size() + y.size(); i++) {
			add[i][0] = (int) y.get(i - x.size());
			add[i][1] = emax2;
			emax2--;
		}
   		setPolynomial('R', add);
   		int[][] toArr = new int[r.size()][2];
		int l = 0;
		for (int j = 0; r.get(j) != null; j++) {
			if (r.get(j) != (Object) 0) {
				toArr[l][0] = (int) r.get(j);
				toArr[l][1] = max[3] - j;
				l++;
			}
		}
		int count = 0;
		int maxExp = toArr[0][1];
		int size = 0;
		for (int ii = 0; ii < r.size(); ii++) {
			if ((int) r.get(ii) != 0) {
				size++;
			}
		}
		boolean finish=true;
		int array1[][]=new int [][] {{0,0}};
		for(int z=0;z<toArr.length;z++) {
			for(int o=0;o<toArr[0].length;o++) {
				if (toArr[z][o] != 0) {
					finish=false;
					break;
				}
			}
		}
		if(finish==true) {
			return array1;
		}
		int[][] suum = new int[size][2];
		for (int j = 0; j < r.size(); j++) {
			if ((int) r.get(j) != 0) {
				suum[count][0] = (int) r.get(j);
				suum[count][1] = maxExp;
				count++;
			}
			maxExp--;
		}
       return suum;     
	}

	@Override
	public int[][] subtract(char poly1, char poly2) {
		 DoublyLinkedList x = new  DoublyLinkedList();
         DoublyLinkedList y = new  DoublyLinkedList();
         if (poly1 != 'A' && poly1 != 'B' && poly1 != 'C' ) {
 			throw new IllegalArgumentException("Operation on polynomial "
 		+ poly1 + " is not permitted");
 		}
         if (poly2 != 'A' && poly2 != 'B' && poly2 != 'C' ) {
 			throw new IllegalArgumentException("Operation on polynomial "
 		+ poly2 + " is not permitted");
 		}   int emax1=0,emax2=0,emin1=0,emin2=0;
         switch (poly1) {
 		   case 'A':
 		   x=a;
 		   emax1 = max[0];
         emin1 = min[0];
 			break;
         case 'B':
 	       x = b;
 	       emax1 = max[1];
         emin1 = min[1];
 			break;
         case 'C':
 		   x = c;
 		   emax1 = max[2];
         emin1 = min[2];
 			break;   
 		default:
 			break;
 		}
         switch (poly2) {
 		   case 'A':
 		   y=a;
 		   emax2 = max[0];
         emin2 = min[0];
 			break;
         case 'B':
 	       y = b;
 	       emax2 = max[1];
         emin2 = min[1];
 			break;
         case 'C':
 		   y = c;
 		   emax2 = max[2];
         emin2 = min[2];
 			break;
 		default:
 			break;
 		}
         int[][] subtract = new int[x.size() + y.size()][2];
 		if (x.isEmpty()) {
 			throw new IllegalArgumentException("Solver evaluated unseted polynomial");
 		}
 		if (y.isEmpty()) {
 			throw new IllegalArgumentException("Solver evaluated unseted polynomial");
 		}int i;
 		for (i = 0; i < x.size(); i++) {
 			subtract[i][0] = (int) x.get(i);
 			subtract[i][1] = emax1;
			emax1--;
		}
 		for (; i < x.size() + y.size(); i++) {
 			subtract[i][0] = (int) y.get(i - x.size())*-1;
 			subtract[i][1] = emax2;
			emax2--;
		}
 		if (!r.isEmpty()) {
			r.clear();
		}
 		setPolynomial('R', subtract);
 		int[][] toArr = new int[r.size()][2];
		int l = 0;
		for (int j = 0; r.get(j) != null; j++) {
			if (r.get(j) != (Object) 0) {
				toArr[l][0] = (int) r.get(j);
				toArr[l][1] = max[3] - j;
				l++;
			}
		}
		int count = 0;
		int maxExp = toArr[0][1];
		int size = 0;
		for (int ii = 0; ii < r.size(); ii++) {
			if ((int) r.get(ii) != 0) {
				size++;
			}
		}
		boolean finish=true;
		int array1[][]=new int [][] {{0,0}};
		for(int z=0;z<toArr.length;z++) {
			for(int o=0;o<toArr[0].length;o++) {
				if (toArr[z][o] != 0) {
					finish=false;
					break;
				}
			}
		}
		if(finish==true) {
			return array1;
		}
		int[][] suum = new int[size][2];
		for (int j = 0; j < r.size(); j++) {
			if ((int) r.get(j) != 0) {
				suum[count][0] = (int) r.get(j);
				suum[count][1] = maxExp;
				count++;
			}
			maxExp--;
		}
     return suum;     
	}

	@Override
	public int[][] multiply(char poly1, char poly2) {
		 DoublyLinkedList x = new  DoublyLinkedList();
         DoublyLinkedList y = new  DoublyLinkedList();
         if (poly1 != 'A' && poly1 != 'B' && poly1 != 'C' ) {
 			throw new IllegalArgumentException("Operation on polynomial "
 		+ poly1 + " is not permitted");
 		}
         if (poly2 != 'A' && poly2 != 'B' && poly2 != 'C' ) {
 			throw new IllegalArgumentException("Operation on polynomial "
 		+ poly2 + " is not permitted");
 		}   int emax1=0,emax2=0,emin1=0,emin2=0;
         switch (poly1) {
 		   case 'A':
 		   x=a;
 		   emax1 = max[0];
         emin1 = min[0];
 			break;
         case 'B':
 	       x = b;
 	       emax1 = max[1];
         emin1 = min[1];
 			break;
         case 'C':
 		   x = c;
 		   emax1 = max[2];
         emin1 = min[2];
 			break;   
 		default:
 			break;
 		}
         switch (poly2) {
 		   case 'A':
 		   y=a;
 		   emax2 = max[0];
         emin2 = min[0];
 			break;
         case 'B':
 	       y = b;
 	       emax2 = max[1];
         emin2 = min[1];
 			break;
         case 'C':
 		   y = c;
 		   emax2 = max[2];
         emin2 = min[2];
 			break;
 		default:
 			break;
 		}
         int[][] multiply = new int[(x.size()+1) * (y.size()+1)][2];
 		if (x.isEmpty()) {
 			throw new IllegalArgumentException("Solver evaluated unseted polynomial");
 		}
 		if (y.isEmpty()) {
 			throw new IllegalArgumentException("Solver evaluated unseted polynomial");
 		}
 		int counter=0;    int cmax=0;
 		int maxExp=emax1+emax2;
 		for (int i = 0; i < x.size(); i++) {
 			cmax = maxExp;
			for (int j = 0; j < y.size(); j++) {
				multiply[counter][0]
					= (int) x.get(i)
					* (int) y.get(j);
				multiply[counter][1] = cmax;
				cmax--;
				counter++;
			}
			maxExp--;
		}
 		setPolynomial('R', multiply);
 		int count = 0;
		int Max = multiply[0][1];
		int size = 0;
		for (int q = 0; q < r.size(); q++) {
			if ((int) r.get(q) != 0) {
				size++;
			}
		}
		boolean finish=true;
		int array1[][]=new int [][] {{0,0}};
		for(int z=0;z<multiply.length;z++) {
			for(int o=0;o<multiply[0].length;o++) {
				if (multiply[z][o] != 0) {
					finish=false;
					break;
				}
			}
		}
		if(finish==true) {
			return array1;
		}
		int[][] multi = new int[size][2];
		for (int i = 0; i < r.size(); i++) {
			if ((int) r.get(i) != 0) {
				multi[count][0] = (int) r.get(i);
				multi[count][1] = Max;
				count++;
			}
			Max--;
		}
		
 		return multi;
	}
	
	  private void order(final int[][] terms) {
			for (int i = 0; i < terms.length - 1; i++) {
				for (int j = i + 1; j < terms.length; j++) {
					if (terms[j][1] > terms[i][1]) {
						terms[i][1] = terms[j][1] ^ terms[i][1];
						terms[j][1] = terms[j][1] ^ terms[i][1];
						terms[i][1] = terms[j][1] ^ terms[i][1];
						terms[i][0] = terms[j][0] ^ terms[i][0];
						terms[j][0] = terms[j][0] ^ terms[i][0];
						terms[i][0] = terms[j][0] ^ terms[i][0];
					}
				}
			}
	  }
	  /**
	   * Checks if is valid.
	   * @param poly
	   *          the poly.
	   * @return true, if is valid.
	   */
	  public boolean isValid(final char poly) {
	    if (poly == 'A') {
	      if (!a.isEmpty()) {
	        return true;
	      }
	    }
	    if (poly == 'B') {
	      if (!b.isEmpty()) {
	        return true;
	      }
	    }
	    if (poly == 'C') {
	      if (!c.isEmpty()) {
	        return true;
	      }
	    }
	    if (poly == 'R') {
	      if (!r.isEmpty()) {
	        return true;
	      }
	    }
	    return false;
	  }
        
}
