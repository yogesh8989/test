/**
 * 
 */
package hello;

/**
 * @author ytoke
 *
 */
public class Offer {
	
	private long id;
	private String name;
	
	public Offer(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	

}
