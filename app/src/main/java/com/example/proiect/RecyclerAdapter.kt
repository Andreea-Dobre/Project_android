import com.example.proiect.R

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class RecyclerAdapter(myList: MutableList<String>): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var list_of_items: MutableList<String> = myList
    private var icons = intArrayOf(R.drawable.index,R.drawable.index,R.drawable.index,R.drawable.index,R.drawable.index,R.drawable.index)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.itemTitle.text = list_of_items[position]
        holder.itemImage.setImageResource(icons[position])
    }

    override fun getItemCount(): Int {
        return list_of_items.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        lateinit var itemImage: ImageView
        lateinit var itemTitle: TextView

        init {
            itemImage = itemView.findViewById(R.id.itemImage)
            itemTitle = itemView.findViewById(R.id.itemTitle)

            itemView.setOnClickListener{
                val position: Int = absoluteAdapterPosition
               // Toast.makeText(itemView.context, "Click on ${list_of_items[position]}", Toast.LENGTH_LONG)
            }
        }
    }

}