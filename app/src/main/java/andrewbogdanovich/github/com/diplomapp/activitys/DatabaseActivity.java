package andrewbogdanovich.github.com.diplomapp.activitys;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import andrewbogdanovich.github.com.diplomapp.R;
import andrewbogdanovich.github.com.diplomapp.db.DatabaseHelper;

public class DatabaseActivity extends AppCompatActivity {
    ListView userList;
    SimpleCursorAdapter userAdapter;
    SQLiteDatabase db;
    DatabaseHelper databaseHelper;
    Cursor cursor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        databaseHelper = new DatabaseHelper(getApplicationContext());
        databaseHelper.create_db();

        db = databaseHelper.open();
        cursor = db.rawQuery("Select * from " + DatabaseHelper.TABLE, null);
        String[] headers = new String[]{DatabaseHelper.COLUMN_NAME, DatabaseHelper.COLUMN_TYPE};
        userAdapter = new SimpleCursorAdapter(this, R.layout.two_line_list_item, cursor, headers,
                new int[]{R.id.name, R.id.type}, 0);

        userList = findViewById(R.id.list);
        userList.setAdapter(userAdapter);
        userList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View v, int position, long id) {
                
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
        cursor.close();
    }
}
