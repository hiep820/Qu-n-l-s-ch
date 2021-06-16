package BookManagement;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Documentation extends user {
	private float unitPrice;
	public Documentation(float unitPrice) {
		super();
		this.unitPrice = unitPrice;
	}

	public Documentation(int id, int quantum, float price) {
		super(id, quantum, price);
	}

	@Override
	public float calculateFee() {
		return this.unitPrice*10/100;
	}

	public static Documentation createObject(ResultSet resultSet)  throws SQLException  {
		int id = resultSet.getInt("id");
       int quantum = resultSet.getInt("quantum");
       float price = resultSet.getFloat("price");
        return new Documentation (id,quantum, price);

    }

}
