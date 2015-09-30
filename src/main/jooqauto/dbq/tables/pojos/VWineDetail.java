/**
 * This class is generated by jOOQ
 */
package dbq.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class VWineDetail implements Serializable {

	private static final long serialVersionUID = -372736132;

	private final Integer id;
	private final String  wineName;
	private final String  typeName;
	private final Integer wineryId;
	private final String  wineryName;
	private final String  vintage;
	private final String  styleName;
	private final String  wineImageLarge;

	public VWineDetail(VWineDetail value) {
		this.id = value.id;
		this.wineName = value.wineName;
		this.typeName = value.typeName;
		this.wineryId = value.wineryId;
		this.wineryName = value.wineryName;
		this.vintage = value.vintage;
		this.styleName = value.styleName;
		this.wineImageLarge = value.wineImageLarge;
	}

	public VWineDetail(
		Integer id,
		String  wineName,
		String  typeName,
		Integer wineryId,
		String  wineryName,
		String  vintage,
		String  styleName,
		String  wineImageLarge
	) {
		this.id = id;
		this.wineName = wineName;
		this.typeName = typeName;
		this.wineryId = wineryId;
		this.wineryName = wineryName;
		this.vintage = vintage;
		this.styleName = styleName;
		this.wineImageLarge = wineImageLarge;
	}

	public Integer getId() {
		return this.id;
	}

	public String getWineName() {
		return this.wineName;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public Integer getWineryId() {
		return this.wineryId;
	}

	public String getWineryName() {
		return this.wineryName;
	}

	public String getVintage() {
		return this.vintage;
	}

	public String getStyleName() {
		return this.styleName;
	}

	public String getWineImageLarge() {
		return this.wineImageLarge;
	}
}
