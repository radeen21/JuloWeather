package com.example.feature_home.presentation.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entities.DailyWeatherItemEntities
import com.example.feature_home.databinding.ItemListWeatherBinding
import java.text.SimpleDateFormat
import java.time.DayOfWeek
import java.time.LocalDate
import java.util.*

class HomeAdapter (private val data: List<DailyWeatherItemEntities>?) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, pos: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        val binding =
            ItemListWeatherBinding.inflate(inflater, viewGroup, false)
        return WeatherDailyViewHolder(binding)
    }

    var onClickedLister: OnClickedListener? = null

    override fun getItemCount(): Int {
        return data?.size!!
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, pos: Int) {
        val dataList = data!![pos]
        (viewHolder as WeatherDailyViewHolder).bind(dataList)
        viewHolder.setOnClickListener(View.OnClickListener {
            onClickedLister?.onItemClicked(
                dataList
            )
        })
    }

    interface OnClickedListener {
        fun onItemClicked(data: DailyWeatherItemEntities)
    }

    inner class WeatherDailyViewHolder(val itemReviewBinding: ItemListWeatherBinding) :
        RecyclerView.ViewHolder(itemReviewBinding.root) {

        fun bind(daily: DailyWeatherItemEntities) {
            val updatedAtText = getDateTime(daily.dt.toLong())
            itemReviewBinding.tvDay.text = updatedAtText.toString()
            itemReviewBinding.tvCelsiusDay.text = daily.temp.min.toString() + 0x00B0.toChar()

            daily.temp.min.toString().substringBefore(".") + "°"

        }

        fun setOnClickListener(listener: View.OnClickListener) {
            itemView.setOnClickListener(listener)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun getDateTime(s: Long): DayOfWeek? {
        return try {
            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.US)
            val netDate = Date(s * 1000)
            val formattedDate = sdf.format(netDate)

            LocalDate.of(
                formattedDate.substringAfterLast("/").toInt(),
                formattedDate.substringAfter("/").take(2).toInt(),
                formattedDate.substringBefore("/").toInt()
            )
                .dayOfWeek
        } catch (e: Exception) {
            e.printStackTrace()
            DayOfWeek.MONDAY
        }
    }

}