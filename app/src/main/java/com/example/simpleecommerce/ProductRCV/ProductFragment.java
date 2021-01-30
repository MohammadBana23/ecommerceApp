package com.example.simpleecommerce.ProductRCV;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simpleecommerce.ApiClient;
import com.example.simpleecommerce.MyEndPoints.ProductEndPoints;
import com.example.simpleecommerce.CategoryRCV.Category;
import com.example.simpleecommerce.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductFragment extends Fragment {
    RecyclerView recyclerView;
    ProductAdapter productAdapter;

    public static ProductFragment newInstance(String id) {

        Bundle args = new Bundle();
        args.putString("CAT_ID", id);
        ProductFragment fragment = new ProductFragment();
        fragment.setArguments(args);

        return fragment;
    }

    private static final String TAG = "ProductFragment";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rc_product_fragment,container,false);
        Category category = new Category();

        String categoryId  = getArguments().getString("CAT_ID");


        productAdapter = new ProductAdapter();
        recyclerView = view.findViewById(R.id.rc_product);
        ProductEndPoints service = ApiClient.getInstance().getProductEndPoints();
        service.getByCategoryId(categoryId).enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                List<Product> products = response.body();
                productAdapter.setData(products);
                recyclerView.setAdapter(productAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext(),RecyclerView.VERTICAL,false));
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });
        return view;
    }
}
