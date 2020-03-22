package dev.pstens.remindr

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.pstens.domain.reminder.GetReminder
import kotlinx.coroutines.launch

class StatsViewModel(private val getReminder: GetReminder) : ViewModel() {
//    private val _stats = MutableLiveData<List<Stat>>()
//    val stats = _stats.map { stats ->
//        stats.mapIndexed { index, stat -> stat.toStatItem(index + 1) }
//    }

    init {
        loadStats()
    }

    fun loadStats(refresh: Boolean = false) = viewModelScope.launch {
        // _stats.value = getStats(refresh)
    }
}