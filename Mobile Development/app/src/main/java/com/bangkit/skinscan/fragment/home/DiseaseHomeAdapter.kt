package com.bangkit.skinscan.fragment.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.skinscan.data.Disease
import com.bangkit.skinscan.databinding.ActivityDetailHomeBinding

class DiseaseHomeAdapter(private val listDisease : ArrayList<Disease>): RecyclerView.Adapter<DiseaseHomeAdapter.ViewHolder>() {
    class ViewHolder(var binding: ActivityDetailHomeBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ActivityDetailHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listDisease.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val disease = listDisease[position]
        holder.binding.imageView.setImageResource(disease.img)
        holder.binding.textViewUsername.text = disease.name
        holder.binding.root.setOnClickListener {
//            val intent = Intent(holder.binding.root.context, DetailItemHomeActivity::class.java)
//            intent.putExtra(DetailItemHomeActivity.EXTRA_USER, disease)
//            holder.binding.root.context.startActivity(intent, )
        }
    }
}