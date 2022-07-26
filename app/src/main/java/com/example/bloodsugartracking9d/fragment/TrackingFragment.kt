package com.example.bloodsugartracking9d.fragment


import android.app.AlertDialog
import android.os.Bundle
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bloodsugartracking9d.R
import com.example.bloodsugartracking9d.adapters.Measurements_recycler_Adapter
import com.example.bloodsugartracking9d.databinding.TrackingFragmentBinding
import com.example.bloodsugartracking9d.koincomponents.ViewmodelKoin
import com.example.bloodsugartracking9d.room.UserDetail
import com.example.bloodsugartracking9d.unit_mmol
import com.takisoft.datetimepicker.DatePickerDialog
import com.takisoft.datetimepicker.TimePickerDialog
import com.takisoft.datetimepicker.widget.DatePicker
import com.takisoft.datetimepicker.widget.TimePicker
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*
import kotlin.collections.ArrayList


class TrackingFragment : Fragment(), View.OnClickListener {

    lateinit var trackingFragmentBinding: TrackingFragmentBinding
    var unit_selected: String? = null

    private val mViewModel: ViewmodelKoin by viewModel()
    lateinit var radio_button: RadioButton
    val measurements = ArrayList<Int>()
    lateinit var measurements_adapter: Measurements_recycler_Adapter
    var medicines: Boolean = false
    lateinit var calendar: Calendar
    var gettime: String? = null
    var getdate: String? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        trackingFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.tracking_fragment, container, false)
        trackingFragmentBinding.buttonSave.setOnClickListener(this)
        trackingFragmentBinding.vTime.setOnClickListener(this)
        trackingFragmentBinding.vDate.setOnClickListener(this)
        trackingFragmentBinding.vMeasurementtime.setOnClickListener(this)
        calendar = Calendar.getInstance()
       // add_recycler_view_measurements()

        measurements.clear()
        for (i in 1..600) {

            measurements.add(i)

        }

        set_adapter(measurements)
        return trackingFragmentBinding.root
    }


    fun add_recycler_view_measurements() {

        mViewModel.get_unit_selected.observe(viewLifecycleOwner, androidx.lifecycle.Observer {

            unit_selected = it

            if (unit_selected == unit_mmol) {

                CoroutineScope(Dispatchers.Main).launch {

                    measurements.clear()
                    for (i in 1..600) {
                        measurements.add(i)
                    }
                }

            } else {
                CoroutineScope(Dispatchers.Main).launch {
                    measurements.clear()
                    var i  = 0.0
                    while (i <= 35) {
                        println("value:$i")
                        i += 0.1
                        measurements.add(i.toInt())
                    }
                }



            }

            set_adapter(measurements)

        })



    }

    fun set_adapter(measurements : ArrayList<Int>){

        measurements_adapter = Measurements_recycler_Adapter(measurements)
        trackingFragmentBinding.measurementRecyclerView.setLayoutManager(LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false))
        trackingFragmentBinding.measurementRecyclerView.adapter = measurements_adapter
    }


    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.button_save -> {

                save_data()
            }

            R.id.v_time -> {

                //mViewModel.select_dialog(true)
                //Time_datepicker_Activity.open_timedatepicker(requireActivity())
                show_time_picker()
            }

            R.id.v_date -> {

                //  mViewModel.select_dialog(false)
                // open_measurement_dialog(requireActivity())

                show_date_picker()
            }


            R.id.v_measurementtime -> {

                open_measurement_dialog()
            }


        }
    }

    fun save_data() {

        CoroutineScope(Dispatchers.IO).launch {

            val gettime = trackingFragmentBinding.tvTime.text.toString()
            val getdate = trackingFragmentBinding.tvDate.text.toString()
            val getmeasurements = trackingFragmentBinding.tvMeasurementtime.text.toString()
            val getnotes = trackingFragmentBinding.tvNotes.text.toString()
            medicines = trackingFragmentBinding.checkbox.isChecked

            val userDetail =
                UserDetail(0, gettime, getdate, getmeasurements, "", getnotes, medicines)
            mViewModel.insert(userDetail)

        }

    }


    fun show_time_picker() {

        val tpd = TimePickerDialog(
            activity, { view1: TimePicker?, hourOfDay: Int, minute: Int ->

                getdate = String.format("%02d", hourOfDay) + ":" + String.format("%02d", minute)
                trackingFragmentBinding.tvTime.text = getdate
            },
            calendar.get(Calendar.HOUR_OF_DAY),
            calendar.get(Calendar.MINUTE),
            DateFormat.is24HourFormat(activity)
        )
        tpd.show()


    }


    fun show_date_picker() {

        val dpd = activity?.let {
            DatePickerDialog(
                it, { view1: DatePicker?, year: Int, month: Int, dayOfMonth: Int ->

                    gettime = String.format("%d", year) + "-" + String.format(
                        "%02d",
                        month + 1
                    ) + "-" + String.format("%02d", dayOfMonth)
                    trackingFragmentBinding.tvDate.text = gettime

                },

                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DATE)
            )
        }

        if (dpd != null) {
            dpd.show()
        }


    }

    fun open_measurement_dialog() {

        var dialogView: View
        var radio_group: RadioGroup
        var btnok: Button
        var btn_cancel: Button
        val dialogBuilder = AlertDialog.Builder(requireActivity()).create()
        val inflater = activity?.layoutInflater

        if (inflater != null) {
            dialogView = inflater.inflate(R.layout.measurement_dialog, null)
            radio_group = dialogView.findViewById(R.id.radio_group)
            btnok = dialogView.findViewById(R.id.btn_ok)
            btn_cancel = dialogView.findViewById(R.id.btn_cancel)

            btnok.setOnClickListener {

                val selectedId: Int = radio_group.getCheckedRadioButtonId()
                radio_button = radio_group.findViewById(selectedId) as RadioButton
                trackingFragmentBinding.tvMeasurementtime.text = radio_button.text.toString()

                dialogBuilder.dismiss()
            }

            btn_cancel.setOnClickListener {

                dialogBuilder.dismiss()
            }

            dialogBuilder.setView(dialogView)
            dialogBuilder.setCancelable(false)
            dialogBuilder.show()
        }


    }

    override fun onResume() {
        super.onResume()

        add_recycler_view_measurements()
    }


}




