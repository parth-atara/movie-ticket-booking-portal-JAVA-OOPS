package MovieTicketBookingPortal;

//Ticket class
import java.util.*;
/*import java.lang.*;*/
public class Ticket extends Movie{
    //All array initiallized with 0 as default
    private int ticket[];
    private int silver;
    private int gold;
    private int platinum;
    
    //Constructer that will allocate memory to ticket array and initiallize screen seat info.
    public Ticket(){
        ticket=new int[100];
        silver=40;
        gold=50;
        platinum=10;
    }
    
    //All getter setter 
    
    public void setTicket(int k){
        ticket[k]=1;
    }
    
    public int getTicket(int k){
        return ticket[k];
    }
    
    public void setSilver(int k){
        silver=k;
    }
    
    public int getSilver(){
        return silver;
    }
    
    public void setGold(int k){
        gold=k;
    }
    
    public int getGold(){
        return gold;
    }
    
    public void setPlatinum(int k){
        platinum=k;
    }
    
    public int getPlatinum(){
        return platinum;
    }
    
    public void display(){
        System.out.println("---------Movie details---------");
        System.out.println("Name : " + getName());
        System.out.println("Genre : " + getGenre());
        System.out.println("Duration : " + getDuration());
        System.out.println("IMDB : " + getIMDB());
    }
    
    public void updatescreeninfo() throws InvalidPercentageException, InvalidInputException{
        Scanner sc=new Scanner(System.in);
        boolean wrong=true;
        
        System.out.println("Current screen seat info is as below");
        System.out.println("Silver : 1-" + silver);
        if(silver<100)System.out.println("Gold : " + (silver+1) +"-"+ (silver+gold));
        else System.out.println("No gold seats available");
        if(silver+gold<100)System.out.println("Platinum : "+ (silver+gold+1) + "-"+ "100");
        else System.out.println("No platinum seats available");
        
        while(wrong){
        try{
        System.out.println("Enter new silver seat percentage");
        silver=sc.nextInt();
        if(silver<0)throw new IllegalArgumentException();
        if(silver>100)throw new InvalidPercentageException();
        
        System.out.println("Enter new gold seat percentage");
        gold=sc.nextInt();
        if(gold<0)throw new InvalidInputException();
        if(gold>100)throw new InvalidPercentageException();
        if(silver==100)gold=0;
        
        wrong=false;
        } catch(InvalidInputException e){
            System.out.println("Enter integer value only");
        } catch(IllegalArgumentException e){
            System.out.println("Enter positive integer only percentage cant be negative here");
        } catch(InvalidPercentageException e){
            System.out.println("Enter proper values total percentage cant exceed 100 here");
        }
        }
        
        if(silver+gold<100)platinum=100-silver-gold;
        else platinum=0;
        
       // Scanner.close();
    }
    
    public void bookticket(){
        Scanner sc=new Scanner(System.in);
        boolean wrong=true;
        
        System.out.println("Current screen seat info is as below");
        System.out.println("Silver : 1-" + silver);
        if(silver<100)System.out.println("Gold : " + (silver+1) +"-"+ (silver+gold));
        else System.out.println("No gold seats available");
        if(silver+gold<100)System.out.println("Platinum : "+ (silver+gold+1) + "-"+ "100");
        else System.out.println("No platinum seats available");
        
        System.out.println("Available seats");
        
        for(int i=0;i<100;i++)if(ticket[i]==0)System.out.print((i+1)+"  ");
        System.out.println("");
        
        int k = 0;
        while(wrong){
        try{
        System.out.println("Enter a seat no.");
        k=sc.nextInt();
        if(k<1) throw new InvalidInputException();
        wrong=false;
        } catch(InvalidInputException e){
            System.out.println("Enter integer value only");
        } catch(IllegalArgumentException e){
            System.out.println("Enter positive value only seat no. cant be negative");
        }
        }
        
        if(k<1 || k>100)System.out.println("Enter valid seat number from the list");
        else if(ticket[k-1]==1)System.out.println("This seat no. is already booked");
        else{
            ticket[k-1]=1;
            System.out.println("Your seat has been successfully booked");
        }
      //  Scanner.close();
    }
    
    public void displaybookedtickets(){
        System.out.println("Booked seat numbers are as below");
        for(int i=0;i<100;i++)if(ticket[i]==1)System.out.println((i+1)+ "  ");
        System.out.println("");
    }
    
}
