package com.june.testlab1.model

import com.june.testlab1.R

enum class Model private constructor(val titleResId: Int, val layoutResId: Int) {
    RED(R.string.one, R.layout.fragment_page1),
    BLUE(R.string.two, R.layout.layout_one),
    GREEN(R.string.three, R.layout.fragment_page3)
}