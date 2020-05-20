package com.example.practiceandroidapp

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        selectDateBtn.setOnClickListener {view ->
            clickDatePicker(view)
        }


    }

    fun clickDatePicker(view: View){
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this, DatePickerDialog.OnDateSetListener {
                view, selectedYear, selectedMonth, selectedDayOfMonth ->
                val selectedDate = "${selectedMonth+1}/$selectedDayOfMonth/$selectedYear"




            val dateFormat = SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH)

            val formattedDate = dateFormat.parse(selectedDate)
            val formatTest = dateFormat.format(formattedDate)
            val formattedCurrentDate = dateFormat.format(myCalendar.time)

            val currentTime = myCalendar.time.time;
            val calculatedTimeInMinutes = (currentTime - formattedDate.time) / 1000 / 60
            Toast.makeText(this, "The selected date is ${formatTest} and current time is $formattedCurrentDate", Toast.LENGTH_LONG).show()
            selectedDateView.setText(selectedDate)
            ageInMinutes.setText(calculatedTimeInMinutes.toString())
        },year
        ,month
        ,day).show()
    }

}
