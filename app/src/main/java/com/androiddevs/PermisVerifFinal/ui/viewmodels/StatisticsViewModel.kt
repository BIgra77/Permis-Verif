package com.mastercamp.permisverif.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.mastercamp.permisverif.repositories.MainRepository

class StatisticsViewModel @ViewModelInject constructor(
    val mainRepository: MainRepository
): ViewModel() {

    val totalTimeRun = mainRepository.getTotalTimeInMillis()
    val totalDistance = mainRepository.getTotalDistance()
    val totalAvgSpeed = mainRepository.getTotalAvgSpeed()
    val runsSortedByDate = mainRepository.getAllRunsSortedByDate()
}