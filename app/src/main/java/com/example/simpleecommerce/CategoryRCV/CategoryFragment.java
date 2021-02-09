package com.example.simpleecommerce.CategoryRCV;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simpleecommerce.ApiClient;
import com.example.simpleecommerce.ClickOnRCV.OnCategoryRecyclerViewItemClickListener;
import com.example.simpleecommerce.MyEndPoints.MyEndPoints;
import com.example.simpleecommerce.ProductRCV.ProductFragment;
import com.example.simpleecommerce.R;
import com.example.simpleecommerce.models.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryFragment extends Fragment {
    RecyclerView recyclerView;
    CategoryAdapter categoryAdapter;
    TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rc_category_fragment,container,false);
        categoryAdapter = new CategoryAdapter();
        recyclerView = view.findViewById(R.id.rc_category);
        textView = view.findViewById(R.id.txt_category);



        MyEndPoints.CategoryEndPoints service = ApiClient.getInstance().getEndPoints(MyEndPoints.CategoryEndPoints.class);
        service.getAllCategories().enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                if (response.code() == 200){
                    List<Category> categories = response.body();
                    categoryAdapter.setData(categories, new OnCategoryRecyclerViewItemClickListener() {
                        @Override
                        public void onClick(int position) {
                            Category category = categories.get(position);
                            assert getFragmentManager() != null;
                            getFragmentManager().beginTransaction().
                                    replace(R.id.main_container,ProductFragment.newInstance(category.getId())).
                                    commit();
                        }
                    });
                    recyclerView.setAdapter(categoryAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext(),RecyclerView.VERTICAL,false));
                }
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {

            }
        });
        return view;
    }

}
