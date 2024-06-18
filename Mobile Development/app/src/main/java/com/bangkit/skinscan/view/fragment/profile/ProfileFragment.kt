package com.bangkit.skinscan.view.fragment.profile

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RatingBar
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.bangkit.skinscan.R
import com.bangkit.skinscan.databinding.FragmentProfileBinding
import com.bangkit.skinscan.view.fragment.profile.resetpass.ResetPassActivity
import com.bangkit.skinscan.view.ViewModelFactory
import com.bangkit.skinscan.view.login.LoginActivity
import com.bangkit.skinscan.view.main.MainActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.coroutines.launch


class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private val profileFragmentViewModel by viewModels<ProfileFragmentViewModel> { ViewModelFactory.getInstance(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        val ratingBar = binding.ratingBar

        ratingBar.setOnClickListener {
            val dialog = BottomSheetDialog(requireContext())

            val view = layoutInflater.inflate(R.layout.activity_rating_app, null)

            val btnClose = view.findViewById<Button>(R.id.submit)

            btnClose.setOnClickListener {
                dialog.dismiss()
            }

            dialog.setCancelable(false)
            dialog.setContentView(view)
            dialog.show()
        }

        binding.termCondition.setOnClickListener {
            val intent = Intent(requireContext(), TermAndCondition::class.java)
            startActivity(intent)
        }


        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setView()
    }

    private fun setView(){
        binding.logoutBtn.setOnClickListener { logoutBtn() }
        binding.Languange.setOnClickListener {
            startActivity(Intent(Settings.ACTION_LOCALE_SETTINGS))
        }
        binding.reset.setOnClickListener {
            val intent = Intent(requireContext(), ResetPassActivity::class.java)
            startActivity(intent)
        }
        observeUserSession()
    }

    private fun logoutBtn(){
        lifecycleScope.launch {
            profileFragmentViewModel.logout()
            val intent = Intent(requireContext(), LoginActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            }
            startActivity(intent)
        }
    }
    private fun observeUserSession(){
        profileFragmentViewModel.userSession.observe(viewLifecycleOwner){ user ->
            binding.gmail.text = user.email
        }
    }
}