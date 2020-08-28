package jp.amachi0.cookpad_internship_2020_summer_pbl.recipes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import jp.amachi0.cookpad_internship_2020_summer_pbl.R
import jp.amachi0.cookpad_internship_2020_summer_pbl.model.Menu

class CardStackAdapter(
    private var menus: List<Menu> = emptyList()
) : RecyclerView.Adapter<CardStackAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardStackAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.item_recipe, parent, false))
    }

    override fun onBindViewHolder(holder: CardStackAdapter.ViewHolder, position: Int) {
        val menu = menus[position]
        holder.titleView.text = menu.menuTitle
        menu.calculateNutrients().let {
            holder.calorieView.text = it.calorie.toString()
            holder.proteinView.text = it.protein.toString()
            holder.lipidView.text = it.lipid.toString()
        }
        Glide.with(holder.imageMainView).load(menu.mainDish.image).into(holder.imageMainView)
        Glide.with(holder.imageSideView).load(menu.sideDish.image).into(holder.imageSideView)
    }

    fun setMenus(menus: List<Menu>) {
        this.menus = menus
    }

    override fun getItemCount(): Int = menus.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleView: TextView = view.findViewById(R.id.recipe_title)
        val calorieView: TextView = view.findViewById(R.id.recipe_calorie)
        val proteinView: TextView = view.findViewById(R.id.recipe_protein)
        val lipidView: TextView = view.findViewById(R.id.recipe_lipid)
        val imageMainView: ImageView = view.findViewById(R.id.image_main)
        val imageSideView: ImageView = view.findViewById(R.id.image_side)
    }

}