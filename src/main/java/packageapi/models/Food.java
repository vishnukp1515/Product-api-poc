package packageapi.models;



import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;


@Table("product")
public class Food {

	@Id
	@PrimaryKey
	private String id;
	private String name;
	private int price;
	
	public Food() {
		
	}
	
	public Food(String id, String name, int price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public String getId() {

		return id;
	}

	public void setId(String id) {

		this.id = id;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public int getPrice() {

		return price;
	}

	public void setPrice(int price) {

		this.price = price;
	}

	
}

