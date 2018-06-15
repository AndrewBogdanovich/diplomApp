package andrewbogdanovich.github.com.diplomapp.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import andrewbogdanovich.github.com.diplomapp.R;

public class CategoriesFragment extends Fragment  {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_categories, container, false);
        ImageView imageView = view.findViewById(R.id.KEK);
        Picasso.get().load("https://avatars.mds.yandex.net/get-pdb/231404/5e546459-506f-4fba-9d5b-5cf35194ac32/s800").into(imageView);
        return view;
    }
}
