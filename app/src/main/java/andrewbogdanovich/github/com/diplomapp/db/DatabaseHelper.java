package andrewbogdanovich.github.com.diplomapp.db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static String DB_PATH;
    private static String DB_NAME = "diplomDB.db";

    private static final int SCHEMA = 1;
    public static final String TABLE = "drink";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "drink_name";
    public static final String COLUMN_TYPE = "drink_type";
    public static final String COLUMN_DESCRIPTION = "drink_description";
    public static final String COLUMN_IMAGE = "drink_image";
    private Context myContext;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, SCHEMA);
        this.myContext = context;
        DB_PATH = context.getFilesDir().getPath() + DB_NAME;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void create_db() {
        InputStream myInput = null;
        OutputStream myOutput = null;
        try {
            File file = new File(DB_PATH);
            if (!file.exists()) {
                this.getReadableDatabase();
                myInput = myContext.getAssets().open(DB_NAME);
                String outFileName = DB_PATH;

                myOutput = new FileOutputStream(outFileName);

                byte[] buffer = new byte[1024];
                int length;
                while ((length = myInput.read(buffer)) > 0) {
                    myOutput.write(buffer, 0, length);
                }

                myOutput.flush();
                myOutput.close();
                myInput.close();
            }
        } catch (IOException ex) {
            Log.d("DatabaseHelper", ex.getMessage());
        }
    }

    public SQLiteDatabase open() throws SQLException {

        return SQLiteDatabase.openDatabase(DB_PATH, null, SQLiteDatabase.OPEN_READWRITE);
    }
}
