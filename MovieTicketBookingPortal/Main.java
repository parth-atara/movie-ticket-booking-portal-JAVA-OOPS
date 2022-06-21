package MovieTicketBookingPortal;

import static java.lang.System.exit;
import java.util.*;
public class Main
{
	public static void main(String[] args) throws InvalidPercentageException, InvalidInputException {
            Scanner st=new Scanner(System.in);
            Scanner sc=new Scanner(System.in);
		Ticket m1 = new Ticket();
		boolean wrong;
		
		System.out.println("\nAdd movie Details\n");
		
		String moviename;
		String moviegenre;
		Double movieimdb;
		int movieduration;
		
                String s;
		System.out.println("Enter movie name");
		moviename=st.nextLine();
		m1.setName(moviename);
		
		System.out.println("Enter movie genre");
		moviegenre=st.nextLine();
		m1.setGenre(moviegenre);
		
		wrong=true;
		while(wrong){
		try{
		System.out.println("Enter movie duration in minutes");
		movieduration=sc.nextInt();
		if(movieduration<0) throw new InvalidInputException();
		m1.setDuration(movieduration);
		wrong=false;
		} catch(InvalidInputException e){
		    System.out.println("Enter integer value only");
		} catch(IllegalArgumentException e){
		    System.out.println("Enter positive value only time cant be negative");
		}
		}
		
		wrong=true;
		while(wrong){
		try{
		System.out.println("Enter movie IMDB ratings");
		movieimdb=sc.nextDouble();
		if(movieimdb<0) throw new InvalidInputException();
		m1.setIMDB(movieimdb);
		wrong=false;
		} catch(IllegalArgumentException e){
		    System.out.println("Enter positive value only imdb rating cant be negative");
		} catch(InvalidInputException e){
		    System.out.println("Enter integer or double value only");
		} 
		}
		
		int ch = 0;
		while(true){
		    
		    wrong=true;
		    while(wrong)
		    try{
		    System.out.println("Enter your choice");
		    System.out.println("1.display movie details");
		    System.out.println("2.Add and Delete screen seat info.");
		    System.out.println("3.Book movie tickets");
		    System.out.println("4.Display booked movie tickets");
		    System.out.println("5.Exit program");
		    
		    ch=sc.nextInt();
		    wrong=false;
		    } catch(IllegalArgumentException e){
		        System.out.println("Enter integer value only");
		    }
		    
		    switch(ch){
		        case 1:{
		            m1.display();
		            
		            break;
		        }
		        case 2:{
		            m1.updatescreeninfo();
		            
		            break;
		        }
		        case 3:{
		            m1.bookticket();
		            
		            break;
		        }
		        case 4:{
		            m1.displaybookedtickets();
		            
		            break;
		        }
		        case 5:{
		            exit (0);
		        }
		        default :{
		            System.out.println("Enter valid choice");
		        }
		    }
		    
		}
		
	}
}
