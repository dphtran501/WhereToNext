package edu.orangecoastcollege.cs273.wheretonext;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Toast;

import java.util.List;

public class CollegeListActivity extends AppCompatActivity {

    private DBHelper db;
    private List<College> collegesList;
    private CollegeListAdapter collegesListAdapter;
    private ListView collegesListView;

    EditText mNameEditText;
    EditText mPopulationEditText;
    EditText mTuitionEditText;
    RatingBar mRatingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_list);

        //this.deleteDatabase(DBHelper.DATABASE_NAME);
        db = new DBHelper(this);

        mNameEditText = (EditText) findViewById(R.id.nameEditText);
        mPopulationEditText = (EditText) findViewById(R.id.populationEditText);
        mTuitionEditText = (EditText) findViewById(R.id.tuitionEditText);
        mRatingBar = (RatingBar) findViewById(R.id.collegeRatingBar);

        // Comment this section out once the colleges below have been added to the database,
        // so they are not added multiple times (prevent duplicate entries)
        /*
        db.addCollege(new College("UC Berkeley", 42082, 14068, 4.7, "ucb.png"));
        db.addCollege(new College("UC Irvine", 31551, 15026.47, 4.3, "uci.png"));
        db.addCollege(new College("UC Los Angeles", 43301, 25308, 4.5, "ucla.png"));
        db.addCollege(new College("UC San Diego", 33735, 20212, 4.4, "ucsd.png"));
        db.addCollege(new College("CSU Fullerton", 38948, 6437, 4.5, "csuf.png"));
        db.addCollege(new College("CSU Long Beach", 37430, 6452, 4.4, "csulb.png"));
        */

        // Fill the collegesList with all Colleges from the database
        collegesList = db.getAllColleges();
        // Connect the list adapter with the list
        collegesListAdapter = new CollegeListAdapter(this, R.layout.college_list_item, collegesList);
        // Set the list view to use the list adapter
        collegesListView = (ListView) findViewById(R.id.collegeListView);
        collegesListView.setAdapter(collegesListAdapter);
    }

    public void viewCollegeDetails(View view) {

        // Implement the view college details using an Intent
        Intent detailsIntent = new Intent(this, CollegeDetailsActivity.class);
        LinearLayout selectedItem = (LinearLayout) view;
        College selectedCollege = (College) selectedItem.getTag();

        detailsIntent.putExtra("Name", selectedCollege.getName());
        detailsIntent.putExtra("Population", selectedCollege.getPopulation());
        detailsIntent.putExtra("Tuition", (float) selectedCollege.getTuition());
        detailsIntent.putExtra("Rating", (float) selectedCollege.getRating());
        detailsIntent.putExtra("ImageName", selectedCollege.getImageName());

        startActivity(detailsIntent);

    }

    public void addCollege(View view) {

        // Implement the code for when the user clicks on the addCollegeButton
        String name = mNameEditText.getText().toString();
        String population = mPopulationEditText.getText().toString();
        String tuition = mTuitionEditText.getText().toString();
        double rating = mRatingBar.getRating();

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(population) || TextUtils.isEmpty(tuition))
        {
            Toast.makeText(this, "All information about college must be provided", Toast.LENGTH_SHORT).show();
        }
        else
        {
            College newCollege = new College(name, Integer.parseInt(population),
                    Double.parseDouble(tuition), rating);
            db.addCollege(newCollege);
            collegesList.add(newCollege);
            collegesListAdapter.notifyDataSetChanged();

            mNameEditText.setText("");
            mPopulationEditText.setText("");
            mTuitionEditText.setText("");
            mRatingBar.setRating(0.0f);
        }
    }

}
