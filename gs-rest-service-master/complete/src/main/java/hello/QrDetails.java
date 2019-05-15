/**
 * 
 */
package hello;

/**
 * @author ytoke
 *
 */
public class QrDetails {

	private long qrId;
	private String qrName;
	
	public QrDetails(long id, String name) {
		this.setQrId(id);
		this.setQrName(name);
	}
	
	

	public long getQrId() {
		return qrId;
	}

	public void setQrId(long qrId) {
		this.qrId = qrId;
	}



	public String getQrName() {
		return qrName;
	}



	public void setQrName(String qrName) {
		this.qrName = qrName;
	}

}
