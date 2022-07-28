package android.bignerdranch.catsanddogs.presentation.adapters

import android.bignerdranch.catsanddogs.data.network.model.CatsFactDto
import android.bignerdranch.catsanddogs.databinding.ItemBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class AnimalAdapter : RecyclerView.Adapter<AnimalViewHolder>() {

    private var mutableDogList = mutableListOf<String>()

    fun setDogsList(dogs: List<String>) {
        mutableDogList = dogs as MutableList<String>
        notifyDataSetChanged()
    }
    private var mutableCatList = mutableListOf<CatsFactDto>()

    fun setCatsList(cats: List<CatsFactDto>) {
        mutableCatList = cats as MutableList<CatsFactDto>
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemBinding.inflate(layoutInflater, parent, false)
        return AnimalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val dogImageUrl = mutableDogList[position]

        with(holder) {
            val ivDogImage = binding.itemPoster
            Picasso.get().load(dogImageUrl).into(ivDogImage)

            if (mutableCatList.isNotEmpty()) { //без этой проверки приложение крашится
                val catFact = mutableCatList[position].fact
                val itemText = binding.itemText
                itemText.text = catFact
            }
        }
    }

    override fun getItemCount(): Int {
        return mutableDogList.size
    }

    fun addNewDogsItems(items: List<String>) {
        mutableDogList.addAll(items)
        notifyDataSetChanged()
    }

    fun addNewCatsItems(items: List<CatsFactDto>) {
        mutableCatList.addAll(items)
        notifyDataSetChanged()
    }
}

class AnimalViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root)


