import java.util.*;


public class InputMenu 
{
    public void display_menu1() 
    {
    	System.out.println("1) Add \n2) View \n3) Delete");
    	System.out.print("Selection: ");
    }
    
    public void display_menu2()
    {
    	System.out.println("0) Back \n 1)Circle \n 2)Square");
    	System.out.print("Selection");
    }
    
    public void question()
    {
		System.out.println("Would you like to proceed or quit?");
		System.out.println("To proceed enter 9.");
		System.out.println("If you wish to quit enter 0.");
		try (Scanner q = new Scanner(System.in)) 
		{
			switch (q.nextInt()) 
			{
			    case 0:
				    System.out.println ("Thank you and godbye.");
				    break;
			    case 9:
				    System.out.println ("Please proceed.");
				    new InputMenu();
				    break;
			    default:
			    	System.err.println ( "Unrecognized option" );
			    	break;
			}
		}
    }
 
    public InputMenu() 
    {
		try (Scanner in = new Scanner(System.in)) 
		{
			display_menu1();
	  
			switch (in.nextInt()) 
			{			
			    case 1:
				    add();
				    break;
			    case 2:
				    System.out.println ( "You picked option 2" );
				    question();
				    break;
			    case 3:
				    System.out.println ( "You picked option 3" );
				    try(Scanner in1 = new Scanner(System.in))
				    {
				        display_menu2();				        
				        switch(in1.nextInt())
				        {
				        case 0:
				        	question();
				        	break;
				        case 1:
				        	deleteCircle();
				        	break;
				        case 2:
				        	deleteSquare();
				        	break;
				        }
				     }
				    break;
			    default:
				    System.err.println ( "Unrecognized option" );
				    break;
			}
		}
	 }
	
    public void add()
    {
    	Shape shape;
		try {
			shape = (Shape)Class.forName("Square").newInstance();
			shape.draw();
 		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		question();
    }
    
    public void deleteCircle()
    {
    	System.out.println("The circle has been deleted");
    	question();
    }
    public void deleteSquare()
    {
    	System.out.println("This square has been deleted");
    	question();
    }

	public static void main (String[]args) 
    {
	new InputMenu();
    }
}
