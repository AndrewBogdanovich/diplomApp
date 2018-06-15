package andrewbogdanovich.github.com.diplomapp.fragments;

import android.app.Fragment;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import andrewbogdanovich.github.com.diplomapp.R;
import andrewbogdanovich.github.com.diplomapp.db.DatabaseHelper;

public class DrinkListFragment extends Fragment {

    ListView userList;
    SimpleCursorAdapter userAdapter;
    SQLiteDatabase db;
    DatabaseHelper databaseHelper;
    Cursor cursor;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_drink_list, container, false);

        databaseHelper = new DatabaseHelper(getActivity());
        databaseHelper.create_db();

        db = databaseHelper.open();
        cursor = db.rawQuery("Select * from " + DatabaseHelper.TABLE, null);
        String[] headers = new String[]{DatabaseHelper.COLUMN_NAME, DatabaseHelper.COLUMN_TYPE};
        userAdapter = new SimpleCursorAdapter(getActivity(), R.layout.two_line_list_item, cursor, headers, new int[]{R.id.name, R.id.type}, 0);
        userList = view.findViewById(R.id.list_fragment_list_view);
        userList.setAdapter(userAdapter);

        /*userList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Object object = userList.getItemAtPosition(position);
            }
        });*/
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        db.close();
        cursor.close();
    }
}
