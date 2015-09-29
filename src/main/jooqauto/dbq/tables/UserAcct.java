/**
 * This class is generated by jOOQ
 */
package dbq.tables;


import dbq.Public;

import java.sql.Timestamp;

import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserAcct extends TableImpl<Record> {

	private static final long serialVersionUID = -1875202779;

	/**
	 * The reference instance of <code>public.user_acct</code>
	 */
	public static final UserAcct USER_ACCT = new UserAcct();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<Record> getRecordType() {
		return Record.class;
	}

	/**
	 * The column <code>public.user_acct.id</code>.
	 */
	public final TableField<Record, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>public.user_acct.email</code>.
	 */
	public final TableField<Record, String> EMAIL = createField("email", org.jooq.impl.SQLDataType.VARCHAR.length(100), this, "");

	/**
	 * The column <code>public.user_acct.password</code>.
	 */
	public final TableField<Record, String> PASSWORD = createField("password", org.jooq.impl.SQLDataType.VARCHAR.length(100), this, "");

	/**
	 * The column <code>public.user_acct.last_login</code>.
	 */
	public final TableField<Record, Timestamp> LAST_LOGIN = createField("last_login", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

	/**
	 * The column <code>public.user_acct.is_verified</code>.
	 */
	public final TableField<Record, Boolean> IS_VERIFIED = createField("is_verified", org.jooq.impl.SQLDataType.BOOLEAN, this, "");

	/**
	 * Create a <code>public.user_acct</code> table reference
	 */
	public UserAcct() {
		this("user_acct", null);
	}

	/**
	 * Create an aliased <code>public.user_acct</code> table reference
	 */
	public UserAcct(String alias) {
		this(alias, USER_ACCT);
	}

	private UserAcct(String alias, Table<Record> aliased) {
		this(alias, aliased, null);
	}

	private UserAcct(String alias, Table<Record> aliased, Field<?>[] parameters) {
		super(alias, Public.PUBLIC, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserAcct as(String alias) {
		return new UserAcct(alias, this);
	}

	/**
	 * Rename this table
	 */
	public UserAcct rename(String name) {
		return new UserAcct(name, null);
	}
}