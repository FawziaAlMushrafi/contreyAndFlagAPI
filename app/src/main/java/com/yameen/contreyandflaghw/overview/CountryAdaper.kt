package com.yameen.contreyandflaghw.overview


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yameen.contreyandflaghw.databinding.FragmentHwBinding
import com.yameen.contreyandflaghw.internet.DataItem


class CountryAdaper : ListAdapter<DataItem,
        CountryAdaper.CountryViewHolder>(DiffCallback) {

    class CountryViewHolder(
        private var binding:
        FragmentHwBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(countyData: DataItem) {
            binding.data = countyData
            binding.executePendingBindings()

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CountryViewHolder {
        return CountryViewHolder(
            FragmentHwBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val countryData = getItem(position)
        holder.bind(countryData)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<DataItem>() {
        override fun areItemsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: DataItem, newItem: DataItem): Boolean {
            return oldItem.flag == newItem.flag || oldItem.name == newItem.name
        }
    }
}
