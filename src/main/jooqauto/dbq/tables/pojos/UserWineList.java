/**
 * This class is generated by jOOQ
 */
package dbq.tables.pojos;


import java.io.Serializable;
import java.sql.Timestamp;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserWineList implements Serializable {

	private static final long serialVersionUID = 676068828;

	private final Integer   userId;
	private final Integer   wineId;
	private final String    listType;
	private final Integer   currentQty;
	private final Timestamp lastUpdate;

	public UserWineList(UserWineList value) {
		this.userId = value.userId;
		this.wineId = value.wineId;
		this.listType = value.listType;
		this.currentQty = value.currentQty;
		this.lastUpdate = value.lastUpdate;
	}

	public UserWineList(
		Integer   userId,
		Integer   wineId,
		String    listType,
		Integer   currentQty,
		Timestamp lastUpdate
	) {
		this.userId = userId;
		this.wineId = wineId;
		this.listType = listType;
		this.currentQty = currentQty;
		this.lastUpdate = lastUpdate;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public Integer getWineId() {
		return this.wineId;
	}

	public String getListType() {
		return this.listType;
	}

	public Integer getCurrentQty() {
		return this.currentQty;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}
}