package ru.geekbrains.fragmentnavigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public class ToolbarFragment extends Fragment {

    public ToolbarFragment() {
        // Required empty public constructor
    }

    public static ToolbarFragment newInstance() {
        return new ToolbarFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_toolbar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toolbar toolbar = view.findViewById(R.id.toolbar);

        // toolbar.setNavigationIcon();
        //toolbar.getMenu().findItem(R.id.action_add).setEnabled(false);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.action_settings:
                        Toast.makeText(requireContext(), R.string.action_main, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_favorite:
                        Toast.makeText(requireContext(), R.string.action_favorite, Toast.LENGTH_SHORT).show();
                        break;

                }
                return false;
            }
        });

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(requireContext(), R.string.go_back, Toast.LENGTH_SHORT).show();

                requireActivity().onBackPressed();
            }
        });
    }
}