package edu.orangecoastcollege.cs273.wheretonext;

import java.text.NumberFormat;

/**
 * The <code>College</code> class maintains information about a four-year college,
 * including its id number, name, population, tuition (in-state), rating and image name.
 *
 * @author Michael Paulding
 */
public class College {

    //Member variables
    private long mId;
    private String mName;
    private int mPopulation;
    private double mTuition;
    private double mRating;
    private String mImageName;

    /**
     * Creates a default <code>College</code> with an id of -1, empty name, population of 0,
     * tuition of 0.0f, rating of 0.0f and default image name of college.png.
     */
    public College()
    {
        this(-1, "", 0, 0.0f, 0.0f, "college.png");
    }

    /**
     * Creates a new <code>College</code> from its name, population, tuition, and rating.
     * @param name The college name
     * @param population The number of students enrolled at the college
     * @param tuition The in-state tuition of the college per year.
     * @param rating The college rating (out of 5.0)
     */
    public College(String name, int population, double tuition, double rating) {
        this(-1, name, population, tuition, rating, "college.png");
    }

    /**
     * Creates a new <code>College</code> from its name, population, tuition, rating and image name.
     * @param name The college name
     * @param population The number of students enrolled at the college
     * @param tuition The in-state tuition of the college per year.
     * @param rating The college rating (out of 5.0)
     * @param imageName The image file name of the college
     */
    public College(String name, int population, double tuition, double rating, String imageName) {
        this(-1, name, population, tuition, rating, imageName);
    }

    /**
     * Creates a new <code>College</code> from its id, description and status.
     * @param id The college id
     * @param name The college name
     * @param population The number of students enrolled at the college
     * @param tuition The in-state tuition of the college per year.
     * @param rating The college rating (out of 5.0)
     * @param imageName The image file name of the college
     */
    public College(int id, String name, int population, double tuition, double rating, String imageName) {
        mId = id;
        mName = name;
        mPopulation = population;
        mTuition = tuition;
        mRating = rating;
        mImageName = imageName;
    }

    /**
     * Gets the unique id of the <code>College</code>.
     * @return The unique id
     */
    public long getId() {
        return mId;
    }

    /**
     * Sets the unique id of the <code>College</code>.
     * @param id The unique id
     */
    void setId(long id) {
        mId = id;
    }

    /**
     * Gets the name of the <code>College</code>.
     * @return The game name
     */
    public String getName() {
        return mName;
    }

    /**
     * Sets the name of the <code>College</code>.
     * @param name The new game name.
     */
    public void setName(String name) {
        mName = name;
    }

    /**
     * Gets the name of the <code>College</code>.
     * @return The college name
     */
    public int getPopulation() {
        return mPopulation;
    }

    /**
     * Sets the population of the <code>College</code>.
     * @param population The new college population
     */
    public void setPopulation(int population) {
        mPopulation = population;
    }

    /**
     * Gets the tuition of the <code>College</code>.
     * @return The college tuition
     */
    public double getTuition() {
        return mTuition;
    }

    /**
     * Sets the tuition of the <code>College</code>.
     * @param tuition The new college tuition
     */
    public void setTuition(double tuition) {
        mTuition = tuition;
    }

    /**
     * Gets the rating of the <code>College</code>.
     * @return The rating (number of stars) of the game.
     */
    public double getRating() {
        return mRating;
    }

    /**
     * Sets the rating of the <code>College</code>.
     * @param rating The rating (number of stars) of the game.
     */
    public void setRating(double rating) {
        mRating = rating;
    }

    /**
     * Gets the image file name of the <code>College</code>.
     * @return The image file name (e.g. lol.png) of the game.
     */
    public String getImageName() {
        return mImageName;
    }

    /**
     * Sets the image file name of the <code>College</code>.
     * @param imageName The image file name (e.g. lol.png) of the game.
     */
    public void setImageName(String imageName) {
        mImageName = imageName;
    }

    /**
     * A method for displaying a <code>College</code> as a String in the form:
     *
     * College{id=1, Name=UC Irvine, Population=31551, Tuition=$15,035.47
     * Rating=4.5, ImageName=uci.png}
     *
     * @return The formatted String
     */
    @Override
    public String toString() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return "College{" +
                "Id=" + mId +
                ", Name='" + mName + '\'' +
                ", Population=" + mPopulation +
                ", Tuition=" + currency.format(mTuition) +
                ", Rating=" + mRating +
                ", ImageName='" + mImageName + '\'' +
                '}';
    }
}
