package edu.orangecoastcollege.cs273.wheretonext;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;

public class CollegeDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_details);

        ImageView collegeDetailsImageView = (ImageView) findViewById(R.id.collegeDetailsImageView);
        TextView collegeDetailsNameTextView = (TextView) findViewById(R.id.collegeDetailsNameTextView);
        TextView collegeDetailsPopulationTextView = (TextView) findViewById(R.id.collegeDetailsPopulationTextView);
        TextView collegeDetailsTuitionTextView = (TextView) findViewById(R.id.collegeDetailsTuitionTextView);
        RatingBar gameDetailsRatingBar = (RatingBar) findViewById(R.id.collegeDetailsRatingBar);


        Intent detailsIntent = getIntent();
        String name = detailsIntent.getStringExtra("Name");
        int population = detailsIntent.getIntExtra("Population", 0);
        float tuition = detailsIntent.getFloatExtra("Tuition", 0.0f);
        float rating = detailsIntent.getFloatExtra("Rating", 0.0f);
        String imageName = detailsIntent.getStringExtra("ImageName");

        AssetManager am = this.getAssets();
        try {
            InputStream stream = am.open(imageName);
            Drawable event = Drawable.createFromStream(stream, name);
            collegeDetailsImageView.setImageDrawable(event);
        }
        catch (IOException ex)
        {
            Log.e("Where To Next", "Error loading " + imageName, ex);
        }

        NumberFormat currency = NumberFormat.getCurrencyInstance();
        NumberFormat thousands = NumberFormat.getIntegerInstance();

        collegeDetailsNameTextView.setText(name);
        collegeDetailsPopulationTextView.setText("Annual Enrollment: " + thousands.format(population));
        collegeDetailsTuitionTextView.setText("In-state Tuition: " + currency.format(tuition));
        gameDetailsRatingBar.setRating(rating);
    }
}
