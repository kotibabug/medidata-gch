package com.medidata.mehealth

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Article: Serializable {
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("condition_summary")
    @Expose
    var condition_summary: String? = null
    @SerializedName("intervention_summary")
    @Expose
    var intervention_summary: String? = null
    @SerializedName("url")
    @Expose
    var url: String? = null
}