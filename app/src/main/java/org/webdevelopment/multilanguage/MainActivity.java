package org.webdevelopment.multilanguage;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    //This allows us to look for a specific string from a specific language
    //regardless of the locale specfied on the phone.
    public String getLocaleString(int id,String language ) {
        Resources res = getResources();
        Configuration conf = res.getConfiguration();
        Locale savedLocale = conf.locale;
        //set the new language
        Locale locale = new Locale.Builder().setLanguage(language).build();
        conf.locale = locale;
        res.updateConfiguration(conf, null);

        String str = res.getString(id);

        // restore original locale - needed otherwise we change it in the settings!
        conf.locale = savedLocale;
        res.updateConfiguration(conf, null);
        return str;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("Danish:"+getLocaleString(R.string.welcome,"da"));
        System.out.println("English:"+getLocaleString(R.string.welcome,"en"));
        System.out.println("German:"+getLocaleString(R.string.welcome,"de"));

        setContentView(R.layout.activity_main);
    }
}
