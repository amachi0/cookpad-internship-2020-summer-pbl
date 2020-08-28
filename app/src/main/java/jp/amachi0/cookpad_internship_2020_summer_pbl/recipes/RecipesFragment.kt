package jp.amachi0.cookpad_internship_2020_summer_pbl.recipes

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.yuyakaido.android.cardstackview.CardStackLayoutManager
import com.yuyakaido.android.cardstackview.CardStackListener
import com.yuyakaido.android.cardstackview.Direction
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import jp.amachi0.cookpad_internship_2020_summer_pbl.R
import kotlinx.android.synthetic.main.fragment_recipes.*
import javax.inject.Inject

class RecipesFragment : Fragment(R.layout.fragment_recipes),
    HasAndroidInjector,
    CardStackListener {
    val args: RecipesFragmentArgs by navArgs()

    private val manager by lazy { CardStackLayoutManager(context, this) }
    private val cardStackAdapter = CardStackAdapter()

    @Inject
    lateinit var viewModel: RecipesViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cardStackView.run {
            layoutManager = manager
            adapter = cardStackAdapter
        }

        viewModel.recipes.observe(viewLifecycleOwner) {
            cardStackAdapter.setMenus(it)
            cardStackAdapter.notifyDataSetChanged()
        }

        viewModel.updateRecipes(args.nutrientsAndFeeling)
    }


    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>
    override fun androidInjector() = dispatchingAndroidInjector


    override fun onCardDragging(direction: Direction?, ratio: Float) {
        Log.d("CardStackView", "onCardDragging: d = ${direction!!.name}, r = $ratio")
    }

    override fun onCardSwiped(direction: Direction?) {
        Log.d("CardStackView", "onCardSwiped: p = ${manager.topPosition}, d = $direction")
    }

    override fun onCardRewound() {
        Log.d("CardStackView", "onCardRewound: ${manager.topPosition}")
    }

    override fun onCardCanceled() {
        Log.d("CardStackView", "onCardCanceled: ${manager.topPosition}")
    }

    override fun onCardAppeared(view: View?, position: Int) {
        Log.d("CardStackView", "onCardAppeared: $position")
    }

    override fun onCardDisappeared(view: View?, position: Int) {
        Log.d("CardStackView", "onCardDisappeared: $position")
    }
}