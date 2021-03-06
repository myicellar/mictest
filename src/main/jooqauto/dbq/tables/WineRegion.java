/**
 * This class is generated by jOOQ
 */
package dbq.tables;


import dbq.Public;

import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class WineRegion extends TableImpl<Record> {

	private static final long serialVersionUID = -64727256;

	/**
	 * The reference instance of <code>public.wine_region</code>
	 */
	public static final WineRegion WINE_REGION = new WineRegion();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<Record> getRecordType() {
		return Record.class;
	}

	/**
	 * The column <code>public.wine_region.id</code>.
	 */
	public final TableField<Record, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>public.wine_region.region_name</code>.
	 */
	public final TableField<Record, String> REGION_NAME = createField("region_name", org.jooq.impl.SQLDataType.VARCHAR.length(200), this, "");

	/**
	 * The column <code>public.wine_region.country_id</code>.
	 */
	public final TableField<Record, Integer> COUNTRY_ID = createField("country_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * Create a <code>public.wine_region</code> table reference
	 */
	public WineRegion() {
		this("wine_region", null);
	}

	/**
	 * Create an aliased <code>public.wine_region</code> table reference
	 */
	public WineRegion(String alias) {
		this(alias, WINE_REGION);
	}

	private WineRegion(String alias, Table<Record> aliased) {
		this(alias, aliased, null);
	}

	private WineRegion(String alias, Table<Record> aliased, Field<?>[] parameters) {
		super(alias, Public.PUBLIC, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WineRegion as(String alias) {
		return new WineRegion(alias, this);
	}

	/**
	 * Rename this table
	 */
	public WineRegion rename(String name) {
		return new WineRegion(name, null);
	}
}
