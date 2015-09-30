/**
 * This class is generated by jOOQ
 */
package dbq.tables.pojos;


import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class VUserReview implements Serializable {

	private static final long serialVersionUID = -1836267889;

	private final Integer    id;
	private final String     wineName;
	private final String     typeName;
	private final String     wineryName;
	private final String     vintage;
	private final String     styleName;
	private final String     wineImageSmall;
	private final UUID       userId;
	private final Date       reviewDate;
	private final BigDecimal rating;
	private final String     comment;
	private final Integer    sortSeq;

	public VUserReview(VUserReview value) {
		this.id = value.id;
		this.wineName = value.wineName;
		this.typeName = value.typeName;
		this.wineryName = value.wineryName;
		this.vintage = value.vintage;
		this.styleName = value.styleName;
		this.wineImageSmall = value.wineImageSmall;
		this.userId = value.userId;
		this.reviewDate = value.reviewDate;
		this.rating = value.rating;
		this.comment = value.comment;
		this.sortSeq = value.sortSeq;
	}

	public VUserReview(
		Integer    id,
		String     wineName,
		String     typeName,
		String     wineryName,
		String     vintage,
		String     styleName,
		String     wineImageSmall,
		UUID       userId,
		Date       reviewDate,
		BigDecimal rating,
		String     comment,
		Integer    sortSeq
	) {
		this.id = id;
		this.wineName = wineName;
		this.typeName = typeName;
		this.wineryName = wineryName;
		this.vintage = vintage;
		this.styleName = styleName;
		this.wineImageSmall = wineImageSmall;
		this.userId = userId;
		this.reviewDate = reviewDate;
		this.rating = rating;
		this.comment = comment;
		this.sortSeq = sortSeq;
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

	public String getWineryName() {
		return this.wineryName;
	}

	public String getVintage() {
		return this.vintage;
	}

	public String getStyleName() {
		return this.styleName;
	}

	public String getWineImageSmall() {
		return this.wineImageSmall;
	}

	public UUID getUserId() {
		return this.userId;
	}

	public Date getReviewDate() {
		return this.reviewDate;
	}

	public BigDecimal getRating() {
		return this.rating;
	}

	public String getComment() {
		return this.comment;
	}

	public Integer getSortSeq() {
		return this.sortSeq;
	}
}