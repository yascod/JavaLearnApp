package com.example.javalearnapp;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.DragEvent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@SuppressLint("NewApi")
public class Aufgabe2 extends AppCompatActivity {

    private Button lsg;
    private Button reset;
    private TextView option1, option2, option3, choice1, choice2, choice3;
    public CharSequence dragData;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aufgabe2);

        lsg= findViewById(R.id.lsg);
        reset= findViewById(R.id.reset);

        //get both sets of text views

        //views to drag
        option1 = (TextView)findViewById(R.id.option_1);
        option2 = (TextView)findViewById(R.id.option_2);
        option3 = (TextView)findViewById(R.id.option_3);

        //views to drop onto
        choice1 = (TextView)findViewById(R.id.choice_1);
        choice1.setTextColor(getResources().getColor(android.R.color.transparent));
        choice2 = (TextView)findViewById(R.id.choice_2);
        choice2.setTextColor(getResources().getColor(android.R.color.transparent));
        choice3 = (TextView)findViewById(R.id.choice_3);
        choice3.setTextColor(getResources().getColor(android.R.color.transparent));

        //set touch listeners
        option1.setOnTouchListener(new ChoiceTouchListener());
        option2.setOnTouchListener(new ChoiceTouchListener());
        option3.setOnTouchListener(new ChoiceTouchListener());

        //set drag listeners
        choice1.setOnDragListener(new ChoiceDragListener());
        choice2.setOnDragListener(new ChoiceDragListener());
        choice3.setOnDragListener(new ChoiceDragListener());

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityAufgabe2();
            }
        });

        lsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(option1.getText().toString().equals(choice1.getText().toString())&&
                        option2.getText().toString().equals(choice2.getText().toString())&&
                        option3.getText().toString().equals(choice3.getText().toString())){
                    Toast.makeText(Aufgabe2.this, "Richtig!", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(Aufgabe2.this, "Falsch!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    /**
     * ChoiceTouchListener will handle touch events on draggable views
     *
     */
    private final class ChoiceTouchListener implements View.OnTouchListener {
        @SuppressLint("NewApi")
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                /*
                 * Drag details: we only need default behavior
                 * - clip data could be set to pass data as part of drag
                 * - shadow can be tailored
                 */
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                //start dragging the item touched
                view.startDrag(data, shadowBuilder, view, 0);
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * DragListener will handle dragged views being dropped on the drop area
     * - only the drop action will have processing added to it as we are not
     * - amending the default behavior for other parts of the drag process
     *
     */
    @SuppressLint("NewApi")
    private class ChoiceDragListener implements View.OnDragListener {

        @Override
        public boolean onDrag(View v, DragEvent event) {

            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    //no action necessary
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    //no action necessary
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    //no action necessary
                    break;
                case DragEvent.ACTION_DROP:

                    //handle the dragged view being dropped over a drop view
                    View view = (View) event.getLocalState();
                    //view dragged item is being dropped on
                    TextView dropTarget = (TextView) v;
                    //view being dragged and dropped
                    TextView dropped = (TextView) view;
                    //////////////////////////////////////////////////////////////

                    //stop displaying the view where it was before it was dragged
                    view.setVisibility(View.INVISIBLE);
                    //update the text in the target view to reflect the data being dropped
                    dropTarget.setText(/*dropTarget.getText().toString() +*/ dropped.getText().toString());
                    dropTarget.setTextColor(getResources().getColor(android.R.color.black));
                    //make it bold to highlight the fact that an item has been dropped
                    dropTarget.setTypeface(Typeface.DEFAULT_BOLD);
                    //if an item has already been dropped here, there will be a tag
                    Object tag = dropTarget.getTag();


                    //checking whether first character of dropTarget equals first character of dropped


                    ////////////////////////////////////////////
                case DragEvent.ACTION_DRAG_ENDED:
                    //no action necessary
                    break;
                default:
                    break;
            }
            return true;
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void openActivityAufgabe2(){
        Intent intent2 = new Intent(this, Aufgabe2.class);
        finish();
        startActivity(intent2);
    }
}
