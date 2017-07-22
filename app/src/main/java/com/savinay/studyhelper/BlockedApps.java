package com.savinay.studyhelper;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.savinay.studyhelper.Adapters.BlockedAppsAdapter;


import java.util.ArrayList;
import java.util.List;

public class BlockedApps extends AppCompatActivity {
RecyclerView recyclerView;
    ArrayList<ApplicationInfo> arrayList;
   PackageManager packageManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blocked_apps);
        recyclerView= (RecyclerView) findViewById(R.id.r_view);
//        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        packageManager=getPackageManager();
        arrayList= (ArrayList<ApplicationInfo>) packageManager.getInstalledApplications(PackageManager.GET_META_DATA);

        BlockedAppsAdapter blockedAppsAdapter=new BlockedAppsAdapter(arrayList,this);
        recyclerView.setAdapter(blockedAppsAdapter);




    }
}
