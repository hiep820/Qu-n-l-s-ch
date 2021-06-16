package BookManagement;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TextBook extends user{
	private float unitPrice;
	private boolean status;
	public TextBook(float unitPrice, boolean status) {
		super();
		this.unitPrice = unitPrice;
		this.status = status;
	}
	public TextBook(int id, int quantum, float price) {
		super(id, quantum, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public float calculateFee() {
		 if(this.status= false) {
			return this.unitPrice/2;
		}
		 else{
			 return this.unitPrice;
		 }
	}
	public static TextBook createObject(ResultSet resultSet)  throws SQLException  {
		int id = resultSet.getInt("id");
       int quantum = resultSet.getInt("quantum");
       float price = resultSet.getFloat("price");
        return new TextBook(id,quantum, price);

    }

	
}
