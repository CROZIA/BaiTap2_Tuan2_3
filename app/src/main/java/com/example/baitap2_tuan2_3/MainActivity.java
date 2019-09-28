package com.example.baitap2_tuan2_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    Spinner spinner;
    EditText ed_Ma,ed_Ten;
    Button nhap;
    ListView lvSp;
    ArrayList<Catalog> arraySpinner=new ArrayList<Catalog>();
    ArrayAdapter<Catalog> adapterSpinner=null;
    ArrayList<Product> arrayListView=new ArrayList<Product>();
    ArrayAdapter<Product> adapterListView=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWidgetControl();
        fakeDataCatalog();
        addEventsFormWidgets();
    }
    private void getWidgetControl() {
        spinner=(Spinner)findViewById(R.id.spinner_Dm);
        ed_Ma=(EditText)findViewById(R.id.editText_Ma);
        ed_Ten=(EditText)findViewById(R.id.editText_Ten);
        nhap=(Button)findViewById(R.id.button_Nhap);
        lvSp=(ListView)findViewById(R.id.listView_Sp);

        adapterSpinner=new ArrayAdapter<Catalog>(this,android.R.layout.simple_spinner_item,arraySpinner);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapterSpinner);

        adapterListView=new ArrayAdapter<Product>(this, android.R.layout.simple_list_item_1,arrayListView);
        lvSp.setAdapter(adapterListView);

    }
    private void fakeDataCatalog() {

        Catalog cat1=new Catalog("1","Samsung");
        Catalog cat2=new Catalog("2","Iphone");
        Catalog cat3=new Catalog("3","Ipad");
        arraySpinner.add(cat1);
        arraySpinner.add(cat2);
        arraySpinner.add(cat3);
        adapterSpinner.notifyDataSetChanged();

    }
    private void addEventsFormWidgets() {
        nhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addProductForCatalog();
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                loadListProductByCatalog(arraySpinner.get(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void loadListProductByCatalog(Catalog catalog) {
        arrayListView.clear();
        arrayListView.addAll(catalog.getProductArrayList());
        adapterListView.notifyDataSetChanged();
    }

    private void addProductForCatalog() {
        Product p=new Product();
        p.setId(ed_Ma.getText()+"");
        p.setName(ed_Ten.getText()+"");
        Catalog c=(Catalog)spinner.getSelectedItem();
        c.addProduct(p);
        loadListProductByCatalog(c);

    }
}
