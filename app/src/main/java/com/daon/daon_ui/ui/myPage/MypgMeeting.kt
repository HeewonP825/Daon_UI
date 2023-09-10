package com.daon.daon_ui.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.daon.daon_ui.R

data class MypgMeeting(
    val meetingImg: Int,
    val meetingLocation: String,
    val meetingDate: String,
    val meetingTime: String,
    val meetingTag1: String,
    val meetingTag2: String,
    val meetingTitle: String,
    val meetingExplain: String,
    val meetingMember: String,
    val meetingOriginalPrice: String,
    val meetingPrice: String,
    val meetingSomething: String,
    val reviewStars: String
)