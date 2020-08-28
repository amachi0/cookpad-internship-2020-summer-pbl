package jp.amachi0.cookpad_internship_2020_summer_pbl.feeling

import com.xwray.groupie.databinding.BindableItem
import jp.amachi0.cookpad_internship_2020_summer_pbl.R
import jp.amachi0.cookpad_internship_2020_summer_pbl.databinding.ItemFeelingBinding

class FeelingItem(
    private val resId: Int,
    private val title: String,
    private val onClick: () -> Unit
) : BindableItem<ItemFeelingBinding>() {

    override fun getLayout(): Int = R.layout.item_feeling

    override fun bind(binding: ItemFeelingBinding, position: Int) {
        binding.imageView.setImageResource(resId)
        binding.textView.text = title
        binding.root.setOnClickListener {
            onClick()
        }
    }
}