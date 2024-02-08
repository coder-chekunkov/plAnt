package cdr.plant.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Тестовые данные
 *
 * @property name название
 * @property team команда создателей
 * @property createdby дата создания
 * @property imageurl ссылка на изображение
 *
 * @author Alexandr Chekunkov
 */
@Parcelize
data class TestData(
    @SerializedName("name") var name: String? = null,
    @SerializedName("team") var team: String? = null,
    @SerializedName("createdby") var createdby: String? = null,
    @SerializedName("imageurl") var imageurl: String? = null,
) : Parcelable
