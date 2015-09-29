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
public class WineryBk extends TableImpl<Record> {

	private static final long serialVersionUID = -894378984;

	/**
	 * The reference instance of <code>public.winery_bk</code>
	 */
	public static final WineryBk WINERY_BK = new WineryBk();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<Record> getRecordType() {
		return Record.class;
	}

	/**
	 * The column <code>public.winery_bk.winery_id</code>.
	 */
	public final TableField<Record, Integer> WINERY_ID = createField("winery_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>public.winery_bk.description</code>.
	 */
	public final TableField<Record, String> DESCRIPTION = createField("description", org.jooq.impl.SQLDataType.VARCHAR.length(500), this, "");

	/**
	 * Create a <code>public.winery_bk</code> table reference
	 */
	public WineryBk() {
		this("winery_bk", null);
	}

	/**
	 * Create an aliased <code>public.winery_bk</code> table reference
	 */
	public WineryBk(String alias) {
		this(alias, WINERY_BK);
	}

	private WineryBk(String alias, Table<Record> aliased) {
		this(alias, aliased, null);
	}

	private WineryBk(String alias, Table<Record> aliased, Field<?>[] parameters) {
		super(alias, Public.PUBLIC, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WineryBk as(String alias) {
		return new WineryBk(alias, this);
	}

	/**
	 * Rename this table
	 */
	public WineryBk rename(String name) {
		return new WineryBk(name, null);
	}
}