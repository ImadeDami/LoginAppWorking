package com.zeathon.loginapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

public class PrefConfig {
    private SharedPreferences sharedPreferences;
    private static PrefConfig mInstance;
    private Context context;

    public PrefConfig(Context context)
    {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(context.getString(R.string.pref_file),Context.MODE_PRIVATE);
    }
    public static synchronized PrefConfig getInstance(Context context)
    {
        if (mInstance == null){
            mInstance = new PrefConfig(context);
        }
        return mInstance;
    }
    public void writeLoginStatus(boolean status)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(context.getString(R.string.pref_login_status),status);
        editor.commit();
    }
    public boolean readLoginStatus()
    {
        return sharedPreferences.getBoolean(context.getString(R.string.pref_login_status),false);
    }
    public void writeName(String name)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(context.getString(R.string.pref_user_name),name);
        editor.commit();
    }
    public String readName()
    {
        return sharedPreferences.getString(context.getString(R.string.pref_user_name),"User");
    }
    public void displayToast(String message)
    {
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }
}
