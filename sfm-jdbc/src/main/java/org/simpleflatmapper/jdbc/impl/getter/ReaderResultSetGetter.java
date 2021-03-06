package org.simpleflatmapper.jdbc.impl.getter;

import org.simpleflatmapper.converter.Context;
import org.simpleflatmapper.map.getter.ContextualGetter;
import org.simpleflatmapper.reflect.Getter;

import java.io.Reader;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class ReaderResultSetGetter implements Getter<ResultSet, Reader>, ContextualGetter<ResultSet, Reader> {
	private final int column;
	
	public ReaderResultSetGetter(final int column) {
		this.column = column;
	}

	public Reader get(final ResultSet target) throws SQLException {
		return target.getCharacterStream(column);
	}

	@Override
	public Reader get(ResultSet resultSet, Context context) throws Exception {
		return get(resultSet);
	}

	@Override
    public String toString() {
        return "ReaderResultSetGetter{" +
                "property=" + column +
                '}';
    }
}
