package com.example.registertest;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class ChooseCityActivity extends AppCompatActivity {
    private String[] provinces=new String[]{"广东","江西","浙江"};
    private String[][] cities=new String[][]{{"广州","佛山","潮州","汕头"},{"南昌","九江","吉安","上饶"},{"杭州","温州","金华"}};
    private ExpandableListView myCityView;
    private List<Map<String,String>> provinceIems=new ArrayList<Map<String,String>>();
    private List<List<Map<String,String>>> cityItems=new ArrayList<List<Map<String,String>>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choosecity);
        myCityView=findViewById(R.id.choosecity);
        initDatas();
        SimpleExpandableListAdapter adapter=new SimpleExpandableListAdapter(this,provinceIems,R.layout.province_item,new String[]{"province"},new int[]{R.id.province},cityItems,R.layout.city_item,new String[]{"city"},new int[]{R.id.city});
        myCityView.setAdapter(adapter);
        myCityView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Intent intent=new Intent();
                intent.putExtra("city",cities[groupPosition][childPosition]);
                intent.putExtra("province",provinces[groupPosition]);
                setResult(0x11,intent);
                ChooseCityActivity.this.finish();
                return true;
            }
        });

    }
    private  void initDatas(){
        for (int i=0;i<provinces.length;i++){
            Map<String,String>provinceItem=new HashMap<String,String>();
            provinceItem.put("province",provinces[i]);
            provinceIems.add(provinceItem);

        List<Map<String,String>>cityOfProvinces=new ArrayList<Map<String, String>>();
        for (int j=0;j<cities[i].length;j++){
            Map<String,String> cityItem=new HashMap<String, String>();
            cityItem.put("city",cities[i][j]);
            cityOfProvinces.add(cityItem);
        }
        cityItems.add(cityOfProvinces);
    }}
}

