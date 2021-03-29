package app.devpedrocarvalho.coroutinesflowwithretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import app.devpedrocarvalho.coroutinesflowwithretrofit.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collect

class MainActivity : AppCompatActivity() {

    private lateinit var  viewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        setupObserver()
        setupListeners()

    }

    private fun setupListeners(){
        binding.newInsultButton.setOnClickListener {
            viewModel.getInsult()
        }
    }

    private fun setupObserver(){
        viewModel.insultLiveData.observe(this, Observer {
            it?.let {
                binding.insultTextView.text = it.insult
            }
        })

        lifecycleScope.launchWhenStarted {
            viewModel.insultStateFlow.collect {
                when(it){
                    is MainActivityViewModel.UiState.Success -> binding.insultTextView.text = it.insult
                    is MainActivityViewModel.UiState.Error -> binding.insultTextView.text = it.exception.toString()
                }
            }
        }
    }
}