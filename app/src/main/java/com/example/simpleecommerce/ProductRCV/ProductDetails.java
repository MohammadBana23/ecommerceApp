package com.example.simpleecommerce.ProductRCV;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.simpleecommerce.ProductRoomDb.ProductDatabase;
import com.example.simpleecommerce.ProductRoomDb.ProductRoom;
import com.example.simpleecommerce.R;

import java.util.ArrayList;

public class ProductDetails extends Fragment {
    private TextView detailName;
    private TextView detailDescription;
    private TextView detailRate;
    private TextView detailPrice;
    ArrayList<String> userList;
    ArrayAdapter<String> adapter;
    EditText edtText;
    Button btnAdd;
    Button btnDelete;
    ListView listView;
    ImageView roomDb;

    public static ProductDetails newInstance(String name,String description,int rate,int price,String categoryId , boolean isAvailable) {
        Bundle args = new Bundle();
        args.putString("DESC", description);
        args.putString("NAME", name);
        args.putInt("RATE", rate);
        args.putInt("PRICE", price);
        args.putString("CATEGORY_ID", categoryId);
        args.putBoolean("AVAILABLE", isAvailable);
        ProductDetails fragment = new ProductDetails();
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.product_detail,container,false);
        String productName  = getArguments().getString("NAME");
        String productDescription  = getArguments().getString("DESC");
        String productCatId  = getArguments().getString("CATEGORY_ID");
        Boolean productIsAvailable = getArguments().getBoolean("AVAILABLE");
        int  productRate  = getArguments().getInt("RATE");
        int productPrice  = getArguments().getInt("PRICE");


        roomDb = view.findViewById(R.id.img_room_db);
        detailName = view.findViewById(R.id.txt_product_detail_name);
        detailDescription = view.findViewById(R.id.txt_product_detail_description);
        detailRate = view.findViewById(R.id.txt_product_detail_rate);
        detailPrice = view.findViewById(R.id.txt_product_detail_price);



        detailName.setText("Name : " + productName);
        detailDescription.setText("Description : " + productDescription);
        detailRate.setText("Rate : " + productRate);
        detailPrice.setText("Price : " + productPrice);


        roomDb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductDatabase productRoomDb = ProductDatabase.getInstance(getActivity());
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        productRoomDb.productDao().createProduct(new ProductRoom
                                (productName,productDescription,productRate,productPrice,productIsAvailable,productCatId));
                    }
                }).start();
            }
        });



        listView = view.findViewById(R.id.lv_of_comment);
        edtText = view.findViewById(R.id.edt_add_comment);
        btnAdd = view.findViewById(R.id.btn_add);
        btnDelete = view.findViewById(R.id.btn_delete);
        userList = new ArrayList<>();
        adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_multiple_choice,
                userList);
        listView.setAdapter(adapter);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtText != null){
                    userList.add(edtText.getText().toString());
                    edtText.setText("");
                    adapter.notifyDataSetChanged();
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SparseBooleanArray positionchecker = listView.getCheckedItemPositions();
                int count = listView.getCount();
                for (int i = count - 1 ; i >= 0 ; i--){
                    if (positionchecker.get(i)){
                        adapter.remove(userList.get(i));
                    }
                }
                positionchecker.clear();
                adapter.notifyDataSetChanged();
            }
        });
        return view;
    }
}
