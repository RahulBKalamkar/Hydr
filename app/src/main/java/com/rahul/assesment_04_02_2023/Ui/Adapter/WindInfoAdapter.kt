package com.rahul.assesment_04_02_2023.Ui.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rahul.assesment_04_02_2023.Data.Model.Dataseries
import com.rahul.assesment_04_02_2023.R
import com.rahul.assesment_04_02_2023.databinding.ItemLayoutBinding

class WindInfoAdapter(
    private val articleList: ArrayList<Dataseries>
) : RecyclerView.Adapter<WindInfoAdapter.DataViewHolder>() {

    class DataViewHolder(private val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(dataseries: Dataseries) {
            binding.textViewDirection.text = "Wind direction " + dataseries.wind10m?.direction
            binding.textViewVisibility.text = "Visibility " + dataseries.seeing
            binding.textViewTemp.text = "Temperature " + dataseries.temp2m + " C"
            if (dataseries.precType.toString().equals("rain")) {
                binding.imageViewCloud.setImageResource(R.drawable.rainy)
            } else {
                binding.imageViewCloud.setImageResource(R.drawable.sunny)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            ItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = articleList.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(articleList[position])

    fun addData(list: List<Dataseries>) {
        articleList.addAll(list)
    }

}