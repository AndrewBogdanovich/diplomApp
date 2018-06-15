package andrewbogdanovich.github.com.diplomapp.activitys;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import andrewbogdanovich.github.com.diplomapp.R;
import andrewbogdanovich.github.com.diplomapp.fragments.CategoriesFragment;
import andrewbogdanovich.github.com.diplomapp.fragments.DrinkListFragment;
import andrewbogdanovich.github.com.diplomapp.fragments.OwnFolderFragment;
import andrewbogdanovich.github.com.diplomapp.fragments.SearchFragment;

public class MainActivity extends AppCompatActivity {

    public static final String DRINK_LIST = "Drink list";
    public static final String CATEGORIES = "Categories";
    public static final String SEARCH = "Search";
    public static final String SAVES = "My bar";

    ImageButton buttonDrinkList, buttonCategories, buttonSearch, buttonOwnFolder;
    FragmentTransaction fragmentTransaction;

    DrinkListFragment drinkListFragment;
    CategoriesFragment categoriesFragment;
    SearchFragment searchFragment;
    OwnFolderFragment ownFolderFragment;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        categoriesFragment = new CategoriesFragment();
        drinkListFragment = new DrinkListFragment();
        searchFragment = new SearchFragment();
        ownFolderFragment = new OwnFolderFragment();

        FragmentTransaction fragmentTransaction2 = getFragmentManager().beginTransaction();
        fragmentTransaction2.add(R.id.fragment_linear_layout, drinkListFragment);
        fragmentTransaction2.commit();
        textView = findViewById(R.id.header_name_text_view);
        textView.setText(DRINK_LIST);

        fragmentSelector();
    }

    public void fragmentSelector() {
        buttonDrinkList = findViewById(R.id.footer_drink_list_image_button);
        buttonCategories = findViewById(R.id.footer_categories_image_button);
        buttonSearch = findViewById(R.id.footer_search_image_button);
        buttonOwnFolder = findViewById(R.id.footer_own_save_folder_image_button);

        textView = findViewById(R.id.header_name_text_view);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentTransaction = getFragmentManager().beginTransaction();
                switch (view.getId()) {
                    case R.id.footer_drink_list_image_button:
                        fragmentTransaction.replace(R.id.fragment_linear_layout, drinkListFragment);
                        textView.setText(DRINK_LIST);
                        break;

                    case R.id.footer_categories_image_button:
                        fragmentTransaction.replace(R.id.fragment_linear_layout, categoriesFragment);
                        textView.setText(CATEGORIES);
                        break;

                    case R.id.footer_search_image_button:
                        fragmentTransaction.replace(R.id.fragment_linear_layout, searchFragment);
                        textView.setText(SEARCH);
                        break;

                    case R.id.footer_own_save_folder_image_button:
                        fragmentTransaction.replace(R.id.fragment_linear_layout, ownFolderFragment);
                        textView.setText(SAVES);
                        break;

                }
                fragmentTransaction.commit();
            }
        };
        buttonDrinkList.setOnClickListener(onClickListener);
        buttonCategories.setOnClickListener(onClickListener);
        buttonSearch.setOnClickListener(onClickListener);
        buttonOwnFolder.setOnClickListener(onClickListener);
    }
}

