package com.mohammadassad.todostask.pages.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mohammadassad.todostask.R
import com.mohammadassad.todostask.databinding.FragmentHomeBinding
import com.mohammadassad.todostask.databinding.FragmentLoginBinding
import com.mohammadassad.todostask.pages.home.calendar.CalendarFragment
import com.mohammadassad.todostask.pages.home.today.TodayFragment
import com.mohammadassad.todostask.pages.login.LoginViewModel
import com.mohammadassad.todostask.storage.LocalStorage


class HomeFragment : Fragment() {
    var vm: HomeViewModel =HomeViewModel()
    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        //(activity as AppCompatActivity).supportActionBar?.show()
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        val bottomNavigationView = _binding?.bottomNavigatinView
        setCurrentFragment(TodayFragment())


        bottomNavigationView?.setupWithNavController(findNavController())
        bottomNavigationView?.setOnItemSelectedListener {
            when(it.itemId){
                R.id.todayFragment->{

                    setCurrentFragment(TodayFragment())
                }
                R.id.calendarFragment->{

                    setCurrentFragment(CalendarFragment())
                }


            }
            true
        }



        return binding.root
    }

    private fun setCurrentFragment(fragment:Fragment)=
        childFragmentManager.beginTransaction().apply {
            replace(R.id.nav_fragment,fragment)
            commit()
        }



    override fun onDestroyView() {
        super.onDestroyView()
        // calling this to avoid memory leak.
        _binding = null
    }

}