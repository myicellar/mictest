/**
 * This class is generated by jOOQ
 */
package db.jooq.tables;


import db.jooq.Public;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.6.2"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class WineMaster extends TableImpl<Record> {

	private static final long serialVersionUID = -451159985;

	/**
	 * The reference instance of <code>public.wine_master</code>
	 */
	public static final WineMaster WINE_MASTER = new WineMaster();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<Record> getRecordType() {
		return Record.class;
	}

	/**
	 * The column <code>public.wine_master.wine_id</code>.
	 */
	public final TableField<Record, Integer> WINE_ID = createField("wine_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>public.wine_master.description</code>.
	 */
	public final TableField<Record, String> DESCRIPTION = createField("description", org.jooq.impl.SQLDataType.VARCHAR.length(200), this, "");

	/**
	 * The column <code>public.wine_master.type_id</code>.
	 */
	public final TableField<Record, Integer> TYPE_ID = createField("type_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>public.wine_master.appellation_id</code>.
	 */
	public final TableField<Record, Integer> APPELLATION_ID = createField("appellation_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>public.wine_master.region_id</code>.
	 */
	public final TableField<Record, Integer> REGION_ID = createField("region_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>public.wine_master.varietal_id</code>.
	 */
	public final TableField<Record, Integer> VARIETAL_ID = createField("varietal_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>public.wine_master.winery_id</code>.
	 */
	public final TableField<Record, Integer> WINERY_ID = createField("winery_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * Create a <code>public.wine_master</code> table reference
	 */
	public WineMaster() {
		this("wine_master", null);
	}

	/**
	 * Create an aliased <code>public.wine_master</code> table reference
	 */
	public WineMaster(String alias) {
		this(alias, WINE_MASTER);
	}

	private WineMaster(String alias, Table<Record> aliased) {
		this(alias, aliased, null);
	}

	private WineMaster(String alias, Table<Record> aliased, Field<?>[] parameters) {
		super(alias, Public.PUBLIC, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WineMaster as(String alias) {
		return new WineMaster(alias, this);
	}

	/**
	 * Rename this table
	 */
	public WineMaster rename(String name) {
		return new WineMaster(name, null);
	}
}
