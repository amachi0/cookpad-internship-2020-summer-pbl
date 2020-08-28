package jp.amachi0.cookpad_internship_2020_summer_pbl.nutrients

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import jp.amachi0.cookpad_internship_2020_summer_pbl.R
import jp.amachi0.cookpad_internship_2020_summer_pbl.databinding.FragmentNutrientsBinding
import jp.amachi0.cookpad_internship_2020_summer_pbl.model.Nutrients


class NutrientsFragment : Fragment(R.layout.fragment_nutrients) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentNutrientsBinding.bind(view)

        binding.buttonNext.setOnClickListener {
            val nutrients = Nutrients(
                calorie = binding.editCalorie.text.toString().toInt(),
                protein = binding.editProtein.text.toString().toInt(),
                lipid = binding.editLipid.text.toString().toInt()
            )

            val action = NutrientsFragmentDirections.actionNutrientsToFeeling(nutrients)
            findNavController().navigate(action)
        }
    }
}
