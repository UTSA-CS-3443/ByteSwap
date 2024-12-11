package edu.utsa.cs3443.byteswap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * A helper class to manage database creation, version management, and user-related operations.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    /**
     * Name of the database file.
     */
    private static final String DATABASE_NAME = "users.db";
    /**
     * Database version. Increment this value when the schema changes.
     */
    private static final int DATABASE_VERSION = 1;

    /**
     * Name of the table to store user information.
     */
    private static final String TABLE_USERS = "users";
    /**
     * Column name for storing usernames.
     */
    private static final String COLUMN_USERNAME = "username";
    /**
     * Column name for storing passwords.
     */
    private static final String COLUMN_PASSWORD = "password";

    /**
     * Constructs a new instance of {@link DatabaseHelper}.
     *
     * @param context The context to use for locating paths to the database.
     */
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Called when the database is created for the first time.
     *
     * @param db The database.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_USERS + " (" +
                COLUMN_USERNAME + " TEXT PRIMARY KEY, " +
                COLUMN_PASSWORD + " TEXT)";
        db.execSQL(createTable);
    }

    /**
     * Called when the database needs to be upgraded.
     *
     * @param db         The database.
     * @param oldVersion The old database version.
     * @param newVersion The new database version.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    /**
     * Adds a new user to the database.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     * @return {@code true} if the user was added successfully, {@code false} otherwise.
     */
    public boolean addUser(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, username);
        values.put(COLUMN_PASSWORD, password);
        long result = db.insert(TABLE_USERS, null, values);
        return result != -1;
    }

     /**
     * Validates a user's credentials by checking the database.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     * @return {@code true} if the credentials are valid, {@code false} otherwise.
     */
    public boolean validateUser(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USERS,
                new String[]{COLUMN_USERNAME},
                COLUMN_USERNAME + "=? AND " + COLUMN_PASSWORD + "=?",
                new String[]{username, password},
                null, null, null);
        boolean isValid = cursor.getCount() > 0;
        cursor.close();
        return isValid;
    }
}
