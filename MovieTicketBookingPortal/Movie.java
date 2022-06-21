package MovieTicketBookingPortal;

public abstract class Movie {
    private String name;
    private String genre;
    private int duration;
    private double IMDB;
    
    //All getter setter 
    public void setName(String s){
        name=s;
    }
    
    public String getName(){
        return name;
    }
    
    public void setGenre(String s){
        genre=s;
    }
    
    public String getGenre(){
        return genre;
    }
    
    public void setIMDB(double k){
        IMDB=k;
    }
    
    public double getIMDB(){
        return IMDB;
    }
    
    public void setDuration(int k){
        duration=k;
    }
    
    public int getDuration(){
        return duration;
    }
    
}
