package com.example.home.domain.enums

import com.example.nytimes.R

enum class Periods (val value: String,val periodName: Int){
    LAST_DAY("1", R.string.last_day),
    LAST_WEEK("7", R.string.last_week),
    LAST_MONTH("30", R.string.last_month);

    companion object{
        fun getPeriod(periodValue: String) = Periods.entries.first { it.value == periodValue}

        fun periodList() = Periods.entries.toList()
    }
}