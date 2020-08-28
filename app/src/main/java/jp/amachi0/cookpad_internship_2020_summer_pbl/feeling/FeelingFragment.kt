package jp.amachi0.cookpad_internship_2020_summer_pbl.feeling

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.databinding.GroupieViewHolder
import jp.amachi0.cookpad_internship_2020_summer_pbl.R
import jp.amachi0.cookpad_internship_2020_summer_pbl.databinding.FragmentFeelingBinding
import jp.amachi0.cookpad_internship_2020_summer_pbl.model.Feeling
import jp.amachi0.cookpad_internship_2020_summer_pbl.model.NutrientsAndFeeling

class FeelingFragment : Fragment(R.layout.fragment_feeling) {
    val args: FeelingFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentFeelingBinding.bind(view)

        val groupAdapter = GroupAdapter<GroupieViewHolder<*>>().apply { spanCount = 2 }
        binding.recycler.run {
            adapter = groupAdapter
            layoutManager = GridLayoutManager(this.context, groupAdapter.spanCount)
        }

        groupAdapter.update(
            createFeelingItems()
        )
    }

    private fun createFeelingItems(): List<FeelingItem> {
        val healthy = FeelingItem(R.drawable.assari, getString(R.string.healthy)) {
            navigateToRecipes(Feeling.HEALTHY)
        }

        val greasy = FeelingItem(R.drawable.kotteri, getString(R.string.greasy)) {
            navigateToRecipes(Feeling.GREASY)
        }
        val hot = FeelingItem(R.drawable.hot, getString(R.string.hot)) {}
        val cold = FeelingItem(R.drawable.cold, getString(R.string.cold)) {}

        return listOf(healthy, greasy, hot, cold)
    }

    private fun navigateToRecipes(feeling: Feeling) {
        val nutrientsAndFeeling = NutrientsAndFeeling(
            nutrients = args.nutrients,
            feeling = feeling
        )
        val action = FeelingFragmentDirections.actionFeelingToRecipes(nutrientsAndFeeling)
        findNavController().navigate(action)
    }
}
