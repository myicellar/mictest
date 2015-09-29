/**
 * This class is generated by jOOQ
 */
package dbq.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CategoriesType implements Serializable {

	private static final long serialVersionUID = -1240692083;

	private final Integer categoriesTypeId;
	private final String  description;

	public CategoriesType(CategoriesType value) {
		this.categoriesTypeId = value.categoriesTypeId;
		this.description = value.description;
	}

	public CategoriesType(
		Integer categoriesTypeId,
		String  description
	) {
		this.categoriesTypeId = categoriesTypeId;
		this.description = description;
	}

	public Integer getCategoriesTypeId() {
		return this.categoriesTypeId;
	}

	public String getDescription() {
		return this.description;
	}
}