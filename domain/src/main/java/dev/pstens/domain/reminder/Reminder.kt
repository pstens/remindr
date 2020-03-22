package dev.pstens.domain.reminder

data class Reminder(val date: String, val tasks: List<Task>)