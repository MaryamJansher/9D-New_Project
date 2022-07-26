package com.example.bloodsugartracking9d.activities

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.format.DateFormat
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.bloodsugartracking9d.R
import com.example.bloodsugartracking9d.databinding.ActivityTimeDatepickerBinding
import com.example.bloodsugartracking9d.koincomponents.ViewmodelKoin
import com.takisoft.datetimepicker.DatePickerDialog
import com.takisoft.datetimepicker.TimePickerDialog
import com.takisoft.datetimepicker.widget.DatePicker
import com.takisoft.datetimepicker.widget.TimePicker
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*


class Time_datepicker_Activity : AppCompatActivity() {


    companion object {
        fun open_timedatepicker(context: Context) {
            var intent = Intent(context, Time_datepicker_Activity::class.java)
            context.startActivity(intent)
            (context as Activity).overridePendingTransition(0, 0)


        }

    }

    lateinit var timeDatepickerBinding: ActivityTimeDatepickerBinding
    var hours: String? = null
    var minutes: String? = null
    var AM_PM: String? = null

    var day_selected: String? = null
    var month_selected: String? = null
    var year_selected: String? = null
    var time: String? = null
    var date: String? = null
    lateinit var calendar: Calendar
    val mViewModel: ViewmodelKoin by viewModel()
    var get_dialog_selected: Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        timeDatepickerBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_time_datepicker)
        calendar = Calendar.getInstance()




        if (get_dialog_selected == true){

            show_time_picker()

        }else {

            show_date_picker()
        }





        /*  timeDatepickerBinding.timePicker.setOnTimeChangedListener { _, hour, minute ->
              var hour = hour

              hours = hour.toString()
              minutes = minute.toString()
              var am_pm = ""
              // AM_PM decider logic
              when {
                  hour == 0 -> {
                      hour += 12
                      am_pm = "AM"
                  }
                  hour == 12 -> am_pm = "PM"
                  hour > 12 -> {
                      hour -= 12
                      am_pm = "PM"
                  }
                  else -> am_pm = "AM"
              }

              AM_PM = am_pm
              time = "$hours: $minutes: $AM_PM"


          }

  */
        /* timeDatepickerBinding.datePicker
         datePicker.init(
             today.get(Calendar.YEAR),
             today.get(Calendar.MONTH),
             today.get(Calendar.DAY_OF_MONTH)
         )

         { view, year, month, day ->
             val month = month + 1
             day_selected = day.toString()
             month_selected = month.toString()
             year_selected = year.toString()
             date = " $day $month,$year"


         }*/
    }

    fun show_date_picker() {


        /*DatePickerDialog
                                    .newInstance(null, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE))
                                    .show(getFragmentManager(), null);*/
        val dpd = DatePickerDialog(
            this@Time_datepicker_Activity,
            { view1: DatePicker?, year: Int, month: Int, dayOfMonth: Int ->
                Toast.makeText(
                    this@Time_datepicker_Activity,
                    String.format("%d", year) + "-" + String.format(
                        "%02d",
                        month + 1
                    ) + "-" + String.format("%02d", dayOfMonth),
                    Toast.LENGTH_SHORT
                ).show()
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DATE)
        )
        dpd.show()

    }


    fun show_time_picker() {

        val tpd = TimePickerDialog(
            this@Time_datepicker_Activity,
            { view1: TimePicker?, hourOfDay: Int, minute: Int ->
                Toast.makeText(
                    this@Time_datepicker_Activity,
                    String.format("%02d", hourOfDay) + ":" + String.format(
                        "%02d",
                        minute
                    ),
                    Toast.LENGTH_SHORT
                ).show()
            },
            calendar.get(Calendar.HOUR_OF_DAY),
            calendar.get(Calendar.MINUTE),
            DateFormat.is24HourFormat(this@Time_datepicker_Activity)
        )
        tpd.show()
    }
}
