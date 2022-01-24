package com.fmb.icookproyect_.network;

import com.fmb.icookproyect_.R;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FoodEntry
{
    private static final String TAG = FoodEntry.class.getSimpleName();
    public final String title;
    public final Uri     dynamicUrl;
    public final String Url;
    public final String type;

    public FoodEntry(String title, String dynamicUrl, String url, String type) {
        this.title = title;
        this.dynamicUrl = Uri.parse(dynamicUrl);
        Url = url;
        this.type = type;
    }

    public static List<FoodEntry> initFoodEntryList(Resources resources)
    {
        InputStream inputStream = resources.openRawResource(R.raw.comidas);

        Writer writer = new StringWriter();
        char[] buffer = new char[1024];

        try{
            Reader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            int pointer;
            while ((pointer = reader.read(buffer)) != -1)
            {
                writer.write(buffer, 0, pointer);;
            }
        }catch (IOException ex){
            Log.e(TAG, "Error al escribir o leer el archivo JSON",ex);
        }finally {
            try {
                inputStream.close();
            }catch (IOException exception){
                Log.e(TAG, "Error al cerrar la connexion con el archivo",exception
                );
            }
        }
        String jsonComidasString = writer.toString();
        Gson gson= new Gson();
        Type foodListType = new TypeToken<ArrayList<FoodEntry>>(){}.getType();

        return gson.fromJson(jsonComidasString, foodListType);

    }

}