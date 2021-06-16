package BookManagement;

public abstract class user {
	private int id;
    private int quantum;
    private float price;
    public user(){
    	
    }
    
    public user(int id,int quantum, float price) {
    	this.id=id;
    	this.quantum=quantum;
    	this.price=price;  	
    }
    public abstract float calculateFee();
}
