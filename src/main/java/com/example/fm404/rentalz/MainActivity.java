package com.example.fm404.rentalz;

// import statements enable more functionality of Java to be made available for this Android app
import android.app.ActionBar; // import 'ActionBar' functionality from the 'android.app' package
import android.app.Activity; // import 'Activity' functionality from the 'android.app' package
import android.app.AlertDialog; // import 'AlertDialog' functionality from the 'android.app' package
import android.app.DatePickerDialog; // import 'DatePickerDialog' functionality from the 'android.app' package
import android.app.DialogFragment; // import 'DialogFragment' functionality from the 'android.app' package
import android.app.TimePickerDialog; // import 'TimePickerDialog' functionality from the 'android.app' package
import android.content.Context; // import 'Context' functionality from the 'android.content' package
import android.content.DialogInterface; // import 'DialogInterface' functionality from the 'android.content' package
import android.content.Intent; // import 'Intent' functionality from the 'android.content' package
import android.content.res.Resources; // import 'Resources' functionality from the 'android.content.res' package
import android.graphics.Bitmap; // import 'Bitmap' functionality from the 'android.graphics' package
import android.graphics.Color; // import 'Color' functionality from the 'android.graphics' package
import android.graphics.Typeface; // import 'Typeface' functionality from the 'android.graphics' package
import android.graphics.drawable.ColorDrawable; // import 'ColorDrawable' functionality from the 'android.graphics.drawable' package
import android.net.Uri; // import 'Uri' functionality from the 'android.net' package
import android.os.Bundle; // import 'Bundle' functionality from the 'android.os' package
import android.provider.MediaStore; // import 'MediaStore' functionality from the 'android.provider' package
import android.support.annotation.NonNull; // import 'NonNull' functionality from the 'android.support.annotation' package
import android.support.annotation.Nullable; // import 'Nullable' functionality from the 'android.support.annotation' package
import android.util.Log; // import 'Log' functionality from the 'android.util' package
import android.view.LayoutInflater; // import 'LayoutInflater' functionality from the 'android.view' package
import android.view.Menu; // import 'Menu' functionality from the 'android.view' package
import android.view.MenuItem; // import 'MenuItem' functionality from the 'android.view' package
import android.view.View; // import 'View' functionality from the 'android.view' package
import android.view.Window; // import 'Window' functionality from the 'android.view' package
import android.view.WindowManager; // import 'WindowManager' functionality from the 'android.view' package
import android.view.inputmethod.InputMethodManager; // import 'InputMethodManager' functionality from the 'android.view.inputmethod' package
import android.widget.AdapterView; // import 'AdapterView' functionality from the 'android.widget' package
import android.widget.ArrayAdapter; // import 'ArrayAdapter' functionality from the 'android.widget' package
import android.widget.Button; // import 'Button' functionality from the 'android.widget' package
import android.widget.CheckBox; // import 'CheckBox' functionality from the 'android.widget' package
import android.widget.DatePicker; // import 'DatePicker' functionality from the 'android.widget' package
import android.widget.EditText; // import 'EditText' functionality from the 'android.widget' package
import android.widget.ImageView; // import 'ImageView' functionality from the 'android.widget' package
import android.widget.LinearLayout; // import 'LinearLayout' functionality from the 'android.widget' package
import android.widget.RadioGroup; // import 'RadioGroup' functionality from the 'android.widget' package
import android.widget.SeekBar; // import 'SeekBar' functionality from the 'android.widget' package
import android.widget.Spinner; // import 'Spinner' functionality from the 'android.widget' package
import android.widget.TextView; // import 'TextView' functionality from the 'android.widget' package
import android.widget.TimePicker; // import 'TimePicker' functionality from the 'android.widget' package
import android.widget.Toast; // import 'Toast' functionality from the 'android.widget' package
import android.widget.VideoView; // import 'VideoView' functionality from the 'android.widget' package

import com.google.android.gms.common.ConnectionResult; // import 'ConnectionResult' functionality from the 'com.google.android.gms.common' package
import com.google.android.gms.common.GooglePlayServicesNotAvailableException; // import 'GooglePlayServicesNotAvailableException' functionality from the 'com.google.android.gms.common' package
import com.google.android.gms.common.GooglePlayServicesRepairableException; // import 'GooglePlayServicesRepairableException' functionality from the 'com.google.android.gms.common' package
import com.google.android.gms.common.api.GoogleApiClient; // import 'GoogleApiClient' functionality from the 'com.google.android.gms.common.api' package
import com.google.android.gms.location.places.Place; // import 'Place' functionality from the 'com.google.android.gms.location.places' package
import com.google.android.gms.location.places.Places; // import 'Places' functionality from the 'com.google.android.gms.location.places' package
import com.google.android.gms.location.places.ui.PlacePicker; // import 'PlacePicker' functionality from the 'com.google.android.gms.location.places.ui' package

import java.io.IOException; // import 'IOException' functionality from the 'java.io' package
import java.text.DateFormat; // import 'DateFormat' functionality from the 'java.text' package
import java.util.ArrayList; // import 'ArrayList' functionality from the 'java.util' package
import java.util.Calendar; // import 'Calendar' functionality from the 'java.util' package

import static android.content.ContentValues.TAG; // import

public class MainActivity extends Activity // 'extends' enables the subclass to inherit public and protected methods + variables of the superclass. Also allows methods to be overriden (@Override).
        implements DatePickerDialog.OnDateSetListener, // listener used to indicate the user has finished selecting a date
        TimePickerDialog.OnTimeSetListener, // listener used to indicate the user has finished selecting a time
        AdapterView.OnItemSelectedListener, // callback that gets invoked upon selection of item within this view (when an item in this view has been selected)
        GoogleApiClient.ConnectionCallbacks, // used to provide callbacks that are called whenever the user is connected or disconnected from the service
        GoogleApiClient.OnConnectionFailedListener { // used to provide callbacks for scenarios that consist of a failed attempt when connecting the user to the service

    // Public variables, are variables that are visible to all classes.
    // Private variables, are visible only to the class to which they belong.
    // Protected variables, are visible only to the class to which they belong, and any subclasses.
    private CheckBox checkboxTermsAndConditions; // private variable named 'checkboxTermsAndConditions' to represent a CheckBox element
    private EditText edittextPropertyAdditionDate; // private variable named 'edittextPropertyAdditionDate' to represent an EditText element
    private EditText edittextPropertyAdditionTime; // private variable named 'edittextPropertyAdditionTime' to represent an EditText element
    private EditText edittextMonthlyRent; // private variable named 'edittextMonthlyRent' to represent an EditText element
    private EditText edittextDescription; // private variable named 'edittextDescription' to represent an EditText element
    private EditText edittextReporterName; // private variable named 'edittextReporterName' to represent an EditText element
    private EditText edittextNearestSchool; // private variable named 'edittextNearestSchool' to represent an EditText element
    private EditText edittextNearestStation; // private variable named 'edittextNearestStation' to represent an EditText element
    private ImageView imgviewPropertyPhoto; // private variable named 'imgviewPropertyPhoto' to represent an ImageView element
    private LinearLayout containerNearestSchools; // private variable named 'containerNearestSchools' to represent a LinearLayout element
    private LinearLayout containerNearestStations; // private variable named 'containerNearestStations' to represent a LinearLayout element
    private RadioGroup radiogroupPetsAllowed; // private variable named 'radiogroupPetsAllowed' to represent a RadioGroup element
    private RadioGroup radiogroupWheelchairAccessible; // private variable named 'radiogroupWheelchairAccessible' to represent a RadioGroup element
    private SeekBar seekbarBathrooms; // private variable named 'seekbarBathrooms' to represent a SeekBar element
    private SeekBar seekbarBedrooms; // private variable named 'seekbarBedrooms' to represent a SeekBar element
    private SeekBar seekbarEnergyEfficiencyRating; // private variable named 'seekbarEnergyEfficiencyRating' to represent a SeekBar element
    private SeekBar seekbarEnvironmentalImpactRating; // private variable named 'seekbarEnvironmentalImpactRating' to represent a SeekBar element
    private Spinner spinnerPropertyType; // private variable named 'spinnerPropertyType' to represent a Spinner element
    private Spinner spinnerFurnitureType; // private variable named 'spinnerFurnitureType' to represent a Spinner element
    private TextView textviewPropertyAddress; // private variable named 'textviewPropertyAddress' to represent a TextView element
    private TextView textviewErrorPropertyType; // private variable named 'textviewErrorPropertyType' to represent a TextView element
    private TextView textviewErrorBedrooms; // private variable named 'textviewErrorBedrooms' to represent a TextView element
    private TextView textviewErrorPropertyAdditionDate; // private variable named 'textviewErrorPropertyAdditionDate' to represent a TextView element
    private TextView textviewErrorPropertyAdditionTime; // private variable named 'textviewErrorPropertyAdditionTime' to represent a TextView element
    private TextView textviewErrorMonthlyRent; // private variable named 'textviewErrorMonthlyRent' to represent a TextView element
    private TextView textviewErrorReporterName; // private variable named 'textviewErrorReporterName' to represent a TextView element
    private TextView textviewSeekbarBathrooms; // private variable named 'textviewSeekbarBathrooms' to represent a TextView element
    private TextView textviewSeekbarBedrooms; // private variable named textviewSeekbarBedrooms to represent a TextView element
    private TextView textviewSeekbarEnergyEfficiencyRating; // private variable named 'textviewSeekbarEnergyEfficiencyRating' to represent a TextView element
    private TextView textviewSeekbarEnvironmentalImpactRating; // private variable named 'textviewSeekbarEnvironmentalImpactRating' to represent a TextView element
    private VideoView videoviewPropertyVideo; // private variable named 'videoviewPropertyVideo' to represent a VideoView element

    /* the name of a 'static final' variables should always be in uppercase (according to Java coding convention) + value cannot be altered after it is first initialised */
    /* 'static' variables stay in the memory for the whole lifetime of an app, and is initialised during the loading of a class */
    /* each integer value represents a request code (each is unique), which is used to identify the particular Intent that the user came back from */
    private static final int REQUEST_PHOTO_CAPTURE = 1; // private static final variable named 'REQUEST_PHOTO_CAPTURE' assigned with the value of 1
    private static final int REQUEST_PHOTO_PICKER = 2; // private static final variable named 'REQUEST_PHOTO_PICKER' assigned with the value of 2
    private static final int REQUEST_VIDEO_CAPTURE = 3; // private static final variable named 'REQUEST_VIDEO_CAPTURE' assigned with the value of 3
    private static final int REQUEST_VIDEO_PICKER = 4; // private static final variable named 'REQUEST_VIDEO_PICKER' assigned with the value of 4
    private static final int REQUEST_PLACE_PICKER = 5; // private static final variable named 'REQUEST_PLACE_PICKER' assigned with the value of 5

    protected GoogleApiClient mGoogleApiClient; // protected variable named 'mGoogleApiClient' to represent a GoogleApiClient class

    // required method to adjust status bar background colour
    private int getFactorColor(int color, float factor) {
        float[] hsv = new float[3];
        Color.colorToHSV(color, hsv);
        hsv[2] *= factor;
        color = Color.HSVToColor(hsv);
        return color;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // set content of activity to the ‘activity_main.xml’ layout file

        final String toolbarColour = "#0098D4"; // light blue colour

        // set status bar background colour
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().setStatusBarColor(getFactorColor(Color.parseColor(toolbarColour), 0.8f));

        // Accessing the action bar
        ActionBar actionbar = getActionBar();

        // Setting up Action bar background colour using # color code.
        actionbar.setBackgroundDrawable(new ColorDrawable(Color.parseColor(toolbarColour)));

        // build the GoogleApiClient and connect to the Places API
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(Places.GEO_DATA_API)
                .addApi(Places.PLACE_DETECTION_API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();

        /*
         * start of 'Property type' spinner code
         */
        // 'Property type' Spinner element
        spinnerPropertyType = findViewById(R.id.spinner_propertytype);

        // 'Property type' Spinner click listener
        spinnerPropertyType.setOnItemSelectedListener(this);

        // 'Property type' Spinner Drop down elements
        ArrayList<String> propertytypeCategories = new ArrayList<>();
        propertytypeCategories.add(getString(R.string.empty_placeholder));
        propertytypeCategories.add(getString(R.string.apartment_flat));
        propertytypeCategories.add(getString(R.string.bungalow));
        propertytypeCategories.add(getString(R.string.chalet));
        propertytypeCategories.add(getString(R.string.cottage));
        propertytypeCategories.add(getString(R.string.duplex));
        propertytypeCategories.add(getString(R.string.garage));
        propertytypeCategories.add(getString(R.string.house));
        propertytypeCategories.add(getString(R.string.maisonette));
        propertytypeCategories.add(getString(R.string.mews));
        propertytypeCategories.add(getString(R.string.penthouse));
        propertytypeCategories.add(getString(R.string.triplex));

        // Creating adapter for spinner
        ArrayAdapter<String> PTdataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, propertytypeCategories);

        // Drop down layout style - list view with radio button
        PTdataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinnerPropertyType.setAdapter(PTdataAdapter);

        PTdataAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        /*
         * end of 'Property type' Spinner code
         */


        /*
         * start of 'Furniture type' spinner code
         */
        // 'Furniture type' Spinner element
        spinnerFurnitureType = findViewById(R.id.spinner_furtnituretype);

        // 'Furniture type' Spinner click listener
        spinnerFurnitureType.setOnItemSelectedListener(this);

        // 'Furniture type' Spinner Drop down elements
        ArrayList<String> furnituretypeCategories = new ArrayList<>();
        furnituretypeCategories.add(getString(R.string.empty_placeholder));
        furnituretypeCategories.add(getString(R.string.furnished));
        furnituretypeCategories.add(getString(R.string.unfurnished));
        furnituretypeCategories.add(getString(R.string.partfurnished));

        // Creating adapter for Spinner
        ArrayAdapter<String> FTdataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, furnituretypeCategories);

        // Drop down layout style - ListView with radio button
        FTdataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to Spinner
        spinnerFurnitureType.setAdapter(FTdataAdapter);

        FTdataAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        /*
         * end of 'Furniture type' Spinner code
         */


        Typeface iconFont = FontManager.getTypeface(getApplicationContext(), FontManager.FONTAWESOME); // FontManager class must be accessed first before text views can be set as image views
        TextView tvimgviewPropertyType = findViewById(R.id.imgView_propertytype); // get access to the 'Property type' ImageView (text view using image font)
        tvimgviewPropertyType.setTypeface(iconFont); // set typeface of textview to FontAwesome font (to enable use of vector images in TextView)
        TextView tvimgviewBedrooms = findViewById(R.id.imgView_bedrooms); // get access to the 'Bedrooms' ImageView (text view using image font)
        tvimgviewBedrooms.setTypeface(iconFont); // set typeface of textview to FontAwesome font (to enable use of vector images in TextView)
        TextView tvimgviewBathrooms = findViewById(R.id.imgView_bathrooms); // get access to the 'Bathrooms' ImageView (text view using image font)
        tvimgviewBathrooms.setTypeface(iconFont); // set typeface of textview to FontAwesome font (to enable use of vector images in TextView)
        TextView tvimgviewPropertyAdditionDate = findViewById(R.id.imgView_propertadditiondate); // get access to the 'Property addition date' ImageView (text view using image font)
        tvimgviewPropertyAdditionDate.setTypeface(iconFont); // set typeface of textview to FontAwesome font (to enable use of vector images in TextView)
        TextView tvimgviewPropertyAdditionTime = findViewById(R.id.imgView_propertadditiontime); // get access to the 'Property addition time' ImageView (text view using image font)
        tvimgviewPropertyAdditionTime.setTypeface(iconFont); // set typeface of textview to FontAwesome font (to enable use of vector images in TextView)
        TextView tvimgviewMonthlyRent = findViewById(R.id.imgView_monthlyrent); // get access to the 'Monthly rent' ImageView (text view using image font)
        tvimgviewMonthlyRent.setTypeface(iconFont); // set typeface of textview to FontAwesome font (to enable use of vector images in TextView)
        TextView tvimgviewFurnitureType = findViewById(R.id.imgView_furnituretype); // get access to the 'Furniture type' ImageView (text view using image font)
        tvimgviewFurnitureType.setTypeface(iconFont); // set typeface of textview to FontAwesome font (to enable use of vector images in TextView)
        TextView tvimgviewNotes = findViewById(R.id.imgView_notes); // get access to the 'Notes' ImageView (text view using image font)
        tvimgviewNotes.setTypeface(iconFont); // set typeface of textview to FontAwesome font (to enable use of vector images in TextView)
        TextView tvimgviewDescription = findViewById(R.id.imgView_description); // get access to the 'Property Description' ImageView (text view using image font)
        tvimgviewDescription.setTypeface(iconFont); // set typeface of textview to FontAwesome font (to enable use of vector images in TextView)
        TextView tvimgviewReporterName = findViewById(R.id.imgView_reportername); // get access to the 'Reporter name' ImageView (text view using image font)
        tvimgviewReporterName.setTypeface(iconFont); // set typeface of textview to FontAwesome font (to enable use of vector images in TextView)
        TextView tvimgviewTermsAndConditions = findViewById(R.id.imgView_termsandconditions); // get access to the 'Terms and Conditions' ImageView (text view using image font)
        tvimgviewTermsAndConditions.setTypeface(iconFont); // set typeface of textview to FontAwesome font (to enable use of vector images in TextView)
        TextView tvimgviewPetsAllowed = findViewById(R.id.imgView_petsallowed); // get access to the 'Pets allowed' ImageView (text view using image font)
        tvimgviewPetsAllowed.setTypeface(iconFont); // set typeface of textview to FontAwesome font (to enable use of vector images in TextView)
        TextView tvimgviewWheelchairAccessible = findViewById(R.id.imgView_wheelchairaccessible); // get access to the 'Wheelchair accessible' ImageView (text view using image font)
        tvimgviewWheelchairAccessible.setTypeface(iconFont); // set typeface of textview to FontAwesome font (to enable use of vector images in TextView)
        TextView tvimgviewEnergyEfficiencyRating = findViewById(R.id.imgView_energyefficiencyrating); // get access to the 'Energy efficiency rating' ImageView (text view using image font)
        tvimgviewEnergyEfficiencyRating.setTypeface(iconFont); // set typeface of textview to FontAwesome font (to enable use of vector images in TextView)
        TextView tvimgviewEnvironmentalImpactRating = findViewById(R.id.imgView_environmentalimpactrating); // get access to the 'Environmental impact rating' ImageView (text view using image font)
        tvimgviewEnvironmentalImpactRating.setTypeface(iconFont); // set typeface of textview to FontAwesome font (to enable use of vector images in TextView)
        TextView tvimgviewPropertyImage = findViewById(R.id.imgView_propertyimage); // get access to the 'Property image' ImageView (text view using image font)
        tvimgviewPropertyImage.setTypeface(iconFont); // set typeface of textview to FontAwesome font (to enable use of vector images in TextView)
        TextView tvimgviewPropertyVideo = findViewById(R.id.imgView_propertyvideo); // get access to the 'Property video' ImageView (text view using image font)
        tvimgviewPropertyVideo.setTypeface(iconFont); // set typeface of textview to FontAwesome font (to enable use of vector images in TextView)
        TextView tvimgviewPropertyLocation = findViewById(R.id.imgView_propertylocation); // get access to the 'Property location' ImageView (text view using image font)
        tvimgviewPropertyLocation.setTypeface(iconFont); // set typeface of textview to FontAwesome font (to enable use of vector images in TextView)
        TextView tvimgviewNearestStations = findViewById(R.id.imgView_neareststations); // get access to the 'Nearest stations' ImageView (text view using image font)
        tvimgviewNearestStations.setTypeface(iconFont); // set typeface of textview to FontAwesome font (to enable use of vector images in TextView)
        TextView tvimgviewNearestSchools = findViewById(R.id.imgView_nearestschools); // get access to the 'Nearest schools' ImageView (text view using image font)
        tvimgviewNearestSchools.setTypeface(iconFont); // set typeface of textview to FontAwesome font (to enable use of vector images in TextView)

        final Button btnAddNearestSchool = findViewById(R.id.btn_addnearestschool); // get access to the 'Add nearest school' button
        final Button btnAddNearestStation = findViewById(R.id.btn_addneareststation); // get access to the 'Add nearest station' button
        final Button btnBathroomsMinus = findViewById(R.id.btn_bathroomsminus); // get access to the 'Bathrooms minus' button
        final Button btnBathroomsPlus = findViewById(R.id.btn_bathroomsplus); // get access to the 'Bathrooms plus' button
        final Button btnBedroomsMinus = findViewById(R.id.btn_bedroomsminus); // get access to the 'Bedrooms minus' button
        final Button btnBedroomsPlus = findViewById(R.id.btn_bedroomsplus); // get access to the 'Bedrooms plus' button
        final Button btnChoosePhoto = findViewById(R.id.btn_choosephoto); // get access to the 'Choose a photo' button
        final Button btnChooseVideo = findViewById(R.id.btn_choosevideo); // get access to the 'Choose a video' button
        final Button btnEnergyEfficiencyRatingMinus = findViewById(R.id.btn_energyefficiencyratingminus); // get access to the 'Energy Efficiency Rating minus' button
        final Button btnEnergyEfficiencyRatingPlus = findViewById(R.id.btn_energyefficiencyratingplus); // get access to the 'Energy Efficiency Rating plus' button
        final Button btnEnvironmentalImpactRatingMinus = findViewById(R.id.btn_environmentalimpactratingminus); // get access to the 'Environmental Impact Rating minus' button
        final Button btnEnvironmentalImpactRatingPlus = findViewById(R.id.btn_environmentalimpactratingplus); // get access to the 'Environmental Impact Rating plus' button
        final Button btnPropertyLocation = findViewById(R.id.btn_choosepropertylocation); // get access to the 'Property location' button
        final Button btnRemovePropertyLocation = findViewById(R.id.btn_removepropertylocation); // get access to the 'Remove location' button
        final Button btnRecordVideo = findViewById(R.id.btn_recordvideo); // get access to the 'Record a video' button
        final Button btnRemovePropertyVideo = findViewById(R.id.btn_removevideo); // get access to the 'Remove location' button
        final Button btnTakePhoto = findViewById(R.id.btn_takephoto); // get access to the 'Take a photo' button

        checkboxTermsAndConditions = findViewById(R.id.checkbox_TandCs); // get access to the 'Terms and Conditions' CheckBox
        containerNearestSchools = findViewById(R.id.container_nearestschools); // get access to the 'Nearest school' LinearLayout
        containerNearestStations = findViewById(R.id.container_neareststations); // get access to the 'Nearest stations' LinearLayout
        edittextNearestSchool = findViewById(R.id.editText_nearestschool); // get access to the 'Nearest school' EditText
        edittextNearestStation = findViewById(R.id.editText_neareststation); // get access to the 'Nearest station' EditText
        edittextPropertyAdditionDate = findViewById(R.id.editText_date); // get access to the 'Property Addition Date' EditText
        edittextPropertyAdditionTime = findViewById(R.id.editText_time); // get access to the 'Property Addition Time' EditText
        edittextMonthlyRent = findViewById(R.id.editText_monthlyrent); // get access to the 'Monthly Rent' EditText
        edittextDescription = findViewById(R.id.editText_description); // get access to the 'Notes' EditText
        edittextReporterName = findViewById(R.id.editText_reportername); // get access to the 'Reporter Name' EditText
        imgviewPropertyPhoto = findViewById(R.id.imgView_propertyphoto); // get access to the 'Property photo' ImageView
        radiogroupPetsAllowed = findViewById(R.id.radiogroup_petsallowed); // get access to the 'Pets allowed' RadioGroup
        radiogroupWheelchairAccessible = findViewById(R.id.radiogroup_wheelchairaccessible); // get access to the 'Wheelchair accessible' RadioGroup
        seekbarBathrooms = findViewById(R.id.seekbar_bathrooms); // get access to the 'Bathrooms' SeekBar
        seekbarBedrooms = findViewById(R.id.seekbar_bedrooms); // get access to the 'Bedrooms' SeekBar
        seekbarEnergyEfficiencyRating = findViewById(R.id.seekbar_energyefficiencyrating); // get access to the 'Energy efficiency rating' SeekBar
        seekbarEnvironmentalImpactRating = findViewById(R.id.seekbar_environmentalimpactrating); // get access to the 'Environmental impact rating' SeekBar
        spinnerPropertyType = findViewById(R.id.spinner_propertytype); // get access to the 'Property Type' Spinner
        spinnerFurnitureType = findViewById(R.id.spinner_furtnituretype); // get access to the 'Furniture Type' Spinner
        textviewPropertyAddress = findViewById(R.id.textView_propertyaddress); // get access to the 'textView_propertyaddress' TextView
        textviewErrorPropertyType = findViewById(R.id.textViewerror_propertytype); // get access to the 'textViewerror_propertytype' TextView
        textviewErrorBedrooms = findViewById(R.id.textViewerror_bedrooms); // get access to the 'textViewerror_bedrooms' TextView
        textviewErrorPropertyAdditionDate = findViewById(R.id.textViewerror_date); // get access to the 'textViewerror_date' TextView
        textviewErrorPropertyAdditionTime = findViewById(R.id.textViewerror_time); // get access to the 'textViewerror_time' TextView
        textviewErrorMonthlyRent = findViewById(R.id.textViewerror_monthlyrent); // get access to the 'textViewerror_monthlyrent' TextView
        textviewErrorReporterName = findViewById(R.id.textViewerror_reportername); // get access to the 'textViewerror_reportername' TextView
        textviewSeekbarBathrooms = findViewById(R.id.textView_seekbarbathroomcount); // get access to the 'textView_seekbarbathroomcount' TextView
        textviewSeekbarBedrooms = findViewById(R.id.textView_seekbarbedroomcount); // get access to the 'textView_seekbarbedroomcount' TextView
        textviewSeekbarEnergyEfficiencyRating = findViewById(R.id.textView_seekbarenergyefficiencyrating); // get access to the 'textView_seekbarenergyefficiencyrating' TextView
        textviewSeekbarEnvironmentalImpactRating = findViewById(R.id.textView_seekbarenvironmentalimpactrating); // get access to the 'textView_seekbarenvironmentalimpactrating' TextView
        videoviewPropertyVideo = findViewById(R.id.videoView_propertyvideo); // get access to the 'Property video' VideoView

        textviewErrorPropertyType.setVisibility(View.INVISIBLE); // make 'textViewerror_propertytype' text view INVISIBLE (not GONE) to keep space between items
        textviewErrorBedrooms.setVisibility(View.INVISIBLE); // make 'textViewerror_bedrooms' text view INVISIBLE (not GONE) to keep space between items
        textviewErrorPropertyAdditionDate.setVisibility(View.INVISIBLE); // make 'textViewerror_propertytype' text view INVISIBLE (not GONE) to keep space between items
        textviewErrorPropertyAdditionTime.setVisibility(View.INVISIBLE); // make 'textviewErrorPropertyAdditionTime' text view INVISIBLE (not GONE) to keep space between items
        textviewErrorMonthlyRent.setVisibility(View.INVISIBLE); // make 'textviewErrorMonthlyRent' text view INVISIBLE (not GONE) to keep space between items
        textviewErrorReporterName.setVisibility(View.INVISIBLE); // make 'textviewErrorReporterName' text view INVISIBLE (not GONE) to keep space between items
        textviewPropertyAddress.setVisibility(View.GONE); // make 'textviewPropertyAddress' text view GONE (not INVISIBLE) to remove space between items

        btnBathroomsMinus.setEnabled(false); // disable 'Bathrooms minus' button when activity is first created
        btnBedroomsMinus.setEnabled(false); // disable 'Bedrooms minus' button when activity is first created
        btnEnergyEfficiencyRatingMinus.setEnabled(false); // disable 'Energy Efficiency Rating minus' button when activity is first created
        btnEnvironmentalImpactRatingMinus.setEnabled(false); // disable 'Environmental Impact Rating minus' button when activity is first created

        edittextPropertyAdditionDate.setFocusable(false);
        edittextPropertyAdditionDate.setFocusableInTouchMode(false); // do nothing when user touches widget on phone with touch screen
        edittextPropertyAdditionDate.setClickable(false); // do nothing when user navigates with wheel and selects widget

        edittextPropertyAdditionTime.setFocusable(false);
        edittextPropertyAdditionTime.setFocusableInTouchMode(false); // do nothing when user touches widget on phone with touch screen
        edittextPropertyAdditionTime.setClickable(false); // do nothing when user navigates with wheel and selects widget

        textviewSeekbarEnergyEfficiencyRating.setText((seekbarEnergyEfficiencyRating.getProgress() + 1) + "\n" + getString(R.string.level_g));
        textviewSeekbarEnvironmentalImpactRating.setText((seekbarEnvironmentalImpactRating.getProgress() + 1) + "\n" + getString(R.string.level_g));

        String seekbarbathroomsinitialValue = String.valueOf(seekbarBathrooms.getProgress()); // String to represent the progress value of the 'Bathrooms' SeekBar
        String seekbarbedroomsinitialValue = String.valueOf(seekbarBedrooms.getProgress()); // String to represent the progress value of the 'Bedrooms' SeekBar
        textviewSeekbarBathrooms.setText(seekbarbathroomsinitialValue); // set text of 'textviewSeekbarBathrooms' TextView to the initial progress value of the 'Bathrooms' SeekBar - i.e. 0
        textviewSeekbarBedrooms.setText(seekbarbedroomsinitialValue); // set text of 'textviewSeekbarBedrooms' TextView to the initial progress value of the 'Bedrooms' SeekBar - i.e. 0

        btnTakePhoto.setFocusable(false);
        videoviewPropertyVideo.setFocusable(false);



        // callback to notify the user when the 'Bathrooms' progress level has been changed
        seekbarBathrooms.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                String seekbarbathroomsValue = String.valueOf(progress);
                textviewSeekbarBathrooms.setText(seekbarbathroomsValue);

                if (progress == 0) {
                    btnBathroomsMinus.setEnabled(false);
                } else if (progress == 1) {
                    btnBathroomsMinus.setEnabled(true);
                } else if (progress == 3) {
                    btnBathroomsPlus.setEnabled(false);
                } else {
                    btnBathroomsMinus.setEnabled(true);
                    btnBathroomsPlus.setEnabled(true);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        // callback to notify the user when the 'Bedrooms' progress level has been changed
        seekbarBedrooms.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                String seekbarbedroomsValue = String.valueOf(progress);
                String seekbarbedroomsValueMinus1 = String.valueOf(progress - 1);
                textviewSeekbarBedrooms.setText(seekbarbedroomsValue);

                if (progress == 0) {
                    btnBedroomsMinus.setEnabled(false);
                } else if (progress == 1) {
                    textviewSeekbarBedrooms.setText(getString(R.string.studio));
                    btnBedroomsMinus.setEnabled(true);
                } else if (progress == 9) {
                    btnBedroomsPlus.setEnabled(false);
                    textviewSeekbarBedrooms.setText(seekbarbedroomsValueMinus1);
                } else {
                    btnBedroomsMinus.setEnabled(true);
                    btnBedroomsPlus.setEnabled(true);
                    textviewSeekbarBedrooms.setText(seekbarbedroomsValueMinus1);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        // callback to notify the user when the 'Energy efficiency rating' progress level has been changed
        seekbarEnergyEfficiencyRating.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                if (progress == 0) {
                    textviewSeekbarEnergyEfficiencyRating.setText((progress + 1) + "\n" + getString(R.string.level_g));
                    btnEnergyEfficiencyRatingMinus.setEnabled(false);
                } else if (progress >= 1 && progress <=19) {
                    textviewSeekbarEnergyEfficiencyRating.setText((progress + 1) + "\n" + getString(R.string.level_g));
                    btnEnergyEfficiencyRatingMinus.setEnabled(true);
                } else if (progress >= 20 && progress <=37) {
                    textviewSeekbarEnergyEfficiencyRating.setText((progress + 1) + "\n" + getString(R.string.level_f));
                } else if (progress >= 38 && progress <=53) {
                    textviewSeekbarEnergyEfficiencyRating.setText((progress + 1) + "\n" + getString(R.string.level_e));
                } else if (progress >= 54 && progress <=67) {
                    textviewSeekbarEnergyEfficiencyRating.setText((progress + 1) + "\n" + getString(R.string.level_d));
                } else if (progress >= 68 && progress <=79) {
                    textviewSeekbarEnergyEfficiencyRating.setText((progress + 1) + "\n" + getString(R.string.level_c));
                } else if (progress >= 80 && progress <=90) {
                    textviewSeekbarEnergyEfficiencyRating.setText((progress + 1) + "\n" + getString(R.string.level_b));
                } else if (progress >= 91 && progress <=98) {
                    textviewSeekbarEnergyEfficiencyRating.setText((progress + 1) + "\n" + getString(R.string.level_a));
                    btnEnergyEfficiencyRatingPlus.setEnabled(true);
                } else if (progress == 99) {
                    textviewSeekbarEnergyEfficiencyRating.setText((progress + 1) + "\n" + getString(R.string.level_a));
                    btnEnergyEfficiencyRatingPlus.setEnabled(false);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        // callback to notify the user when the 'Environmental impact rating' progress level has been changed
        seekbarEnvironmentalImpactRating.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                if (progress == 0) {
                    textviewSeekbarEnvironmentalImpactRating.setText((progress + 1) + "\n" + getString(R.string.level_g));
                    btnEnvironmentalImpactRatingMinus.setEnabled(false);
                } else if (progress >= 1 && progress <=19) {
                    textviewSeekbarEnvironmentalImpactRating.setText((progress + 1) + "\n" + getString(R.string.level_g));
                    btnEnvironmentalImpactRatingMinus.setEnabled(true);
                } else if (progress >= 20 && progress <=37) {
                    textviewSeekbarEnvironmentalImpactRating.setText((progress + 1) + "\n" + getString(R.string.level_f));
                } else if (progress >= 38 && progress <=53) {
                    textviewSeekbarEnvironmentalImpactRating.setText((progress + 1) + "\n" + getString(R.string.level_e));
                } else if (progress >= 54 && progress <=67) {
                    textviewSeekbarEnvironmentalImpactRating.setText((progress + 1) + "\n" + getString(R.string.level_d));
                } else if (progress >= 68 && progress <=79) {
                    textviewSeekbarEnvironmentalImpactRating.setText((progress + 1) + "\n" + getString(R.string.level_c));
                } else if (progress >= 80 && progress <=90) {
                    textviewSeekbarEnvironmentalImpactRating.setText((progress + 1) + "\n" + getString(R.string.level_b));
                } else if (progress >= 91 && progress <=98) {
                    textviewSeekbarEnvironmentalImpactRating.setText((progress + 1) + "\n" + getString(R.string.level_a));
                    btnEnvironmentalImpactRatingPlus.setEnabled(true);
                } else if (progress == 99) {
                    textviewSeekbarEnvironmentalImpactRating.setText((progress + 1) + "\n" + getString(R.string.level_a));
                    btnEnvironmentalImpactRatingPlus.setEnabled(false);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        // click event for 'bathrooms minus' button
        btnBathroomsMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // perform all of the following functions when the 'bathrooms minus' button is clicked
                if (seekbarBathrooms.getProgress() == 0) {
                    btnBathroomsMinus.setEnabled(false); // disable the 'btnBathroomsMinus' button
                    seekbarBathrooms.setProgress(seekbarBathrooms.getProgress() - 1); // decrement the 'seekbarBathrooms' SeekBar value by 1
                } else { // otherwise do the following
                    btnBathroomsMinus.setEnabled(true); // enable the 'btnBathroomsMinus' button
                    btnBathroomsPlus.setEnabled(true); // enable the 'btnBathroomsPlus' button
                    seekbarBathrooms.setProgress(seekbarBathrooms.getProgress() - 1); // decrement the 'seekbarBathrooms' SeekBar value by 1
                }
            }
        });


        // click event for 'bathrooms plus' button
        btnBathroomsPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // perform all of the following functions when the 'bathrooms plus' button is clicked
                if (seekbarBathrooms.getProgress() == 3) {
                    seekbarBathrooms.setProgress(seekbarBathrooms.getProgress() + 1); // increment the 'seekbarBathrooms' SeekBar value by 1
                    btnBathroomsPlus.setEnabled(false); // disable the 'btnBathroomsPlus' button
                } else { // otherwise do the following
                    btnBathroomsMinus.setEnabled(true); // enable the 'btnBathroomsMinus' button
                    btnBathroomsPlus.setEnabled(true); // enable the 'btnBathroomsPlus' button
                    seekbarBathrooms.setProgress(seekbarBathrooms.getProgress() + 1); // increment the 'seekbarBathrooms' SeekBar value by 1
                }
            }
        });


        // click event for 'bedrooms minus' button
        btnBedroomsMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // perform all of the following functions when the 'bedrooms minus' button is clicked
                if (seekbarBedrooms.getProgress() == 1) {
                    btnBedroomsMinus.setEnabled(false); // disable the 'btnBathroomsMinus' button
                    seekbarBedrooms.setProgress(seekbarBedrooms.getProgress() - 1); // decrement the 'seekbarBedrooms' SeekBar value by 1
                } else { // otherwise do the following
                    btnBedroomsMinus.setEnabled(true); // enable the 'btnBathroomsMinus' button
                    btnBedroomsPlus.setEnabled(true); // enable the 'btnBathroomsPlus' button
                    seekbarBedrooms.setProgress(seekbarBedrooms.getProgress() - 1); // decrement the 'seekbarBedrooms' SeekBar value by 1
                }
            }
        });


        // click event for 'bedrooms plus' button
        btnBedroomsPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // perform all of the following functions when the 'bedrooms plus' button is clicked
                if (seekbarBedrooms.getProgress() == 8) {
                    btnBedroomsPlus.setEnabled(false); // disable the 'btnBathroomsPlus' button
                    seekbarBedrooms.setProgress(seekbarBedrooms.getProgress() + 1); // increment the 'seekbarBedrooms' SeekBar value by 1
                } else {
                    btnBedroomsMinus.setEnabled(true); // enable the 'btnBathroomsMinus' button
                    btnBedroomsPlus.setEnabled(true); // enable the 'btnBathroomsPlus' button
                    seekbarBedrooms.setProgress(seekbarBedrooms.getProgress() + 1); // increment the 'seekbarBedrooms' SeekBar value by 1
                }
            }
        });


        // click event for 'choose date' button
        Button btnChooseDate = this.findViewById(R.id.btn_choosedate);
        btnChooseDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // perform all of the following functions when the 'choose date' button is clicked
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getFragmentManager(), "date picker");
            }
        });


        // click event for 'choose time' button
        Button btnChooseTime = this.findViewById(R.id.btn_choosetime);
        btnChooseTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // perform all of the following functions when the 'choose time' button is clicked
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getFragmentManager(), "time picker");
            }
        });


        // click event for 'Energy efficiency rating minus' button
        btnEnergyEfficiencyRatingMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // perform all of the following functions when the 'Energy efficiency rating minus' button is clicked
                if (seekbarEnergyEfficiencyRating.getProgress() == 1) {
                    seekbarEnergyEfficiencyRating.setProgress(seekbarEnergyEfficiencyRating.getProgress() - 1);
                    btnEnergyEfficiencyRatingMinus.setEnabled(false);
                } else {
                    btnEnergyEfficiencyRatingMinus.setEnabled(true);
                    btnEnergyEfficiencyRatingPlus.setEnabled(true);
                    seekbarEnergyEfficiencyRating.setProgress(seekbarEnergyEfficiencyRating.getProgress() - 1);
                }
            }
        });


        // click event for 'Energy efficiency rating plus' button
        btnEnergyEfficiencyRatingPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // perform all of the following functions when the 'Energy efficiency rating plus' button is clicked
                seekbarEnergyEfficiencyRating.setProgress(seekbarEnergyEfficiencyRating.getProgress() + 1);
            }
        });


        // click event for 'Environmental Impact Rating minus' button
        btnEnvironmentalImpactRatingMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // perform all of the following functions when the 'Energy efficiency rating minus' button is clicked
                seekbarEnvironmentalImpactRating.setProgress(seekbarEnvironmentalImpactRating.getProgress() - 1);
            }
        });


        // click event for 'Environmental Impact Rating plus' button
        btnEnvironmentalImpactRatingPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // perform all of the following functions when the 'Energy efficiency rating plus' button is clicked
                seekbarEnvironmentalImpactRating.setProgress(seekbarEnvironmentalImpactRating.getProgress() + 1);
            }
        });


        // click event for 'Take a photo' button
        btnTakePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // perform all of the following functions when the 'Take a photo' button is clicked
                if (imgviewPropertyPhoto.getDrawable() != null){
                    // Show dialog if image exists in image view
                    AlertDialog.Builder adbT = new AlertDialog.Builder(MainActivity.this);
                    adbT.setTitle(getString(R.string.take_a_photo)); // Title of alert dialog
                    adbT.setIcon(android.R.drawable.ic_dialog_alert); // Icon of alert dialog (warning sign)
                    adbT.setCancelable(false); // Prevent user from tapping outside dialog to cancel
                    adbT.setMessage(getString(R.string.replacephoto_warning)); // Message of alert dialog

                    adbT.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
//                        imgviewPropertyPhoto.setVisibility(View.GONE); // Remove image from 'Property Photo' ImageView

                        Intent photoCaptureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(photoCaptureIntent, REQUEST_PHOTO_CAPTURE);
                        }
                    });

                    adbT.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss(); // Dismiss the dialog
                        }
                    });

                    adbT.show(); // Show the alert dialog
                } else {
                    Intent photoCaptureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(photoCaptureIntent, REQUEST_PHOTO_CAPTURE);
                }
            }
        });


        // click event for 'Choose a photo' button
        btnChoosePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // perform all of the following functions when the 'Choose a photo' button is clicked
                if (imgviewPropertyPhoto.getDrawable() != null){
                    // Show dialog if image exists in image view
                    AlertDialog.Builder adbR = new AlertDialog.Builder(MainActivity.this);
                    adbR.setTitle(getString(R.string.choose_a_photo)); // Title of alert dialog
                    adbR.setIcon(android.R.drawable.ic_dialog_alert); // Icon of alert dialog (warning sign)
                    adbR.setCancelable(false); // Prevent user from tapping outside dialog to cancel
                    adbR.setMessage(getString(R.string.replacephoto_warning)); // Message of alert dialog

                    adbR.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
//                            imgviewPropertyPhoto.setVisibility(View.GONE); // Remove image from 'Property Photo' ImageView

                            // Launch image chooser
                            Intent choosephotoIntent = new Intent();
                            choosephotoIntent.setType("image/*");
                            choosephotoIntent.setAction(Intent.ACTION_GET_CONTENT);
                            startActivityForResult(Intent.createChooser(choosephotoIntent, getString(R.string.select_a_photo)), REQUEST_PHOTO_PICKER);
                        }
                    });

                    adbR.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss(); // Dismiss the dialog
                        }
                    });

                    adbR.show(); // Show the alert dialog
                } else {
                    Intent choosephotoIntent = new Intent();
                    choosephotoIntent.setType("image/*");
                    choosephotoIntent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(Intent.createChooser(choosephotoIntent, getString(R.string.select_a_photo)), REQUEST_PHOTO_PICKER);
                }
            }
        });


        // click event for 'Remove photo' button
        Button btnRemovePhoto = this.findViewById(R.id.btn_removephoto);
        btnRemovePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // perform all of the following functions when the 'Remove photo' button is clicked
                if (imgviewPropertyPhoto.getDrawable() != null){
                    // Show dialog if image exists in image view
                    AlertDialog.Builder adbD = new AlertDialog.Builder(MainActivity.this);
                    adbD.setTitle(getString(R.string.remove_photo)); // Title of alert dialog
                    adbD.setIcon(android.R.drawable.ic_dialog_alert); // Icon of alert dialog (warning sign)
                    adbD.setCancelable(false); // Prevent user from tapping outside dialog to cancel
                    adbD.setMessage(getString(R.string.removephoto_warning)); // Message of alert dialog

                    adbD.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Show toast stating that Image was successfully deleted
                            Toast.makeText(MainActivity.this, R.string.image_removed_successfully, Toast.LENGTH_LONG).show(); // show a toast

                            imgviewPropertyPhoto.setVisibility(View.GONE); // Remove image from 'Property Photo' ImageView
                        }
                    });

                    adbD.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss(); // Dismiss the dialog
                        }
                    });

                    adbD.show(); //Show the alert dialog
                } else {
                    // If image doesn't exist in image view, show toast stating that Image doesn´t exist
                    Toast.makeText(MainActivity.this, R.string.image_doesnt_exist, Toast.LENGTH_SHORT).show(); // show a toast
                }
            }
        });

        // click event for 'Record a video' button
        btnRecordVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // perform all of the following functions when the 'Record a video' button is clicked
                // check if video exists in the VideoView
                if (videoviewPropertyVideo.getVisibility() == View.VISIBLE){
                    // Show dialog if video exists in VideoView
                    AlertDialog.Builder adbD = new AlertDialog.Builder(MainActivity.this);
                    adbD.setTitle(getString(R.string.record_a_video)); // Title of alert dialog
                    adbD.setIcon(android.R.drawable.ic_dialog_alert); // Icon of alert dialog (warning sign)
                    adbD.setCancelable(false); // Prevent user from tapping outside dialog to cancel
                    adbD.setMessage(getString(R.string.replacevideo_warning)); // Message of alert dialog

                    adbD.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // If OK button is clicked, launch video capture intent
                            dispatchTakeVideoIntent();
                        }
                    });

                    adbD.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss(); // Dismiss the dialog
                        }
                    });

                    adbD.show(); // Show the alert dialog
                } else {
                    // If video doesn't exist in VideoView, launch video capture intent
                    dispatchTakeVideoIntent();
                }
            }
        });


        // click event for 'Choose a video' button
        btnChooseVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // perform all of the following functions when the 'Choose a photo' button is clicked
                // check if video exists in the VideoView
                if (videoviewPropertyVideo.getVisibility() == View.VISIBLE){
                    // Show dialog if video exists in VideoView
                    AlertDialog.Builder adbD = new AlertDialog.Builder(MainActivity.this);
                    adbD.setTitle(getString(R.string.choose_a_video)); //Title of alert dialog
                    adbD.setIcon(android.R.drawable.ic_dialog_alert); // Icon of alert dialog (warning sign)
                    adbD.setCancelable(false); // Prevent user from tapping outside dialog to cancel
                    adbD.setMessage(getString(R.string.replacevideo_warning)); // Message of alert dialog

                    adbD.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // If OK button is clicked, launch video capture intent
                            Intent choosevideoIntent = new Intent();
                            choosevideoIntent.setType("video/*");
                            choosevideoIntent.setAction(Intent.ACTION_GET_CONTENT);
                            startActivityForResult(Intent.createChooser(choosevideoIntent, getString(R.string.select_a_video)), REQUEST_VIDEO_PICKER);
                        }
                    });

                    adbD.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss(); // Dismiss the dialog
                        }
                    });

                    adbD.show(); // Show the alert dialog
                } else {
                    // If video doesn't exist in VideoView, launch video picker intent
                    Intent choosevideoIntent = new Intent();
                    choosevideoIntent.setType("video/*");
                    choosevideoIntent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(Intent.createChooser(choosevideoIntent, getString(R.string.select_a_video)), REQUEST_VIDEO_PICKER);
                }
            }
        });


        // click event for 'Remove video' button
        btnRemovePropertyVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // perform all of the following functions when the 'Remove video' button is clicked
                // check if video exists in the VideoView
                if (videoviewPropertyVideo.getVisibility() == View.VISIBLE){
                    // Show dialog if video exists in VideoView
                    AlertDialog.Builder adbD = new AlertDialog.Builder(MainActivity.this);
                    adbD.setTitle(getString(R.string.remove_video)); // Title of alert dialog
                    adbD.setIcon(android.R.drawable.ic_dialog_alert); // Icon of alert dialog (warning sign)
                    adbD.setCancelable(false); // Prevent user from tapping outside dialog to cancel
                    adbD.setMessage(getString(R.string.removevideo_warning)); // Message of alert dialog

                    adbD.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Show toast stating that Video was successfully deleted
                            Toast.makeText(MainActivity.this, R.string.video_removed_successfully, Toast.LENGTH_LONG).show(); // show a toast

                            videoviewPropertyVideo.setVisibility(View.GONE); //Remove video from 'Property Video' ImageView
                        }
                    });

                    adbD.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss(); // Dismiss the dialog
                        }
                    });

                    adbD.show(); //Show the alert dialog
                } else {
                    // If text doesn't exist in image view, show toast stating that video doesn´t exist
                    Toast.makeText(MainActivity.this, R.string.video_doesnt_exist, Toast.LENGTH_SHORT).show(); // show a toast
                }
            }
        });

        // click event for 'Choose a location' button
        btnPropertyLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // perform all of the following functions when the 'Choose a location' button is clicked
                // check if text exists in the TextView
                if (textviewPropertyAddress.getVisibility() == View.VISIBLE){
                    // Show dialog if text exists in TextView
                    AlertDialog.Builder adbD = new AlertDialog.Builder(MainActivity.this);
                    adbD.setTitle(getString(R.string.choose_a_location)); // Title of alert dialog
                    adbD.setIcon(android.R.drawable.ic_dialog_alert); // Icon of alert dialog (warning sign)
                    adbD.setCancelable(false); // Prevent user from tapping outside dialog to cancel
                    adbD.setMessage(getString(R.string.replacelocation_warning)); // Message of alert dialog

                    adbD.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            textviewPropertyAddress.setVisibility(View.GONE); //Remove text from 'Property Address' TextView

                            PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
                            try {
                                startActivityForResult(builder.build(MainActivity.this), REQUEST_PLACE_PICKER);
                            } catch (GooglePlayServicesRepairableException e) {
                                Log.e(TAG, "onClick: GooglePlayServicesRepairableException: " + e.getMessage() );
                            } catch (GooglePlayServicesNotAvailableException e) {
                                Log.e(TAG, "onClick: GooglePlayServicesNotAvailableException: " + e.getMessage() );
                            }
                        }
                    });

                    adbD.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss(); // Dismiss the dialog
                        }
                    });

                    adbD.show(); // Show the alert dialog
                } else {
                    PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
                    try {
                        startActivityForResult(builder.build(MainActivity.this), REQUEST_PLACE_PICKER);
                    } catch (GooglePlayServicesRepairableException e) {
                        Log.e(TAG, "onClick: GooglePlayServicesRepairableException: " + e.getMessage() );
                    } catch (GooglePlayServicesNotAvailableException e) {
                        Log.e(TAG, "onClick: GooglePlayServicesNotAvailableException: " + e.getMessage() );
                    }
                }
            }
        });


        // click event for 'Remove location' button
        btnRemovePropertyLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // perform all of the following functions when the 'Remove location' button is clicked
                // check if text exists in the TextView
                if (textviewPropertyAddress.getVisibility() == View.VISIBLE){
                    // Show dialog if text exists in TextView
                    AlertDialog.Builder adbD = new AlertDialog.Builder(MainActivity.this);
                    adbD.setTitle(getString(R.string.remove_location)); // Title of alert dialog
                    adbD.setIcon(android.R.drawable.ic_dialog_alert); // Icon of alert dialog (warning sign)
                    adbD.setCancelable(false); // Prevent user from tapping outside dialog to cancel
                    adbD.setMessage(getString(R.string.removelocation_warning)); // Message of alert dialog

                    adbD.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Show toast stating that Image was successfully deleted
                            Toast.makeText(MainActivity.this, R.string.location_removed_successfully, Toast.LENGTH_LONG).show(); // show a toast

                            textviewPropertyAddress.setVisibility(View.GONE); // Remove text from 'Property Address' TextView
                        }
                    });

                    adbD.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Show toast stating that text was not deleted
                            Toast.makeText(MainActivity.this, R.string.property_location_has_not_been_removed, Toast.LENGTH_LONG).show(); //show a toast

                            dialog.dismiss(); // Dismiss the dialog
                        }
                    });

                    adbD.show(); // Show the alert dialog
                } else {
                    // If text doesn't exist in image view, show toast stating that text doesn´t exist
                    Toast.makeText(MainActivity.this, R.string.location_doesnt_exist, Toast.LENGTH_SHORT).show(); //show a toast
                }
            }
        });


        // click event for 'Add nearest station' button
        btnAddNearestStation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // perform all of the following functions when the 'Add a station' button is clicked
                LayoutInflater layoutInflater =
                        (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View addView = layoutInflater.inflate(R.layout.nearests_row, null);
                final TextView textOut = addView.findViewById(R.id.textView_nearestS);
                textOut.setText(edittextNearestStation.getText().toString());
                Button buttonRemove = addView.findViewById(R.id.btn_removeS);
                buttonRemove.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        ((LinearLayout)addView.getParent()).removeView(addView);
                    }});

                containerNearestStations.addView(addView, 0);

                edittextNearestStation.setText(null); // clear text from the 'edittextNearestStation' EditText field
            }
        });


        // click event for 'Add nearest school' button
        btnAddNearestSchool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // perform all of the following functions when the 'Add a station' button is clicked
                LayoutInflater layoutInflater =
                        (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View addView = layoutInflater.inflate(R.layout.nearests_row, null);
                final TextView textOut = addView.findViewById(R.id.textView_nearestS);
                textOut.setText(edittextNearestSchool.getText().toString());

                Button buttonRemove = addView.findViewById(R.id.btn_removeS);
                buttonRemove.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        ((LinearLayout)addView.getParent()).removeView(addView);
                    }
                });

                containerNearestSchools.addView(addView, 0);

                edittextNearestSchool.setText(null); // clear text from the 'edittextNearestSchool' EditText field
            }
        });


        // click event for 'submit' button
        Button buttonSubmit = this.findViewById(R.id.btn_submit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // perform all of the following functions when the 'submit' button is clicked

                hideKeyboard(); // hide the on-screen keyboard, because the Android system doesn't do this automatically

                // 'Property type' Spinner decision making
                if (spinnerPropertyType.getSelectedItemPosition() == 0) { // if the selected item of 'spinnerPropertytype' spinner is 'choose bedroom quantity...',
                    textviewErrorPropertyType.setVisibility(View.VISIBLE); // ...make the 'textviewErrorPropertyType' text view visible
                } else {
                    textviewErrorPropertyType.setVisibility(View.INVISIBLE); // otherwise, make the 'textviewErrorPropertyType' text view invisible
                }

                // 'Bedrooms' SeekBar decision making
                if (seekbarBedrooms.getProgress() == 0) { // if the progress of 'seekbarBedrooms' SeekBar is '0',
                    textviewErrorBedrooms.setVisibility(View.VISIBLE); // make the 'textviewErrorBedrooms' text view visible
                } else {
                    textviewErrorBedrooms.setVisibility(View.INVISIBLE); // otherwise, make the 'textviewErrorBedrooms' text view invisible
                }

                // 'Property addition date' EditText decision making
                if (edittextPropertyAdditionDate.getText().length() == 0) { // if the 'edittextPropertyAdditionDate' EditText field is empty (contains 0 characters),
                    textviewErrorPropertyAdditionDate.setVisibility(View.VISIBLE); // make the 'textviewErrorPropertyAdditionDate' text view visible
                } else {
                    textviewErrorPropertyAdditionDate.setVisibility(View.INVISIBLE); // otherwise, make the 'textviewErrorPropertyAdditionDate' text view invisible
                }

                // 'Property addition time' EditText decision making
                if (edittextPropertyAdditionTime.getText().length() == 0) { // if the 'edittextPropertyAdditionTime' EditText field is empty (contains 0 characters),
                    textviewErrorPropertyAdditionTime.setVisibility(View.VISIBLE); // make the 'textviewErrorPropertyAdditionTime' text view visible
                } else {
                    textviewErrorPropertyAdditionTime.setVisibility(View.INVISIBLE); // otherwise, make the 'textviewErrorPropertyAdditionTime' text view invisible
                }

                // 'Monthly rent' EditText decision making
                if (edittextMonthlyRent.getText().length() == 0) { // if the 'edittextMonthlyRent' EditText field is empty (contains 0 characters),
                    textviewErrorMonthlyRent.setVisibility(View.VISIBLE); // make the 'textviewErrorMonthlyRent' text view visible
                } else {
                    textviewErrorMonthlyRent.setVisibility(View.INVISIBLE); // otherwise, make the 'textviewErrorMonthlyRent' text view invisible
                }

                // 'Reporter name' EditText decision making
                if (edittextReporterName.getText().length() < 2) { // if the 'edittextReporterName' EditText field has less than 2 characters,
                    textviewErrorReporterName.setVisibility(View.VISIBLE); // make the 'textviewErrorReporterName' text view visible
                } else {
                    textviewErrorReporterName.setVisibility(View.INVISIBLE); // otherwise, make the 'textviewErrorReporterName' text view invisible
                }

                // 'Terms and Conditions' CheckBox decision making
                if (!checkboxTermsAndConditions.isChecked()) { // if the 'Terms and Conditions' CheckBox is not checked
                    Toast.makeText(MainActivity.this, R.string.you_must_agree_to_termsandconditions, Toast.LENGTH_LONG).show(); // show a toast
                } else {
                    showalerdialogDetailsEntered();
                }
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance(); //new Calendar instance
        c.set(Calendar.YEAR, year); //show current year of device (data passed by 'int year' variable)
        c.set(Calendar.MONTH, month); //show current month of device (data passed by 'int month' variable)
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth); //show current day (of the month) of device (data passed by 'int dayOfMonth' variable)
        String currentDateString = DateFormat.getDateInstance(DateFormat.SHORT).format(c.getTime()); // use the short date format when displaying the date

        edittextPropertyAdditionDate.setText(currentDateString); // set text of 'edittextPropertyAdditionDate' EditText to the 'currentDateString' variable
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        edittextPropertyAdditionTime.setText(String.format("%02d:%02d", hourOfDay, minute)); // set text of 'edittextPropertyAdditionDate' EditText to the 'currentDateString' variable
        // '%02d:%02d' prevents any zeros from being omitted upon time selection
    }

    private void hideKeyboard() {
        View view = getCurrentFocus();
        if (view != null) {
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).
                    hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        // Return true so Android will know that we want to display the menu
        return true;
    }

    //show user-defined details from all field in AlertDialog
    private void showalerdialogDetailsEntered() {
        AlertDialog.Builder adbDE = new AlertDialog.Builder(this);
        adbDE.setTitle(getString(R.string.details_entered)); // Title of alert dialog
        adbDE.setIcon(android.R.drawable.ic_dialog_info); // Icon of alert dialog (information sign)
        adbDE.setCancelable(false); // Prevent user from tapping outside dialog to cancel
        adbDE.setMessage(getString(R.string.property_type_) + "\u0020" + spinnerPropertyType.getSelectedItem().toString() + "\n\n" +
                getString(R.string.bedrooms_) + "\u0020" + textviewSeekbarBedrooms.getText() + "\n\n" +
                getString(R.string.property_addition_date_) + "\u0020" + edittextPropertyAdditionDate.getText() + "\n\n" +
                getString(R.string.property_addition_time_) + "\u0020" + edittextPropertyAdditionTime.getText() + "\n\n" +
                getString(R.string.monthly_rent_) + "\u0020" + edittextMonthlyRent.getText() + "\n\n" +
                getString(R.string.furniture_type_) + "\u0020" + spinnerFurnitureType.getSelectedItem().toString() + "\n\n" +
                getString(R.string.property_description_) + "\u0020" + edittextDescription.getText() + "\n\n" +
                getString(R.string.reporter_name_) + "\u0020" + edittextReporterName.getText()
        ); // Message of alert dialog


        adbDE.setNeutralButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss(); // Dismiss the dialog
            }
        });

        adbDE.show(); // Show the alert dialog
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_reset:
                // User chose the "Reset" item, show confirm dialog ...

                AlertDialog.Builder adb = new AlertDialog.Builder(this);
                adb.setTitle(getString(R.string.reset_form)); // Title of alert dialog
                adb.setIcon(android.R.drawable.ic_dialog_alert); // Icon of alert dialog (warning sign)
                adb.setCancelable(false); // Prevent user from tapping outside dialog to cancel
                adb.setMessage(getString(R.string.reset_warning)); // Message of alert dialog

                adb.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, R.string.all_entered_information_cleared_and_reset_successfully, Toast.LENGTH_LONG).show(); // show a toast

                        spinnerPropertyType.setSelection(0); // set 'Property Type' Spinner position to 0
                        seekbarBedrooms.setProgress(0); // set progress of 'Bedrooms' SeekBar to 0
                        seekbarBathrooms.setProgress(0); // set progress of 'Bathrooms' SeekBar to 0
                        edittextPropertyAdditionDate.setText(""); // Clear text from 'Property Addition Date' EditText field
                        edittextPropertyAdditionTime.setText(""); // Clear text from 'Property Addition Time' EditText field
                        edittextMonthlyRent.setText(""); // Clear text from 'Monthly Rent' EditText field
                        spinnerFurnitureType.setSelection(0); // set 'Furniture Type' Spinner position to 0
                        edittextDescription.setText(""); // Clear text from 'Notes' EditText field
                        edittextReporterName.setText(""); // Clear text from 'Reporter Name' EditText field
                        radiogroupPetsAllowed.clearCheck(); // Clear selection from 'Pets allowed' RadioGroup
                        radiogroupWheelchairAccessible.clearCheck(); // Clear selection from 'Wheelchair accessible' RadioGroup
                        seekbarEnergyEfficiencyRating.setProgress(0); // set 'Energy Efficiency Rating' SeekBar position to 0
                        seekbarEnvironmentalImpactRating.setProgress(0); // set progress of 'Environmental Impact Rating' SeekBar to 0
                        imgviewPropertyPhoto.setImageDrawable(null); // Remove image from 'Property Photo' ImageView
                        textviewPropertyAddress.setText(""); // Clear text from 'Property Location' TextView field
                        edittextNearestStation.setText(""); // Clear text from 'Nearest Stations' EditText field
                        edittextNearestSchool.setText(""); // Clear text from 'Nearest Schools' EditText field

                        // if the 'Terms and Conditions' CheckBox is checked, uncheck it
                        if (checkboxTermsAndConditions.isChecked()) {
                            checkboxTermsAndConditions.setChecked(false);
                        }

                        textviewErrorPropertyType.setVisibility(View.INVISIBLE); // make 'textViewerror_propertytype' text view INVISIBLE (not GONE) to keep space between items
                        textviewErrorBedrooms.setVisibility(View.INVISIBLE); // make 'textViewerror_bedrooms' text view INVISIBLE (not GONE) to keep space between items
                        textviewErrorPropertyAdditionDate.setVisibility(View.INVISIBLE); // make 'textViewerror_propertytype' text view INVISIBLE (not GONE) to keep space between items
                        textviewErrorPropertyAdditionTime.setVisibility(View.INVISIBLE); // make 'textviewErrorPropertyAdditionTime' text view INVISIBLE (not GONE) to keep space between items
                        textviewErrorMonthlyRent.setVisibility(View.INVISIBLE); // make 'textviewErrorMonthlyRent' text view INVISIBLE (not GONE) to keep space between items
                        textviewErrorReporterName.setVisibility(View.INVISIBLE); // make 'textviewErrorReporterName' text view INVISIBLE (not GONE) to keep space between items
                    }
                });

                adb.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, R.string.all_entered_information_has_not_been_cleared_nor_reset, Toast.LENGTH_LONG).show(); // show a toast
                        dialog.dismiss(); // Dismiss the dialog
                    }
                });

                adb.show(); // Show the alert dialog

                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void dispatchTakeVideoIntent() {
        Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (takeVideoIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takeVideoIntent, REQUEST_VIDEO_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // 'super.onActivityResult' isn't necessary unless using a FragmentActivity

        // check to see if the result is from Camera intent | ensure the Camera request was successful
        if (requestCode == REQUEST_PHOTO_CAPTURE && resultCode == RESULT_OK) {
            //hearing back from the camera
            Bundle extras = data.getExtras();
            Bitmap bitmap = (Bitmap) extras.get("data");

            imgviewPropertyPhoto.setVisibility(View.VISIBLE);

            //at this point, image has been obtained from the camera
            imgviewPropertyPhoto.setImageBitmap(bitmap);
        }

        // check to see if the result is from Gallery intent | ensure the Gallery request was successful
        if (requestCode == REQUEST_PHOTO_PICKER && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri uri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);

                imgviewPropertyPhoto.setVisibility(View.VISIBLE);

                imgviewPropertyPhoto.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // check to see if the result is from Camera intent | ensure the video recording request was successful
        if (requestCode == REQUEST_VIDEO_CAPTURE && resultCode == RESULT_OK) {
            Uri videoUri = data.getData();
            videoviewPropertyVideo.setVideoURI(videoUri);

            videoviewPropertyVideo.setVisibility(View.VISIBLE);

            videoviewPropertyVideo.start();
        }

        // check to see if the result is from Gallery intent | ensure the Gallery request was successful
        if (requestCode == REQUEST_VIDEO_PICKER && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri videoUri = data.getData();
            videoviewPropertyVideo.setVideoURI(videoUri);

            videoviewPropertyVideo.setVisibility(View.VISIBLE);

            videoviewPropertyVideo.start();
        }

        // check to see if the result is from Place Picker intent
        if (requestCode == REQUEST_PLACE_PICKER) {
            // ensure the request was successful
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(this, data);
                Resources res = getResources();

                String chosenAddressforToast = String.format(res.getString(R.string.selected_location), place.getAddress()); // %1$s in the 'selected_location' string is a placeholder representing whichever address the user has chosen
                Toast.makeText(this, chosenAddressforToast, Toast.LENGTH_LONG).show(); // show toast to inform user which address was selected

                textviewPropertyAddress.setVisibility(View.VISIBLE);

                textviewPropertyAddress.setText(place.getAddress()); // show selected address in the TextView
            }
        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}