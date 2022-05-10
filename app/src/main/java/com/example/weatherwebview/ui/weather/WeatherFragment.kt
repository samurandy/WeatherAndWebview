package com.example.weatherwebview.ui.weather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.weatherwebview.R
import com.example.weatherwebview.data.network.model.RemoteResult
import com.example.weatherwebview.databinding.FragmentWeatherBinding
import com.example.weatherwebview.ui.getDayOfWeek
import com.example.weatherwebview.ui.loadUrl
import com.example.weatherwebview.ui.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@AndroidEntryPoint
class WeatherFragment : Fragment() {

    private lateinit var binding: FragmentWeatherBinding

    private val viewModel by viewModels<WeatherViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWeatherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){

                viewModel.state.collect { updateUi(it) }
            }
        }
    }

    private fun updateUi(state: WeatherViewModel.UiState) {
        binding.progressBar.visibility = if (state.loading) View.VISIBLE else View.GONE
        state.weather?.let { showDataInUI(it) }
        state.error?.let { activity?.toast(it) }
    }

    private fun showDataInUI(result: RemoteResult) {
        with(binding) {
            currentDayDescription.text =
                getString(
                    R.string.currentDayDescription,
                    result.current?.weather?.get(0)?.description?.replaceFirstChar { it.uppercase() }
                        .toString()
                )
            currentDayIcon
                .loadUrl("http://openweathermap.org/img/wn/${result.current?.weather?.get(0)?.icon}@2x.png")
            currentDayTemp.text =
                getString(R.string.currentDayTemp, result.current?.temp?.toInt().toString())
            currentDayRealfeel.text =
                getString(
                    R.string.currentDayRealfeel,
                    result.current?.feelsLike?.toInt().toString()
                )
            secondDayWeekIcon
                .loadUrl("http://openweathermap.org/img/wn/${result.daily[1].weather[0].icon}@2x.png")
            secondDayWeek.text =
                getString(R.string.secondDayWeekName, result.daily[1].dt?.getDayOfWeek())
            secondDayMinTemp.text =
                getString(R.string.secondDayMinTemp, result.daily[1].temp?.min?.toInt().toString())
            secondDayMaxTemp.text =
                getString(R.string.secondDayMaxTemp, result.daily[1].temp?.max?.toInt().toString())
            thirdDayWeekIcon
                .loadUrl("http://openweathermap.org/img/wn/${result.daily[2].weather[0].icon}@2x.png")
            thirdDayWeek.text =
                getString(R.string.thirdDayWeekName, result.daily[2].dt?.getDayOfWeek())
            thirdDayMinTemp.text =
                getString(R.string.thirdDayMinTemp, result.daily[2].temp?.min?.toInt().toString())
            thirdDayMaxTemp.text =
                getString(R.string.thirdDayMaxTemp, result.daily[2].temp?.max?.toInt().toString())
            fourthDayWeekIcon
                .loadUrl("http://openweathermap.org/img/wn/${result.daily[3].weather[0].icon}@2x.png")
            fourthDayWeek.text =
                getString(R.string.fourthDayWeekName, result.daily[3].dt?.getDayOfWeek())
            fourthDayMinTemp.text =
                getString(R.string.fourthDayMinTemp, result.daily[3].temp?.min?.toInt().toString())
            fourthDayMaxTemp.text =
                getString(R.string.fourthDayMaxTemp, result.daily[3].temp?.max?.toInt().toString())
        }
    }
}