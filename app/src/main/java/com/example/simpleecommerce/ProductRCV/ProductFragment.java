package com.example.simpleecommerce.ProductRCV;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simpleecommerce.ApiClient;
import com.example.simpleecommerce.MyEndPoints.MyEndPoints;
import com.example.simpleecommerce.ProductRoomDb.ProductDatabase;
import com.example.simpleecommerce.ProductRoomDb.ProductRoom;
import com.example.simpleecommerce.models.Category;
import com.example.simpleecommerce.R;
import com.example.simpleecommerce.ClickOnRCV.OnProductRecyclerViewItemClickListener;
import com.example.simpleecommerce.models.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductFragment extends Fragment {
    RecyclerView recyclerView;
    ProductAdapter productAdapter;
    TextView textView;
    ImageView roomDb;

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
        textView = view.findViewById(R.id.txt_category);



        productAdapter = new ProductAdapter();
        recyclerView = view.findViewById(R.id.rc_product);
        MyEndPoints.ProductEndPoints service = ApiClient.getInstance().getEndPoints(MyEndPoints.ProductEndPoints.class);
        service.getByCategoryId(categoryId).enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                List<Product> products = response.body();
                productAdapter.setData(products);
                recyclerView.setAdapter(productAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()
                        , RecyclerView.VERTICAL, false));
                productAdapter.setListener(new OnProductRecyclerViewItemClickListener() {
                    @Override
                    public void onClick(int position, Product product) {
                        Product myProduct = products.get(position);
                        assert getFragmentManager() != null;
                        getFragmentManager().beginTransaction().
                                replace(R.id.main_container, ProductDetails.newInstance
                                        (myProduct.getName(), myProduct.getDescription()
                                                , myProduct.getRate(), myProduct.getPrice(),myProduct.getCategoryId(),myProduct.getAvailable())).
                                commit();


                    }
                });
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });


        return view;
    }
//    public int makeToast() {
//        Toast.makeText(getActivity(),"There aren't any category",Toast.LENGTH_LONG).show();
//        return 0;
//    }
}
