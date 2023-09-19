package com.daon.daon_ui.ui.allFeed

import java.io.Serializable

data class AllFeed(
    //val allfeedProfileImg: Int,
    val allfeedNickmane: String,
    val allfeedIntroduce: String,
    //val allfeedLike: Int,
    //val allfeedMore: Int,
    val shouldHideImage: Boolean, // 이미지를 숨길지(true) 표시할지(false) 여부
    val allfeedImg: Int,
    val allfeedContext: String,
    val allfeedTag: String
) : Serializable // Serializable 인터페이스 구현 추가