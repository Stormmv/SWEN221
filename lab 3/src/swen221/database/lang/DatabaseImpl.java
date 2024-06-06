package swen221.database.lang;

import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.validation.Schema;

/**
 * The third part of the lab is to construct a class DatabaseImpl which
 * implements the Database
 * interface. You should update method DatabaseFileReader.read() to return an
 * appropriate instance
 * of DatabaseImpl. You will also need to implement all methods from the
 * Database interface correctly.
 * Having done this, you should find that all tests now pass.
 * 
 */
public class DatabaseImpl implements Database {
    private ColumnType[] schema;
    private int keyField;
    private ArrayList<Object[]> rows;

    public DatabaseImpl(ColumnType[] schema, int keyField, ArrayList<Object[]> rows) {
        this.schema = schema;
        this.keyField = keyField;
        this.rows = rows;
    }

    @Override
    public ColumnType[] getSchema() {
        return schema;
    }

    @Override
    public int getKeyField() {
        return keyField;
    }

    @Override
    public int size() {
        return rows.size();
    }

    @Override
    public void addRow(Object... data) throws InvalidRowException, DuplicateKeyException {
        for (Object[] row : rows) {
            if (row[keyField].equals(data[keyField])) {
                throw new DuplicateKeyException();
            }
        }
        if (data.length != schema.length) {
            throw new InvalidRowException();
        }
        for (int i = 0; i < schema.length; i++) {
            if (schema[i].getType() instanceof RowType.Integer) {
                if (!(data[i] instanceof Integer)) {
                    throw new InvalidRowException();
                }
            } else {
                if (!(data[i] instanceof String)) {
                    throw new InvalidRowException();
                }
            }
        }
        rows.add(data);
    }

    @Override
    public Object[] getRow(Object key) throws InvalidKeyException {
        for (Object[] row : rows) {
            if (row[keyField].equals(key)) {
                return row;
            }
        }
        throw new InvalidKeyException();
    }

    @Override
    public Object[] getRow(int index) throws IndexOutOfBoundsException {
        return rows.get(index);
    }
}
