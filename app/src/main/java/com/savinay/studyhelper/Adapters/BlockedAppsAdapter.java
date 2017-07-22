package com.savinay.studyhelper.Adapters;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.savinay.studyhelper.R;

import java.util.ArrayList;

/**
 * Created by savinaysingh on 22/07/17.
 */

public class BlockedAppsAdapter extends RecyclerView.Adapter<BlockedAppsAdapter.HolderClass> {

    private static final String TAG ="yo" ;
    ArrayList<ApplicationInfo> arrayList;
     Context context;
    PackageManager packageManager;

    public BlockedAppsAdapter(ArrayList<ApplicationInfo> arrayList, Context context) {
        this.arrayList=arrayList;
        this.context=context;
        packageManager=context.getPackageManager();

    }

    @Override
    public HolderClass onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=layoutInflater.inflate(R.layout.list_items_apps,null);

        HolderClass holderClass=new HolderClass(v);

        return holderClass;
    }

    @Override
    public void onBindViewHolder(HolderClass holder, int position) {
        ApplicationInfo applicationInfo=arrayList.get(position);

        holder.t1.setText(applicationInfo.loadLabel(packageManager));
//        try{
//            if(applicationInfo.loadIcon(packageManager)!=null)
//                holder.i1.setImageDrawable(applicationInfo.loadIcon(packageManager));
//        }
//        catch (Exception e){
//            Log.e(TAG, "onBindViewHolder: exception" );
//        }


        // not able to get application icon
        //

    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class HolderClass extends RecyclerView.ViewHolder {
        TextView t1;
        ImageView i1;


        public HolderClass(View itemView) {
            super(itemView);
            t1= itemView.findViewById(R.id.textView8);
            i1= itemView.findViewById(R.id.imageView);
        }
    }
}
